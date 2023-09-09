package com.alex.bracketschecker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
public class BracketsCheckerModel {
    @JsonProperty("isCorrect")
    private Boolean isCorrect;
    @JsonIgnore
    private final String text;
}
