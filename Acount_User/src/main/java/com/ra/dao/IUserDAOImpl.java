package com.ra.dao;

import com.ra.model.User;
import com.ra.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserDAOImpl implements IUserDAO {
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(Connection connection = ConnectDB.openConnection();
            CallableStatement cb = connection.prepareCall("{call pro_show_user()}")) {
            ResultSet rs = cb.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return users;
}

    @Override
    public boolean create(User user) {
        try(Connection connection = ConnectDB.openConnection();
            CallableStatement cb = connection.prepareCall("{call pro_add_user(?,?,?,?)}")) {
            cb.setString(1, user.getFullName());
            cb.setString(2, user.getEmail());
            cb.setString(3, user.getPassword());
            cb.setString(4, user.getPhone());
            if(cb.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }

    @Override
    public User findById(int _id) {
        try(Connection connection = ConnectDB.openConnection();
            CallableStatement cb = connection.prepareCall("{call pro_showByID_user(?)}")) {
            cb.setInt(1, (_id));
            ResultSet rs = cb.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(_id);
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRole(Boolean.parseBoolean(rs.getString("role")));
                user.setStatus(Boolean.parseBoolean(rs.getString("status")));
                return user;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public Boolean update(User user) {
        try(Connection connection = ConnectDB.openConnection();
            CallableStatement cb = connection.prepareCall("{call pro_update_user(?,?,?,?,?)}")) {
            cb.setString(1, user.getFullName());
            cb.setString(2, user.getEmail());
            cb.setString(3, user.getPassword());
            cb.setString(4, user.getPhone());
            cb.setInt(5, user.getId());
            if(cb.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }

    @Override
    public Boolean delete(int _id) {
        try(Connection connection = ConnectDB.openConnection();
            CallableStatement cb = connection.prepareCall("{call pro_delete_user(?)}")) {
            cb.setInt(1, _id);
            if(cb.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }
}
