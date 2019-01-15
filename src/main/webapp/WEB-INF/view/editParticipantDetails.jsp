<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>National Physical Fitness Test System</title>

    <!-- Bootstrap core CSS -->
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>


<!-- Page Content -->
<div class="container" style="margin-top: 50px">
    <div class="innerContent" id="curvebackgroundPop">
        <h1 class="mt-2">Participant Details</h1>
        <hr>

        <form:form action="" modelAttribute="participant" method="post">
            <div class="form-group row">
                <form:input path="id" type="hidden" id="id" name="id" value="${participant.id}" />
                <label class="col-sm-12 col-form-label">Full Name :</label>
                <form:input path="name" type="text" id="fullname" name="fullname" value="${participant.name}" />
                <label class="col-sm-12 col-form-label">NRIC No :</label>
                <form:input path="nricNo" type="text" id="nricno" name="nricno" value="${participant.nricNo}" />
                <label class="col-sm-12 col-form-label">Age :</label>
                <form:input path="age" type="text" id="age" name="age" value="${participant.age}" />
                <label class="col-sm-12 col-form-label">Gender :</label>
                <form:input path="gender" type="text" id="gender" name="gender" value="${participant.gender}" />

            </div>
            <div class="form-group row">
                <label class="col-sm-12 col-form-label">Height (cm) :</label>
                <form:input path="height" type="text" id="height" name="height" value="${participant.height}" />
                <label class="col-sm-12 col-form-label">Weight (kg) :</label>
                <form:input path="weight" type="text" id="weight" name="weight" value="${participant.weight}" />
                <label class="col-sm-12 col-form-label">Body No. :</label>
                <form:input path="bodyNo" type="text" id="bodyNo" name="bodyNo" value="${participant.bodyNo}" />
                <label class="col-sm-12 col-form-label">Turn No. :</label>
                <form:input path="turnNo" type="text" id="turnNo" name="turnNo" value="${participant.turnNo}" />
            </div>
        </form:form>
        <hr>

        <div class="row">
            <div class="col-sm-12">
                <form>
                    <table class="table table-bordered table-striped">
                        <tr>
                            <td colspan="4">Body Mass Index (BMI) Test</td>
                        </tr>
                        <tr>
                            <td>Mark</td>
                            <td><input type="text" id="bmiMarkah" name="bmiMarkah" value="${testResultBmi.mark}"
                                       readonly/>
                            </td>
                            <td>Score</td>
                            <td><input type="text" id="bmiSkor" name="bmiSkor" value="${testResultBmi.score}"
                                       readonly/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <form>
                    <table class="table table-bordered table-striped">
                        <tr>
                            <td colspan="4">Hand Grip Test</td>
                        </tr>
                        <tr>
                            <td>Mark</td>
                            <td><input type="text" id="genggamanTMarkah" name="genggamanTMarkah"
                                       value="${testResultGenggaman.mark}" readonly/>
                            </td>
                            <td>Score</td>
                            <td><input type="text" id="genggamanTSkor" name="genggamanTSkor"
                                       value="${testResultGenggaman.score}" readonly/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <form>
                    <table class="table table-bordered table-striped">
                        <tr>
                            <td colspan="4">Sit and Reach Test</td>
                        </tr>
                        <tr>
                            <td>Mark</td>
                            <td><input type="text" id="dudukJMarkah" name="dudukJMarkah"
                                       value="${testResultDudukJ.mark}" readonly/>
                            </td>
                            <td>Score</td>
                            <td><input type="text" id="dudukJSkor" name="dudukJSkor" value="${testResultDudukJ.score}"
                                       readonly/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <form>
                    <table class="table table-bordered table-striped">
                        <tr>
                            <td colspan="4">Curl-up Test</td>
                        </tr>
                        <tr>
                            <td>Mark</td>
                            <td><input type="text" id="bangunTMarkah" name="bangunTMarkah"
                                       value="${testResultBangunT.mark}" readonly/>
                            </td>
                            <td>Score</td>
                            <td><input type="text" id="bangunTSkor" name="bangunTSkor"
                                       value="${testResultBangunT.score}" readonly/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <form>
                    <table class="table table-bordered table-striped">
                        <tr>
                            <td colspan="4">Bleep Test</td>
                        </tr>
                        <tr>
                            <td>Mark</td>
                            <td><input type="text" id="bleepTMarkah" name="bleepTMarkah"
                                       value="${testResultBleepT.mark}" readonly/>
                            </td>
                            <td>Score</td>
                            <td><input type="text" id="bleepTSkor" name="bleepTSkor" value="${testResultBleepT.score}"
                                       readonly/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-12">
                <table>
                    <tr>
                        <td>Total Score</td>
                        <td>: ${totalMark}</td>
                    </tr>
                    <tr>
                        <td>Award Type</td>
                        <td>: ${awardType}</td>
                    </tr>
                </table>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-12">
                <button class="btn btn-info float-right" onclick="window.close()">Close</button>
            </div>
        </div>
    </div>

    <!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>

</body>

</html>