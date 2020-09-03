package com.hks.bookmanager.dao;

import com.hks.bookmanager.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {
    String table_name = " user ";
    String insert_field = " name, email, password ";
    String select_field = " id, " + insert_field;

    @Insert({"insert into", table_name, "(", insert_field,
            ") values (#{name},#{email},#{password})"})
    int addUser(User user);

    @Select({"select", select_field, "from", table_name, "where id=#{id}"})
    User selectById(int id);

    @Select({"select", select_field, "from", table_name, "where name=#{name}"})
    User selectByName(String name);

    @Select({"select", select_field, "from", table_name, "where email=#{email}"})
    User selectByEmail(String email);

    @Update({"update", table_name, "set password=#{password} where id=#{id}"})
    void updatePassword(User user);
}
