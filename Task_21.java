package home.Task_21;
/*
Есть класс User.
Написать интерфейс Storage, и класс FileStorage который в конструкторе принимает имя файла где будут храниться данные.
Продемонстрирвоать работу всех методов.
Данные должны храниться в тектовом файле в формате JSON.
При добавлении метод addUser должен назначить User уникальный id - порядковый номер.
 */
public class Task_21 {
    public static void main(String[] args) throws NoSuchUserException {
        FileStorage fileStorage = new FileStorage("users.txt");
        fileStorage.addUser(new User("Alex", 23));
        fileStorage.addUser(new User("Bob", 33));
        fileStorage.addUser(new User("Carl", 44));
        fileStorage.addUser(new User("Tom", 20));
        fileStorage.addUser(new User("Max", 37));
        fileStorage.addUser(new User("Carl", 14));
        fileStorage.addUser(new User("Mark", 44));

        System.out.println(".getAllUsers(): " + fileStorage.getAllUsers());
        System.out.println(".getUser(id:1): " + fileStorage.getUser(1) + "\n");

        fileStorage.updateUser(new User(0,"David", 55));
        System.out.println(".updateUser(id:0): " + fileStorage.getAllUsers() + "\n");

        fileStorage.removeUserByName("Carl");
        System.out.println("removed \"Carl\": " + fileStorage.getAllUsers());

        fileStorage.removeUser(0);
        fileStorage.removeUser(3);
        fileStorage.removeUser(6);
        System.out.println("removed users id: 0, 3, 6: " + fileStorage.getAllUsers() + "\n");

        fileStorage.removeAll();
        System.out.println(".removeAll(): " + fileStorage.getAllUsers());
    }
}
