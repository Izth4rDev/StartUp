package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.IAddressDao;
import model.models.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDaoImp implements IAddressDao {
    private static final String INSERT_ADDRESS = "INSERT INTO addresses (address_name, address_number, user_id) VALUES (?,?,?)";

    @Override
    public Address insertAddress(Address address){
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ADDRESS)){

            ps.setString(1,address.getAddress_name());
            ps.setInt(2,address.getAddress_number());
            ps.setInt(3, address.getUser_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("No se pudo insertar la fila de Direcciones");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return address;
    }
}
