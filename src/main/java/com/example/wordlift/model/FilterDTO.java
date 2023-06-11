package com.example.wordlift.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FilterDTO {
    List<String> url = new ArrayList<>();

    @JsonProperty("date_greater_than")
    LocalDateTime dateGreaterThan;

    @JsonProperty("date_less_than")
    LocalDateTime dateLessThan;

    Long cursor;

    Integer limit;
}

