package com.example.agence.handelers.sign_in;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class hashPassword {
    public static String hashPasswd(String plainTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(plainTextPassword.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //compare tow Hashees
    public static boolean compareHashes(String hash1, String hash2) {
        return hash1.equals(hash2);
    }
}
