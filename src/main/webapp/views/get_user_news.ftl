<#if feed??>
    <#if 0 < feed?size>
<div class="divider"></div>
    </#if>
    <#list feed as feed_item>
        <div style="height: 0"><button style="margin: 0; float:right; font-size: 20px; background: none; border: none;" onclick="deleteFeedItem(${feed_item.getId()})">x</button></div>

        <div class="light_blue text">${feed_item.getDateTime()}</div>
        <div class="text">Автор: ${feed_item.getAuthorName()}</div>
        <div class="text">${feed_item.getText()}</div>

        <#if feed_item_index < feed?size - 1>
        <div class="divider"></div>
        </#if>
    </#list>

    <div style="text-align: center">Всего ${feed?size} записей</div>
</#if>