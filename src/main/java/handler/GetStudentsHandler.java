package handler;

import java.util.List;

import entity.Student;
import repository.StudentRepository;
import response.Response;

public class GetStudentsHandler {
    public Response<List<Student>> handle() {

        StudentRepository studentRepository = new StudentRepository();

        return studentRepository.readAll();
    }
}
