package handler;

import java.util.List;

import entity.Student;
import repository.StudentRepository;
import response.Response;

public class GetStudentsFromGroupHandler {

    public Response<List<Student>> handle(Long groupId) {

        StudentRepository repos = new StudentRepository();

        return repos.getStudentsFromGroup(groupId);
    }

}
