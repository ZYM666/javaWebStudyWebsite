<%@ page import="WebDB.StudentDAO" %>
<%@ page import="beans.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.StudentHomework" %><%--
  Created by IntelliJ IDEA.
  User: 韩壮
  Date: 2017/5/16
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生作业</title>
</head>
<body>
<%@include file="aside.jsp"%><!--左侧布局-->
<div id="fh5co-main">
    <!--右侧布局-->
    <%
        Users user=(Users)session.getAttribute("user");

        if(user==null){//过滤器
           return;
        }

        StudentDAO studentDAO=new StudentDAO(user);

        ArrayList<StudentHomework> homeworkList=studentDAO.getStudentHomework();

        for(StudentHomework homework:homeworkList){
           out.println("1111111111111111111111111");
        }

    %>
</div>
</body>
</html>