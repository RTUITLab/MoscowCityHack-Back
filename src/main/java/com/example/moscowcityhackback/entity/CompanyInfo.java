package com.example.moscowcityhackback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CompanyInfo extends AbstractEntity{
    private String name;
    private String address;
    @OneToOne
    private UserInfo userInfo;

    public CompanyInfo(Long id, String name, String address, UserInfo userInfo) {
        super(id);
        this.name = name;
        this.address = address;
        this.userInfo = userInfo;
    }
}
