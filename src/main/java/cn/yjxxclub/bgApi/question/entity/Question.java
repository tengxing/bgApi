package cn.yjxxclub.bgApi.question.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-25
 * Time: 上午9:20
 * Describe: 问题实体类
 */
public class Question implements java.io.Serializable {

    private Integer id;
    private String quesId;
    private String title;
    private String description;//描述
    private String orderDegree;//难度系数
    private String isSolved;//是否解决
    private Timestamp solvedTime;//解决时间
    private Date lastUpdateTime;
    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderDegree() {
        return orderDegree;
    }

    public void setOrderDegree(String orderDegree) {
        this.orderDegree = orderDegree;
    }

    public String getIsSolved() {
        return isSolved;
    }

    public void setIsSolved(String isSolved) {
        this.isSolved = isSolved;
    }

    public Timestamp getSolvedTime() {
        return solvedTime;
    }

    public void setSolvedTime(Timestamp solvedTime) {
        this.solvedTime = solvedTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}

