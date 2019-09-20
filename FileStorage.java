package home.Task_21;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {
    private String fileName;
    private List<User> users = new ArrayList<>();
    private int maxId = 0;

    private Gson gson = new Gson();


    public FileStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void removeAll() {
        users.clear();
        saveToFile();
    }

    @Override
    public void removeUser(int id) {

        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
        }
        saveToFile();
    }

    @Override
    public void removeUserByName(String name) {
        users.removeIf(user -> user.getName().equals(name));
        saveToFile();
    }

    @Override
    public void addUser(User user) {
        users.add(maxId, user);
        user.setId(maxId);
        maxId++;
        saveToFile();
    }

    @Override
    public void updateUser(User user) {
        users.set(user.getId(), user);
        saveToFile();
    }

    @Override
    public User getUser(int id) throws NoSuchUserException {

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new NoSuchUserException(String.format("User with such %d doesn't exist", id));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    private void saveToFile() {
        String json = gson.toJson(users);
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
