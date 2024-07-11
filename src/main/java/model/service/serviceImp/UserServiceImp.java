package model.service.serviceImp;
import model.dao.daoImp.AddressDaoImp;
import model.dao.daoImp.UserDaoImp;
import model.dao.daoImp.UserRoleDaoImp;
import model.models.Address;
import model.models.User;
import model.models.UserRole;
import model.service.IUserService;

import java.sql.SQLException;


public class UserServiceImp implements IUserService {
    private UserDaoImp userDaoImp = new UserDaoImp();
    private AddressDaoImp addressDaoImp = new AddressDaoImp();
    private UserRoleDaoImp userRoleDaoImp = new UserRoleDaoImp();

    @Override
    public Boolean insertUserAddress(User user, Address address, UserRole userRole) {
            Boolean userResp = false;

            try{
                user = userDaoImp.insertUser(user);
                // Asignar el user_id generado al objeto Address y al objeto useRole
                address.setUser_id(user.getUser_id());
                userRole.setUser_id(user.getUser_id());
                // Insertar la dirección asociada al usuario
                addressDaoImp.insertAddress(address);
                //Insertar en tabla intermedia userRole
                userRoleDaoImp.insertUserRole(userRole);
                userResp = true;
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }

        return userResp;
    }



}
