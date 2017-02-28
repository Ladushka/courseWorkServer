package schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import schedule.entity.Group;
import schedule.entity.Lecturer;
import schedule.service.LectureService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/lecturers")
public class LecturerController {
    @Autowired
    private LectureService lectureService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Lecturer> save(@RequestBody @Valid Lecturer lecturer) {
        return new ResponseEntity<>(lectureService.save(lecturer), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Lecturer>>getAll(){
        return new ResponseEntity<>(lectureService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lecturer>get(@PathVariable("id") Integer id){
        return new ResponseEntity<>(lectureService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        lectureService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<Lecturer>get(@PathVariable("login") String login){
        return new ResponseEntity<>(lectureService.findByLogin(login), HttpStatus.OK);
    }

    @RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET)
    public ResponseEntity<List<Lecturer>> getBySurname(@PathVariable("surname") String surname) {
        return new ResponseEntity<>(lectureService.findBySurname(surname), HttpStatus.OK);
    }


}
