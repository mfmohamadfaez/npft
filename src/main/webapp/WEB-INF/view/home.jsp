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

    <title>NPFT @ Award System</title>

    <!-- Bootstrap core CSS -->
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css" />--%>
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>">

    <!-- Custom styles for this template -->
    <%--<link href="/resources/css/logo-nav.css" rel="stylesheet">--%>
    <%--<link rel="stylesheet" href="/resources/css/style.css" />--%>
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

    function print() {


    }
</script>

<!-- Navigation -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">
        <%--<img src="/resources/images/NPFTWORD.png" width="150" height="30" alt="NPFT">--%>
        NPFT @ Award System
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
            aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/NPFT/processLoginForm">Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/NPFT/participantForm">Add Participant</a>
                </a>
            </li>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">Services</a>--%>
            <%--</li>--%>
            <li class="nav-item">
                <a class="nav-link" href="/NPFT/">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<!-- Page Content -->
<div class="container" style="margin-top: 50px">
    <div class="innerContent" id="curvebackgroundPop">
        <h1 class="mt-2">Participant List</h1>
        <hr/>
        <button class="btn btn-info btn-sm float-right mx-2 mb-2" onclick="window.open('../NPFT/printParticipant', '_blank')">Print</button>
        <table class="table table-dark table-striped table-bordered table-hover table-sm" id="npftParticipantsTable">
            <thead>
            <tr>
                <th scope="col">#</th>
                <%--<th scope="col" rowspan="2">No. Badan</th>--%>
                <%--<th scope="col" rowspan="2">Catatan</th>--%>
                <th scope="col">Full Name</th>
                <%--<th scope="col" rowspan="2">Angka Giliran</th>--%>
                <th scope="col">NRIC No.</th>
                <%--<th scope="col" rowspan="2">Umur</th>--%>
                <%--<th scope="col" rowspan="2">Jantina</th>--%>
                <%--<th scope="col" >Tinggi</th>--%>
                <%--<th scope="col" >Berat</th>--%>
                <%--<th scope="col" colspan="2">BMI</th>--%>
                <%--<th scope="col" colspan="2">Genggaman Tangan</th>--%>
                <%--<th scope="col" colspan="2">Duduk Jangkau</th>--%>
                <%--<th scope="col" colspan="2">Bangun Tubi</th>--%>
                <%--<th scope="col" colspan="2">Bleep Test</th>--%>
                <%--<th scope="col" colspan="2">Berjalan 6 Minit</th>--%>
                <%--<th scope="col" rowspan="2">Jumlah</th>--%>
                <th scope="col">Award</th>
                <th>Action</th>
            </tr>
            <%--<tr>
                <th scope="col">CM</th>
                <th scope="col">KG</th>
                <th scope="col">Markah</th>
                <th scope="col">Skor</th>
                <th scope="col">Markah</th>
                <th scope="col">Skor</th>
                <th scope="col">Markah</th>
                <th scope="col">Skor</th>
                <th scope="col">Markah</th>
                <th scope="col">Skor</th>
                <th scope="col">Markah</th>
                <th scope="col">Skor</th>
                <th scope="col">Markah</th>
                <th scope="col">Skor</th>
            </tr>--%>
            </thead>
            <tbody>
            <%--<c:forEach items="${participantList}" var="participant" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${participant.name}</td>
                    <td>${participant.nricNo}</td>
                    <td>{ANUGERAH}</td>
                    <td><a href="#" class="buttonRoundSmall" onclick="window.open('${pageContext.request.contextPath}/getParticipantDetails/${participant.id}', 'regWindow', 'toolbar=no, status=no, menubar=no, scrollbars=yes')">View</a></td>
                </tr>
            </c:forEach>--%>
            </tbody>
        </table>

        <!-- Modal -->
        <%--<div id="viewParticipantDtl" class="modal fade" role="dialog">--%>
        <%--<div class="modal-dialog modal-lg">--%>

        <%--<!-- Modal content-->--%>
        <%--<div class="modal-content">--%>
        <%--<div class="modal-header">--%>
        <%--<h4 class="modal-title">Participant Details</h4>--%>
        <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
        <%--</div>--%>
        <%--<div class="modal-body">--%>
        <%--<form action="">--%>
        <%--<div class="form-group row">--%>
        <%--<label  for="fullname" class="col-sm-5 col-form-label">Full Name : ${participantName}</label>--%>
        <%--<div class="input-group">--%>
        <%--<input  class="form-control-plaintext" type="text" id="fullname" name="fullname" value="" readonly/>--%>
        <%--</div>--%>
        <%--<label for="nricNo" class="col-sm-5 col-form-label">NRIC No.</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="nricNo" name="nricNo" value="" readonly/>--%>
        <%--</div>--%>
        <%--<label for="age" class="col-sm-5 col-form-label">Age</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="age" name="age" value="" readonly/>--%>
        <%--</div>--%>
        <%--<label for="gender" class="col-sm-5 col-form-label">Gender</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="gender" name="gender" value="" readonly/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group row">--%>
        <%--<label for="height" class="col-sm-5 col-form-label">Height (cm)</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="height" name="height" value="" readonly/>--%>
        <%--</div>--%>
        <%--<label for="weight" class="col-sm-5 col-form-label">Weight (kg)</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="weight" name="weight" value="" readonly/>--%>
        <%--</div>--%>
        <%--<label for="bodyNo" class="col-sm-5 col-form-label">Body No.</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="bodyNo" name="bodyNo" value="" readonly/>--%>
        <%--</div>--%>
        <%--<label for="turnNo" class="col-sm-5 col-form-label">Turn No.</label>--%>
        <%--<div class="input-group">--%>
        <%--<input class="form-control-plaintext" type="text" id="turnNo" name="turnNo" value="" readonly/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</form>--%>
        <%--<hr>--%>

        <%--<form>--%>
        <%--<table class="table">--%>
        <%--<tbody>--%>
        <%--<tr>--%>
        <%--<td colspan="2">BMI</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>Markah</td>--%>
        <%--<td><input type="text" id="bmiMarkah" name="bmiMarkah" value="" readonly/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<td>Skor</td>--%>
        <%--<td><input type="text" id="bmiSkor" name="bmiSkor" value="" readonly/></td>--%>
        <%--</tr>--%>
        <%--</tbody>--%>
        <%--</table>--%>
        <%--</form>--%>
        <%--</div>--%>
        <%--<div class="modal-footer">--%>
        <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
<!-- /.container -->

<!-- Bootstrap core JavaScript -->
<script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">

    var table;
    var dataObject = null;

    $(document).ready(function () {

        var tableElement = $('#npftParticipantsTable');

        table = tableElement.dataTable({
            "autoWidth": false,
            "bFilter": false,
            "bPaginate": false,
            "bInfo": false,
            "bSort": false,
            "serverSide": true,
            "processing": false,
            "ajax": '${pageContext.request.contextPath}/getParticipantDataTable',
        });

        <%--$.ajax({--%>
        <%--type: 'GET',--%>
        <%--url: '${pageContext.request.contextPath}/getParticipantDataTable',--%>
        <%--contentType: "application/x-www-form-urlencoded",--%>
        <%--dataType: 'json',--%>
        <%--success: function (result) {--%>
        <%--alert(result[0].toString());--%>
        <%--// $.each(result, function(idx, elem){--%>
        <%--//     table.append("<tr><td>"+result.username+"</td><td>"+elem.name+"</td>   <td>"+elem.lastname+"</td></tr>");--%>
        <%--// });--%>
        <%--},--%>
        <%--});--%>


    });


</script>


</body>

</html>