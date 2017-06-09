package schedule.entity.form;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;


public class LessonForm {

    private Integer id;
    private String subject_name;
    private String lecturerSurname;
    private String lecturerName;
    private String lecturerPatronymic;
    private Integer group_id;
    private String dayOfWeek;
    private Integer numberOfLesson;
    private String lecture_hall;
    private String type;
    private Integer subgroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getLecturerSurname() {
        return lecturerSurname;
    }

    public void setLecturerSurname(String lecturerSurname) {
        this.lecturerSurname = lecturerSurname;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerPatronymic() {
        return lecturerPatronymic;
    }

    public void setLecturerPatronymic(String lecturerPatronymic) {
        this.lecturerPatronymic = lecturerPatronymic;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(Integer numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public String getLecture_hall() {
        return lecture_hall;
    }

    public void setLecture_hall(String lecture_hall) {
        this.lecture_hall = lecture_hall;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }
}
