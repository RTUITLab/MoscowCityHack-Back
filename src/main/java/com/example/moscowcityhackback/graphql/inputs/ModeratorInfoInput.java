package com.example.moscowcityhackback.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeratorInfoInput {
    String name;
    String surname;
    Date birthdate;
    UserInput user;
}
