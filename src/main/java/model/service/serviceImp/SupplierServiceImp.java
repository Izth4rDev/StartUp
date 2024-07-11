package model.service.serviceImp;
import model.dao.daoImp.SupplierDaoImp;
import model.models.Supplier;
import model.service.ISupplierService;
import java.util.List;

public class SupplierServiceImp implements ISupplierService {

    private SupplierDaoImp supplierDaoImp = new SupplierDaoImp();

    @Override
    public List<Supplier> getSuppliers() {
        return supplierDaoImp.getAllSuppliers();
    }
}
