package com.example.service.impl;

import com.example.mapper.BookMapper;
import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectBook(String title, String author) {
        return bookMapper.selectBy(title, author);
    }

    @Override
    public Boolean addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public Boolean updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return bookMapper.delById(id);
    }

}
