package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.models.LoginDTO;
import model.models.Supplier;
import model.models.UserCarList;
import model.models.UserRoleAuthDTO;
import model.service.serviceImp.LoginImp;
import model.service.serviceImp.SupplierServiceImp;
import model.service.serviceImp.UserCarListImp;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServ extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LoginDTO loginDTO = new LoginDTO();
        LoginImp loginImp = new LoginImp();
        UserCarListImp uclImp = new UserCarListImp();
        SupplierServiceImp suppServ = new SupplierServiceImp();

        UserRoleAuthDTO usrAuth;

        String mail = req.getParameter("mail");
        String password = req.getParameter("pass");

        loginDTO.setMail(mail);
        loginDTO.setPassword(password);

        usrAuth = loginImp.validateLogin(loginDTO);
        List<UserCarList> ucList = uclImp.getCarList();
        List<Supplier> suppList = suppServ.getSuppliers();

        if(usrAuth.getEval().equals("adm")){

            req.setAttribute("messageUsr", "Login exitoso");
            req.setAttribute("uclList", ucList);
            req.setAttribute("suppList",suppList);
            req.setAttribute("user", usrAuth);
            req.getRequestDispatcher("home.jsp").forward(req,res);

        }else if(usrAuth.getEval().equals("others")){
            req.setAttribute("messageUsr", "No eres admin, no tienes acceso");
        }else{
            req.setAttribute("messageUsr", "Error al Logearse, no existe usuario o contraseña incorrecta");
        }
        req.getRequestDispatcher("index.jsp").forward(req,res);
    }
}
