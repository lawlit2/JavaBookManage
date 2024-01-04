package entitle;

import dao.Book;
import dao.Student;

import java.util.List;

public interface BookMapper {
    List<Book> SelectAllBook();
    int InsertBook(Book book);
    List<Student> SelectAllStudent();
    int InsertStudent(Student student);
}
