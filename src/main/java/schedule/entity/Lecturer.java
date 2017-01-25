package schedule.entity;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;

import javax.persistence.*;

@Entity
@Table(name = "lecture")
//@javax.persistence.Table(name = "lecture")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id", nullable = false)
    //@javax.persistence.Column(name = "lecture_id", nullable = false, insertable = true, updatable = true)
    private Integer lecture_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;


    @Column(name = "login", unique = true, nullable = false)
    private String login;

    public Integer getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Integer lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
