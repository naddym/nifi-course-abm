package naddym.nifi.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private long id;
    private String name;
    private String age;
    private String address;
    private long zipCode;
}
