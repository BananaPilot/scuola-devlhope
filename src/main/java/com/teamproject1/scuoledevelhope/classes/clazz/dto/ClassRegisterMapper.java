package com.teamproject1.scuoledevelhope.classes.clazz.dto;

import com.teamproject1.scuoledevelhope.classes.clazz.Clazz;
import com.teamproject1.scuoledevelhope.classes.coordinator.repo.CoordinatorDAO;
import com.teamproject1.scuoledevelhope.classes.course.repo.CourseDAO;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.school.repo.SchoolDAO;
import com.teamproject1.scuoledevelhope.classes.tutor.repo.TutorDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassRegisterMapper {
    private final CoordinatorDAO coordinatorDAO;
    private final CourseDAO courseDAO;
    private final TutorDAO tutorDAO;
    private final SchoolDAO schoolDAO;

    public ClassRegisterMapper(CoordinatorDAO coordinatorDAO, CourseDAO courseDAO, TutorDAO tutorDAO, SchoolDAO schoolDAO) {

        this.coordinatorDAO = coordinatorDAO;
        this.courseDAO = courseDAO;
        this.tutorDAO = tutorDAO;
        this.schoolDAO = schoolDAO;
    }

    public Clazz toClass(ClassRegisterDTO classRegisterDTO) {
        Clazz classes = new Clazz();

        classes.setName(classRegisterDTO.getClassName());
        classes.setCoordinator(coordinatorDAO.findById(classRegisterDTO.getCoordinatorId()).orElse(null));
        classes.setCourse(courseDAO.findById(classRegisterDTO.getCourseId()).orElse(null));
        classes.setTutor(tutorDAO.findById(classRegisterDTO.getTutorId()).orElse(null));
        classes.setSchool(schoolDAO.findById(classRegisterDTO.getSchoolId()).orElse(null));
        return classes;
    }

    public Register toRegister(ClassRegisterDTO classRegisterDTO) {
        Register register = new Register();

        register.setTutor(tutorDAO.findById(classRegisterDTO.getTutorId()).orElse(null));
        register.setSchoolYear(classRegisterDTO.getSchoolYear());

        return register;
    }

    public ClassRegisterDTO toClassRegisterDTO(Clazz classes) {
        ClassRegisterDTO classRegisterDTO = new ClassRegisterDTO();

        classRegisterDTO.setSchoolYear(classes.getRegisters().getSchoolYear());
        classRegisterDTO.setClassName(classes.getName());
        classRegisterDTO.setSchoolId(classes.getSchool().getId());
        classRegisterDTO.setCoordinatorId(classes.getCoordinator() != null ? classes.getCoordinator().getUser().getId() : null);
        classRegisterDTO.setCourseId(classes.getCourse().getId());
        classRegisterDTO.setTutorId(classes.getTutor() != null ? classes.getTutor().getUser().getId() : null);

        return classRegisterDTO;
    }

    public List<ClassRegisterDTO> toListOfClassRegisterDto(List<Clazz> classes) {
        List<ClassRegisterDTO> toReturn = new ArrayList<>();
        for (Clazz element : classes) {
            toReturn.add(this.toClassRegisterDTO(element));
        }
        return toReturn;
    }

    public List<Clazz> toListOfClass(List<ClassRegisterDTO> classRegisterListDto) {
        List<Clazz> toReturn = new ArrayList<>();
        for (ClassRegisterDTO element : classRegisterListDto) {
            toReturn.add(this.toClass(element));
        }
        return toReturn;
    }


}
