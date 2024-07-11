package model.dao;

import model.models.LoginDTO;

public interface ILoginDao {
    public Boolean loginAuth(LoginDTO loginDTO);
}
