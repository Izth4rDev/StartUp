package model.service;

import model.models.Address;
import model.models.User;
import model.models.UserRole;

public interface IUserService {
    public Boolean insertUserAddress(User user, Address address, UserRole userRole);
}
