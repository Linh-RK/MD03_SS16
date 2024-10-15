package com.ra.config;

import com.ra.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet",value = "/home")
public class UserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "show":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                default:
                    break;
            }
        } else {
            showAll(req, resp);
        }
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) {
        List<User> userList = new ArrayList<>();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/")
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
