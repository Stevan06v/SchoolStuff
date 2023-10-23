package at.htlleonding.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.LinkedList;

@Entity
public class Teacher {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;
    private static final double MIN_RATING = 0.0;
    private static final double MAX_RATING = 10.0;
    @Column(name = "age")
    private int age;
    @Column(name = "rating")
    private Gender gender;
    @Column(name = "rating")
    private double rating;
    @Column(name = "last_name")
    private String firstname;
    @Column(name = "first_name")
    private String lastname;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    public Teacher(int age, String gender, double rating, String firstname, String lastname) {
        this.setAge(age);
        this.setRating(rating);
        this.gender = Gender.valueOf(gender);
        this.rating = rating;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Teacher() {
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setRating(double rating) {
        if(this.rating >= MIN_RATING && this.rating <= MAX_RATING){
            this.rating = rating;
        }else{
            throw new IllegalArgumentException("The rating can not be < 0 and > 10.0");

        }
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return this.gender;
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
