package com.jk.mapper.freemaker;

import com.jk.model.freemaker.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface FreeMakerMapper {

    @Select("SELECT * FROM USER where id=#{userid}")
    List<UserBean> queryUserInfo(@Param("userid") Integer userid);

    @Select("SELECT e.* FROM educationexperience e ,USER u where e.userId = u.id and e.userId=#{userid}")
    List<EducationExperience> queryEducationList(@Param("userid")Integer userid);

    @Select("SELECT e.* FROM expertise e ,USER u where e.userId = u.id and e.userId=#{userid}")
    List<Expertise> expertiseList(@Param("userid")Integer userid);

    @Select("SELECT e.* FROM project e,USER u where e.userId = u.id and e.userId=#{userid}")
    List<Project> projectList(@Param("userid")Integer userid);

    @Select("SELECT e.* FROM workexperience e,USER u where e.userId = u.id and e.userId=#{userid}")
    List<WorkExperience> workExperienceList(@Param("userid")Integer userid);
}
