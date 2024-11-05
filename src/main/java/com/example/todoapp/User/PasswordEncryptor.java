package com.example.todoapp.User;


public class PasswordEncryptor {


    public String encrypt (String password) {
        StringBuilder encryptedPassword = new StringBuilder();
        for (char character : password.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encryptedPassword.append((char) ((character - base + 4) % 26 + base));
            } else if (Character.isDigit(character)) {
                encryptedPassword.append((char) ((character - '0' + 8) % 10 + '0'));
            } else{encryptedPassword.append(character);}
        }
        return encryptedPassword.toString();
    }

    public String decrypt (String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();
        for (char character : encryptedPassword.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                decryptedPassword.append((char) ((character - base - 4 + 26) % 26 + base));
            } else if (Character.isDigit(character)) {
                decryptedPassword.append((char) ((character - '0' - 8 + 10) % 10 + '0'));
            } else{
                decryptedPassword.append(character);}
        }
        return decryptedPassword.toString();
    }
}
