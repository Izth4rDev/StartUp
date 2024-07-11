package model.service.serviceImp;
import model.dao.daoImp.UserCarListDaoImp;
import model.models.UserCarListDTO;
import model.service.ICarListService;
import java.util.List;

public class UserCarListImp implements ICarListService {
    UserCarListDaoImp uclDao = new UserCarListDaoImp();

    @Override
    public List<UserCarListDTO> getCarList() {
        return uclDao.getAllCarList();
    }
}
