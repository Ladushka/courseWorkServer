package schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schedule.entity.Group;
import schedule.entity.Lesson;

import java.util.List;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByGroup(Group group_id);

   // @Query("SELECT l FROM Lesson l LEFT JOIN Group g ON l.group_id = g.group_id WHERE g.number = :number AND g.faculty = :faculty")
   // List<Lesson> findByGroupAndFaculty(@Param("number") Integer number, @Param("faculty") String faculty);
}
