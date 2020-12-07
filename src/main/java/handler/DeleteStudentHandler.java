package handler;

import dto.Student;
import repository.StudentRepository;
import response.Response;

public class DeleteStudentHandler {

        public Response<Void> handle(Student Student) {

                StudentRepository repos = new StudentRepository();

                return repos.delete(Student.getDatabaseObject());
        }

}
