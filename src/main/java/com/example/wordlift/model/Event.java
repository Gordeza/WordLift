package com.example.wordlift.model;

import io.r2dbc.postgresql.codec.Json;
import jakarta.persistence.Convert;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table("event")
public class Event {
    @Id
    private Long id;

    @NotEmpty
    private String source;

    @NotEmpty
    @URL
    private String url;

    private Map<String, Object> args;

    @CreationTimestamp
    private LocalDateTime recordedAt;

    public Event(EventRequestDTO dto) {
        this.source = dto.getSource();
        this.url = dto.getUrl();
        this.args = new HashMap<>();
        for(Map<String, Object> m : dto.getArgs()) {
            this.args.putAll(m);
        }
    }

}
