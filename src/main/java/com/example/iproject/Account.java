package com.example.iproject;

public class Account extends CreateAccountController implements AccountDetails {
    public static String username;
    public static String password;
    public static String role;

    @Override
    public void setRole(String newName, String newRole) {
        username = newName;
        role = newRole;
    }
    // TODO Log-in Log out button
    // TODO: 1/5/2022 add + and - signs to the footer of the table to add or remove items.
}
