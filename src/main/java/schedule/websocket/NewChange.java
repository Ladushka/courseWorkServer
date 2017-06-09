package schedule.websocket;

import java.util.Date;

public class NewChange {
    private Integer number;
    private String lecturerName;
    private String lecturerSurname;
    private String lecturerPatronymic;
    private String day;
    private Date updateDate;

    public NewChange(Integer number, String lecturerName, String lecturerSurname, String lecturerPatronymic, String day, Date updateDate) {
        this.number = number;
        this.lecturerName = lecturerName;
        this.lecturerSurname = lecturerSurname;
        this.lecturerPatronymic = lecturerPatronymic;
        this.day = day;
        this.updateDate = updateDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerSurname() {
        return lecturerSurname;
    }

    public void setLecturerSurname(String lecturerSurname) {
        this.lecturerSurname = lecturerSurname;
    }

    public String getLecturerPatronymic() {
        return lecturerPatronymic;
    }

    public void setLecturerPatronymic(String lecturerPatronymic) {
        this.lecturerPatronymic = lecturerPatronymic;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
