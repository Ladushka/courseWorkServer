package schedule.entity.form;

public class StudentForm {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private Long sdo;
    private Integer group_id;
    private Integer subgroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Long getSdo() {
        return sdo;
    }

    public void setSdo(Long sdo) {
        this.sdo = sdo;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }

    @Override
    public String toString() {
        return "StudentForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sdo_id=" + sdo +
                ", group=" + group_id +
                ", subgroup_number=" + subgroup +
                '}';
    }
}
