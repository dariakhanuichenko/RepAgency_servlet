package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        //TODO: убрать пользователя из контекста
        return "redirect:/api";
    }
}
