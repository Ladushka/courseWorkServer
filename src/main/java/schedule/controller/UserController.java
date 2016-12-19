package schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.entity.Lesson;
import schedule.entity.User;
import schedule.entity.form.LessonForm;
import schedule.service.LessonService;
import schedule.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>>getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User>get(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
