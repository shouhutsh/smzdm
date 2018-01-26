package cn.edu.zzti.pi.smzdm.service.filter;

import cn.edu.zzti.pi.smzdm.model.ArticleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SimpleFilterService implements FilterService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private static final int THRESHOLD = 80;

    @Override
    public boolean isWorth(ArticleModel article) {
        try {
            if (getArticleWorthy(article) > THRESHOLD)
                return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    private int getArticleWorthy(ArticleModel model) {
        String str = model.getArticleWorthy();
        if (StringUtils.isEmpty(str)) return 0;

        if (str.contains("%")) {
            str = str.replace("%", "");
        }
        return Integer.valueOf(str);
    }
}
