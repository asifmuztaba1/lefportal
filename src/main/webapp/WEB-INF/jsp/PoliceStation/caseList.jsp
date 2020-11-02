<%@include file="head.jsp" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>


        <div class="row">
            <%@include file="mainmenu.jsp" %>

        </div>
        <script>
            $(document).ready(function () {
                $("#caseTable").dataTable();

            });
        </script>

        <div class="row">
            <div class="mainview" >
                <br>
                <div class="panel panel-default">
                    <div class="panel-body" style="color: #122B40;background-color: #F0F0F0;">
                        <div class="row" style="background-color: #cccccc">
                            <div class="col-md-2"><h4 style="float: right">Case List of </h4></div>
                            <div class="col-md-2"><h4 style="color: #ff6666;float: left">${sDate}</h4></h4></div>
                            <div class="col-md-3"></div>
                            <div class="col-md-2"><h4 style="float: right"></h4> </div>
                            <div class="col-md-2">
                                <form action="caseList" method="POST">
                                    <input type="Date" name="searchDate" class="form-control" style="width: 180px;float: left" autofocus required>

                                    </div>
                                    <div class="col-md-1">
                                        <input type="submit" value="View" class="btn btn-info" class="form-control" style="width: 100px;float: left">
                                        </form>
                                    </div>

                            </div>
                            <hr style="display: block;border-top: 1px solid #449D44;height: 1px;">
                            <div class="row"><br>
                                <table class="table table-hover" id="caseTable">
                                    <thead>
                                        <tr>
                                            <th>Case ID</th>
                                            <th>Crime Date</th>
                                            <th>Case File Date</th>
                                            <th>Case Type</th>
                                            <th>Victim Age</th>
                                            <th>Victim Name</th>
                                            <th>Crime Loc</th>
                                            <th>Invest. Ofcr</th>
                                            <th>Action</th>
                                        </tr>

                                    </thead>

                                    <c:forEach items="${caseList}" var="c">
                                        <tr style="font-size: 12px;color: #006666;">
                                            <td>${c.caseId}</td>
                                            <td>${c.crimeDate}</td>
                                            <td>${c.caseFileDate}</td>
                                            <td>${c.caseType}</td>
                                            <td>${c.victimAge}</td>
                                            <td>${c.victimName}</td>
                                            <td>${c.crimeLocation}</td>
                                            <td>${c.investigatingOfficer}</td>
                                            <td>
                                                <a href="CaseManagement?caseId=${c.caseId}"><button class="btn bg-primary">Manage</button></a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>


                </div>
            </div>

            <%@include file="footer.jsp" %>
        </div>    

</body>




</html>
