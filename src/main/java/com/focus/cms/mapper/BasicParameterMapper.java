package com.focus.cms.mapper;

import com.focus.cms.entity.BasicParameter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 参数表 Mapper 接口
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
public interface BasicParameterMapper extends BaseMapper<BasicParameter> {

  BasicParameter selectById(Integer id);

}
