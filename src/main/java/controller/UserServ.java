package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.models.Address;
import model.models.User;
import model.models.UserRole;
import model.service.serviceImp.UserServiceImp;

import java.io.IOException;
import java.util.Date;

@WebServlet("/user")
public class UserServ extends HttpServlet {
    private UserServiceImp userService = new UserServiceImp();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = new User();
        Address address = new Address();
        UserRole userRole = new UserRole();
        Boolean userResp;

        //campos del user
        String name = req.getParameter("nameUser");
        String mail = req.getParameter("mail");
        String nick = req.getParameter("nick");
        String password = req.getParameter("pass");
        String weight = req.getParameter("weight");
        int role_id = Integer.parseInt(req.getParameter("role"));

        //Campos de direccion
        String addressName = req.getParameter("addressName");
        int addressNum = Integer.parseInt(req.getParameter("addressNum"));

        //Objeto model user
        user.setName(name);
        user.setMail(mail);
        user.setNick(nick);
        user.setPassword(password);
        user.setWeight(weight);
        Date now = new Date();
        user.setCreated_at(now);
        user.setUpdated_at(now);

        //Objeto model Address
        address.setAddress_name(addressName);
        address.setAddress_number(addressNum);

        //Objeto UserRole
        userRole.setRole_id(role_id);

        userResp = userService.insertUserAddress(user, address, userRole);

        if(userResp){
            req.setAttribute("userAdded", user);
            req.setAttribute("message", "Usuario creado exitosamente");
            req.setAttribute("userResp", userResp);
        }else{
            req.setAttribute("message","usuario no se pudo crear");
        }

        req.getRequestDispatcher("index.jsp").forward(req,res);

    }
}
