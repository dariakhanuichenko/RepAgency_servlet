package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;

public class CompletedRequests implements Command {

    private final RequestService requestService;

    public CompletedRequests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String master= (String)request.getSession().getAttribute( "userName");


        try {
            request.setAttribute("completedRequests",requestService.findByMasterAndStatus(master, "completed"));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/master/master-completed-request.jsp";
    }
}
