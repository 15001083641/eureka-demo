package com.jk.service.freemaker;

import com.jk.mapper.freemaker.FreeMakerMapper;
import com.jk.model.freemaker.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeMakerServiceImpl implements FreeMakerService {

    @Autowired
    private FreeMakerMapper freeMakerMapper;

    @Override
    public  List<UserBean> queryUserInfo(Integer userid) {
        return freeMakerMapper.queryUserInfo(userid);
    }

    @Override
    public List<EducationExperience> queryEducationList(Integer userid) {
        return freeMakerMapper.queryEducationList(userid);
    }

    @Override
    public List<Expertise> expertiseList(Integer userid) {
        return freeMakerMapper.expertiseList(userid);
    }

    @Override
    public List<Project> projectList(Integer userid) {
        return freeMakerMapper.projectList(userid);
    }

    @Override
    public List<WorkExperience> workExperienceList(Integer userid) {
        return freeMakerMapper.workExperienceList(userid);
    }
}
