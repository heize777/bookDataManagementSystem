package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result addBook(@RequestBody Book book) {
        Boolean flag = bookService.addBook(book);
        return new Result(flag ? Code.ADD_OK : Code.ADD_ERR, flag, "添加成功");
    }

    @PutMapping
    public Result updateBook(@RequestBody Book book) {
        Boolean flag = bookService.updateBook(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, "修改成功");
    }

    @DeleteMapping("/{id}")
    public Result deleteBook(@PathVariable Integer id) {
        Boolean flag = bookService.deleteBook(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, "删除成功");
    }

    @GetMapping
    public Result selectAll() {
        List<Book> list = bookService.selectBook(null,null);
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String message = list != null ? "" : "数据查询失败,请重试";
        return new Result(code, list, message);
    }

    @PostMapping("/by")
    public Result selectBy(@RequestBody Book book) {
        List<Book> list = bookService.selectBook(book.getTitle(), book.getAuthor());
        Integer code = list != null ? Code.GET_OK : Code.GET_ERR;
        String message = list != null ? "" : "数据查询失败,请重试";
        return new Result(code, list, message);
    }
}
