package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.ConfigModel;
import cn.edu.zzti.pi.smzdm.model.UserModel;

public interface ConfigService {

    ConfigModel getUserConfig(UserModel userModel) throws BizException;
}
