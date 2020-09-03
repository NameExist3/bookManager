package com.hks.bookmanager.dao;

import com.hks.bookmanager.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    String table_name = " book ";
    String insert_field = " name, author, price ";
    String select_field = " id, status, " + insert_field;

    @Select({"select", select_field, "from", table_name})
    List<Book> selectAll();

    @Insert({"insert into", table_name, "(", insert_field, ") value (#{name},#{author},#{price})"})
    int addBook(Book book);

    @Update({"update", table_name, " set status = #{status} where id = #{id}"})
    void updateBookStatus(@Param("id") int id, @Param("status") int status);
}
