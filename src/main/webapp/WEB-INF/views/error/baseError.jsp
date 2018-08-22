<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@include file="/WEB-INF/views/include/taglibs.jsp" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%
    //设置返回码200，避免浏览器自带的错误页面
    response.setStatus(200);
    System.err.println("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + exception.getMessage());
%>
<script>

    "访问:" + "<%=request.getRequestURI()%>" + " 发生错误, 错误信息:" + "<%=exception.getMessage()%>"
</script>