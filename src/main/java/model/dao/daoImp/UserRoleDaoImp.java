package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.IUserRoleDAO;
import model.models.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRoleDaoImp implements IUserRoleDAO {
    private static final String INSERT_USER_ROLE = "INSERT INTO user_roles (role_id, user_id) VALUES (?,?)";
    @Override
    public UserRole insertUserRole(UserRole userRole) {
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER_ROLE)){

            ps.setInt(1,userRole.getRole_id());
            ps.setInt(2,userRole.getUser_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("No se pudo insertar el rol");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return userRole;
    }
}
