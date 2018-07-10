package cn.edu.zzti.pi.smzdm.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * SMZDM 数据模型
 */
public class ArticleModel extends BaseModel {
    @JSONField(name = "article_link_list")
    private String articleLinkList;

    @JSONField(name = "article_mall")
    private String articleMall;

    @JSONField(name = "article_referrals")
    private String articleReferrals;

    @JSONField(name = "article_price")
    private String articlePrice;

    @JSONField(name = "article_worthy")
    private String articleWorthy;

    @JSONField(name = "article_channel_name")
    private String articleChannelName;

    @JSONField(name = "article_pic")
    private String articlePic;

    @JSONField(name = "data_from")
    private String dataFrom;

    @JSONField(name = "article_is_sold_out")
    private String articleIsSoldOut;

    @JSONField(name = "article_id")
    private String articleId;

    @JSONField(name = "article_channel")
    private String articleChannel;

    @JSONField(name = "yh_type")
    private String yhType;

    @JSONField(name = "article_tese_tags")
    private String articleTeseTags;

    @JSONField(name = "article_comment")
    private String articleComment;

    @JSONField(name = "article_unworthy")
    private String articleUnworthy;

    @JSONField(name = "article_author")
    private String articleAuthor;

    @JSONField(name = "article_logo_class")
    private String articleLogoClass;

    @JSONField(name = "article_item_title_mode")
    private String articleItemTitleMode;

    @JSONField(name = "article_stock_note")
    private String articleStockNote;

    @JSONField(name = "taobao_url")
    private String taobaoUrl;

    @JSONField(name = "timesort")
    private String timesort;

    @JSONField(name = "top_category")
    private String topCategory;

    @JSONField(name = "article_link_name")
    private String articleLinkName;

    @JSONField(name = "article_channel_url")
    private String articleChannelUrl;

    @JSONField(name = "article_link")
    private String articleLink;

    @JSONField(name = "article_category")
    private String articleCategory;

    @JSONField(name = "category_layer")
    private String categoryLayer;

    @JSONField(name = "matches_rules")
    private String matchesRules;

    @JSONField(name = "gtm")
    private String gtm;

    @JSONField(name = "article_type")
    private String articleType;

    @JSONField(name = "link_nofollow")
    private String linkNofollow;

    @JSONField(name = "article_content")
    private String articleContent;

    @JSONField(name = "article_mall_url")
    private String articleMallUrl;

    @JSONField(name = "article_format_date")
    private String articleFormatDate;

    @JSONField(name = "article_is_timeout")
    private String articleIsTimeout;

    @JSONField(name = "buy_button_name")
    private String buyButtonName;

    @JSONField(name = "article_channel_class")
    private String articleChannelClass;

    @JSONField(name = "article_url")
    private String articleUrl;

    @JSONField(name = "article_channel_id")
    private String articleChannelId;

    @JSONField(name = "article_channel_note")
    private String articleChannelNote;

    @JSONField(name = "article_date")
    private String articleDate;

    @JSONField(name = "article_title")
    private String articleTitle;

    @JSONField(name = "article_pic_style")
    private String articlePicStyle;

    @JSONField(name = "mall_more_info")
    private String mallMoreInfo;

    @JSONField(name = "article_content_all")
    private String articleContentAll;

    @JSONField(name = "article_collection")
    private String articleCollection;

    @JSONField(name = "article_link_domain")
    private String articleLinkDomain;

    public String getArticleLinkList() {
        return articleLinkList;
    }

    public void setArticleLinkList(String articleLinkList) {
        this.articleLinkList = articleLinkList;
    }

    public String getArticleMall() {
        return articleMall;
    }

    public void setArticleMall(String articleMall) {
        this.articleMall = articleMall;
    }

    public String getArticleReferrals() {
        return articleReferrals;
    }

    public void setArticleReferrals(String articleReferrals) {
        this.articleReferrals = articleReferrals;
    }

    public String getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(String articlePrice) {
        this.articlePrice = articlePrice;
    }

    public String getArticleWorthy() {
        return articleWorthy;
    }

    public void setArticleWorthy(String articleWorthy) {
        this.articleWorthy = articleWorthy;
    }

    public String getArticleChannelName() {
        return articleChannelName;
    }

    public void setArticleChannelName(String articleChannelName) {
        this.articleChannelName = articleChannelName;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    public String getArticleIsSoldOut() {
        return articleIsSoldOut;
    }

    public void setArticleIsSoldOut(String articleIsSoldOut) {
        this.articleIsSoldOut = articleIsSoldOut;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleChannel() {
        return articleChannel;
    }

    public void setArticleChannel(String articleChannel) {
        this.articleChannel = articleChannel;
    }

    public String getYhType() {
        return yhType;
    }

    public void setYhType(String yhType) {
        this.yhType = yhType;
    }

    public String getArticleTeseTags() {
        return articleTeseTags;
    }

    public void setArticleTeseTags(String articleTeseTags) {
        this.articleTeseTags = articleTeseTags;
    }

    public String getArticleComment() {
        return articleComment;
    }

    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }

    public String getArticleUnworthy() {
        return articleUnworthy;
    }

    public void setArticleUnworthy(String articleUnworthy) {
        this.articleUnworthy = articleUnworthy;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleLogoClass() {
        return articleLogoClass;
    }

    public void setArticleLogoClass(String articleLogoClass) {
        this.articleLogoClass = articleLogoClass;
    }

    public String getArticleItemTitleMode() {
        return articleItemTitleMode;
    }

    public void setArticleItemTitleMode(String articleItemTitleMode) {
        this.articleItemTitleMode = articleItemTitleMode;
    }

    public String getArticleStockNote() {
        return articleStockNote;
    }

    public void setArticleStockNote(String articleStockNote) {
        this.articleStockNote = articleStockNote;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getTimesort() {
        return timesort;
    }

    public void setTimesort(String timesort) {
        this.timesort = timesort;
    }

    public String getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(String topCategory) {
        this.topCategory = topCategory;
    }

    public String getArticleLinkName() {
        return articleLinkName;
    }

    public void setArticleLinkName(String articleLinkName) {
        this.articleLinkName = articleLinkName;
    }

    public String getArticleChannelUrl() {
        return articleChannelUrl;
    }

    public void setArticleChannelUrl(String articleChannelUrl) {
        this.articleChannelUrl = articleChannelUrl;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getCategoryLayer() {
        return categoryLayer;
    }

    public void setCategoryLayer(String categoryLayer) {
        this.categoryLayer = categoryLayer;
    }

    public String getMatchesRules() {
        return matchesRules;
    }

    public void setMatchesRules(String matchesRules) {
        this.matchesRules = matchesRules;
    }

    public String getGtm() {
        return gtm;
    }

    public void setGtm(String gtm) {
        this.gtm = gtm;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getLinkNofollow() {
        return linkNofollow;
    }

    public void setLinkNofollow(String linkNofollow) {
        this.linkNofollow = linkNofollow;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleMallUrl() {
        return articleMallUrl;
    }

    public void setArticleMallUrl(String articleMallUrl) {
        this.articleMallUrl = articleMallUrl;
    }

    public String getArticleFormatDate() {
        return articleFormatDate;
    }

    public void setArticleFormatDate(String articleFormatDate) {
        this.articleFormatDate = articleFormatDate;
    }

    public String getArticleIsTimeout() {
        return articleIsTimeout;
    }

    public void setArticleIsTimeout(String articleIsTimeout) {
        this.articleIsTimeout = articleIsTimeout;
    }

    public String getBuyButtonName() {
        return buyButtonName;
    }

    public void setBuyButtonName(String buyButtonName) {
        this.buyButtonName = buyButtonName;
    }

    public String getArticleChannelClass() {
        return articleChannelClass;
    }

    public void setArticleChannelClass(String articleChannelClass) {
        this.articleChannelClass = articleChannelClass;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getArticleChannelId() {
        return articleChannelId;
    }

    public void setArticleChannelId(String articleChannelId) {
        this.articleChannelId = articleChannelId;
    }

    public String getArticleChannelNote() {
        return articleChannelNote;
    }

    public void setArticleChannelNote(String articleChannelNote) {
        this.articleChannelNote = articleChannelNote;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticlePicStyle() {
        return articlePicStyle;
    }

    public void setArticlePicStyle(String articlePicStyle) {
        this.articlePicStyle = articlePicStyle;
    }

    public String getMallMoreInfo() {
        return mallMoreInfo;
    }

    public void setMallMoreInfo(String mallMoreInfo) {
        this.mallMoreInfo = mallMoreInfo;
    }

    public String getArticleContentAll() {
        return articleContentAll;
    }

    public void setArticleContentAll(String articleContentAll) {
        this.articleContentAll = articleContentAll;
    }

    public String getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(String articleCollection) {
        this.articleCollection = articleCollection;
    }

    public String getArticleLinkDomain() {
        return articleLinkDomain;
    }

    public void setArticleLinkDomain(String articleLinkDomain) {
        this.articleLinkDomain = articleLinkDomain;
    }
}
