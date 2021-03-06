<%--
  Created by IntelliJ IDEA.
  User: 韩壮
  Date: 2017/5/17
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <title>登录页面</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
   <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>


   <!-- Facebook and Twitter integration -->
   <meta property="og:title" content=""/>
   <meta property="og:image" content=""/>
   <meta property="og:url" content=""/>
   <meta property="og:site_name" content=""/>
   <meta property="og:description" content=""/>
   <meta name="twitter:title" content=""/>
   <meta name="twitter:image" content=""/>
   <meta name="twitter:url" content=""/>
   <meta name="twitter:card" content=""/>

   <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

   <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

   <link rel="stylesheet" href="css/bootstrap.min.css">
   <link rel="stylesheet" href="css/animate.css">
   <link rel="stylesheet" href="css/style.css">


   <!-- Modernizr JS -->
   <script src="js/modernizr-2.6.2.min.js"></script>
   <!-- FOR IE9 below -->
   <!--[if lt IE 9]>
   <script src="js/respond.min.js"></script>
   <![endif]-->
   <script src="frontDesk/js/myJs.js"></script>
   <!--输入合法性检验-->

</head>
<body>

<div class="container">
   <div class="copyrights">Collect from hanzhuang</div>
   <div class="row">
      <div class="col-md-4 col-md-offset-4">


         <!-- Start Sign In Form -->
         <form name="loginForm" action = "login.action" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
            <h2>登录</h2>
            <s:actionmessage/>
            <div class="form-group">
               <label for="user.username" class="sr-only">用户名</label>
               <input type="text" class="form-control" id="user.username" name="user.username" placeholder="用户名"
                      autocomplete="off">
            </div>
            <div class="form-group">
               <label for="user.password" class="sr-only">密码</label>
               <input type="password" class="form-control" id="user.password" name="user.password" placeholder="密码"
                      autocomplete="off">
            </div>
            <div class="form-group">
               <p>稍后登录? <a href="frontDesk/index.jsp">主页面</a>
            </div>
            <div class="form-group">
               <input type="button" onclick="loginCheck()" value="登录" class="btn btn-primary">
            </div>
         </form>
         <!-- END Sign In Form -->

      </div>
   </div>
   <div class="row" style="padding-top: 60px; clear: both;">
      <div class="col-md-12 text-center">
         <p>
            <small>&copy; All Rights Reserved.</small>
         </p>
      </div>
   </div>
</div>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="js/main.js"></script>


</body>
</html>

