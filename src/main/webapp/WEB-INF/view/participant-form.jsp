<%--
  Created by IntelliJ IDEA.
  User: mfmohamadfaez
  Date: 29/11/2018
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css" />
    <title>Participant Form</title>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tbody>
        <tr>
            <td colspan="1">
                <form:form class="well form-horizontal" action="/processParticipantForm" modelAttribute="participant" method="post">
                    <fieldset>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="">Full Name</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="name" id="fullName" name="fullName" placeholder="Full Name" class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="">Age</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="age" id="age" name="age" placeholder="age" class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Gender</label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon" style="max-width: 100%;"><i class="glyphicon glyphicon-list"></i></span>
                                    <form:select path="gender" class="selectpicker form-control">
                                        <form:option value="-" label="--Please Select--"/>
                                        <form:option value="M" label="Male"/>
                                        <form:option value="F" label="Female"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" class="col-md-4 control-label">Height</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="height" id="height" name="height" placeholder="Height" class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" class="col-md-4 control-label">Weight</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="weight" id="weight" name="weight" placeholder="Weight" class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" class="col-md-4 control-label">NRIC No.</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="nricNo" id="nricNo" name="nricNo" placeholder="NRIC No." class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" class="col-md-4 control-label">Body No.</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="bodyNo" id="bodyNo" name="bodyNo" placeholder="Body No." class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" class="col-md-4 control-label">Turn No.</form:label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><form:input path="turnNo" id="turnNo" name="turnNo" placeholder="Turn No." class="form-control" required="true" value="" type="text"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:button type="submit" class="btn btn-login float-right">Submit</form:button>
                        </div>
                    </fieldset>
                </form:form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
