package com.survey.api.controllers;

import com.github.fge.jsonpatch.JsonPatch;
import com.survey.api.Model.Survey;
import com.survey.api.services.SurveyServices;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("surveys")
public class SurveyController {

    @Autowired
    private SurveyServices surveyServices;

    @PostMapping()
    public ResponseEntity <Survey> addSurvey (@RequestBody Survey survey){
        surveyServices.create(survey);

        return ResponseEntity.ok(survey);
    }

    @GetMapping("/{id}")
    public Survey getCourseById (@PathVariable String  id){
        return surveyServices.findById(id).orElseThrow();
    }
    @GetMapping
    public List<Survey> getCourseById (){
        return surveyServices.findAll();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteBook(@PathVariable String id){
        surveyServices.deleteById(id);

        return ResponseEntity.ok("Deleted successfully");
    }
    @PatchMapping ("/{id}")
    public ResponseEntity<Survey> updateSurvey (@PathVariable String id, @RequestBody JsonPatch patch){
        return ResponseEntity.ok(surveyServices.patchOne(id,patch));
    }


}
