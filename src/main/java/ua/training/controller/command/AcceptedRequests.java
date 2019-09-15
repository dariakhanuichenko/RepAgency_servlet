package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;

public class AcceptedRequests implements Command {
    private RequestService requestService;

    public AcceptedRequests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String master= (String)request.getSession().getAttribute( "userName");


        try {
            request.setAttribute("acceptedRequests",requestService.findByMasterAndStatus(master, "accepted"));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/master/master-accepted-request.jsp";
    }
}
