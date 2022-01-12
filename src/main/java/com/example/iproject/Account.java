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
    //TODO separating different meds (drinkable for ex)   -------DONE
    //TODO Log-in Log out button
    //TODO Multiple criteria search   ----------DONE
    // TODO: 1/5/2022 press enter to search/login   ---------DONE
    // TODO: 1/5/2022 partial words searching (not whole words)   ----------DONE
    // TODO: 1/5/2022 add a back button besides Search to clear the input and reset filters    -------DONE
    // TODO: 1/5/2022 placeholder text for fields       -----DONE
    // TODO: 1/5/2022 differentiate navigation buttons from actionable buttons (aspect or ellipses...)    -------DONE
    // TODO: 1/5/2022 add + and - signs to the footer of the table to add or remove items.
    // TODO: 1/5/2022 remove redundant title   ------DONE
}
