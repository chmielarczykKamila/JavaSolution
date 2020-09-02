package com.github.kamila.Utils;

import com.github.kamila.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String path = "C:/kama/test.txt";
    private static File file = new File(path);

    public static void writeToFile(List<User> usersList) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (User u : usersList) {
                objectOut.writeObject(u);
            }
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static List<User> readFromFile() {
        List users = new ArrayList();
        InputStream input = null;
        try {
            input = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(input);
            while (true) {
                try {
                    Object object = ois.readObject();
                    users.add(object);
                } catch (EOFException ex) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    static void deleteFromFile(String name) {
        List<User> users = readFromFile();
        long size = users.stream().filter(x -> x.getName().contains(name)).count();
        if (size == 0) {
            System.out.println("User " + name + " not found to delete");
        } else {
            users.removeIf(x -> x.getName().contains(name));
            writeToFile(users);
            System.out.println("User " + name + " was successfully deleted from file");
        }

    }

    static List<User> addUserIntoList(User user) {
        List<User> usersList;
        if (checkIfFileIsEmpty()) {
            usersList = new ArrayList<>();
            usersList.add(user);
        } else {
            usersList = readFromFile();
            usersList.add(user);
        }
        return usersList;
    }

    static void createFileIfNotExist() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static boolean checkIfFileIsEmpty() {
        return file.length() == 0;
    }
}
