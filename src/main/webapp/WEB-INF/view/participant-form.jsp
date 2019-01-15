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
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <style>
        .error {
            color: red
        }
    </style>
    <title>Participant Form</title>
</head>
<body>
<div class="container" style="margin-top: 50px">
    <div class="innerContent" id="curvebackgroundPop">
        <h1 class="mt-2">Participant Form</h1>
        <hr>
        <%--<table class="table table-striped">--%>
        <%--<tbody>--%>
        <%--<tr>--%>
        <%--<td colspan="1">--%>
        <form:form class="form-horizontal" action="/NPFT/processParticipantForm"
                   modelAttribute="participant" method="post">
            <fieldset>
                <div class="form-group">
                    <form:label class="col-md-4 control-label" path="">Full Name</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="name" id="fullName" name="fullName" placeholder=""
                                        class="form-control" value="" type="text"/>
                        </div>
                        <form:errors path="name" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label class="col-md-4 control-label" path="">Age</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="age" id="age" name="age" placeholder="" class="form-control"
                                        type="text"/>
                        </div>
                        <form:errors path="age" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Gender</label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:select path="gender" class="form-control form-control-sm">
                                <form:option value="-" label="--Please Select--"/>
                                <form:option value="M" label="Male"/>
                                <form:option value="F" label="Female"/>
                            </form:select>
                        </div>
                        <form:errors path="gender" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="" class="col-md-4 control-label">Height</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="height" id="height" name="height" placeholder=""
                                        class="form-control" type="text"/>
                        </div>
                        <form:errors path="height" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="" class="col-md-4 control-label">Weight</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="weight" id="weight" name="weight" placeholder=""
                                        class="form-control" type="text"/>
                        </div>
                        <form:errors path="weight" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="" class="col-md-4 control-label">NRIC No.</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="nricNo" id="nricNo" name="nricNo" placeholder="xxxxxx-xx-xxxx"
                                        class="form-control" type="text"/>
                        </div>
                        <form:errors path="nricNo" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="" class="col-md-4 control-label">Body No.</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="bodyNo" id="bodyNo" name="bodyNo" placeholder=""
                                        class="form-control" type="text"/>
                        </div>
                        <form:errors path="bodyNo" cssClass="error small"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="" class="col-md-4 control-label">Turn No.</form:label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <form:input path="turnNo" id="turnNo" name="turnNo" placeholder=""
                                        class="form-control" type="text"/>
                        </div>
                        <form:errors path="turnNo" cssClass="error small"/>
                    </div>
                </div>
                <hr>
                <div class="form-group">
                    <form:button type="submit" class="btn btn-login ml-2">Submit</form:button>
                </div>
            </fieldset>
        </form:form>
        <%--</td>--%>
        <%--</tr>--%>
        <%--</tbody>--%>
        <%--</table>--%>
    </div>
</body>
</html>
