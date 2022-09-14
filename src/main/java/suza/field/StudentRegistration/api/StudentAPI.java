package suza.field.StudentRegistration.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suza.field.StudentRegistration.models.Student;
import suza.field.StudentRegistration.repos.StudentRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentAPI {
    @Autowired
    private StudentRepo studentRepo;

//    @GetMapping("/get_students")
    @GetMapping
    public ResponseEntity<?> getStudents(){
        try {
            List<Student> students=studentRepo.findAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Somethis went wrong", HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/new_student")
    @PostMapping
    public ResponseEntity<?> newStudent(@RequestBody Student stud){
        try {
            Student student=studentRepo.save(stud);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Somethis went wrong", HttpStatus.CONFLICT);
        }
    }
//    @PutMapping("/edit_student/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<?> editStudent(@PathVariable int id,@RequestBody Student stud){
        try {
            if(studentRepo.findById(id).isPresent()){
                stud.setId(id);
                Student student=studentRepo.save(stud);
                return new ResponseEntity<>(student, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            return new ResponseEntity<>("Somethis went wrong", HttpStatus.CONFLICT);
        }
    }

    //    @PutMapping("/edit_student/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        try {
            Optional<Student> student=studentRepo.findById(id);
            if(student.isPresent()){
                return new ResponseEntity<>(student.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            return new ResponseEntity<>("Somethis went wrong", HttpStatus.CONFLICT);
        }
    }

    //    @DeleteMapping("/delete_student/{id}")
    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        try {
            studentRepo.deleteById(id);
                return new ResponseEntity<>("Student has been deleted", HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Somethis went wrong", HttpStatus.CONFLICT);
        }
    }

}
