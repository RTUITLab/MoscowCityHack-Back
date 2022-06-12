package com.example.moscowcityhackback.graphql.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventFilter {
    String region;
    Boolean online;
    Boolean published;
}
