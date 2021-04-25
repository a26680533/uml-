<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="panel panel-default">
	<div class="panel-heading">打卡情况</div>
	<table class="table table-hover  table-bordered table-striped">
		<thead>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>日期</th>
			<th>打卡情况</th>
			<th></th>
		</tr>
		<c:forEach var="student" items="${ student }" varStatus="status">
		<tr>
			<td>${student.id}</td>
			<td>${student.name }</td>
			<td>${date}</td>
			<td>未打卡</td>

		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>