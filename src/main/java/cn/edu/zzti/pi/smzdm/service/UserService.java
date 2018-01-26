package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.UserModel;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取所有用户列表
     * @return
     * @throws BizException
     */
    List<UserModel> selectAllUsers() throws BizException;
}
