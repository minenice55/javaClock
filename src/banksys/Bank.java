/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

import java.util.ArrayList;

/**
 *
 * @author minenice
 */
public class Bank {
    static ArrayList<Atm> atms;
    static ArrayList<User> users;
    
    static void addUser(User user) {
        users.add(user);
    }

    static ArrayList<Atm> getAtms() {
        return atms;
    }

    static ArrayList<User> getUsers() {
        return users;
    }
}
