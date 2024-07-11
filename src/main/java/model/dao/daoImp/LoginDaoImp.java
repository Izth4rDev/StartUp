package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.ILoginDao;
import model.models.LoginDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImp implements ILoginDao {

    private static final String SELECT_AUTH_USER = "SELECT mail, password FROM user WHERE mail=? AND password=?";
    @Override
    public Boolean loginAuth(LoginDTO login) {

        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_AUTH_USER)){

           ps.setString(1, login.getMail());
           ps.setString(2, login.getPassword());

           try(ResultSet rs = ps.executeQuery()){
               return rs.next();
           }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
