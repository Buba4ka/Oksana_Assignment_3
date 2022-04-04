package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

    public UserPOJO [] createUsers () {
        //UserPOJO user = new UserPOJO();
        UserPOJO[] users = new UserPOJO[4];
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader("data.txt"));

            int index = 0;

            String userString = "";
            while ((userString = fileReader.readLine()) != null) {

                String[] userInfo = userString.split(",");
                UserPOJO user = new UserPOJO();
                user.setUsername(userInfo[0]);
                user.setPassword(userInfo[1]);
                user.setName(userInfo[2]);

                users[index] = user;
                //System.out.println(users[index].getUsername() + "," + users[index].getPassword() + "," + users[index].getName());
                index++;

            }
        } catch (FileNotFoundException ex) {
            System.out.println("There is no such file");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //System.out.println(users.toString());
        return users;
    }

    public void userLogIn () {

        UserPOJO[] usersInfo = createUsers();

        Scanner sc = new Scanner(System.in);
        int attempt = 0;
        int index = 0;


        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        UserPOJO newUser = usersInfo[index];

        while (attempt != 5 && (!username.equalsIgnoreCase(newUser.getUsername()) || !password.equals(newUser.getPassword()))){
            while (index < 3 && (!username.equalsIgnoreCase(newUser.getUsername()) || !password.equals(newUser.getPassword()))) {
                index++;
                newUser = usersInfo[index];
            }
            if (index == 3 && (!username.equalsIgnoreCase(newUser.getUsername()) || !password.equals(newUser.getPassword()))) {
                attempt++;
                System.out.println("Invalid login, please try again: ");
                System.out.println("Enter your username: ");
                username = sc.nextLine();
                System.out.println("Enter your password: ");
                password = sc.nextLine();
                index = 0;
                newUser = usersInfo[index];
            }

        }if (attempt <= 5 && username.equalsIgnoreCase(newUser.getUsername()) && password.equals(newUser.getPassword())) {
                System.out.println("Welcome " + newUser.getName());

        } else if (attempt == 5 && (!username.equalsIgnoreCase(newUser.getUsername()) || !password.equals(newUser.getPassword()))) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

    }


}
