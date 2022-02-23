package com.emlakburada.service;

import com.emlakburada.entity.Advert;
import com.emlakburada.repository.AdvertRepository;
import com.emlakburada.utility.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertService extends DatabaseHelper implements AdvertRepository {
    private static final String INSERT_ADVERT = "INSERT INTO ADVERT (ID, ADVERTNO, TITLE, DESCRIPTION) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_ADVERTS = "SELECT * FROM ADVERT";
    private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE ID = ?";
    private static final String UPDATE_ADVERT = "UPDATE ADVERT SET TITLE = ? WHERE ID = ?";
    private static final String DELETE_ADVERT = "DELETE FROM ADVERT WHERE ADVERTNO = ?";

    @Override
    public void save(Advert advert) throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            PreparedStatement prepareStatement = null;
            try {
                prepareStatement = connection.prepareStatement(INSERT_ADVERT);
                prepareStatement.setInt(1, advert.getId());
                prepareStatement.setInt(2, advert.getAdvertNo());
                prepareStatement.setString(3, advert.getTitle());
                prepareStatement.setString(4, advert.getDescription());
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

    private Advert prepareAdvert(int id, int advertNo, String title, String description) {
        Advert advert = new Advert();
        advert.setId(id);
        advert.setAdvertNo(advertNo);
        advert.setTitle(title);
        advert.setDescription(description);
        return advert;
    }

    @Override
    public void findAll() throws SQLException {
        List<Advert> advertList = new ArrayList<>();
        Connection connection = getConnection();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERTS);
            ResultSet result = prepareStatement.executeQuery();

            while (result.next()) {
                int advertId = result.getInt("id");
                int advertNo = result.getInt("advertNo");
                String title = result.getString("title");
                String description = result.getString("description");
                advertList.add(prepareAdvert(advertId, advertNo, title, description));
            }
            System.out.println(advertList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findOne(int id) throws SQLException {
        Advert advert = null;
        Connection connection = getConnection();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                int advertId = result.getInt("id");
                int advertNo = result.getInt("advertNo");
                String title = result.getString("title");
                String description = result.getString("description");
                advert = prepareAdvert(id, advertNo, title, description);
            }
            System.out.println(advert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADVERT);
            preparedStatement.setString(1, "Acil Satılık!!");
            preparedStatement.setInt(2, 1);
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADVERT);
            preparedStatement.setInt(1, 3424324);
            preparedStatement.executeUpdate();
            System.out.println("Kayıt silindi.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnection().close();
        }
    }
}