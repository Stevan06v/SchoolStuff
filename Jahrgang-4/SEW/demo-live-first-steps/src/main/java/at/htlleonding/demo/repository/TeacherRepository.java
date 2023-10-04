package at.htlleonding.demo.repository;

import at.htlleonding.demo.model.Teacher;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TeacherRepository {

    private static TeacherRepository teacherRepository;
    private Map<Integer, Teacher> teachers;

    private TeacherRepository() {
        teachers = new HashMap<>();
    }
    public static TeacherRepository getInstance(){
        if (teacherRepository == null){
            teacherRepository = new TeacherRepository();
        }
        return teacherRepository;
    }
    public boolean delete(int id){
        this.teachers.remove(id);
        if (this.teachers.containsKey(id)){
            return false;
        }
        return true;
    }
    public boolean add(Teacher teacher){
        this.teachers.put(teacher.getId(), teacher);
        if(this.teachers.containsKey(teacher)){
            return true;
        }
        return false;
    }
    public LinkedList<Teacher> getTeachers(){
        return new LinkedList<>(this.teachers.values());
    }
    public Teacher getTeacherById(int id){
        return this.teachers.get(id);
    }

}
