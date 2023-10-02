package com.survey.api.repositories;

import com.survey.api.Model.Survey;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SurveyRepository extends MongoRepository<Survey, String> {

}
