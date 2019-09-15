package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;


public class UserAllRequest implements Command {

    private RequestService requestService;

    public UserAllRequest(RequestService requestService) {
        System.out.println("controller all requests");
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String userName= (String)request.getSession().getAttribute( "userName");

        try {
            request.setAttribute("requests",requestService.findByCreator(userName));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/user/user-all-request.jsp";
    }
}
