package com.focus.cms.service.impl;

import com.focus.cms.entity.BasicParameter;
import com.focus.cms.mapper.BasicParameterMapper;
import com.focus.cms.service.BasicParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数表 服务实现类
 * </p>
 *
 * @author wangyong
 * @since 2019-07-04
 */
@Service
public class BasicParameterServiceImpl extends ServiceImpl<BasicParameterMapper, BasicParameter> implements BasicParameterService {

  @Autowired
  private BasicParameterMapper basicParameterMapper;

//  @Override
//  public BasicParameter getById(Serializable id) {
//    return basicParameterMapper.selectById(id);
//  }

  @Override
  public BasicParameter getById(Integer id) {
    return basicParameterMapper.selectById(id);
  }
}
