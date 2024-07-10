package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.IRoleDao;
import model.models.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImp implements IRoleDao {
    private static final String SELECT_ALL_ROLES = "SELECT id_role, role_name FROM roles";

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<Role>();
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ROLES)){
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            while(rs.next()){
                Role role = new Role();
                role.setId_role(rs.getInt("id_role"));
                role.setRole_name(rs.getString("role_name"));
                roles.add(role);
            }

            System.out.println(roles);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }
}
