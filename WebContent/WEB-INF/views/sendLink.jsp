<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>



<h3>Page where you can inform the link to get the sub links</h3>

<form  method="post" action="/Project-GetLinks/linksave">


<div> 
  <label for="linkAdd"  >Link Adress</label>
  <input type="text" name="linkAdd" id="linkAdd" />
</div>


<div>
<input  type="submit" value="Send" />
</div>



</form>



</body>
</html>