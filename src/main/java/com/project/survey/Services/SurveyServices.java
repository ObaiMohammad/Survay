package com.project.survey.Services;

import com.project.survey.Model.Survey;
import com.project.survey.Repositories.SurveyRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyServices {

    private final SurveyRepositories sRepository;

    @Autowired
    public SurveyServices(SurveyRepositories sRepository ){
        this.sRepository = sRepository;
    }

    public Survey create (Survey survey){

        return sRepository.save(survey);
    }

    public Optional <Survey> findById (Long id){

        return sRepository.findById(id);
    }

    public void deleteById (Long id){

        sRepository.deleteById(id);
    }

}
