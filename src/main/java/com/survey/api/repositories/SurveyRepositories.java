package com.survey.api.repositories;

import com.survey.api.Model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SurveyRepositories extends MongoRepository<Survey, Long> {

}
