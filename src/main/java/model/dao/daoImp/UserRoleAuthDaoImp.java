package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.IUserRoleAuthDao;
import model.models.UserRoleAuthDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleAuthDaoImp implements IUserRoleAuthDao {
    private static final String SELECT_USER_ROL_ADD = "SELECT u.name, u.mail, r.role_name FROM user u\n" +
            "    LEFT JOIN user_roles ur ON  u.id_user = ur.user_id\n" +
            "    LEFT JOIN roles r ON ur.role_id = r.id_role\n" +
            "WHERE u.mail = ?";
    @Override
    public UserRoleAuthDTO getUserRoleAdd(String mail) {

        UserRoleAuthDTO usr = new UserRoleAuthDTO();

        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_ROL_ADD)){

            ps.setString(1,mail);
            ResultSet res = ps.executeQuery();

            while(res.next()){
                usr.setName(res.getString("u.name"));
                usr.setMail(res.getString("u.mail"));
                usr.setRole_name(res.getString("r.role_name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return usr;
    }
}
