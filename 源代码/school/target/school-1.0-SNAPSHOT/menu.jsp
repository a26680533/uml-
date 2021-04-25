<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function logout(){
	if(confirm('您确定要退出系统吗？')){
		window.location.href="${pageContext.request.contextPath}/index.jsp";
	}
}
</script>
</div>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
<form role="search">
    <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
    </div>
</form>
<ul class="nav menu">
<c:if test="${ sort=='teacher'}">
    <li><a href="${pageContext.request.contextPath}/TeacherServlet?action=approve"><span class="glyphicon glyphicon-dashboard"></span>出校审批</a></li>
    <li><a href="${pageContext.request.contextPath}/TeacherServlet?action=checkinfo"><span class="glyphicon glyphicon-th"></span>打卡情况</a></li>
    <li role="presentation" class="divider"></li>
    <li><a href="javascript:logout()"><span class="glyphicon glyphicon-user"></span> Sign Out</a></li>
    </ul>
    <div class="attribution">Template by <a href="#" target="_blank">ShawAdmin</a></div>
    </div>
</c:if>
<c:if test="${ sort=='student'}">
    <li><a href="${pageContext.request.contextPath}/StudentServlet?action=application"><span class="glyphicon glyphicon-dashboard"></span>出校申请</a></li>
    <li><a href="${pageContext.request.contextPath}/StudentServlet?action=info"><span class="glyphicon glyphicon-th"></span>每日打卡</a></li>
    <li role="presentation" class="divider"></li>
    <li><a href="javascript:logout()"><span class="glyphicon glyphicon-user"></span> Sign Out</a></li>
    </ul>
    <div class="attribution">Template by <a href="#" target="_blank">ShawAdmin</a></div>
    </div>
</c:if>

