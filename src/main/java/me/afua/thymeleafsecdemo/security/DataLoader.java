package me.afua.thymeleafsecdemo.security;

import me.afua.thymeleafsecdemo.entities.UserData;
import me.afua.thymeleafsecdemo.entities.UserRole;
import me.afua.thymeleafsecdemo.repositories.RoleRepository;
import me.afua.thymeleafsecdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new UserRole("USER"));
        roleRepository.save(new UserRole("ADMIN"));

        UserRole adminRole = roleRepository.findByRole("ADMIN");
        UserRole userRole = roleRepository.findByRole("USER");


        UserData userData = new UserData("bob@bob.com", "bob", "Bob", "Bobberson", true, "bob");
        userData.addRoles(userRole);
        userRepository.save(userData);


         userData = new UserData("jim@jim.com", "jim", "Jim", "Jimmerson", true, "jim");
        userData.addRoles(userRole);
        userRepository.save(userData);


         userData = new UserData("admin@adm.com", "pass", "Admin", "User", true, "admin");
        userData.addRoles(userRole);
        userRepository.save(userData);


         userData = new UserData("sam@ev.com", "pass", "Sam", "Everyman", true, "sam");
        userData.addRoles(userRole);
        userRepository.save(userData);
    }
}
