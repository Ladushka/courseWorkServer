package schedule.repository;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schedule.entity.Group;
import schedule.entity.Lecturer;
import schedule.entity.Lesson;

import java.util.List;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByGroup(Group group_id);
    List<Lesson> findByLecturerSurname(String surname);
    List<Lesson> findByDayOfWeekAndNumberOfLesson(String day_of_week, Integer numberOfLesson);

    @Query("SELECT l FROM Lesson l WHERE l.dayOfWeek = :day AND l.numberOfLesson = :number AND l.group.group_id = :group")
    List<Lesson> findByGroupAndDayOfWeekAndNumberOfLesson(@Param("number") Integer number, @Param("day") String day, @Param("group") Integer group);
}
