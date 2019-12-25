<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Type message here">
            <input type="text" name="tags" placeholder="Tags">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Add</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter?ifExists}">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Find</button>
    </form>
    <#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tags}</i>
        <strong>${message.userName}</strong>
    </div>
    <#else>
    No message
    </#list>
</@c.page>