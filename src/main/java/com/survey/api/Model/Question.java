package com.survey.api.Model;

import com.survey.api.Model.Enum.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;
    private String questionBody;
    private List<String> choices;
    private QuestionType questionType;

}
