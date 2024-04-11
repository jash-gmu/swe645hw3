package edu.gmu.springboot.service.impl;
import edu.gmu.springboot.exception.ResourceNotFoundException;
import edu.gmu.springboot.model.Student;
import edu.gmu.springboot.repository.StudentRepository;
import edu.gmu.springboot.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    public StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            return student.get();
        } else {
            throw new ResourceNotFoundException("Student", "Id", id);
        }
    }
    @Override
    public Student updateStudent(Student studentDetails, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "Id", id));

        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setStreetAddress(studentDetails.getStreetAddress());
        existingStudent.setCity(studentDetails.getCity());
        existingStudent.setState(studentDetails.getState());
        existingStudent.setZip(studentDetails.getZip());
        existingStudent.setTelephone(studentDetails.getTelephone());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setDateOfSurvey(studentDetails.getDateOfSurvey());
        existingStudent.setLikes(studentDetails.getLikes());
        existingStudent.setInterestSource(studentDetails.getInterestSource());
        existingStudent.setRecommendationLikelihood(studentDetails.getRecommendationLikelihood());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Student", "Id", id));
        studentRepository.deleteById(id);
    }

}
