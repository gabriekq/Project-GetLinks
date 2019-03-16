<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.text.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>list page rows</title>
</head>
<body>
<%
response.setIntHeader("Refresh", 10);
%>

<h3> List of sub Web sites</h3>

<br></br>

<c:forEach items="${ElementsList}" var="Element" >

<td>${Element.webAddress}</td>
<br>

</c:forEach>


</body>
</html>