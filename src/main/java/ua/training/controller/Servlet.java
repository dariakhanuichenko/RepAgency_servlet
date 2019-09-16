package ua.training.controller;

import ua.training.controller.command.*;
import ua.training.controller.command.Exception;
import ua.training.model.entity.Request;
import ua.training.model.service.RequestService;
import ua.training.model.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {
        UserService userService = new UserService();
        RequestService requestService=new RequestService();

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("logout", new LogOut());
        commands.put("login", new Login(userService));
        commands.put("registration", new Registration(userService));
        commands.put("exception", new Exception());

        commands.put("user/create_request", new CreateRequest(requestService));
        commands.put("user/all_requests", new UserAllRequest(requestService));

        commands.put("master/accepted_requests", new AcceptedRequests(requestService));
        commands.put("master/accepted_requests/make", new MakeInProgress(requestService));
        commands.put("master/in_progress_requests", new InProgressRequests(requestService));
        commands.put("master/in_progress_requests/done", new MakeCompleted(requestService));
        commands.put("master/in_progress_requests/beyond_repair", new MakeBeyondRepair(requestService));
        commands.put("master/completed_requests", new CompletedRequests(requestService));

        commands.put("manager/new_requests", new NewRequests(requestService));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/app/", "");
        System.out.println(path);
        Command command = commands.getOrDefault(path,
                (r) -> "/index.jsp)");
        String page = command.execute(request);
        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}