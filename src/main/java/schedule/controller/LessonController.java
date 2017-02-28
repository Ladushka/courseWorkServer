package schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.entity.Lecturer;
import schedule.entity.Lesson;
import schedule.entity.form.LessonForm;
import schedule.service.LectureService;
import schedule.service.LessonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Lesson> save(@RequestBody @Valid LessonForm lesson) {
        return new ResponseEntity<>(lessonService.save(lesson), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> getAll() {
        return new ResponseEntity<>(lessonService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lesson> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(lessonService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        lessonService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{group_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> getByGroup(@PathVariable("group_id") Integer group_id) {
        return new ResponseEntity<>(lessonService.findByGroup(group_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/lecturer/{lecturer_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> getByLecturer(@PathVariable("lecturer_id") Integer lecturer_id) {
        return new ResponseEntity<>(lessonService.findByLecturer(lecturer_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculty/{faculty}/group/{number}", method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> findByFacultyAndNumber(@PathVariable("faculty") String faculty, @PathVariable("number") Integer number) {
        return new ResponseEntity<>(lessonService.findByFacultyAndNumber(faculty, number), HttpStatus.OK);
    }

    @RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET)
    public ResponseEntity<List<Lesson>> findByFacultyAndNumber(@PathVariable("surname") String surname) {
        return new ResponseEntity<>(lessonService.findBySurname(surname), HttpStatus.OK);
    }


}
