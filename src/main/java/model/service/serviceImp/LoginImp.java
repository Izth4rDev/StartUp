package model.service.serviceImp;
import model.dao.daoImp.LoginDaoImp;
import model.dao.daoImp.UserRoleAuthDaoImp;
import model.models.LoginDTO;
import model.models.UserRoleAuthDTO;
import model.service.ILogin;

public class LoginImp implements ILogin {
    private final LoginDaoImp loginDaoImp = new LoginDaoImp();
    private final UserRoleAuthDaoImp uraDaoImp = new UserRoleAuthDaoImp();

    @Override
    public UserRoleAuthDTO validateLogin(LoginDTO loginDTO) {
        Boolean resAuth;
        UserRoleAuthDTO uraAuth = new UserRoleAuthDTO();
        resAuth = loginDaoImp.loginAuth(loginDTO);

        //Verificamos si existe el usuario en la base de datos
        if(resAuth){
            uraAuth = uraDaoImp.getUserRoleAdd(loginDTO.getMail());
           //Verificamos que el usuario es Admin o no
           if(uraAuth.getRole_name().equals("administrativo")){
               uraAuth.setEval("adm");
           }else{
               uraAuth.setEval("others");
           }
        }else{
            uraAuth.setName("notFound");
            uraAuth.setRole_name("notFound");
            uraAuth.setMail("notFound");
            uraAuth.setEval("error");
        }

        return uraAuth;

    }
}
