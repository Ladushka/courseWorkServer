package schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.entity.User;
import schedule.repository.UserRepository;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findOne(Integer id){
        return userRepository.findOne(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
