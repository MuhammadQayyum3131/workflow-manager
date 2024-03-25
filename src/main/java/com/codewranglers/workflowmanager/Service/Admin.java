package com.codewranglers.workflowmanager.Service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface Admin {

    String renderUserManagementPortal(Model model);
    String searchUser(String fName, Model model);
}
