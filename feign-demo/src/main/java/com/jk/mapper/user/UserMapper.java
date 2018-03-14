package com.jk.mapper.user;

import com.jk.model.freemaker.Ma;
import com.jk.model.freemaker.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper{

    @Select("select * from user")
    List<UserBean>  queryUser();

    @Select("select * from ma where userid=#{userid}")
    Ma queryUserId(@Param("userid") Integer userId);

    @Insert("insert into ma (userid,newMa,createTime,validTime) values (#{userid},#{newMa},#{createTime},#{validTime})")
    void insertMa(Ma ma);

    //登录查询用户返回单条记录
  /*  @Select("SELECT * FROM user_info where username = #{username}")
    UserInfo findByUsername(@Param("username")String username);*/
}
