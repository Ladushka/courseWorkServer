package schedule.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import schedule.entity.Lesson;
import schedule.entity.form.LessonForm;
import schedule.websocket.NewChange;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Service("exportService")
public class ExportServiceImpl implements ExportService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LessonService lessonService;

    @Autowired
    private GroupService groupService;

//    @Autowired
//    @Qualifier("list")
//    private List<NewChange> changes;

    private String dayOfWeek(Integer day) {
        String dayOfWeek = "";
        switch (day) {
            case 1:
                dayOfWeek = "Понедельник";
                break;
            case 2:
                dayOfWeek = "Вторник";
                break;
            case 3:
                dayOfWeek = "Среда";
                break;
            case 4:
                dayOfWeek = "Четверг";
                break;
            case 5:
                dayOfWeek = "Пятница";
                break;
            case 6:
                dayOfWeek = "Суббота";
                break;
        }
        return dayOfWeek;

    }

    public void lessonsComparison(LessonForm newLesson) {
        List<Lesson> savedLesson = lessonService.findByGroupAndDayOfWeekAndNumberOfLesson(newLesson.getNumberOfLesson(), newLesson.getDayOfWeek(), newLesson.getGroup_id());

        if (!savedLesson.isEmpty()) {
            if ((!savedLesson.get(0).getSubject_name().equals(newLesson.getSubject_name()) || !savedLesson.get(0).getLecture_hall().equals(newLesson.getLecture_hall()))) {
                newLesson.setId(savedLesson.get(0).getId());
                lessonService.save(newLesson);
//                changes.add(new NewChange(newLesson.getGroup_id(),newLesson.getLecturerName(),newLesson.getLecturerSurname(),newLesson.getLecturerPatronymic(),newLesson.getDayOfWeek(),new Date()));
            } else {
                newLesson.setId(0);
                lessonService.save(newLesson);
            }
        } else {
            newLesson.setId(0);
            lessonService.save(newLesson);
        }
    }

    @Override
    public void push(JSONArray array) throws RemoteException {
        LessonForm lesson = new LessonForm();
        System.out.println(array.size());
        for (int i = 0; i < array.size(); i++) {
            JSONObject newLesson = (JSONObject) array.get(i);
//            lesson.setId(Integer.parseInt(newLesson.get("id").toString()));
            lesson.setSubject_name(newLesson.get("subject_name").toString());
            lesson.setLecturerSurname(newLesson.get("lecturerSurname").toString());
            lesson.setLecturerName(newLesson.get("lecturerName").toString());
            lesson.setLecturerPatronymic(newLesson.get("lecturerPatronymic").toString());
            lesson.setSubgroup(Integer.parseInt(newLesson.get("subgroup").toString()));
            lesson.setType(newLesson.get("type").toString());
            lesson.setLecture_hall(newLesson.get("lecture_hall").toString());
            lesson.setNumberOfLesson(Integer.parseInt(newLesson.get("number_of_lesson").toString()));
            lesson.setDayOfWeek(dayOfWeek(Integer.parseInt(newLesson.get("day_of_week").toString())));
            lesson.setGroup_id(groupService.findByFacultyAndNumber("ФМиИТ", Integer.parseInt(newLesson.get("group_id").toString())).get(0).getGroup_id());
//            lessonService.save(lesson);
            lessonsComparison(lesson);
        }
        logger.error("ничоси!");
    }
}
