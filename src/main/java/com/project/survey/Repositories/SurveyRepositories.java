package com.project.survey.Repositories;

import com.project.survey.Model.Question;
import com.project.survey.Model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SurveyRepositories extends MongoRepository<Survey, Long> {

}
