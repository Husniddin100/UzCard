package com.example.UzCard.config;


import com.example.UzCard.entity.CompanyEntity;
import com.example.UzCard.entity.ProfileEntity;
import com.example.UzCard.exp.AppBadException;
import com.example.UzCard.repository.CompanyRepository;
import com.example.UzCard.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // login/username
        Optional<ProfileEntity> optional = profileRepository.findByUsername(username);
        if (optional.isEmpty()) {
            throw new AppBadException("Bad Credentials. Mazgi");
        }

        ProfileEntity profile = optional.get();
        return new CustomUserDetails(profile.getId(), profile.getUsername(),
                profile.getPassword(), profile.getStatus(), profile.getRole());
    }
}
