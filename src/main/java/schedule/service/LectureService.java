package schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.entity.Lecturer;
import schedule.repository.LecturerRepository;

import java.util.List;

@Service("lectureService")
public class LectureService {
    @Autowired
    private LecturerRepository lecturerRepository;

    public Lecturer save(Lecturer lecturer){
        return lecturerRepository.save(lecturer);
    }

    public Lecturer findOne(Integer lecture_id){
        return lecturerRepository.findOne(lecture_id);
    }

    public Lecturer findByLogin(String login){
        return lecturerRepository.findByLogin(login);
    }

    public List<Lecturer> findAll(){
        return lecturerRepository.findAll();
    }

    public void delete(Integer lecture_id) {
        lecturerRepository.delete(lecture_id);
    }

    public List<Lecturer> findBySurname(String surname) {
        return lecturerRepository.findBySurname(surname);
    }
}
