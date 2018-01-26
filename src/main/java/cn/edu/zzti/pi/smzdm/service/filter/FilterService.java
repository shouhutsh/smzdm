package cn.edu.zzti.pi.smzdm.service.filter;

import cn.edu.zzti.pi.smzdm.model.ArticleModel;

/**
 * 过滤器服务
 */
public interface FilterService {

    /**
     * 判断 SMZDM 该条是否值得
     *
     * @param article
     * @return
     */
    boolean isWorth(ArticleModel article);
}
