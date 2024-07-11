package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.IUserCarlistDao;
import model.models.UserCarList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCarListDaoImp implements IUserCarlistDao {

    private static final String SELECT_CAR_USER = "SELECT u.name,u.nick, u.mail,u.weight,r.role_name,a.address_name,a.address_number,c.car_name\n" +
            "FROM user u LEFT JOIN user_roles ur ON u.id_user = ur.user_id\n" +
            "            LEFT JOIN roles r ON r.id_role = ur.role_id\n" +
            "            LEFT JOIN addresses a ON a.user_id=u.id_user\n" +
            "            LEFT JOIN cars c ON c.user_id  = u.id_user";

    @Override
    public List<UserCarList> getAllCarList() {

        List<UserCarList> ucList = new ArrayList<>();

        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_CAR_USER)){
            ResultSet rs =  ps.executeQuery();

            while(rs.next()){

                UserCarList ucl = new UserCarList();
                ucl.setName(rs.getString("u.name"));
                ucl.setNick(rs.getString("u.nick"));
                ucl.setMail(rs.getString("u.mail"));
                ucl.setWeight(rs.getString("u.weight"));
                ucl.setRole_name(rs.getString("r.role_name"));
                ucl.setAddress_name(rs.getString("a.address_name"));
                ucl.setAddress_number(rs.getInt("a.address_number"));
                ucl.setCar_name(rs.getString("c.car_name"));

                ucList.add(ucl);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ucList;
    }
}
