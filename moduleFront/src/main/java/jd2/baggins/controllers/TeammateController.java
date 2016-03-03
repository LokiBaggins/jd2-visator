package jd2.baggins.controllers;

import jd2.baggins.beans.Teammate;
import jd2.baggins.services.TeammateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/samplecontroller.do"})
public class TeammateController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("controller_message", "Message from controller!");

        TeammateService tmService = new TeammateService();
        List<Teammate> tmList = tmService.getAll();
        req.setAttribute("teamList", tmList);
        req.setAttribute("teammate", tmService.getById(tmList.get(0).getId()));
        req.getRequestDispatcher("pages/main.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
