package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.ICarDao;
import model.models.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDaoImp implements ICarDao {
    private static final String INSERT_CAR = "INSERT INTO cars(car_name,user_id,supplier_id,url) VALUES (?,?,?,?)";

    @Override
    public Car insertCar(Car car) {
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_CAR)){

            ps.setString(1,car.getCar_name());
            ps.setInt(2,car.getUser_id());
            ps.setInt(3,car.getSupplier_id());
            ps.setString(4,car.getUrl());

            int affectedRow = ps.executeUpdate();

            if(affectedRow == 0){
                throw new SQLException("No se pudo insertar el Vehiculo");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return car;
    }
}
