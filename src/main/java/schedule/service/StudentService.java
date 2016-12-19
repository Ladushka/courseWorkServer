package schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.entity.Group;
import schedule.entity.Student;
import schedule.entity.form.StudentForm;
import schedule.repository.GroupRepository;
import schedule.repository.StudentRepository;

import java.util.List;

@Service("studentService")
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Student save(StudentForm studentForm) {
        Student student = new Student();
        student.setId(studentForm.getId());
        student.setSurname(studentForm.getSurname());
        student.setName(studentForm.getName());
        student.setPatronymic(studentForm.getPatronymic());
        student.setSdo_id(studentForm.getSdo_id());
        student.setGroup(groupRepository.findOne(studentForm.getGroup_id()));
        student.setSubgroup_number(studentForm.getSubgroup_number());
        return studentRepository.save(student);
    }

    public Student findOne(Integer id){
        return studentRepository.findOne(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    public List<Student> findByGroup(Integer group_id) {
        Group group=new Group();
        group.setGroup_id(group_id);
        return studentRepository.findByGroup(group);
    }
}
