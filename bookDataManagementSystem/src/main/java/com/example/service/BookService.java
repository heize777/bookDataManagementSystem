package com.example.service;

import com.example.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface BookService {

    /**
     * 可以根据书名，作者查询
     * @param title
     * @param author
     * @return List<Book>
     **/
    public List<Book> selectBook(String title, String author);

    /**
     * 添加书本
     * @param book
     * @return Boolean
     **/
    public Boolean addBook(Book book);

    /**
     * 更新书本
     * @param book
     * @return Boolean
     **/
    public Boolean updateBook(Book book);

    /**
     * 删除书本
     * @param id
     * @return Boolean
     **/
    public Boolean deleteBook(Integer id);

}
