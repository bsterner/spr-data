package com.spr.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String nickname;

    @Column(name = "employees_number")
    private Integer emplNumber;

    public Employee(String name, Integer emplNumber) {
        this.name = name;
        this.emplNumber = emplNumber;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmplNumber() {
        return emplNumber;
    }

    public void setEmplNumber(Integer emplNumber) {
        this.emplNumber = emplNumber;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.JSON_STYLE);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
