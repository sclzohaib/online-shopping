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
		<nav
			class="navbar navbar-expand-lg navbar-dark bg-dark navbar-fixed-top">
			<div>
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home"><u>Home</u></a>
				</div>
			</div>
		</nav>
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap:break-word">${errorDescription}</blockquote>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>



	<script src="${js}/bootstrap.bundle.min.js"></script>

	<!-- data tables-->
	<script src="${js}/jquery.dataTables.min.js"></script>

	<!-- self coded javascript -->
	<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>