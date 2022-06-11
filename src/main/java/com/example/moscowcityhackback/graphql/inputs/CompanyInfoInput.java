package com.example.moscowcityhackback.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfoInput {
    String name;
    String address;
    UserInput user;
}
