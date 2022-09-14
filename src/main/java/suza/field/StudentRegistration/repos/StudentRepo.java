package suza.field.StudentRegistration.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suza.field.StudentRegistration.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
