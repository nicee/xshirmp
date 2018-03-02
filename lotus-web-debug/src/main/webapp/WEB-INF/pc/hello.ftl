<!DOCTYPE html>
<html lang="zh_CN">
    <head>
    <meta charset="UTF-8">
        <title>Spring 与 Freemarker 结合</title>
        <script src="/dwr/engine.js"></script>
        <script src="/dwr/util.js" async></script>
        <script src="/dwr/interface/messagePublisher.js"></script>
        <script type="text/javascript">
            window.onload = function (){
                messagePublisher.onEventPublish();
            }
        </script>
    </head>
    <body>
        <p>在ftl文件中暴露出的属性值: </p>
        <ul>
            <ol>org.springframework.web.context.request.async.WebAsyncManager.WEB_ASYNC_MANAGE: ${org.springframework.web.context.request.async.WebAsyncManager.WEB_ASYNC_MANAGER!"null"}</ol>
            <ol>org.springframework.web.servlet.DispatcherServlet.CONTEXT: ${org.springframework.web.servlet.DispatcherServlet.CONTEXT!"null"}</ol>
            <ol>authc.FILTERED: ${authc.FILTERED!"null"}</ol>
            <ol>org.springframework.web.servlet.DispatcherServlet.THEME_SOURCE: ${org.springframework.web.servlet.DispatcherServlet.THEME_SOURCE!"null"}</ol>
            <ol>org.apache.shiro.web.servlet.ShiroHttpServletRequest_REFERENCED_SESSION_IS_NEW: ${org.apache.shiro.web.servlet.ShiroHttpServletRequest_REFERENCED_SESSION_IS_NEW!"null"}</ol>
            <ol>characterEncoding.FILTERED: ${characterEncoding.FILTERED!"null"}</ol>
            <ol>org.springframework.web.servlet.DispatcherServlet.LOCALE_RESOLVER: ${org.springframework.web.servlet.DispatcherServlet.LOCALE_RESOLVER!"null"}</ol>
            <ol>org.apache.shiro.web.servlet.ShiroHttpServletRequest_REQUESTED_SESSION_ID_VAolD: ${org.apache.shiro.web.servlet.ShiroHttpServletRequest_REQUESTED_SESSION_ID_VAolD!"null"}</ol>
            <ol>org.apache.shiro.web.servlet.ShiroHttpServletRequest_REQUESTED_SESSION_ID: ${org.apache.shiro.web.servlet.ShiroHttpServletRequest_REQUESTED_SESSION_ID!"null"}</ol>
            <ol>org.apache.shiro.web.servlet.ShiroHttpServletRequest_SESSION_ID_URL_REWRITING_ENABLED: ${org.apache.shiro.web.servlet.ShiroHttpServletRequest_SESSION_ID_URL_REWRITING_ENABLED!"null"}</ol>
            <ol>org.springframework.web.servlet.HandlerMapping.bestMatchingPattern: ${org.springframework.web.servlet.HandlerMapping.bestMatchingPattern!"null"}</ol>
            <ol>org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP: ${org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP!"null"}</ol>
            <ol>shiroFilter.FILTERED: ${shiroFilter.FILTERED!"null"}</ol>
            <ol>org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping: ${org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping!"null"}</ol>
            <ol>org.springframework.web.servlet.DispatcherServlet.FLASH_MAP_MANAGER: ${org.springframework.web.servlet.DispatcherServlet.FLASH_MAP_MANAGER!"null"}</ol>
            <ol>org.springframework.web.servlet.HandlerMapping.uriTemplateVariables: ${org.springframework.web.servlet.HandlerMapping.uriTemplateVariables!"null"}</ol>
            <ol>org.springframework.web.servlet.DispatcherServlet.THEME_RESOLVER: ${org.springframework.web.servlet.DispatcherServlet.THEME_RESOLVER!"null"}</ol>
            <ol>org.springframework.core.convert.ConversionService: ${org.springframework.core.convert.ConversionService!"null"}</ol>
            <ol>org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY: ${org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY!"null"}</ol>
            <ol>org.apache.shiro.web.servlet.ShiroHttpServletRequestREFERENCED_SESSION_ID_SOURCE: ${org.apache.shiro.web.servlet.ShiroHttpServletRequestREFERENCED_SESSION_ID_SOURCE!"null"}</ol>

            <hr/>
            <ol>org.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEY: ${org.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEY}</ol>
            <ol>${data!"null"}</ol>
            <ol>${request}</ol>
            <ol>${springMacroRequestContext!"null"}</ol>
        </ul>
    </body>
</html>