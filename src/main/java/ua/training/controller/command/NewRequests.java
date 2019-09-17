package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;

public class NewRequests implements Command {

    private RequestService requestService;

    public NewRequests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.setAttribute("newRequests",requestService.findByStatus("new"));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/manager/manager-new-request.jsp";
    }
}
