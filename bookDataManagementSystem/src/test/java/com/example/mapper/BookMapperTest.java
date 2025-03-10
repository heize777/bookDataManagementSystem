package com.example.mapper;

import com.example.config.SpringConfig;
import com.example.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testSelectBy() {
        List<Book> list = bookMapper.selectBy(null, null);
        System.out.println(list);
    }

    @Test
    public void testAdd() {
//        Book book = new Book("三体", "刘慈欣", "9787539189295", 2006, "重庆出版社", 35.00);
//        bookMapper.addBook(book);
    }

    @Test
    public  void  testUpdate() {
//        Book book = new Book(1,"三体", "刘慈欣", "9787539189295", 2006, "重庆出版社", 35.00);
//        bookMapper.updateBook(book);
    }
}
