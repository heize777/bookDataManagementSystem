package com.example.mapper;

import com.example.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

        // 查询操作
        public List<Book> selectBy(@Param("title") String title,@Param("author") String author);

        // 添加操作
        @Insert("insert into book(title, author, isbn, publication_year, publisher, price) values (#{title}, #{author}, #{isbn}, #{publicationYear}, #{publisher}, #{price});")
        public Boolean addBook(Book book);

        // 更新操作
        public Boolean updateBook(Book book) ;

        // 删除操作
        @Delete("delete from book where id = #{id};")
        public Boolean delById(Integer id);

}
