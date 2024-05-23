package com.yoo.Runner;

import com.yoo.Controller.BookDAOImpl;
import com.yoo.DAOInterface.BOOKDAO;
import com.yoo.model.Book;

import java.sql.SQLException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AccessBook {
    public static void main(String[] args) {

        // creating object
        BOOKDAO bookDao = new BookDAOImpl();
        System.out.println("--------- inserting book records ----------");

        ArrayList<Book> BookList = new ArrayList<Book>();

        Book b1 = new Book();
        b1.setIsbn(120);
        b1.setBookName("Java Book");
        BookList.add(b1);

        Book b2 = new Book();
        b2.setIsbn(300);
        b2.setBookName("Python Book");
        BookList.add(b2);

        Book b3 = new Book();
        b3.setIsbn(365);
        b3.setBookName("JavaScript Book");
        BookList.add(b3);

        Book b4 = new Book();
        b4.setIsbn(256);
        b4.setBookName("SQL Book");
        BookList.add(b4);

        bookDao.saveBook(BookList);

        System.out.println(" ====== Display list of all books ====");
        try {
            for (Book cc : bookDao.getAllBooks()) {
                int ISBN = cc.getIsbn();
                String BookName = cc.getBookName();
                System.out.println("======================");
                System.out.println("ISBN Number :" + ISBN + "and Book name: " + BookName);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("----Book information is updating -----");
        Book Bookupdating = new Book();
        Bookupdating.setIsbn(3);
        Bookupdating.setBookName("Algorithms Book");
        boolean result = bookDao.updateBook(Bookupdating, 3);
        System.out.println(result);

        boolean a = bookDao.deleteBook(4); // 4 is a id of book
        if(a == true) {
            System.out.println("Record is deleted");
        }
        else
        {
            System.out.println("Record is not deleted");
        }


    }

}
