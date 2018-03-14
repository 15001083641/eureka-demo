package com.jk.service.freemaker;

import com.jk.model.freemaker.*;

import java.util.List;

public interface FreeMakerService {

    List<UserBean> queryUserInfo(Integer userid);

    List<EducationExperience> queryEducationList(Integer userid);

    List<Expertise> expertiseList(Integer userid);

    List<Project> projectList(Integer userid);

    List<WorkExperience> workExperienceList(Integer userid);
}
