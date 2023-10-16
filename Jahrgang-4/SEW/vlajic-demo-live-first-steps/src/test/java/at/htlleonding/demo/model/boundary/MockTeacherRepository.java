package at.htlleonding.demo.model.boundary;

import at.htlleonding.demo.model.Teacher;
import at.htlleonding.demo.repository.TeacherRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Priority(666)
public class MockTeacherRepository extends TeacherRepository{
    @PostConstruct
    public void init() {
        //int age, String gender, double rating, String firstname, String lastname
        this.add(new Teacher(21, "MALE", 9.9, "Stevan", "Vlajic"));
        this.add(new Teacher(18, "FEMALE", 8.9, "Stevan", "Vlajic"));
        this.add(new Teacher(20, "FEMALE", 8.9, "Stevan", "Vlajic"));
        this.add(new Teacher(19, "MALE", 9.9, "Stevan", "Vlajic"));
        this.add(new Teacher(21, "FEMALE", 6.9, "Stevan", "Vlajic"));

    }
}








