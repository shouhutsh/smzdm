package cn.edu.zzti.pi.smzdm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.charset.Charset;

public final class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static String loadFile(Resource resource) {
        InputStream in = null;
        try {
            in = resource.getInputStream();
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            return new String(bytes, Charset.defaultCharset());
        } catch (Exception e) {
            logger.error(String.format("加载文件失败！", e));
            return null;
        } finally {
            CodeUtils.close(in);
        }
    }
}
