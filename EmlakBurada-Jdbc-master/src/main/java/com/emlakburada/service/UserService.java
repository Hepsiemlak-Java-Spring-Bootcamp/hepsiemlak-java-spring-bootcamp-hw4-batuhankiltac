package com.emlakburada.service;

import com.emlakburada.entity.User;
import com.emlakburada.repository.UserRepository;
import com.emlakburada.utility.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService extends DatabaseHelper implements UserRepository {
    private static final String INSERT_USER = "INSERT INTO USER (ID, NAME, EMAIL, BIO) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM USER";
    private static final String FIND_USER = "SELECT * FROM USER WHERE ID = ?";
    private static final String UPDATE_USER = "UPDATE USER SET NAME = ? WHERE ID = ?";
    private static final String DELETE_USER = "DELETE FROM USER WHERE NAME = ?";

    @Override
    public void save(User user) throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            PreparedStatement prepareStatement = null;
            try {
                prepareStatement = connection.prepareStatement(INSERT_USER);
                prepareStatement.setInt(1, user.getId());
                prepareStatement.setString(2, user.getName());
                prepareStatement.setString(3, user.getEmail());
                prepareStatement.setString(4, user.getBio());
                prepareStatement.executeUpdate();
                System.out.println("Kayıt oluşturuldu.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    assert prepareStatement != null;
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Connection oluşturulamadı!");
        }
    }

    private User prepareUser(int id, String name, String email, String bio) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setBio(bio);
        return user;
    }

    @Override
    public void findAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = getConnection();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet result = prepareStatement.executeQuery();

            while (result.next()) {
                int userId = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String bio = result.getString("bio");
                userList.add(prepareUser(userId, name, email, bio));
            }
            System.out.println(userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findOne(int id) throws SQLException {
        User user = null;
        Connection connection = getConnection();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_USER);
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                int userId = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String bio = result.getString("bio");
                user = prepareUser(userId, name, email, bio);
            }
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id) {

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, "Ahmet");
            preparedStatement.setInt(2, 6);
            preparedStatement.executeUpdate();
            System.out.println("Kayıt güncellendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, "Ahmet");
            preparedStatement.executeUpdate();
            System.out.println("Kayıt silindi.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnection().close();
        }
    }
}