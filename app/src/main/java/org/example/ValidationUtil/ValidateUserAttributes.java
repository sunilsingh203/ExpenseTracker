package org.example.ValidationUtil;


import java.util.regex.Pattern;

public class ValidateUserAttributes {

    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    private static final Pattern PASSWORD_REGEX = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
    );

    public static boolean isValidEmail(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return PASSWORD_REGEX.matcher(password).matches();
    }

    public static void validateUserAttributes(String username,  String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is required");
        }

        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters and include uppercase, lowercase, number, and special character");
        }
    }
}
