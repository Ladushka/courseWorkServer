package schedule.repository;


import schedule.entity.Group;
import schedule.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByGroup(Group group_id);
    Student findBySdo(Long sdo);
}
