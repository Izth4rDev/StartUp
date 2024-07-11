package model.service.serviceImp;
import model.dao.daoImp.UserCarListDaoImp;
import model.models.UserCarList;
import model.service.ICarListService;
import java.util.List;

public class UserCarListImp implements ICarListService {
    UserCarListDaoImp uclDao = new UserCarListDaoImp();

    @Override
    public List<UserCarList> getCarList() {
        return uclDao.getAllCarList();
    }
}
