package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;


public class UserAllRequest implements Command {

    private RequestService requestService;

    public UserAllRequest(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String userName= (String)request.getSession().getAttribute( "userName");

        try {
            requestService.findByCreatorAndStatus(userName,"rejected").ifPresent(requests->request.setAttribute("rejectRequests",requests));
            requestService.findByCreatorAndNotStatus(userName, "rejected").ifPresent(requests->request.setAttribute("requests",requests));


        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/user/user-all-request.jsp";
    }
}
