<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data">
            <label><input type="text" name="text" placeholder="Type message here"/></label>
            <label><input type="text" name="tags" placeholder="Tags"/></label>
            <input type="file" name="file"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Add</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get" action="/main">
        <label><input type="text" name="filter" value="${filter!}"></label>
        <button type="submit">Find</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tags}</i>
            <strong>${message.userName}</strong>
            <div>
                <#if message.filename??>
                    <img src="/img/${message.filename}" alt="bla">
                <#else>
                    No image file
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
</@c.page>