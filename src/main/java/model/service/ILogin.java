package model.service;
import model.models.LoginDTO;
import model.models.UserRoleAuthDTO;

public interface ILogin {
    public UserRoleAuthDTO validateLogin(LoginDTO loginDTO);
}
