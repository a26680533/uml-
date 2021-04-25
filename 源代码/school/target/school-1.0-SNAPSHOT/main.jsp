<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
	  <meta charset="utf-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <title>Bootstrap 101 Template</title>
	  <link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/bootstrap3/css/datepicker3.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/bootstrap3/css/styles.css" rel="stylesheet">

<%
	if(session.getAttribute("sort")==null){
		response.sendRedirect("index.jsp");
		return;
	}

	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="default.jsp";
	}
%>
  </head>
  <body>
  <div class="container">
	  <jsp:include page="head.jsp"/>

	  <jsp:include page="menu.jsp"/>

	  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		  <div>
			  <ol class="breadcrumb">
				  <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
				  <li class="active">${modeName }</li>
			  </ol>
		  </div>
		  <jsp:include page="<%=mainPage%>"/>
	  </div>

	  <jsp:include page="foot.jsp"/>

  </div>




  </div>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/chart.min.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/chart-data.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/easypiechart.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/easypiechart-data.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap-datepicker.js"></script>
  <script>
	  $('#calendar').datepicker({
	  });

	  !function ($) {
		  $(document).on("click","ul.nav li.parent > a > span.icon", function(){
			  $(this).find('em:first').toggleClass("glyphicon-minus");
		  });
		  $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
	  }(window.jQuery);

	  $(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
	  })
	  $(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
	  })
  </script>
  </body>
</html>
