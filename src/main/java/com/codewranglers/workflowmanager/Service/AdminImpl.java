package com.codewranglers.workflowmanager.Service;

import com.codewranglers.workflowmanager.models.User;
import com.codewranglers.workflowmanager.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
class AdminImpl implements Admin {

    @Autowired
   private UserRepository userRepository;

    @Override
    public String renderUserManagementPortal(Model model) {
        Iterable<User> users = userRepository.findAll();

        // Using Map with key as User and Value as Role to show Role name on user index page.
        Map<User, String> userMap = new LinkedHashMap<>();

        for (User user : users) {
            if (user.getRole() == 1) {
                userMap.put(user, "Manager");
            }
            if (user.getRole() == 2) {
                userMap.put(user, "Member");
            }
            if (user.getRole() == 3) {
                userMap.put(user, "Administrator");
            }
        }
        model.addAttribute("users", userMap);
        return "admin/user_management/index";
    }

    public String searchUser(String fName, Model model){
        List<User> userList = userRepository.findByFirstnameStartingWithIgnoreCase(fName);

        // Using Map with key as User and Value as Role to show Role name on user index page.
        Map<User, String> userMap = new LinkedHashMap<>();

        for (User user : userList) {
            if (user.getRole() == 1) {
                userMap.put(user, "Manager");
            }
            if (user.getRole() == 2) {
                userMap.put(user, "Member");
            }
            if (user.getRole() == 3) {
                userMap.put(user, "Administrator");
            }
        }
        model.addAttribute("FirstName", fName);
        model.addAttribute("users", userMap);
        return "admin/user_management/search_user";
    }
}
