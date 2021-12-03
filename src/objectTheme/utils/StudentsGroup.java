package objectTheme.utils;


import objectTheme.myexception.GroupLimitException;
import objectTheme.myexception.NoExistStudentException;
import objectTheme.people.Student;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class StudentsGroup implements Serializable {
    private static final long serialVersionUID=1L;
    private static Student[] students;
    private int studentsCount = 0;

    public StudentsGroup(int i) {
        students = new Student[i];
    }

    public void add(Student s) throws GroupLimitException {
        if (studentsCount == students.length) {
            throw new GroupLimitException("Sorry man, but group is full  -- You can`t add another student");
        } else {
            students[studentsCount++] = s;
        }
    }

    private Student get(int n) {
        return students[n];
    }

    public Student find(String name) throws NoExistStudentException {
        Student student = null;
        for (int i = 0; i < studentsCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name) || students[i].getSurname().equalsIgnoreCase(name)) {
                student = this.get(i);
            }
        }
        if (student == null) {
            throw new NoExistStudentException("Sorry, but there is no student named " + name + " in the group");
        }
        return student;
    }

    public Student[] sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst(new StudentComparator()));
        return students;
    }

    public Student[] getStudents() {
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
