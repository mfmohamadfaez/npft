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

    <script type="text/javascript">

        function deleteParticipant(pid) {
            var pId = pid;
            var r = confirm("Are you sure to delete this?");
            if (r){
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/deleteParticipantDetails/' + pId,
                    data: JSON.stringify(pId),
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    success: function (result) {
                        console.log("SUCCESS: ", result);
                        alert("Participant succesfully deleted.")
                        refreshTableGet(table, '${pageContext.request.contextPath}/getParticipantDataTable');

                        /*
                        if ($.trim(result) == "true") {
                            bootbox.alert("DELETED");
                            refreshTableGet(table, '../../../getParticipantDataTable');
                        } else {
                            bootbox.alert("An error occurred.");
                        }*/

                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        alert("An error occurred.")
                    }
                });
                alert(r + " " + pId);
            }
            else {
                alert(r)
            }
        }


    </script>

</head>

<body>


<!-- Navigation -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">
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
                <th scope="col">Full Name</th>
                <th scope="col">NRIC No.</th>
                <th scope="col">Award</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
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
    });

    function refreshTableGet(ptable,purl){
        ptable.fnClearTable();
        $.ajax({
            url: purl,
            type: "GET",
            contentType: 'application/x-www-form-urlencoded',
            success: function (result) {
                if(result!=""){
                    jsonResult = JSON.parse(result);
                    if(jsonResult.aaData!=""){
                        ptable.fnAddData(jsonResult.aaData);
                    }
                }
            }
        });
    }

</script>


</body>

</html>