<#if feed??>
<#if 0 < feed?size>
    <div class="divider"></div>
</#if>
    <#list feed as feed_item>
    <div class="news_item">
        <div class="news_item_text_time">${feed_item.getDateTime()}</div>
        <div class="news_item_text_author">Автор: ${feed_item.getAuthorName() ! ""}</div>
        <div class="news_item_text">${feed_item.getText()}</div>
    </div>

        <#if feed_item_index < feed?size - 1>
        <div class="divider"></div>
        </#if>
    </#list>
</#if>