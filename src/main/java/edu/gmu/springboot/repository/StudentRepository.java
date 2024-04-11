package edu.gmu.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.gmu.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
