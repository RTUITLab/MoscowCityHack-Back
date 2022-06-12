package com.example.moscowcityhackback.entity.specification;

import com.example.moscowcityhackback.entity.event.Event;
import org.springframework.data.jpa.domain.Specification;

public class EventSpecification {

    public static Specification<Event> isRegion(String region) {
        if (region == null) {
            return null;
        }
        return ((root, query, cb) -> {
            return cb.like(root.get("asd"), region);
        });
    }
}
