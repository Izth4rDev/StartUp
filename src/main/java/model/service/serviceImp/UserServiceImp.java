package model.service.serviceImp;
import model.connection.MysqlConnection;
import model.dao.daoImp.AddressDaoImp;
import model.dao.daoImp.UserDaoImp;
import model.models.Address;
import model.models.User;
import model.service.IUserService;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImp implements IUserService {
    private UserDaoImp userDaoImp = new UserDaoImp();
    private AddressDaoImp addressDaoImp = new AddressDaoImp();

    @Override
    public User insertUserAddress(User user, Address address) {

            user = userDaoImp.insertUser(user);
            // Asignar el user_id generado al objeto Address
            address.setUser_id(user.getUser_id());
            // Insertar la dirección asociada al usuario
            addressDaoImp.insertAddress(address);

        return user;
    }
}
