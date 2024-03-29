package com.TYR.MainPackage.Service.Implementator;

import com.TYR.MainPackage.Model.Entity.AppUser;
import com.TYR.MainPackage.Model.Entity.User;
import com.TYR.MainPackage.Repository.UserRepository;
import com.TYR.MainPackage.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementator implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByusername(username).orElseThrow(() -> (
                new UsernameNotFoundException("Invalid user credential"))
                );
        return AppUser.builder()
                .userId(user.getId())
                .password(user.getPassword())
                .role(user.getRole().getName())
                .build();
    }

    @Override
    public AppUser loadUserByUserId(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> (
                new UsernameNotFoundException("Invalid user credential"))
        );
        return AppUser.builder()
                .userId(user.getId())
                .password(user.getPassword())
                .role(user.getRole().getName())
                .build();
    }
}