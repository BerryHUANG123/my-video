package com.myvideo.model.persistant;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_loldytt_movie
 */
public class LolDyTtMoviePo {
    /**
     * Database Column Remarks:
     *   主键ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.id
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   电影名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.name
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.type
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String type;

    /**
     * Database Column Remarks:
     *   电影图片地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.img_url
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String imgUrl;

    /**
     * Database Column Remarks:
     *   来源网页地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.source_url
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String sourceUrl;

    /**
     * Database Column Remarks:
     *   主演
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.staring
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String staring;

    /**
     * Database Column Remarks:
     *   电影信息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.inforamation
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String inforamation;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.create_time
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.update_time
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   下载信息(链接地址,链接类型,链接名称)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_loldytt_movie.download_info_list
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    private String downloadInfoList;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.id
     *
     * @return the value of t_loldytt_movie.id
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.id
     *
     * @param id the value for t_loldytt_movie.id
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.name
     *
     * @return the value of t_loldytt_movie.name
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.name
     *
     * @param name the value for t_loldytt_movie.name
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.type
     *
     * @return the value of t_loldytt_movie.type
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.type
     *
     * @param type the value for t_loldytt_movie.type
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.img_url
     *
     * @return the value of t_loldytt_movie.img_url
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.img_url
     *
     * @param imgUrl the value for t_loldytt_movie.img_url
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.source_url
     *
     * @return the value of t_loldytt_movie.source_url
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.source_url
     *
     * @param sourceUrl the value for t_loldytt_movie.source_url
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.staring
     *
     * @return the value of t_loldytt_movie.staring
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getStaring() {
        return staring;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.staring
     *
     * @param staring the value for t_loldytt_movie.staring
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setStaring(String staring) {
        this.staring = staring == null ? null : staring.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.inforamation
     *
     * @return the value of t_loldytt_movie.inforamation
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getInforamation() {
        return inforamation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.inforamation
     *
     * @param inforamation the value for t_loldytt_movie.inforamation
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setInforamation(String inforamation) {
        this.inforamation = inforamation == null ? null : inforamation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.create_time
     *
     * @return the value of t_loldytt_movie.create_time
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.create_time
     *
     * @param createTime the value for t_loldytt_movie.create_time
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.update_time
     *
     * @return the value of t_loldytt_movie.update_time
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.update_time
     *
     * @param updateTime the value for t_loldytt_movie.update_time
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_loldytt_movie.download_info_list
     *
     * @return the value of t_loldytt_movie.download_info_list
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public String getDownloadInfoList() {
        return downloadInfoList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_loldytt_movie.download_info_list
     *
     * @param downloadInfoList the value for t_loldytt_movie.download_info_list
     *
     * @mbg.generated 2018-09-16 16:40:15
     */
    public void setDownloadInfoList(String downloadInfoList) {
        this.downloadInfoList = downloadInfoList == null ? null : downloadInfoList.trim();
    }
}