<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</script>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">个人信息</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" role="form"  method="post"  action="StudentServlet?action=addcheck" onsubmit="return checkForm()">
            <div class="form-group">
                <label class="col-md-2 control-label">用户名：</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="id" name="id" style="width: 300px;"
                           value="${student.id }" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">姓名：</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="name" name="name" style="width: 300px;"
                           value="${student.name }" readonly="readonly">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">日期：</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="date" name="date" style="width: 300px;" value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">健康：</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="healthy" name="healthy" style="width: 300px;" value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">地址：</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="address" name="address" style="width: 300px;" value="">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;

                </div>
            </div>

        </form>
    </div>
</div>

