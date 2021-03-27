package com.example.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/25 10:19
 * @Version 1.0
 */
@Document(indexName = "index_activity", type = "res_activity")
public class Activity {

    @Id
    private Long id;

    private Integer activityType;

    private String activityName;

    private String activityOrg;

    private Long createBy;

    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityOrg() {
        return activityOrg;
    }

    public void setActivityOrg(String activityOrg) {
        this.activityOrg = activityOrg;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
