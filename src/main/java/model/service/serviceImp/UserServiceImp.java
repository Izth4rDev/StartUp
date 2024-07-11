package model.service.serviceImp;
import model.dao.daoImp.AddressDaoImp;
import model.dao.daoImp.CarDaoImp;
import model.dao.daoImp.UserDaoImp;
import model.dao.daoImp.UserRoleDaoImp;
import model.models.*;
import model.service.IUserService;

import java.sql.SQLException;


public class UserServiceImp implements IUserService {
    private UserDaoImp userDaoImp = new UserDaoImp();
    private AddressDaoImp addressDaoImp = new AddressDaoImp();
    private UserRoleDaoImp userRoleDaoImp = new UserRoleDaoImp();
    private CarDaoImp carDaoImp = new CarDaoImp();

    @Override
    public Boolean insertUserAddress(User user, Address address, UserRole userRole, Car car) {
            Boolean userResp = false;

            try{

                user = userDaoImp.insertUser(user);
                // Asignar el user_id generado al objeto Address, objeto useRole y objeto car
                address.setUser_id(user.getUser_id());
                userRole.setUser_id(user.getUser_id());
                car.setUser_id(user.getUser_id());
                // Insertar la dirección asociada al usuario
                addressDaoImp.insertAddress(address);
                //Insertar en tabla intermedia userRole
                userRoleDaoImp.insertUserRole(userRole);
                //Insertar en la tabla car
                carDaoImp.insertCar(car);

                userResp = true;
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }

        return userResp;
    }



}
