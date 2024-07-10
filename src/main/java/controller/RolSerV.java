package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.service.serviceImp.RolServiceImp;
import java.io.IOException;

@WebServlet("/rolserv")
public class RolSerV extends HttpServlet {
    private RolServiceImp rolServiceImp = new RolServiceImp();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("roles", rolServiceImp.getAllRoles());
        req.getRequestDispatcher("registro.jsp").forward(req, res);
    }
}