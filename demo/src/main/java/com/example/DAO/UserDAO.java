package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Entities.*;

public class UserDAO {
    private Connection connection; // Thay bằng kết nối cơ sở dữ liệu thực tế

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(User user) {
        try {
            // Sử dụng PreparedStatement để thêm người dùng
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO user (userId, userName, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getEmail());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(String userId) {
        try {
            // Xoá người dùng dựa trên userId
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE userId = ?");
            preparedStatement.setString(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user) {
        try {
            // Cập nhật thông tin người dùng
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE user SET userName = ?, email = ? WHERE userId = ?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUserId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUser(String userId) {
        try {
            // Truy vấn thông tin người dùng dựa trên userId
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE userId = ?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                return new User(userId, userName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
                ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String userId = resultSet.getString("userId");
                String username = resultSet.getString("userName");
                String email= resultSet.getString("email");
                User user = new User(userId, username,email);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
