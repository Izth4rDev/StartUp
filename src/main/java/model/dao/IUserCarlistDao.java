package model.dao;
import model.models.UserCarListDTO;
import java.util.List;

public interface IUserCarlistDao{
    public List<UserCarListDTO> getAllCarList();
}
