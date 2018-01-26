package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.ConfigModel;
import cn.edu.zzti.pi.smzdm.model.UserModel;
import cn.edu.zzti.pi.smzdm.utils.FileUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ConfigServiceImpl implements ConfigService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static JSONObject configs;

    @Value(value = "classpath:/config/config.json")
    private Resource resource;

    @PostConstruct
    public void init() {
        try {
            logger.info(resource.getURI().toString());
            configs = JSONObject.parseObject(FileUtils.loadFile(resource));
            logger.info("配置读取成功!");
        } catch (Exception e) {
            logger.error("ConfigService 初始化失败！", e);
        }
    }

    @Override
    public ConfigModel getUserConfig(UserModel userModel) throws BizException {
        return configs.getObject(userModel.getId(), ConfigModel.class);
    }
}
