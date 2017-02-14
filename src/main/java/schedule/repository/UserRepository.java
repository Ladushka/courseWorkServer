package schedule.repository;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
//    User findBySdoid(Long sdo_id);
}
