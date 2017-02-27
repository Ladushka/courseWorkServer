package schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.entity.Group;
import schedule.service.GroupService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Group> save(@RequestBody @Valid Group group) {
        return new ResponseEntity<>(groupService.save(group), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Group>>getAll(){
        return new ResponseEntity<>(groupService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Group>get(@PathVariable("id") Integer id){
        return new ResponseEntity<>(groupService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        groupService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/faculty/{faculty}", method = RequestMethod.GET)
    public ResponseEntity<List<Group>> getByFaculty(@PathVariable("faculty") String faculty) {
        return new ResponseEntity<>(groupService.findByFaculty(faculty), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculty/{faculty}/number/{number}", method = RequestMethod.GET)
    public ResponseEntity<List<Group>> getByFaculty(@PathVariable("faculty") String faculty, @PathVariable("number") Integer number) {
        return new ResponseEntity<>(groupService.findByFacultyAndNumber(faculty,number), HttpStatus.OK);
    }

}
