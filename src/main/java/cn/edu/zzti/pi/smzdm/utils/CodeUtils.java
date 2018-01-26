package cn.edu.zzti.pi.smzdm.utils;

import java.io.Closeable;
import java.io.IOException;

public final class CodeUtils {

    public static void close(Closeable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }
        } catch (IOException e) {
            closeable = null;
        }
    }
}
