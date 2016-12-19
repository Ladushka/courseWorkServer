package schedule.entity.form;

public class StudentForm {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private Long sdo_id;
    private Integer group_id;
    private Integer subgroup_number;

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

    public Long getSdo_id() {
        return sdo_id;
    }

    public void setSdo_id(Long sdo_id) {
        this.sdo_id = sdo_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getSubgroup_number() {
        return subgroup_number;
    }

    public void setSubgroup_number(Integer subgroup_number) {
        this.subgroup_number = subgroup_number;
    }

    @Override
    public String toString() {
        return "StudentForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sdo_id=" + sdo_id +
                ", group=" + group_id +
                ", subgroup_number=" + subgroup_number +
                '}';
    }
}
