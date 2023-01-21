package naddym.nifi.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class NiFiUser {

    private String user;
    private String pwd;
}
