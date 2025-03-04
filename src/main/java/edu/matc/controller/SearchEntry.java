package edu.matc.controller;

import edu.matc.entity.CarbonFootprintEntry;
import edu.matc.persistence.CarbonFootprintEntryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

        CarbonFootprintEntryDao carbonFootprintEntryDao = new CarbonFootprintEntryDao();

        String search = req.getParameter("search");
        String submit = req.getParameter("submit");

        if (search == null || search.trim().isEmpty()) {
            req.setAttribute("carbonFootprintEntryList", carbonFootprintEntryDao.getAll());
        } else if ("search".equals(submit)) {
            req.setAttribute("carbonFootprintEntry", carbonFootprintEntryDao.getByPropertyEqual("entryDate", search.trim()));
        }


//        Integer userId = (Integer) req.getSession().getAttribute("userId");
//        String dateParam = req.getParameter("date");
//
//        if (userId != null && dateParam != null) {
//            LocalDate date = LocalDate.parse(dateParam);
//            List<CarbonFootprintEntry> entries = carbonFootprintEntryDao.getEntriesByUserIdAndDate(userId, date);
//            req.setAttribute("entries", entries);
//        } else {
//            req.setAttribute("errorMessage", "You must be logged in and provide a valid date.");
//            System.out.println("User ID in session: " + userId);
//
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

    }


}
