package model.service.serviceImp;
import model.dao.daoImp.RoleDaoImp;
import model.models.Role;
import model.service.IRoleService;
import java.util.List;

public class RolServiceImp implements IRoleService {
    private RoleDaoImp roleDao = new RoleDaoImp();

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
