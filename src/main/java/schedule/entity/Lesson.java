package schedule.entity;

import javax.persistence.*;


@Entity
@Table(name = "lesson")
//@javax.persistence.Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
   // @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Integer id;

    @Column(name = "subject_name",nullable = false)
    private String subject_name;

    @Column(name = "lecturer_surname", nullable = false)
    private String lecturerSurname;

    @Column(name = "lecturer_name", nullable = false)
    private String lecturerName;

    @Column(name = "lecturer_patronymic", nullable = false)
    private String lecturerPatronymic;

    @ManyToOne
    @JoinColumn(name = "group_id",nullable = false)
    private Group group;

    @Column(name = "day_of_week",nullable = false)
    private String dayOfWeek;

    @Column(name = "number_of_lesson",nullable = false)
    private Integer numberOfLesson;

    @Column(name = "lecture_hall",nullable = false)
    private String lecture_hall;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "subgroup_number",nullable = false)
    private Integer subgroup;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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



    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }
}
