package at.htlleonding.demo.addressbook.model;
public class Contact {


    private Integer id;
    private String name;
    private String phone_number;
    private String email;

    public Contact(String name, String phone_number, String email)  {
        this.setName(name);
        this.setEmail(email);
        this.setPhone_number(phone_number);
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number){
            this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
