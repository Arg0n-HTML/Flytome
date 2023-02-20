package com.cubes.infrastructure;

import com.cubes.services.User;
import io.agroal.api.AgroalDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    public boolean register(User user, String hashedPassword, AgroalDataSource dataSource) {
        String query = "INSERT INTO `users` (Name, Email, Password) VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + hashedPassword + "');";
        try {
            Connection con = dataSource.getConnection();
            Statement stm = con.createStatement();

            stm.executeUpdate(query);
        } catch (SQLException e) {
            return false;

        }
        return true;
    }
}
