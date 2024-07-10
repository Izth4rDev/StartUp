package model.service;

import model.models.Address;
import model.models.User;

public interface IUserService {
    public User insertUserAddress(User user, Address address);
}
