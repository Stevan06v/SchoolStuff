package at.htlleonding.demo.boundary;

import at.htlleonding.demo.model.Teacher;
import at.htlleonding.demo.repository.TeacherRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.ResourceBundle;

@Path("/api/teachers")
public class TeacherResource {
    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teachers() {
        return Response.ok(teacherRepository.getTeachers()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTeacher(Teacher teacher){
        teacherRepository.getInstance().add(teacher);
        return Response.ok(this.teacherRepository.getTeachers()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{teacher-id}")
    public Response getTeacher( @PathParam("teacher-id") int teacherId ){
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        return Response.ok(teacher).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/teacher-count")
    public int getTeacherCount(){
        return teacherRepository.getTeacherCount();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/female-teacher-count")
    public int getFemaleTeacherCount(){
        return teacherRepository.getFemaleTeacherCount();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/male-teacher-count")
    public int getMaleTeacherCount(){
        return teacherRepository.getMaleTeacherCount();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{teacher-id}")
    public Response removeTeacherById(@PathParam("teacher-id") int teacherId){
        teacherRepository.removeTeacherById(teacherId);
        return Response.ok(teacherRepository.getTeachers()).build();
    }

}
