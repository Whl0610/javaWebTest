<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*, java.util.* , java.sql.*" %>
<%@ page import = "javax.servlet.http.* , javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>SQL SELECT</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver"
       url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8"
       user="root" password="123"/>
<sql:query dataSource="${snapshot}" var = "result">
SELECT * from Que;
</sql:query>>
    <h3>SQL SELECT操作</h3>
    <table border="1" width = "100%">
    <tr>
    	<th>id</th>
    	<th>question</th>
    	<th>A</th>
    	<th>B</th>
    	<th>C</th>
    	<th>D</th>
    	<th>answer</th>
    </tr>
    <c:forEach var ="row" items="${result.rows}">
    <tr>
    	<td><c:out value = "${row.id}"/></td>
    	<td><c:out value = "${row.question}"/></td>
    	<td><c:out value = "${row.A}"/></td>
    	<td><c:out value = "${row.B}"/></td>
    	<td><c:out value = "${row.C}"/></td>
    	<td><c:out value = "${row.D}"/></td>
    	<td><c:out value = "${row.answer}"/></td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>
