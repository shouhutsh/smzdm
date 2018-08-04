<html>
<head>
    <meta name="referrer" content="no-referrer"/>
</head>
<body>
<div>
    帮助我做的更好？
    <a href="mailto:shouhutsh@outlook.com">邮件</a>
    <a href="https://github.com/shouhutsh/smzdm">GitHub</a>
    <a href="donation">捐赠</a>
    <a href="red_package">领红包</a>
</div>
<hr/>
    <#list worthAtircles as w>
    <li>
        <div>
            <div>
                <img src="${w.articlePic}" referrerpolicy="never">
            </div>
            <div>
                <div><a href="${w.articleUrl}">${w.articleTitle}</a></div>
                <div>时间：${w.articleDate}</div>
                <div>价格：${w.articlePrice}</div>
                <div>评论：${w.articleComment}</div>
                <div>值：${w.articleWorthy}</div>
            </div>
        </div>
    </li>
    </#list>
</body>
</html>
