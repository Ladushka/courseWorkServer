package schedule.repository;

import schedule.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    Lecturer findByLogin(String login);

    List<Lecturer> findBySurname(String surname);
}
