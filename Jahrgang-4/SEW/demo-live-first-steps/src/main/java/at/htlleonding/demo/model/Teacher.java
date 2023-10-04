package at.htlleonding.demo.model;

public class Teacher {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;
    private static final double MIN_RATING = 0.0;
    private static final double MAX_RATING = 10.0;
    private int age;
    private double is_male;
    private double rating;
    private String firstname;
    private String lastname;
    private int id;
    private int counter;

    public Teacher(int age, double is_male, double rating, String firstname, String lastname) {
        this.age = age;
        this.is_male = is_male;
        this.rating = rating;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = counter++;
    }

    public Teacher() {
    }

    public void setAge(int age) {
        if(this.age < MIN_AGE || this.age > MAX_AGE){
            throw new IllegalArgumentException("The age can not be <= 18 and >= 65");
        }else{
            this.age = age;
        }
    }

    public void setRating(double rating) {
        if(this.rating < MIN_RATING || this.rating > MAX_RATING){
            throw new IllegalArgumentException("The rating can not be < 0 and > 10.0");
        }else{
            this.rating = rating;
        }
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public double getIs_male() {
        return is_male;
    }

    public double getRating() {
        return rating;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
