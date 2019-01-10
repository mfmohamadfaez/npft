<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript">

    function viewParticipantDetails(id) {
        $.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath}/getParticipantById/' + id,
            contentType: "application/x-www-form-urlencoded",
            dataType: 'json',
            success: function (result) {

                alert(result);
                // $('#fullname').val(result.name);
                // $('#age').val(result.age);
                // $('#gender').val(result.gender);
                // $('#height').val(result.height);
                // $('#weight').val(result.weight);
                // $('#nricNo').val(result.nricNo);
                // $('#turnNo').val(result.turnNo);
                // $('#bodyNo').val(result.bodyNo);
            },
        });


    }
</script>

<!-- Page Content -->
<div class="container" style="margin-top: 50px">
    <div class="innerContent" id="curvebackgroundPop">
        <h1 class="mt-2">Participant Details</h1>
        <hr>

        <form action="">
            <div class="form-group row">
                <label class="col-sm-12 col-form-label">Full Name :</label>
                <label class="col-sm-12">${participantName}</label>
                <label class="col-sm-12 col-form-label">NRIC No :</label>
                <label class="col-sm-12">${participantNric}</label>
                <label class="col-sm-12 col-form-label">Age :</label>
                <label class="col-sm-12">${participantAge}</label>
                <label class="col-sm-12 col-form-label">Gender :</label>
                <label class="col-sm-12 ">${participantGender}</label>
            </div>
            <div class="form-group row">
                <label class="col-sm-12 col-form-label">Height (cm) :</label>
                <label class="col-sm-12">${participantHeight}</label>
                <label class="col-sm-12 col-form-label">Weight (kg) :</label>
                <label class="col-sm-12 ">${participantWeight}</label>
                <label class="col-sm-12 col-form-label">Body No. :</label>
                <label class="col-sm-12 ">${participantBodyNo}</label>
                <label class="col-sm-12 col-form-label">Turn No. :</label>
                <label class="col-sm-12 ">${participantTurnNo}</label>
            </div>
        </form>
        <hr>

        <div class="row">
            <div class="col-sm-12">
                <form>
                    <%--<div class="card">--%>
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
                    <%--</div>--%>
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
    <%--<script src="/webjars/jquery/3.0.0/jquery.min.js"></script>--%>
    <%--<script src="/webjars/bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>--%>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>

</body>

</html>