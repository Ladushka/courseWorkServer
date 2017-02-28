package schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schedule.entity.Group;
import schedule.entity.Lecturer;
import schedule.entity.Lesson;
import schedule.entity.form.LessonForm;
import schedule.repository.GroupRepository;
import schedule.repository.LecturerRepository;
import schedule.repository.LessonRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("lessonService")
public class LessonService {
    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public Lesson save(LessonForm lessonForm) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonForm.getId());
        lesson.setSubject_name(lessonForm.getSubject_name());
        lesson.setLecturer(lecturerRepository.findOne(lessonForm.getLecture_id()));
        lesson.setDay_of_week(lessonForm.getDay_of_week());
        lesson.setNumber_of_lesson(lessonForm.getNumber_of_lesson());
        lesson.setGroup(groupRepository.findOne(lessonForm.getGroup_id()));
        lesson.setLecture_hall(lessonForm.getLecture_hall());
        lesson.setType(lessonForm.getType());
        lesson.setSubgroup(lessonForm.getSubgroup());
        return lessonRepository.save(lesson);
    }

    public Lesson findOne(Integer id) {
        return lessonRepository.findOne(id);
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public void delete(Integer id) {
        lessonRepository.delete(id);
    }

    public List<Lesson> findByGroup(Integer group_id) {
        Group group = new Group();
        group.setGroup_id(group_id);
        return lessonRepository.findByGroup(group);
    }

    public List<Lesson> findByLecturer(Integer lecturer_id) {
        Lecturer lecturer = new Lecturer();
        lecturer.setLecture_id(lecturer_id);
        return lessonRepository.findByLecturer(lecturer);
    }


    @Transactional
    public List<Lesson> findByFacultyAndNumber(String faculty, Integer number) {
        Optional<Group> optional = groupRepository.findByFacultyAndNumber(faculty, number).stream().findFirst();
        return optional.isPresent() ? lessonRepository.findByGroup(optional.get()) : Collections.emptyList();
    }

    @Transactional
    public List<Lesson> findBySurname(String surname) {
        Optional<Lecturer> optional = lecturerRepository.findBySurname(surname).stream().findFirst();
        return optional.isPresent() ? lessonRepository.findByLecturer(optional.get()) : Collections.emptyList();
    }


}
