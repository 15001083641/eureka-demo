package com.jk.model.freemaker;

import java.util.Date;

public class Ma {

    private Integer id;
    private Integer userid;
    private String newMa;
    private String myMa;
    private Date createTime;
    private Date validTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNewMa() {
        return newMa;
    }

    public void setNewMa(String newMa) {
        this.newMa = newMa;
    }

    public String getMyMa() {
        return myMa;
    }

    public void setMyMa(String myMa) {
        this.myMa = myMa;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    @Override
    public String toString() {
        return "Ma{" +
                "id=" + id +
                ", userid=" + userid +
                ", newMa='" + newMa + '\'' +
                ", myMa='" + myMa + '\'' +
                ", createTime=" + createTime +
                ", validTime=" + validTime +
                '}';
    }
}
