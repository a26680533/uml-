<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">

    // 选择课程
    function agree(id, date, status) {

        $.post("TeacherServlet?action=agree", {id: id, date: date, status: status},
            function (result) {
                var result = eval('(' + result + ')');
                if (result.success) {
                    alert("审批成功!");
                    window.location.href = "${pageContext.request.contextPath}/TeacherServlet?action=approve";
                } else {
                    alert("审批失败！");
                }
            }
        );

    }


</script>
<div class="panel panel-default">
    <div class="panel-heading">待审批名单</div>
    <table class="table table-hover  table-bordered table-striped">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>出校日期</th>
            <th>出校原因</th>
            <th>审批</th>
        </tr>
        <c:forEach var="application" items="${ application }" varStatus="status">
        <tr>
            <td>${application.sid}</td>
            <td>${application.sname }</td>
            <td>${application.date }</td>
            <td>${application.reason }</td>
            <td>
                <button type="button" class="btn btn-success"
                        onclick="agree(${application.sid },'${application.date }','同意')">同意
                </button>
                <button type="button" class="btn btn-danger"
                        onclick="agree(${application.sid },'${application.date }','拒绝')">拒绝
                </button>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



