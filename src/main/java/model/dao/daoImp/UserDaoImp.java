package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.IUserDao;
import model.models.User;

import java.sql.*;

public class UserDaoImp implements IUserDao {
    private static final String INSERT_USER = "INSERT INTO user(mail, created_at, nick, name, password, weight, updated_at, role_id) VALUES (?,?,?,?,?,?,?,?)";
    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User insertUser(User user) {
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1,user.getMail());
            ps.setDate(2, new Date(user.getCreated_at().getTime()));
            ps.setString(3, user.getNick());
            ps.setString(4, user.getName());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getWeight());
            ps.setDate(7, new Date(user.getUpdated_at().getTime()));
            ps.setInt(8, user.getRole_id());

            int affectedRows =  ps.executeUpdate();

            //Verificamos que se haya insertado el registro
            if(affectedRows == 0){
                throw new SQLException("Crear usuario ha fallado");
            }

            //obtenemos el Id generado de la query Insert y lo asignamos al objeto usuario antes de retornarlo
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    user.setUser_id(rs.getInt(1));
                }else{
                    throw new SQLException("Creacion de usuario fallida no se pudo obtener el id");
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }
}
