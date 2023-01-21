package naddym.nifi.course.security;

import naddym.nifi.course.model.NiFiUser;
import naddym.nifi.course.model.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NiFiUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<String> users = Collections.singletonList("nifi_user");
        if (users.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        }
        return new SecurityUser(new NiFiUser(users.get(0), "awesome_nifi"));
    }
}
