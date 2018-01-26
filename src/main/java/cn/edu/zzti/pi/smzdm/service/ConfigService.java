package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.ConfigModel;
import cn.edu.zzti.pi.smzdm.model.UserModel;

/**
 * 配置服务
 */
public interface ConfigService {

    /**
     * 获取用户配置信息
     * @param userModel
     * @return
     * @throws BizException
     */
    ConfigModel getUserConfig(UserModel userModel) throws BizException;
}
