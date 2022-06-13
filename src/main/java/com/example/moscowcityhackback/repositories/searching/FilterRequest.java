package com.example.moscowcityhackback.repositories.searching;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FilterRequest implements Serializable {

//    private static final long serialVersionUID = 6293344849078612450L;

    public String key;

    public Operator operator;

    public FieldType fieldType;

    public transient Object value;

    public transient Object valueTo;

    public transient List<Object> values;

}
