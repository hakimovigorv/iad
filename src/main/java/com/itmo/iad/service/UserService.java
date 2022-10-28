package com.itmo.iad.service;
import com.itmo.iad.model.ERole;
import com.itmo.iad.model.Role;
import com.itmo.iad.model.User;
import com.itmo.iad.repository.RoleRepository;
import com.itmo.iad.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    //public UserService() {
    //    this.users = List.of(
    //            new User("anton", "1234", "Антон", "Иванов", Collections.singleton(Role.USER)),
    //            new User("ivan", "12345", "Сергей", "Петров", Collections.singleton(Role.ADMIN))
    //    );
    //}

    public Optional<User> getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login);
    }

    public boolean existsByLogin(String username) {
        return userRepository.existsByLogin(username);
    }

    public String registerUser(User user) {
        Set<Role> roles= new HashSet<Role>();
        Role role = roleRepository.findByName(ERole.USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return "User registered successfully!";
    }

}