package cn.edu.zzti.pi.smzdm;

import cn.edu.zzti.pi.smzdm.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;

public class CreateModel {

    private static final String JSON = "{\n" +
            "\t\"article_link_list\": [{\n" +
            "\t\t\"is_tao_v\": true,\n" +
            "\t\t\"buy_btn_domain\": \"smzdm.com\",\n" +
            "\t\t\"link_nofollow\": \"\",\n" +
            "\t\t\"taobao_url\": {\n" +
            "\t\t\t\"is_taobao\": false,\n" +
            "\t\t\t\"taobao_url\": \"http://jr.smzdm.com/vplan/\",\n" +
            "\t\t\t\"href\": \"http://jr.smzdm.com/vplan/\"\n" +
            "\t\t},\n" +
            "\t\t\"name\": \"刷卡价更值\",\n" +
            "\t\t\"link\": \"http://jr.smzdm.com/vplan/\"\n" +
            "\t}],\n" +
            "\t\"article_mall\": \"SHOPBOP\",\n" +
            "\t\"article_referrals\": \"专修打火机\",\n" +
            "\t\"article_price\": \"$347.5包直邮（约￥2185）\",\n" +
            "\t\"article_worthy\": 0,\n" +
            "\t\"article_channel_name\": \"海淘\",\n" +
            "\t\"article_pic\": \"https://tp-qny.smzdm.com/201804/01/5ac042120c0882614.jpg_a200.jpg\",\n" +
            "\t\"data_from\": \"redis\",\n" +
            "\t\"article_is_sold_out\": 0,\n" +
            "\t\"article_id\": \"9010047\",\n" +
            "\t\"article_channel\": \"海淘\",\n" +
            "\t\"yh_type\": \"youhui\",\n" +
            "\t\"article_tese_tags\": [{\n" +
            "\t\t\"os_num\": 0,\n" +
            "\t\t\"jy_num\": 0,\n" +
            "\t\t\"image\": \"\",\n" +
            "\t\t\"post_num\": 0,\n" +
            "\t\t\"tag_type\": 1,\n" +
            "\t\t\"all_num\": 0,\n" +
            "\t\t\"fx_num\": 0,\n" +
            "\t\t\"last_update_time\": \"2017-04-25 19:37:59\",\n" +
            "\t\t\"news_num\": 0,\n" +
            "\t\t\"ht_num\": 0,\n" +
            "\t\t\"url_nicktitle\": \"\",\n" +
            "\t\t\"intro\": \"\",\n" +
            "\t\t\"name\": \"淘金v计划\",\n" +
            "\t\t\"id\": 418018,\n" +
            "\t\t\"tag_url\": \"http://www.smzdm.com/tag/æ·\u0098é\u0087\u0091vè®¡å\u0088\u0092/haitao/\"\n" +
            "\t}, {\n" +
            "\t\t\"os_num\": 0,\n" +
            "\t\t\"jy_num\": 0,\n" +
            "\t\t\"image\": \"\",\n" +
            "\t\t\"post_num\": 0,\n" +
            "\t\t\"tag_type\": 1,\n" +
            "\t\t\"all_num\": 0,\n" +
            "\t\t\"fx_num\": 0,\n" +
            "\t\t\"last_update_time\": \"0000-00-00 00:00:00\",\n" +
            "\t\t\"news_num\": 0,\n" +
            "\t\t\"ht_num\": 0,\n" +
            "\t\t\"url_nicktitle\": \"\",\n" +
            "\t\t\"intro\": \"\",\n" +
            "\t\t\"name\": \"美国馆\",\n" +
            "\t\t\"id\": 388351,\n" +
            "\t\t\"tag_url\": \"http://www.smzdm.com/tag/ç¾\u008Eå\u009B½é¦\u0086/haitao/\"\n" +
            "\t}],\n" +
            "\t\"article_comment\": 0,\n" +
            "\t\"article_unworthy\": 0,\n" +
            "\t\"article_author\": \"587\",\n" +
            "\t\"article_logo_class\": \"\",\n" +
            "\t\"article_item_title_mode\": \"0\",\n" +
            "\t\"article_stock_note\": \"\",\n" +
            "\t\"taobao_url\": {\n" +
            "\t\t\"is_taobao\": false,\n" +
            "\t\t\"taobao_url\": \"https://go.smzdm.com/7dba22c4ce757dbb/ca_aa_ht_57_9010047_587_45999_133\",\n" +
            "\t\t\"href\": \"https://go.smzdm.com/7dba22c4ce757dbb/ca_aa_ht_57_9010047_587_45999_133\"\n" +
            "\t},\n" +
            "\t\"timesort\": 152254945770,\n" +
            "\t\"top_category\": \"服饰鞋包\",\n" +
            "\t\"article_link_name\": \"\",\n" +
            "\t\"article_channel_url\": \"http://haitao.smzdm.com/\",\n" +
            "\t\"article_link\": \"https://go.smzdm.com/7dba22c4ce757dbb/ca_aa_ht_57_9010047_587_45999_133\",\n" +
            "\t\"article_category\": {\n" +
            "\t\t\"nicktitle\": \"女款挎包，女士挎包\",\n" +
            "\t\t\"search_nicktitle\": \"女款挎包，女士挎包\",\n" +
            "\t\t\"category_url\": \"http://www.smzdm.com/fenlei/xiekuabao/\",\n" +
            "\t\t\"url_nicktitle\": \"xiekuabao\",\n" +
            "\t\t\"parent_id\": 133,\n" +
            "\t\t\"ID\": 577,\n" +
            "\t\t\"parent_ids\": \"57,133\",\n" +
            "\t\t\"title\": \"女士斜挎包\"\n" +
            "\t},\n" +
            "\t\"category_layer\": [{\n" +
            "\t\t\"nicktitle\": \"服装鞋包，鞋包服饰，衣服鞋包\",\n" +
            "\t\t\"search_nicktitle\": \"服装鞋包，鞋包服饰，衣服鞋包\",\n" +
            "\t\t\"url_nicktitle\": \"fushixiebao\",\n" +
            "\t\t\"parent_id\": 0,\n" +
            "\t\t\"ID\": 57,\n" +
            "\t\t\"parent_ids\": \"\",\n" +
            "\t\t\"title\": \"服饰鞋包\"\n" +
            "\t}, {\n" +
            "\t\t\"nicktitle\": \"潮流女包，精美女包\",\n" +
            "\t\t\"search_nicktitle\": \"潮流女包，精美女包，包\",\n" +
            "\t\t\"url_nicktitle\": \"jingpinnvbao\",\n" +
            "\t\t\"parent_id\": 57,\n" +
            "\t\t\"ID\": 133,\n" +
            "\t\t\"parent_ids\": \"57\",\n" +
            "\t\t\"title\": \"女包\"\n" +
            "\t}, {\n" +
            "\t\t\"nicktitle\": \"女款挎包，女士挎包\",\n" +
            "\t\t\"search_nicktitle\": \"女款挎包，女士挎包\",\n" +
            "\t\t\"url_nicktitle\": \"xiekuabao\",\n" +
            "\t\t\"parent_id\": 133,\n" +
            "\t\t\"ID\": 577,\n" +
            "\t\t\"parent_ids\": \"57,133\",\n" +
            "\t\t\"title\": \"女士斜挎包\"\n" +
            "\t}],\n" +
            "\t\"matches_rules\": [],\n" +
            "\t\"gtm\": {\n" +
            "\t\t\"cates_str\": \"服饰鞋包/女包/女士斜挎包/无\",\n" +
            "\t\t\"mall\": \"SHOPBOP\",\n" +
            "\t\t\"rmb_price\": 348,\n" +
            "\t\t\"buy_domain\": \"shopbop.com\",\n" +
            "\t\t\"title\": \"CUERO &amp; MOR Perla 女士斜挎包\",\n" +
            "\t\t\"dimension32\": \"先发后审\",\n" +
            "\t\t\"dimension20\": \"无\",\n" +
            "\t\t\"dimension12\": \"SHOPBOP\",\n" +
            "\t\t\"dimension34\": \"\",\n" +
            "\t\t\"channel_dimension\": \"haitao\",\n" +
            "\t\t\"id\": \"9010047\",\n" +
            "\t\t\"dimension4\": \"5阶价格\",\n" +
            "\t\t\"dimension25\": \"587\",\n" +
            "\t\t\"brand\": \"CUERO &amp; MOR\",\n" +
            "\t\t\"object\": \"{'name':'CUERO &amp; MOR Perla 女士斜挎包','id':'9010047' , 'price':'348','brand':'CUERO &amp; MOR' ,'mall':'SHOPBOP', 'category':'服饰鞋包/女包/女士斜挎包/无','metric1':'348','dimension10':'shopbop.com','dimension9':'haitao','dimension11':'5阶价格','dimension12':'SHOPBOP','dimension20':'无','dimension32':'先发后审','dimension25':'587'}\"\n" +
            "\t},\n" +
            "\t\"article_type\": \"好价\",\n" +
            "\t\"link_nofollow\": \"rel=\\\"nofollow\\\"\",\n" +
            "\t\"article_content\": \"<strong>圆润可爱包型，清新生机绿色~</strong>CUERO &amp; MOR来自美国洛杉矶，Cuero在西班牙语中是皮革的意思，Mor则是Well Done的意思，连起来就是做得...\",\n" +
            "\t\"article_mall_url\": \"http://www.smzdm.com/mall/shopbop/\",\n" +
            "\t\"article_format_date\": \"10:24\",\n" +
            "\t\"article_is_timeout\": 0,\n" +
            "\t\"buy_button_name\": \"去购买\",\n" +
            "\t\"article_channel_class\": \"z-tag-haitao\",\n" +
            "\t\"article_url\": \"https://m.smzdm.com/p/9010047/\",\n" +
            "\t\"article_channel_id\": \"1\",\n" +
            "\t\"article_channel_note\": \"\",\n" +
            "\t\"article_date\": \"10:24\",\n" +
            "\t\"article_title\": \"CUERO & MOR Perla 女士斜挎包\",\n" +
            "\t\"article_pic_style\": \" width=\\\"190px\\\" height=\\\"190px\\\" style=\\\"margin-top:0px\\\" \",\n" +
            "\t\"mall_more_info\": [],\n" +
            "\t\"article_content_all\": \"\",\n" +
            "\t\"article_collection\": 0,\n" +
            "\t\"article_link_domain\": \"shopbop.com\"\n" +
            "}";

    public static void main(String[] args) {
        JSONObject json = JSONObject.parseObject(JSON);
        for (String key : json.keySet()) {
            System.out.println(String.format("\t@JSONField(name = \"%s\")\n" +
                            "\tprivate String %s;\n",
                    key, StringUtils.underline2Camel(key)));
        }
    }
}
