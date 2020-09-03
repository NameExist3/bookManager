package com.hks.bookmanager.service;


import com.hks.bookmanager.dao.BookDao;
import com.hks.bookmanager.model.Book;
import com.hks.bookmanager.model.enums.BookStatusEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  private BookDao bookDao;

  public List<Book> getAllBooks() {
    return bookDao.selectAll();
  }

  public int addBooks(Book book) {
    return bookDao.addBook(book);
  }

  public void deleteBooks(int id) {
    bookDao.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
  }

  public void recoverBooks(int id) {
    bookDao.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
  }
}
