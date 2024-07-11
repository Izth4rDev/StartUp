package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.models.*;
import model.service.serviceImp.UserServiceImp;
import java.io.IOException;
import java.util.Date;

@WebServlet("/user")
public class UserServ extends HttpServlet {
    private UserServiceImp userService = new UserServiceImp();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Objetos del modelo
        User user = new User();
        Address address = new Address();
        UserRole userRole = new UserRole();
        Car car = new Car();

        Boolean userResp;

        //campos del user
        String name = req.getParameter("nameUser");
        String mail = req.getParameter("mail");
        String nick = req.getParameter("nick");
        String password = req.getParameter("pass");
        String weight = req.getParameter("weight");

        //Campos del rol
        int role_id = Integer.parseInt(req.getParameter("role"));

        //Campos de direccion
        String addressName = req.getParameter("addressName");
        int addressNum = Integer.parseInt(req.getParameter("addressNum"));

        //campos de auto
        String url = req.getParameter("urlCar");
        String car_name = req.getParameter("car");

        //campo proveedor
        int supplier_id = Integer.parseInt(req.getParameter("supplier"));

        //Seteo Objeto model user
        user.setName(name);
        user.setMail(mail);
        user.setNick(nick);
        user.setPassword(password);
        user.setWeight(weight);
        Date now = new Date();
        user.setCreated_at(now);
        user.setUpdated_at(now);

        //Seteo Objeto model Address
        address.setAddress_name(addressName);
        address.setAddress_number(addressNum);

        //Seteo Objeto UserRole
        userRole.setRole_id(role_id);

        //Seteo del objeto car
        car.setCar_name(car_name);
        car.setUrl(url);
        car.setSupplier_id(supplier_id);

        userResp = userService.insertUserAddress(user, address, userRole, car);

        if(userResp){
            req.setAttribute("userAdded", user);
            req.setAttribute("messageUsr", "Usuario creado exitosamente");
            req.setAttribute("userResp", userResp);
        }else{
            req.setAttribute("messageUsr","usuario no se pudo crear");
        }

        req.getRequestDispatcher("index.jsp").forward(req,res);

    }
}
