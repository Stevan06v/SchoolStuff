package at.htlleonding.demo.addressbook.model;
import java.sql.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.LinkedList;
import java.util.List;
import java.util.spi.CurrencyNameProvider;

public class AddressBook {
    private static AddressBook instance;
    private SimpleIntegerProperty totalContacts;
    private ObservableList<Contact> contacts;
    private Connection conn = null;
    public ObservableList<Contact> getContacts(){
        return FXCollections.unmodifiableObservableList(this.contacts);
    }
    public int getTotalContacts(){
        return this.totalContacts.get();
    }
    public SimpleIntegerProperty totalContactsProperty(){
        return this.totalContacts;
    }
    private AddressBook() {
        this.contacts = FXCollections.observableList(new LinkedList<>());
        try  {
            conn = DriverManager.getConnection("jdbc:derby:db");
            conn.setAutoCommit(true);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CONTACT");

            while(resultSet.next()) {
                this.contacts.add(new Contact(resultSet.getString("NAME"), resultSet.getString("PHONENR"), resultSet.getString("EMAIL")));
                System.out.printf("%d,%s,%s,%s%n", resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getString("PHONENR"), resultSet.getString("EMAIL"));
            }

            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.totalContacts = new SimpleIntegerProperty(0);
    }

    public static synchronized AddressBook getInstance() {
        if (instance == null) {
            instance = new AddressBook(); // lazy initialization
        }
        return instance;
    }
     public void addContact(String name, String phone_number, String email){
         Contact contact = new Contact(name,phone_number,email);

        try(PreparedStatement query = this.conn.prepareStatement("insert into contacts (name,phonenr,email) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {

             query.setString(1, name);
             query.setString(2, phone_number);
             query.setString(3, email);

             query.execute();

             this.contacts.add(contact);
             this.totalContacts.set(this.contacts.size());
         } catch (SQLException err) {
             System.out.println(err.getErrorCode());
         }
     }

     public void deleteContact(Contact contact){
        try(PreparedStatement preparedStatement = this.conn.prepareStatement("DELETE FROM CONTACT WHERE ID = ?");) {

            preparedStatement.setString(1, contact.getId()+"");

            int rowsAffected = preparedStatement.executeUpdate();

            this.contacts.remove(contact);
            this.totalContacts.set(this.contacts.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

    public void updateContact(Contact c){
        try(PreparedStatement preparedStatement = this.conn.prepareStatement("UPDATE contacts SET NAME,PHONENR,EMAIL where ID = ?")){
            preparedStatement.setString(1, c.getId()+"");
            int rowsAffected = preparedStatement.executeUpdate();
            contacts.set(c.getId(), c);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
     }

     public ObservableList<Contact> getFilteredContacts(String needle){
        List<Contact> filteredContacts =  this.contacts
                .stream()
                .filter(iterator -> iterator.getName().contains(needle))
                .toList();
        return (ObservableList<Contact>) filteredContacts;
    }
}
