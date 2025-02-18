package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * A servlet to search for the Users entry.
 *
 * @author egimm
 */


@WebServlet(
        urlPatterns = {"/searchEntry"}
)
public class SearchEntry extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        UserDao userDao = new UserDao();

        String entry = request.getParameter("userName");
        if (entry != null) {
            request.setAttribute("users", userDao.getPropertyByEqual ("userName", entry));
        } else {
            request.setAttribute("entry", userDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

    }


}
