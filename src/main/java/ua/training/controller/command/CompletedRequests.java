package ua.training.controller.command;

import ua.training.model.entity.Request;
import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class CompletedRequests implements Command {

    private final RequestService requestService;

    public CompletedRequests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String master= (String)request.getSession().getAttribute( "userName");

        try {
            requestService.findByMasterAndStatus(master, "completed").ifPresent(requests ->
                    request.setAttribute("completedRequests", requests));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/master/master-completed-request.jsp";
    }
}
