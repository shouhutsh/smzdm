package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.UserModel;
import cn.edu.zzti.pi.smzdm.utils.FileUtils;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static List<UserModel> users;

    @Value(value = "classpath:/config/users.json")
    private Resource resource;

    @PostConstruct
    public void init() throws IOException {
        try {
            logger.info(resource.getURI().toString());
            users = JSONArray.parseArray(FileUtils.loadFile(resource), UserModel.class);
            logger.info("配置读取成功!");
        } catch (Exception e) {
            logger.error("UserService 初始化失败！", e);
        }
    }

    @Override
    public List<UserModel> selectAllUsers() throws BizException {
        return users;
    }
}
