package com.example.moscowcityhackback.config;

import graphql.scalars.ExtendedScalars;
import graphql.scalars.datetime.DateTimeScalar;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfig {
    @Bean
    public GraphQLScalarType localDateScalar() {
        return ExtendedScalars.Date;
    }
    @Bean
    public GraphQLScalarType offsetDateTimeScalar() {
        return ExtendedScalars.DateTime;
    }
    @Bean
    public GraphQLScalarType longScalar() {
        return ExtendedScalars.GraphQLLong;
    }
}
