package edu.matc.controller;

import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * A servlet to search for the Users entry.
 *
 * @author egimm
 */


@WebServlet(
        urlPatterns = {"/searchEntry"}
)
public class SearchEntry extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();

        String entry = req.getParameter("userName");
        if (entry != null) {
            req.setAttribute("users", userDao.getByPropertyEqual ("userName", entry));
        } else {
            req.setAttribute("entry", userDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

    }


}
