package cn.edu.zzti.pi.smzdm.utils;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.charset.Charset;

public final class FileUtils {

    public static String loadFile(Resource resource) {
        InputStream in = null;
        try {
            in = resource.getInputStream();
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            return new String(bytes, Charset.defaultCharset());
        } catch (Exception e) {
            CodeUtils.close(in);
            return null;
        }
    }
}
