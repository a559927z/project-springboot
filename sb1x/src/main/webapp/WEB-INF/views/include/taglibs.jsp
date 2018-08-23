<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

// Object version=request.getAttribute("version");
    Object versionObj = request.getAttribute("versionMap");
    if (versionObj == null) {
        versionObj = new Object();
    }
    String versionJson = "{}";
    if (request.getAttribute("versionJson") != null) {
        versionJson = request.getAttribute("versionJson").toString();
    }
    long reflesh = System.currentTimeMillis();

    // 分割线
    String link = "<HR style=\"FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)\" width=\"80%\" color=#987cb9 SIZE=1>";
%>
<c:set var="ctx" value="<%=basePath%>"/>
<c:set var="v" value="<%=versionObj%>"/>
<c:set var="reflesh" value="<%=reflesh%>"/>
<c:set var="link" value="<%=link%>"/>

<script language="JavaScript">
    var version =<%=versionJson%>;
    var USER_KEY = '<%=session.getAttribute("userKey")%>';
    G_WEB_ROOT = "<%=basePath%>";
</script>

