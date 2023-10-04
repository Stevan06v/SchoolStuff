package at.htlleonding.demo.addressbook.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import at.htlleonding.demo.addressbook.model.AddressBook;
import at.htlleonding.demo.addressbook.model.Contact;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddressBookController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ListView<Contact> listview_lbl;
    @FXML
    private Button save_btn;
    @FXML
    private TextField search_text_field;
    @FXML
    private TextField phone_text_field;
    @FXML
    private TextField email_text_field;
    @FXML
    private Button delete_btn;
    @FXML
    private Label number_of_contacts_lbl;
    @FXML
    private TextField name_text_field;
    @FXML
    private Button new_btn;
    @FXML
    private TextField id_text_field;
    private FilteredList<Contact>contacts;
    private AddressBook addressBook;

    @FXML
    void initialize() {
        this.addressBook = AddressBook.getInstance();
        this.contacts = new FilteredList<>(this.addressBook.getContacts());
        this.id_text_field.setDisable(true);

        try {
            List<Contact> file_contacts =  Files.lines(Paths.get("src/main/resources/at/htlleonding/demo/addressbook/contacts.csv"))
                    .skip(1)
                    .map(iterator -> {
                        String[] parts = iterator.split(";");
                        return new Contact(parts[0], parts[1], parts[2]);
                    })
                    .toList();

           file_contacts.forEach(iterator -> this.addressBook.addContact(iterator.getName(), iterator.getEmail(), iterator.getPhone_number()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.listview_lbl.setItems(this.contacts);

        this.number_of_contacts_lbl.textProperty().bind(new StringBinding() {
            {
                bind(addressBook.totalContactsProperty());
            }
            @Override
            protected String computeValue() {
                return String.format("%s",addressBook.getTotalContacts());
            }
        });

        this.listview_lbl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
            @Override
            public void changed(ObservableValue<? extends Contact> observableValue, Contact from, Contact to) {
                if(to == null){
                   delete_btn.setDisable(true);
                }else{
                    delete_btn.setDisable(false);
                }
            }
        });

        this.listview_lbl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
            @Override
            public void changed(ObservableValue<? extends Contact> observableValue, Contact from, Contact to) {
                id_text_field.setText(to.getId()+"");
                name_text_field.setText(to.getName());
                email_text_field.setText(to.getEmail());
                phone_text_field.setText(to.getPhone_number());
            }
        });

        this.search_text_field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String from, String to) {
                if(to !=  null){
                   contacts.setPredicate(contact -> {
                       if (to.isEmpty()) {
                           return true; // Show all contacts if search field is empty
                       }
                       String lowerCaseSearchTerm = to.toLowerCase();
                       return contact.getName().toLowerCase().contains(lowerCaseSearchTerm) ||
                               contact.getPhone_number().toLowerCase().contains(lowerCaseSearchTerm) ||
                               contact.getEmail().toLowerCase().contains(lowerCaseSearchTerm);
                   });
                }
            }
        });
    }

    @FXML
    void onBtnSearchAction(ActionEvent event) {
        this.contacts.setPredicate(contact ->{
            if (this.search_text_field.getText().isEmpty()){
                return true;
            }
            return  contact.getPhone_number().contains(this.search_text_field.getText()) ||
                    contact.getEmail().contains(this.search_text_field.getText()) ||
                    contact.getName().contains(this.search_text_field.getText());
        });
    }

    @FXML
    void onBtnDeleteAction(ActionEvent event) {
        Contact contact = this.listview_lbl.getSelectionModel().getSelectedItem();
        this.addressBook.deleteContact(contact);
        this.listview_lbl.getSelectionModel().clearSelection();
    }
    @FXML
    void onBtnNewAction(ActionEvent event) {
        String name = this.name_text_field.getText();
        String email = this.email_text_field.getText();
        String phone = this.phone_text_field.getText();

        this.addressBook.addContact(name, email, phone);
    }
    @FXML
    void onBtnSaveAction(ActionEvent event)  {
       Contact contact = contacts.get(listview_lbl.getSelectionModel().getSelectedIndex());

       contact.setPhone_number(phone_text_field.getText());
       contact.setName(name_text_field.getText());
       contact.setEmail(email_text_field.getText());

       this.addressBook.updateContact(contact);
    }
}
