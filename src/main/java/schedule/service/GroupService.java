package schedule.service;

import schedule.entity.Group;
import schedule.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupService")
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group findOne(Integer group_id) {
        return groupRepository.findOne(group_id);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public void delete(Integer group_id) {
        groupRepository.delete(group_id);
    }

    public List<Group> findByFaculty(String name) {
        return groupRepository.findByFaculty(name);
    }

}
