package com.project.survey.Controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.project.survey.Model.Survey;
import com.project.survey.Services.SurveyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Surveys")
public class SurveyController {

    @Autowired
    private SurveyServices surveyServices;

    @PostMapping()
    public ResponseEntity <Survey> addSurvey (@RequestBody Survey survey){
        surveyServices.create(survey);

        return ResponseEntity.ok(survey);
    }

    @GetMapping("/{id}")
    public Survey getCourseById (@PathVariable Long id){
        return surveyServices.findById(id).orElseThrow();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteBook(@PathVariable Long id){
        surveyServices.deleteById(id);

        return ResponseEntity.ok("Deleted successfully");
    }
    @PatchMapping ("/{id}")
    public ResponseEntity<Survey> updateSurvey (@PathVariable long id, @RequestBody JsonPatch patch){
        return ResponseEntity.ok(surveyServices.patchOne(id,patch));
    }
}
