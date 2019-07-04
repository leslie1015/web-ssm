package com.focus.cms.service;

import com.focus.cms.entity.BasicParameter;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;

/**
 * <p>
 * 参数表 服务类
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
public interface BasicParameterService extends IService<BasicParameter> {


//  @Override
  BasicParameter getById(Integer id);
}
