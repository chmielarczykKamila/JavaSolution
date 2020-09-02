package com.github.kamila.Utils;

import com.github.kamila.User;
import java.util.List;
import static com.github.kamila.Utils.FileUtils.*;

public class UserUtils {

    public static void addNewUser(User user) {
        List<User> users = addUserIntoList(user);
        writeToFile(users);
        System.out.println("User " + user.getName() + " was successfully add into file");
    }
    public static void deleteUser(String name) {
        if(checkIfFileIsEmpty()){
            System.out.println("User " + name + " not found to delete");
        }
        else {
            createFileIfNotExist();
            deleteFromFile(name);
        }
    }
}
