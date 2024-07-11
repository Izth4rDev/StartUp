package model.service;
import model.models.UserCarListDTO;
import java.util.List;

public interface ICarListService {
    public List<UserCarListDTO> getCarList();
}
