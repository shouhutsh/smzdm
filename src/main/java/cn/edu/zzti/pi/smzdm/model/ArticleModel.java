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

    @JSONField(name = "article_column")
    private String articleColumn;

    @JSONField(name = "article_top")
    private String articleTop;

    @JSONField(name = "article_anonymous")
    private String articleAnonymous;

    @JSONField(name = "article_price")
    private String articlePrice;

    @JSONField(name = "article_unix_date")
    private String articleUnixDate;

    @JSONField(name = "article_channel_name")
    private String articleChannelName;

    @JSONField(name = "article_worthy")
    private String articleWorthy;

    @JSONField(name = "article_district")
    private Integer articleDistrict;

    @JSONField(name = "article_pic")
    private String articlePic;

    @JSONField(name = "article_is_sold_out")
    private String articleIsSoldOut;

    @JSONField(name = "article_id")
    private String articleId;

    @JSONField(name = "article_unworthy")
    private String articleUnworthy;

    @JSONField(name = "article_comment")
    private String articleComment;

    @JSONField(name = "article_logo_class")
    private String articleLogoClass;

    @JSONField(name = "article_tag")
    private String articleTag;

    @JSONField(name = "article_link")
    private String articleLink;

    @JSONField(name = "article_region")
    private String articleRegion;

    @JSONField(name = "matches_rules")
    private String matchesRules;

    @JSONField(name = "promotion_type")
    private String promotionType;

    @JSONField(name = "article_type_name")
    private String articleTypeName;

    @JSONField(name = "article_mall_icon")
    private String articleMallIcon;

    @JSONField(name = "article_link_type")
    private String articleLinkType;

    @JSONField(name = "article_format_date")
    private String articleFormatDate;

    @JSONField(name = "article_is_timeout")
    private String articleIsTimeout;

    @JSONField(name = "article_url")
    private String articleUrl;

    @JSONField(name = "article_channel_id")
    private String articleChannelId;

    @JSONField(name = "article_date")
    private String articleDate;

    @JSONField(name = "article_type_id")
    private String articleTypeId;

    @JSONField(name = "article_title")
    private String articleTitle;

    @JSONField(name = "redirect_data")
    private RedirectData redirectData;

    @JSONField(name = "ga_category")
    private String gaCategory;

    @JSONField(name = "article_collection")
    private String articleCollection;

    @JSONField(name = "time_sort")
    private String timeSort;

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

    public String getArticleColumn() {
        return articleColumn;
    }

    public void setArticleColumn(String articleColumn) {
        this.articleColumn = articleColumn;
    }

    public String getArticleTop() {
        return articleTop;
    }

    public void setArticleTop(String articleTop) {
        this.articleTop = articleTop;
    }

    public String getArticleAnonymous() {
        return articleAnonymous;
    }

    public void setArticleAnonymous(String articleAnonymous) {
        this.articleAnonymous = articleAnonymous;
    }

    public String getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(String articlePrice) {
        this.articlePrice = articlePrice;
    }

    public String getArticleUnixDate() {
        return articleUnixDate;
    }

    public void setArticleUnixDate(String articleUnixDate) {
        this.articleUnixDate = articleUnixDate;
    }

    public String getArticleChannelName() {
        return articleChannelName;
    }

    public void setArticleChannelName(String articleChannelName) {
        this.articleChannelName = articleChannelName;
    }

    public String getArticleWorthy() {
        return articleWorthy;
    }

    public void setArticleWorthy(String articleWorthy) {
        this.articleWorthy = articleWorthy;
    }

    public Integer getArticleDistrict() {
        return articleDistrict;
    }

    public void setArticleDistrict(Integer articleDistrict) {
        this.articleDistrict = articleDistrict;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
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

    public String getArticleUnworthy() {
        return articleUnworthy;
    }

    public void setArticleUnworthy(String articleUnworthy) {
        this.articleUnworthy = articleUnworthy;
    }

    public String getArticleComment() {
        return articleComment;
    }

    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }

    public String getArticleLogoClass() {
        return articleLogoClass;
    }

    public void setArticleLogoClass(String articleLogoClass) {
        this.articleLogoClass = articleLogoClass;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getArticleRegion() {
        return articleRegion;
    }

    public void setArticleRegion(String articleRegion) {
        this.articleRegion = articleRegion;
    }

    public String getMatchesRules() {
        return matchesRules;
    }

    public void setMatchesRules(String matchesRules) {
        this.matchesRules = matchesRules;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getArticleMallIcon() {
        return articleMallIcon;
    }

    public void setArticleMallIcon(String articleMallIcon) {
        this.articleMallIcon = articleMallIcon;
    }

    public String getArticleLinkType() {
        return articleLinkType;
    }

    public void setArticleLinkType(String articleLinkType) {
        this.articleLinkType = articleLinkType;
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

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(String articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public RedirectData getRedirectData() {
        return redirectData;
    }

    public void setRedirectData(RedirectData redirectData) {
        this.redirectData = redirectData;
    }

    public String getGaCategory() {
        return gaCategory;
    }

    public void setGaCategory(String gaCategory) {
        this.gaCategory = gaCategory;
    }

    public String getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(String articleCollection) {
        this.articleCollection = articleCollection;
    }

    public String getTimeSort() {
        return timeSort;
    }

    public void setTimeSort(String timeSort) {
        this.timeSort = timeSort;
    }
}
