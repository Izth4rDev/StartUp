package model.dao.daoImp;
import model.connection.MysqlConnection;
import model.dao.ISupplierDao;
import model.models.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImp implements ISupplierDao {
    private static final String SELECT_SUPPLIER = "SELECT supplier_name FROM supplier";
    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();

        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_SUPPLIER)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Supplier supplier = new Supplier();
                supplier.setSupplier_name(rs.getString("supplier_name"));
                suppliers.add(supplier);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return suppliers;
    }
}
