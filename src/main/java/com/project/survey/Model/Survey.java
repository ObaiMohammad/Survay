package com.project.survey.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "Survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Survey {

    @Id
    private Long id;
    private List<Question> questions;

}
