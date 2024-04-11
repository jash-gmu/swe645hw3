package edu.gmu.springboot.service;
import java.util.List;
import edu.gmu.springboot.model.Student;
public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    void deleteStudent(long id);
    Student updateStudent(Student student, long id);
}
