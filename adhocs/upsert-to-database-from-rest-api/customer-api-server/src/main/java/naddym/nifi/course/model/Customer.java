package naddym.nifi.course.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String name;
    private String age;
    private String address;
    private long zipCode;
}
