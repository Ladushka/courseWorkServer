package schedule.entity.form;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;


public class LessonForm {

    private Integer id;
    private String subject_name;
    private Integer lecture_id;
    private Integer group_id;
    private String day_of_week;
    private Integer number_of_lesson;
    private String lecture_hall;
    private String type;
    private Integer subgroup_number;

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

    public Integer getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Integer lecture_id) {
        this.lecture_id = lecture_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Integer getNumber_of_lesson() {
        return number_of_lesson;
    }

    public void setNumber_of_lesson(Integer number_of_lesson) {
        this.number_of_lesson = number_of_lesson;
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

    public Integer getSubgroup_number() {
        return subgroup_number;
    }

    public void setSubgroup_number(Integer subgroup_number) {
        this.subgroup_number = subgroup_number;
    }
}
