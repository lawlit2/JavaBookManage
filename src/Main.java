import Util.MybatisUtil;
import dao.Book;
import dao.Student;
import entitle.BookMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        try (SqlSession session = MybatisUtil.GetSession(true)) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);

            System.out.println("welcome to BookManagement");
            boolean f = true;
            out :while (f) {
                System.out.print("1.查询图书\t");
                System.out.print("2.查询学生\t");
                System.out.print("3.增加学生信息\t");
                System.out.print("4.增加图书信息\t");
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                switch (scanner.nextLine()) {
                    case "1":
                        List<Book> bookList = bookMapper.SelectAllBook();
                        bookList.forEach(System.out::println);
                        break;
                    case "2":
                        List<Student> Student = bookMapper.SelectAllStudent();
                        Student.forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("请输入学生姓名与性别");
                        String StudentName = scanner.nextLine();
                        String Sex = scanner.nextLine();
                        Student student = new Student();
                        student.setName(StudentName);student.setSex(Sex);
                        System.out.println(bookMapper.InsertStudent(student));
                        List<Student> Student1 = bookMapper.SelectAllStudent();
                        Student1.forEach(System.out::println);
                        break;
                    case "4":
                        System.out.println("请输入图书与作者");
                        String bookName = scanner.nextLine();
                        String AUthor = scanner.nextLine();
                        Book book = new Book();
                        book.setBookName(bookName); book.setAuthor(AUthor);
                        System.out.println(bookMapper.InsertBook(book));
                        List<Book> bookList1 = bookMapper.SelectAllBook();
                        bookList1.forEach(System.out::println);
                        break;
                }
                System.out.println("是否继续查询或增加信息");
                switch (scanner.nextLine()){
                    case  "否":
                        break out;
                    case "是" :
                    default:
                        break;
                }
            }

        }
    }
}
