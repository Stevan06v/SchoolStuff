package at.htlleonding.demo.boundary;

import at.htlleonding.demo.model.Teacher;
import at.htlleonding.demo.repository.TeacherRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/teachers")
public class TeacherResource {

    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public List<Teacher> teachers() {
        return teacherRepository.getTeachers();
    }


}
