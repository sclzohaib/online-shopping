<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.minn.css" rel="stylesheet">
<link href="${css}/bootstrap.min.css" rel="stylesheet">


<!-- Bootstrap simplex theme CSS -->
<!--  <link href="${css}/pulse-theme.css" rel="stylesheet"/>-->

<!-- Bootstrap data CSS -->
<link href="${css}/jquery.dataTables.min.css" rel="stylesheet">

<!-- Bootstrap data CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.min.css" rel="stylesheet">
<!-- <link href="${css}/dataTables.jqueryui.min.css" rel="stylesheet"> -->

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<link href="${css}/round-about.css" rel="stylesheet">
</head>

<body>
 <div class="wrapper">
	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>
		
	<div class="content">

	<!-- When User Click on Home ,Page Content -->
	<c:if test="${userClickHome == true}">
		<%@include file="home.jsp"%>
	</c:if>

	<!-- When User Click on About ,Page Content -->
	<c:if test="${userClickAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>

	<!-- When User Click on Contact ,Page Content -->
	<c:if test="${userClickContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
	
	<!-- When User Click on Contact ,Page Content -->
	<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
		<%@include file="listProducts.jsp"%>
	</c:if>
	
	<!-- When User Click on,show product -->
	<c:if test="${userClickShowProduct == true}">
		<%@include file="singleProduct.jsp"%>
	</c:if>
	
	<!-- When User Click on,Manage product -->
	<c:if test="${userClickManageProducts == true}">
		<%@include file="manageProducts.jsp"%>
	</c:if>
	
	
	
</div>



<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	
	<script src="${js}/jquery.validate.js"></script>
	
	<script src="${js}/bootstrap.bundle.min.js"></script>
	
	<!-- data tables-->
	<script src="${js}/jquery.dataTables.min.js"></script> 
	
	
	<!-- bootbox-->
	<script src="${js}/bootbox.min.js"></script> 
	
	
	
	<!-- self coded javascript -->
	<script src="${js}/myapp.js"></script>
	
	</div>

</body>

</html>