package com.cubes.services;

import com.cubes.infrastructure.UserRepository;
import io.agroal.api.AgroalDataSource;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.mariadb.jdbc.plugin.authentication.standard.ed25519.Utils.bytesToHex;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    public boolean register(User user, AgroalDataSource dataSource) {
        String hashedPassword = hashPassword(user.getPassword());
        if (hashedPassword == null) {
            return false;
        }
        return userRepository.register(user, hashedPassword, dataSource);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
