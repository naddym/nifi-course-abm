package naddym.nifi.course.controller;

import naddym.nifi.course.utils.JWTTokenGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/access")
public class LoginController {

    @GetMapping(value = "token")
    public ResponseEntity<Map<String, String>> getToken() {
        String jwt = JWTTokenGenerator.generateToken();
        Map<String, String> data = new HashMap<>();
        data.put("access_token", jwt);
        data.put("issued_at", Instant.now().toString());
        return ResponseEntity.ok().body(data);
    }

}
