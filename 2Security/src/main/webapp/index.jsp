<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<title>Halloween Application</title>

	<!-- <script src="lib/jquery.min.js"></script>
	<script src="lib/jquery.cookie.js"></script>
	<script src="index.js"></script>
	<script src="utils.js"></script>-->
</head>
<body>
	Here's what our Helloween service is saying to you:

	<div id="helloweenMessage"></div>

	<button id="postButton" type="button">POST something...</button>
	<br/>

	<button id="logoutButton" type="button">Get me out of here! (logout)</button>
	
	<form action="/logout" method="post">
		<input name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="logout">
	</form>
	
	<a href="/mylogin">login</a>
	
	
	<a href="/rest/hello">rest/hello</a>
	
</body>
</html>