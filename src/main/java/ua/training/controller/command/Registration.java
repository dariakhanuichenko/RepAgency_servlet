package ua.training.controller.command;

import ua.training.model.entity.Role;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Registration implements Command {

    private UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String role= request.getParameter("role");
        System.out.println("Regisatation: " + name + " " + email + " " + " " + password);
        if (name == null || name.equals("") || password == null || password.equals("") || email == null || email.equals("")) {
            return "/registration.jsp";
        }
        try {
            if (userService.findUser(email, password).isPresent()) {
                throw new RuntimeException("User with this email already exist");
            }
            String userRole="";
            if(role.equals("ROLE_USER"))
                userRole=Role.ROLE_USER.name();
            if(role.equals("ROLE_MASTER"))
                userRole=Role.ROLE_MASTER.name();
            if(role.equals("ROLE_MANAGER"))
                userRole=Role.ROLE_MANAGER.name();
            userService.addUser(email, name, password, Role.valueOf(userRole));

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }
        return "/welcome.jsp";
    }
}
