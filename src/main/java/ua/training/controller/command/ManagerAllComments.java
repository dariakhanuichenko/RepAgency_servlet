package ua.training.controller.command;

import ua.training.model.service.CommentService;
import javax.servlet.http.HttpServletRequest;

public class ManagerAllComments implements Command {

    private CommentService commentService;


    public ManagerAllComments(CommentService commentService) {
        this.commentService = commentService;
    }
    @Override
    public String execute(HttpServletRequest request) {

        try {
            commentService.findAllComment().ifPresent(com->request.setAttribute("comments",com));

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/manager/manager-all-comment.jsp";
    }
}
