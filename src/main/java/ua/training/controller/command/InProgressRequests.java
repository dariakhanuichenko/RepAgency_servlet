package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;

public class InProgressRequests implements Command{

    private RequestService requestService;

    public InProgressRequests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String master= (String)request.getSession().getAttribute( "userName");


        try {
            request.setAttribute("inProgressRequests",requestService.findByMasterAndStatus(master, "in progress"));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/master/master-in-progress-request.jsp";
    }
}