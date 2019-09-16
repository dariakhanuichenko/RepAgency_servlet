package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;

public class MakeBeyondRepair implements Command {
    private RequestService requestService;


    public MakeBeyondRepair(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try{
            System.out.println(request.getParameter("id"));
            Long id=Long.parseLong(request.getParameter("id"));
            ;
            requestService.updateRequest("beyond repair", id);
        }catch( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "redirect:/api/app/master/in_progress_requests";
    }
}
