package model.dao;
import model.models.Address;

import java.sql.SQLException;

public interface IAddressDao {
    public Address insertAddress(Address address) throws SQLException;
}
