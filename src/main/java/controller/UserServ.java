package controller;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.models.Address;
import model.models.User;
import model.service.serviceImp.UserServiceImp;

import java.util.Date;

@WebServlet("/user")
public class UserServ extends HttpServlet {
    private UserServiceImp userService = new UserServiceImp();

    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        User user = new User();
        Address address = new Address();

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
        user.setRole_id(role_id);
        Date now = new Date();
        user.setCreated_at(now);
        user.setUpdated_at(now);

        //Objeto model Address
        address.setAddress_name(addressName);
        address.setAddress_number(addressNum);

        userService.insertUserAddress(user, address);
    }
}
