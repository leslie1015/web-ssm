package com.focus.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 参数表
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BasicParameter对象", description="参数表")
public class BasicParameter extends Model<BasicParameter> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "参数组的type")
    private String paramType;

    @ApiModelProperty(value = "参数名")
    private String paramName;

    @ApiModelProperty(value = "参数key，param_type + param_key确定唯一数据")
    private String paramKey;

    @ApiModelProperty(value = "参数值")
    private String paramValue;

    @ApiModelProperty(value = "语言，1中文，2英文")
    private Integer lanCode;

    @ApiModelProperty(value = "顺序，按照所填数字排序")
    private Integer orderNum;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "添加人编号")
    private String addNo;

    @ApiModelProperty(value = "添加人姓名")
    private String addName;

    @ApiModelProperty(value = "添加时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "修改人编号")
    private String updateNo;

    @ApiModelProperty(value = "修改人姓名")
    private String updateName;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    

}
