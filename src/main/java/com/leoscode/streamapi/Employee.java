package com.leoscode.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private String firstname;
    private String lastname;
    private Double salary;

    private List<String> projects;
}
