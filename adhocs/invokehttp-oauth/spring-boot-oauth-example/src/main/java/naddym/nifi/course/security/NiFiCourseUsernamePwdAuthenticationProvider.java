package naddym.nifi.course.security;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class NiFiCourseUsernamePwdAuthenticationProvider implements  AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        if (username != null && username.equals("nifi_user")) {
            if (pwd != null && pwd.equals("awesome_nifi")) {
                return new UsernamePasswordAuthenticationToken(username, pwd, Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
            } else {
                throw new BadCredentialsException("Invalid Password !!");
            }
        } else  {
            throw new BadCredentialsException("User doesn't exist in the system");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}
