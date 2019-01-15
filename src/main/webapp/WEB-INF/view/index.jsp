<%--
  Created by IntelliJ IDEA.
  User: mfmohamadfaez
  Date: 08/10/2018
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NPFT Log-In Form</title>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>">

    <style>
        @import url("//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");

        .login-block {
            background: #DE6262; /* fallback for old browsers */
            background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262); /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to bottom, #FFB88C, #DE6262); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            float: left;
            width: 100%;
            padding: 50px 0;
        }

        .banner-sec {
            background: url("${pageContext.request.contextPath}/resources/images/NPFTWORD3.png") no-repeat left bottom;
            background-position: center;
            background-size: cover;
            min-height: 450px;
            border-radius: 0 10px 10px 0;
            padding < div class = "carousel-caption d-none d-md-block" > < div class = "banner-text" > < h2 > This is Heaven < / h2 > < p > Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua . Ut enim ad minim veniam, quis nostrud exercitation < / p > < / div > < / div >: 0;
        }

        .container {
            background: #fff;
            border-radius: 10px;
            box-shadow: 15px 20px 0px rgba(0, 0, 0, 0.1);
        }

        .carousel-inner {
            border-radius: 0 10px 10px 0;
        }

        .carousel-caption {
            text-align: left;
            left: 5%;
        }

        .login-sec {
            padding: 50px 30px;
            position: relative;
        }

        .login-sec .copy-text {
            position: absolute;
            width: 80%;
            bottom: 20px;
            font-size: 13px;
            text-align: center;
        }

        .login-sec .copy-text i {
            color: #FEB58A;
        }

        .login-sec .copy-text a {
            color: #E36262;
        }

        .login-sec h2 {
            margin-bottom: 30px;
            font-weight: 800;
            font-size: 30px;
            color: #DE6262;
        }

        .login-sec h2:after {
            content: " ";
            width: 100px;
            height: 5px;
            background: #FEB58A;
            display: block;
            margin-top: 20px;
            border-radius: 3px;
            margin-left: auto;
            margin-right: auto
        }

        .btn-login {
            background: #DE6262;
            color: #fff;
            font-weight: 600;
        }

        .banner-text {
            width: 70%;
            position: absolute;
            bottom: 40px;
            padding-left: 20px;
        }

        .banner-text h2 {
            color: #fff;
            font-weight: 600;
        }

        .banner-text h2:after {
            content: " ";
            width: 100px;
            height: 5px;
            background: #FFF;
            display: block;
            margin-top: 20px;
            border-radius: 3px;
        }

        .banner-text p {
            color: #fff;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>

<section class="login-block">
    <div class="container">
        <div class="row">

            <div class="col-md-4 login-sec">
                <h2 class="text-center">Login Now</h2>
                <form:form class="login-form" action="/NPFT/processLoginForm" modelAttribute="identity" method="post">
                    <div class="form-group">

                        <form:label path="" cssClass="text-uppercase">Username</form:label>
                        <form:input cssClass="form-control" placeholder="" path="userName"/>

                    </div>

                    <div class="form-group">

                        <form:label path="" cssClass="text-uppercase">Password</form:label>
                        <form:password cssClass="form-control" placeholder="" path="password"/>

                    </div>
                    <c:if test="${not empty errorMsg}">
                        <p class="error"><c:out value="${errorMsg}"/></p>
                    </c:if>

                    <div class="form-check">
                        <form:button type="submit" class="btn btn-login float-right">Submit</form:button>
                    </div>


                </form:form>
            </div>
            <div class="col-md-8 banner-sec">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
            </div>
            <div class="col-md-8">
                <div class="mb-2 copy-text float-md-right">Prepared for Kementerian Belia dan Sukan (KKBS).</div>
            </div>
        </div>
    </div>
</section>
<div id="footer">
    <div class="container-fluid text-center">
        <div class="mb-2 copy-text ml-auto mr-auto">copyright 2019@UiTM</div>
    </div>
</div>
<script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
</html>