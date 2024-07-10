package model.dao;
import model.models.User;

public interface IUserDao {
    public User getUser(int id);
    public User insertUser(User user);
}
