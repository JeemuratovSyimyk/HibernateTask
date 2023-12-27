package org.example;

import org.example.Service.ServiceImpl.UserServiceImpl;
import org.example.Service.UserService;


import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
      UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
  while (true) {
      int num = scanner.nextInt();
      switch (num) {
          case 1 -> userService.createUsersTable();
          case 2-> userService.dropUsersTable();
          case 3 -> {
              userService.saveUser("John", "Doe", (byte) 25);
              userService.saveUser("Alice", "Smith", (byte) 22);
              userService.saveUser("Bob", "Johnson", (byte) 30);
              userService.saveUser("Eva", "Williams", (byte) 28);
              userService.saveUser("Charlie", "Brown", (byte) 21);
          }
          case 4-> userService.removeUserById(1L);
          case 5-> System.out.println(userService.getAllUsers());
          case 6-> userService.cleanUsersTable();
      }
    }
}
}
