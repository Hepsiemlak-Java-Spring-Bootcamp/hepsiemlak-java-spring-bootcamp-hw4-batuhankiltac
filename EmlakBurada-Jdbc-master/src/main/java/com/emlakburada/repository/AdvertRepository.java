package com.emlakburada.repository;

import com.emlakburada.entity.Advert;

import java.sql.SQLException;

public interface AdvertRepository {
    void save(Advert advert) throws SQLException;
    void findAll() throws SQLException;
    void findOne(int id) throws SQLException;
    void update(int id) throws SQLException;
    void delete(int id) throws SQLException;
}