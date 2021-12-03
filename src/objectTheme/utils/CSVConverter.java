package objectTheme.utils;


import objectTheme.people.Student;

public interface CSVConverter {
    String toCSVString(Student student);
    Student fromCSVString(String str);
}
