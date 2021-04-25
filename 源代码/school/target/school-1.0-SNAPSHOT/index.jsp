<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/css/mystyle.css" rel="stylesheet">
    <title>Perfect Campus</title>
    <script language="javascript">
        function check() { /*表单信息验证*/
            var id = document.getElementById("id").value;
            var pwd = document.getElementById("pwd").value;


            if (id == null || id == "") {
                alert("请输入用户名！");
                return false;
            }
            if (pwd == null || pwd == "") {
                alert("请输入密码");
                return false;
            }0



        }
    </script>
</head>

<body >
<div class="container">
    <div class="login-wrapper">
        <div class="header">Login</div>
        <div class="form-warpper">
            <form action="LoginServlet" method="post" name="form" id="form" onsubmit="return check()">
                <input type="text" name="id" id="id" placeholder="username" class="input-item">
                <input type="password" name="pwd" id="pwd" placeholder="password" class="input-item">
                <input type="radio" name="sort" value="teacher" checked>教师
                <input type="radio" name="sort" value="student">学生
                <input name="Submit" type="submit" class="btn"
                       value="login">
            </form>
        </div>

    </div>
</div>

</body>
</html>
<script type=text/javascript>
    if('${error}'!=''){
        alert('${error}');
    }
</script>