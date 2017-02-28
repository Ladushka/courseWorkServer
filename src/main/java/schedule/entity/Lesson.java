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

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "group_id",nullable = false)
    private Group group;

    @Column(name = "day_of_week",nullable = false)
    private String day_of_week;

    @Column(name = "number_of_lesson",nullable = false)
    private Integer number_of_lesson;

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

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
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
