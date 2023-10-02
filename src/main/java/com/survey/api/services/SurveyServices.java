package com.survey.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.survey.api.Model.Survey;
import com.survey.api.repositories.SurveyRepository;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServices {

    private final SurveyRepository sRepository;

    @Autowired
    public SurveyServices(SurveyRepository sRepository ){
        this.sRepository = sRepository;
    }

    public Survey create (Survey survey){

        return sRepository.save(survey);
    }

    public Optional <Survey> findById (String id){

        return sRepository.findById(id);
    }    public List<Survey> findAll (){

        return sRepository.findAll();
    }

    public void deleteById ( String id){

        sRepository.deleteById(id);
    }

    public Survey patchOne(String  id, JsonPatch patch) {
        Survey survey = findById(id).orElseThrow();
        Survey patchedSurvey = patchSurvey(survey,patch);
        return sRepository.save(patchedSurvey);
    }
    private Survey patchSurvey(Survey survey, JsonPatch patch) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode surveyJson = objectMapper.convertValue(survey, JsonNode.class);
        try {
            JsonNode patched = patch.apply(surveyJson);
            survey = objectMapper.treeToValue(patched,Survey.class);
            return survey;
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}
