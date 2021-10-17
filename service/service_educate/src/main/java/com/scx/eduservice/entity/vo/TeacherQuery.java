package com.scx.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther scx
 * @date 2021/7/24 - 14:27
 */
@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教师名称，模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间",example = "2019-10-30 11:55:19")
    private String begin;

    @ApiModelProperty(value = "查询结束时间",example = "2019-10-30 11:55:19")
    private String end;
}
