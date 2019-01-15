<%--
  Created by IntelliJ IDEA.
  User: mfmohamadfaez
  Date: 29/11/2018
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Test Result Form</title>
</head>
<body>
<div class="container" style="margin-top: 50px">
    <div class="innerContent" id="curvebackgroundPop">
        <form:form class="" action="" modelAttribute="participant" method="post">
            <fieldset>
                <legend>Participant Details</legend>
                <hr>
                <div class="form-group row">
                    <label class="col-sm-12 col-form-label">Full Name :</label>
                    <label class="col-sm-12">${participant.name}</label>
                    <label class="col-sm-12 col-form-label">NRIC No :</label>
                    <label class="col-sm-12">${participant.nricNo}</label>
                    <label class="col-sm-12 col-form-label">Age :</label>
                    <label class="col-sm-12">${participant.age}</label>
                    <label class="col-sm-12 col-form-label">Gender :</label>
                    <label class="col-sm-12 ">${participant.gender}</label>
                </div>
                <div class="form-group row">
                    <label class="col-sm-12 col-form-label">Height (cm) :</label>
                    <label class="col-sm-12">${participant.height}</label>
                    <label class="col-sm-12 col-form-label">Weight (kg) :</label>
                    <label class="col-sm-12 ">${participant.weight}</label>
                    <label class="col-sm-12 col-form-label">Body No. :</label>
                    <label class="col-sm-12 ">${participant.bodyNo}</label>
                    <label class="col-sm-12 col-form-label">Turn No. :</label>
                    <label class="col-sm-12 ">${participant.turnNo}</label>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <form:form class="form-horizontal" action="/NPFT/processTRForm" modelAttribute="testResult" method="post">
            <fieldset>
                <legend>Test Result Form</legend>
                <hr>
                <div class="form-group">
                    <label class="col-sm-12 col-form-label" path="">Body Mass Index (BMI) Test</label>
                    <div class="col-md-8 inputGroupContainer">
                        <div class="input-group">
                            <form:input path="pId" id="pId" name="pId"
                                        placeholder=""
                                        class="form-control"
                                        required="true"
                                        value="${participant.id}"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="testId" id="testId"
                                        name="testId" placeholder=""
                                        class="form-control"
                                        required="true" value="1"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="mark" id="bmiMark"
                                        name="bmiMark" placeholder=""
                                        class="form-control"
                                        required="true" value=""
                                        type="text"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12 col-form-label" path="">Hand Grip Test</label>
                    <div class="col-md-8 inputGroupContainer">
                        <div class="input-group">
                            <form:input path="pId" id="pId" name="pId"
                                        placeholder=""
                                        class="form-control"
                                        required="true"
                                        value="${participant.id}"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="testId" id="testId"
                                        name="testId" placeholder=""
                                        class="form-control"
                                        required="true" value="2"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="mark" id="gtMark"
                                        name="gtMark" placeholder=""
                                        class="form-control"
                                        required="true" value=""
                                        type="text"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12 col-form-label" path="">Sit and Reach Test</label>
                    <div class="col-md-8 inputGroupContainer">
                        <div class="input-group">
                            <form:input path="pId" id="pId" name="pId"
                                        placeholder=""
                                        class="form-control"
                                        required="true"
                                        value="${participant.id}"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="testId" id="testId"
                                        name="testId" placeholder=""
                                        class="form-control"
                                        required="true" value="3"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="mark" id="djMark"
                                        name="djMark" placeholder=""
                                        class="form-control"
                                        required="true" value=""
                                        type="text"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12 col-form-label" path="">Curl-up Test</label>
                    <div class="col-md-8 inputGroupContainer">
                        <div class="input-group">
                            <form:input path="pId" id="pId" name="pId"
                                        placeholder=""
                                        class="form-control"
                                        required="true"
                                        value="${participant.id}"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="testId" id="testId"
                                        name="testId" placeholder=""
                                        class="form-control"
                                        required="true" value="4"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="mark" id="btMark"
                                        name="btMark" placeholder=""
                                        class="form-control"
                                        required="true" value=""
                                        type="text"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12 col-form-label" path="">Bleep Test</label>
                    <div class="col-md-8 inputGroupContainer">
                        <div class="input-group">
                            <form:input path="pId" id="pId" name="pId"
                                        placeholder=""
                                        class="form-control"
                                        required="true"
                                        value="${participant.id}"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="testId" id="testId"
                                        name="testId" placeholder=""
                                        class="form-control"
                                        required="true" value="5"
                                        type="hidden"/></div>
                        <div class="input-group">
                            <form:input path="mark" id="bleepMark"
                                        name="bleepMark" placeholder="Lx/Sx"
                                        class="form-control"
                                        required="true" value=""
                                        type="text"/></div>
                    </div>
                </div>
                <div class="row">
                    <hr>
                    <div class="form-group">
                        <form:button type="submit" class="btn btn-login ml-4">Submit</form:button>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>
<script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</body>
</html>
