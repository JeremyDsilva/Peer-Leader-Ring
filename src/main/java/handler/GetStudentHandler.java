package handler;

import static java.lang.Long.valueOf;

import entity.Student;
import repository.StudentRepository;
import response.Response;

public class GetStudentHandler {

    public Response<Student> handle(Long id) {

        StudentRepository studentRepository = new StudentRepository();
       

        return studentRepository.read(id);
    }

}
