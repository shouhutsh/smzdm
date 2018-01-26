package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> selectAllUsers() throws BizException;
}
