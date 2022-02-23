package com.emlakburada.repository;

import com.emlakburada.entity.User;

import java.sql.SQLException;

public interface UserRepository {
	void save(User user) throws SQLException;
	void findAll() throws SQLException;
	void findOne(int id) throws SQLException;
	void update(int id) throws SQLException;
	void delete(int id) throws SQLException;
}