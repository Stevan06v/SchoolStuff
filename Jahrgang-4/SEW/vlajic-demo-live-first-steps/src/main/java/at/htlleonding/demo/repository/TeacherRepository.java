package at.htlleonding.demo.repository;

import at.htlleonding.demo.model.Gender;
import at.htlleonding.demo.model.Teacher;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TeacherRepository {

    private Map<Integer, Teacher> teachers;

    private TeacherRepository() {
        teachers = new HashMap<>();
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
    public int getTeacherCount(){
        return this.teachers.size();
    }

    public boolean removeTeacherById(int teacherId){
        try{
            this.teachers.remove(teacherId);
        }catch(NullPointerException err){
            throw new IllegalArgumentException("This teacherId is unknown!");
        }
        return this.teachers.containsKey(teacherId);
    }

    public int getMaleTeacherCount(){
        int countMale = 0;
        for (Teacher teacher : this.teachers.values()) {
            if(teacher.getGender() == Gender.valueOf("MALE")){
                countMale++;
            }
        }
        return countMale;
    }

    public int getFemaleTeacherCount(){
        int countFemale = 0;
        for (Teacher teacher : this.teachers.values()) {
            if(teacher.getGender() == Gender.valueOf("FEMALE")){
                countFemale++;
            }
        }
        return countFemale;
    }
    public Teacher getTeacherById(int id){
        return this.teachers.get(id);
    }

}
