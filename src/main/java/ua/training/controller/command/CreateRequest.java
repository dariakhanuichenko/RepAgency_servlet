package ua.training.controller.command;

import ua.training.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CreateRequest implements Command{

    private RequestService requestService=new RequestService();
    @Override
    public String execute(HttpServletRequest request) {
        String requestName=request.getParameter("request");

        String userName= (String)request.getSession().getAttribute( "userName");

        if (requestName == null || requestName.equals("")) {
            return "/WEB-INF/user/user-create-request.jsp";
        }
        try {
           requestService.addRequest(requestName, userName);

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        }
        return "/WEB-INF/user/user-create-request.jsp";
    }
}
