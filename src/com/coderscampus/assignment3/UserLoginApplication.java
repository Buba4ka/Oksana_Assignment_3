package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) {

        UserService userService = new UserService();
        //UserPOJO [] users = userService.createUsers();

        userService.userLogIn();

        //userService.userIteration(users);

    }

}
