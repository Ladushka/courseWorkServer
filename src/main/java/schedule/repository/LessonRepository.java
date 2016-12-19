package schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entity.Group;
import schedule.entity.Lesson;

import java.util.List;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByGroup(Group group_id);
}
