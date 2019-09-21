package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class AcceptedRequests implements Command {
    private RequestService requestService;

    public AcceptedRequests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String master = (String) request.getSession().getAttribute("userName");


        try {
            Optional<List<ua.training.model.entity.Request>> list = requestService.findByMasterAndStatus
                    (master, "accepted");

            list.ifPresent(requests -> request.setAttribute("acceptedRequests", requests));


        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/master/master-accepted-request.jsp";
    }
}
