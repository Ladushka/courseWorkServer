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
        lesson.setLecturerName(lessonForm.getLecturerName());
        lesson.setLecturerSurname(lessonForm.getLecturerSurname());
        lesson.setLecturerPatronymic(lessonForm.getLecturerPatronymic());
        //lesson.setLecturer(lecturerRepository.findOne(lessonForm.getLecture_id()));
        lesson.setDayOfWeek(lessonForm.getDayOfWeek());
        lesson.setNumberOfLesson(lessonForm.getNumberOfLesson());
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

    public List<Lesson> findByDayOfWeekAndNumberOfLesson(String day_of_week, Integer numberOfLesson) {
        return lessonRepository.findByDayOfWeekAndNumberOfLesson(day_of_week, numberOfLesson);
    }


    @Transactional
    public List<Lesson> findByFacultyAndNumber(String faculty, Integer number) {
        Optional<Group> optional = groupRepository.findByFacultyAndNumber(faculty, number).stream().findFirst();
        return optional.isPresent() ? lessonRepository.findByGroup(optional.get()) : Collections.emptyList();
    }

//    @Transactional
//    public List<Lesson> findByFacultyAndNumberAndDayOfWeek(String faculty, Integer number,String dayOfWeek) {
//        List<Lesson> optional = findByFacultyAndNumber(faculty, number);
//        return optional.isPresent() ? lessonRepository.findByGroup(optional.get()) : Collections.emptyList();
//    }


    public List<Lesson> findByLecturerSurname(String surname) {
        return lessonRepository.findByLecturerSurname(surname);
    }

    public List<Lesson> findByGroupAndDayOfWeekAndNumberOfLesson(Integer number, String day, Integer group) {
        return lessonRepository.findByGroupAndDayOfWeekAndNumberOfLesson(number, day, group);
    }


}
