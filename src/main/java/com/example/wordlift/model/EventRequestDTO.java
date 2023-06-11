package com.example.wordlift.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class EventRequestDTO {
    @NotEmpty
    private String source;

    @NotEmpty
    @URL
    private String url;

    List<Map<String, Object>> args = new ArrayList<>();
}
