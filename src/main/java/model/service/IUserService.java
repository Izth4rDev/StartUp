package model.service;

import model.models.*;

public interface IUserService {
    public Boolean insertUserAddress(User user, Address address, UserRole userRole, Car car);
}
