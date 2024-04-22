package com.teamproject1.scuoledevelhope.classes.school.service;

import com.teamproject1.scuoledevelhope.classes.school.School;
import com.teamproject1.scuoledevelhope.classes.school.repo.SchoolDAO;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolDAO schoolDAO;

    public SchoolService(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    public BaseResponseList<School> findAll() {
        return new BaseResponseList<>(schoolDAO.findAll());
    }

    public BaseResponseElement<School> findById(Long id) {
        Optional<School> result = schoolDAO.findById(id);
        if (result.isEmpty()) {
            throw new SQLException("School was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<School> save(School school) {
        return new BaseResponseElement<>(schoolDAO.save(school));
    }

    public BaseResponseElement<School> deleteById(Long id) {
        Optional<School> temp = schoolDAO.findById(id);

        if (temp.isEmpty()) {
            throw new SQLException("School was not present");
        }
        schoolDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}