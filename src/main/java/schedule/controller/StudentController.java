package schedule.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.entity.Lesson;
import schedule.entity.Student;
import schedule.entity.form.LessonForm;
import schedule.entity.form.StudentForm;
import schedule.service.LessonService;
import schedule.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private Log bla = new SimpleLog(StudentController.class.getName());
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody @Valid StudentForm student) {
        bla.error(student);
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(studentService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{group_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getByGroup(@PathVariable("group_id") Integer group_id) {
        return new ResponseEntity<>(studentService.findByGroup(group_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/sdo/{sdo}", method = RequestMethod.GET)
    public ResponseEntity<Student> getByGroup(@PathVariable("sdo") Long sdo) {
        return new ResponseEntity<>(studentService.findBySdo(sdo), HttpStatus.OK);
    }


}
