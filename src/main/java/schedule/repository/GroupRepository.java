package schedule.repository;

import schedule.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findByFaculty(String name);

    List<Group> findByFacultyAndNumber(String faculty,Integer number);
}
