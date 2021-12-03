package objectTheme;
/*
Домашнее задание
1. Создайте класс описывающий человека (создайте метод
выводящий информацию о человеке)
2. На его основе создайте класс студент (переопределите
метод вывода информации)
3. Создайте класс группа — который содержит массив из
объектов класса студент. Реализуйте метод поиска студента
по фамилии.
4. Используя стандартный методы сериализации создайте
мини базу данных для работы с группами студентов
(возможность записи и чтения базы из файла по запросу
пользователя).
*/


import objectTheme.myexception.GroupLimitException;
import objectTheme.people.Student;
import objectTheme.utils.StudentsGroup;

import java.io.*;

 public class MyClass {

    public static void main(String[] args) {
        System.out.println("--------------------добавим в группу студентов----------------------------");
        StudentsGroup group = new StudentsGroup(10);
        try {
            group.add(new Student("Kolya", "Saychuk", 1975, 5, 15));
            group.add(new Student("Gena", "Saychuk", 1976, 7, 16));
            group.add(new Student("Seva", "Evgienko", 1986, 3, 11));
            group.add(new Student("Vasya", "Pupko", 1988, 4, 12));
            group.add(new Student("Tolya", "Avko", 1989, 5, 13));
            group.add(new Student("Olya", "Blavko", 1991, 6, 14));
        } catch (GroupLimitException e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        }
        group.printGroup();
        System.out.println("---------------serialization------------------");
        try(ObjectOutputStream OOS=new ObjectOutputStream(new FileOutputStream("diskD"))){
            OOS.writeObject(group);
            System.out.println("Done!");
        } catch(IOException e){
            System.out.println("ERROR save group !!!");
        }
        System.out.println("---------------deserialization------------------");
        StudentsGroup polytechnic102=null;
        try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("diskD"))){
            polytechnic102=(StudentsGroup)OIS.readObject();
        } catch(IOException |  ClassNotFoundException e){
            System.out.println("ERROR load group !!!");
        } System.out.println();
        System.out.println("Вывод данных считанного объекта");
        System.out.println();
        polytechnic102.printGroup();

    }
}
