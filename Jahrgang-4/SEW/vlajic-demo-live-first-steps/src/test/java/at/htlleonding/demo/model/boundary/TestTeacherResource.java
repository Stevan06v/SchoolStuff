package at.htlleonding.demo.model.boundary;
import at.htlleonding.demo.boundary.TeacherResource;
import at.htlleonding.demo.model.Teacher;
import io.quarkus.runtime.Application;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@QuarkusTest
@TestHTTPEndpoint(TeacherResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestTeacherResource {

    @Test
    public void testListEndpoint(){
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .body(containsString("19"));
    }

    @Test
    public void testGetMaleTeacherCountEndpoint(){
        given()
                .when()
                .get("/male-teacher-count")
                .then()
                .statusCode(200)
                .body(containsString("2"));
    }

    @Order(2)
    @Test
    public void testDeleteEndpoint(){
        given()
                .when()
                .pathParams("teacher-id", 2)
                .delete("/delete/{teacher-id}", 2)
                .then()
                    .statusCode(200)
                    .body("size()", is(5));
    }

    @Order(5)
    @Test
    public void testGetTeacherByIdEndpoint(){
        given()
                .when()
                .pathParams("teacher-id", 1)
                .get("/{teacher-id}", 1)
                .then()
                .statusCode(200)
                .body(containsString("21"));
    }

    @Test
    public void testCountTeachersEndpoint(){
        given()
                .when()
                    .get("/teacher-count")
                    .then()
                .statusCode(200)
                .body(containsString("5"));
    }

    @Test
    public void testGetFemaleTeacherCountEndpoint(){
        given()
                .when()
                .get("/female-teacher-count")
                .then()
                .statusCode(200)
                .body(containsString("3"));
    }

    @Order(1)
    @Test
    public void testAdd(){
        Teacher teacher = new Teacher(21, "MALE", 9.9, "Stevan", "Vlajic");
        given()
                .contentType(MediaType.APPLICATION_JSON)
                    .when()
                    .body(teacher)
                    .post()
                .then()
                    .body("size()", is(6))
                    .statusCode(200);
    }
}
