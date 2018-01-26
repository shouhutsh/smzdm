package cn.edu.zzti.pi.smzdm.service.filter;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.ArticleModel;
import cn.edu.zzti.pi.smzdm.model.ConfigModel;
import cn.edu.zzti.pi.smzdm.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FilterProxy {

    private static final Map<String, FilterService> filters = new ConcurrentHashMap<>();

    @Autowired
    private ApplicationContext context;
    @Autowired
    private ConfigService configService;

    @PostConstruct
    private void init() {
        for (FilterService f : context.getBeansOfType(FilterService.class).values()) {
            filters.put(f.getClass().getSimpleName(), f);
        }
    }

    public boolean isWorth(ConfigModel config, ArticleModel article) throws BizException {
        for (String fn : config.getFilters()) {
            if (filters.get(fn).isWorth(article)) {
                return true;
            }
        }
        return false;
    }
}
