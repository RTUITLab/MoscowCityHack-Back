package com.example.moscowcityhackback.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
    String login;
    String password;
    RoleInput role;
}
