package at.htlleonding.demo.model;

import at.htlleonding.demo.repository.TeacherRepository;

import java.util.LinkedList;

public class Class {
    private LinkedList<Student> students;
    private Teacher teacher;
    private int size;
    private static int counter = 1;
    private int id;

    public Class(Teacher teacher, int size, int id) {
        this.teacher = teacher;

        this.size = size;
        this.id = id;
    }
}
