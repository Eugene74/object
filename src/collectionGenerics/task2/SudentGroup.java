package collectionGenerics.task2;

/*
2) Модифицируйте класс группа для более удобных методов работы
с динамическими массивами.
*/


import objectTheme.myexception.GroupLimitException;
import objectTheme.myexception.NoExistStudentException;
import objectTheme.people.Student;
import objectTheme.utils.StudentComparator;

import java.io.Serializable;
import java.util.*;

/*public*/ class StudentGroup implements Serializable {
    private static final long serialVersionUID=1L;
    private static ArrayList<Student> students;
    private int studentsCount = 0;

    public StudentGroup() {
        students = new ArrayList<>();
    }

    public void add(Student s) throws GroupLimitException {

            students.add(s);

    }

    private Student get(int n) {
        return students.get(n);
    }

    public Student find(String name) throws NoExistStudentException {
        Student student = null;
        for (int i = 0; i < studentsCount; i++) {
            if (students.get(i).getName().equalsIgnoreCase(name) || students.get(i).getSurname().equalsIgnoreCase(name)) {
                student = this.get(i);
            }
        }
        if (student == null) {
            throw new NoExistStudentException("Sorry, but there is no student named " + name + " in the group");
        }
        return student;
    }

    public List<Student> sortStudentsByLastName() {
        Collections.sort(students, Comparator.nullsFirst(new StudentComparator()));
        return students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printGroup(){
        for(Student std : students){
            if (std != null) {
                System.out.println(std);
            }
        }
    }
}
