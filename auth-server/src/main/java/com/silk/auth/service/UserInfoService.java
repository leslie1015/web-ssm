package com.silk.auth.service;

import com.silk.auth.entity.UserInfo;
import com.silk.auth.dao.UserInfoMapper;
import com.silk.auth.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2019-08-13 14:06:22
 */
@Service
public class UserInfoService {

  @Resource
  private UserInfoMapper userInfoMapper;

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */

  public UserInfo queryById(Integer id) {
    return this.userInfoMapper.queryById(id);
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */

  public List<UserInfo> queryAllByLimit(int offset, int limit) {
    return this.userInfoMapper.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param userInfo 实例对象
   * @return 实例对象
   */

  public UserInfo insert(UserInfo userInfo) {
    this.userInfoMapper.insert(userInfo);
    return userInfo;
  }

  /**
   * 修改数据
   *
   * @param userInfo 实例对象
   * @return 实例对象
   */

  public UserInfo update(UserInfo userInfo) {
    this.userInfoMapper.update(userInfo);
    return this.queryById(userInfo.getId());
  }

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */

  public boolean deleteById(Integer id) {
    return this.userInfoMapper.deleteById(id) > 0;
  }
}