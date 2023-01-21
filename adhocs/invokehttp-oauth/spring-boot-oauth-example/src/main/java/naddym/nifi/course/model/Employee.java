package naddym.nifi.course.model;

import lombok.*;

@Setter
@Getter
@Builder
public class Employee {

    private String name;
    private String age;
    private String address;
}
