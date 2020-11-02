<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
                <h1 style="text-align: center">Case Information</h1><br>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Case Name</th>
                        <th>Case Type</th>
                        <th>Crime Date</th>
                        <th>Case Date</th>
                        <th>Victim</th>
                        <th>Victim Age</th>
                        <th>District</th>
                        <th>Division</th>
                        <th>Officer</th>

                    </tr>

                    <tr>
                        <td>${case_info.id}</td>
                        <td>${case_info.caseName}</td>
                        <td>${case_info.type}</td>
                        <td>${case_info.crimeDate}</td>
                        <td>${case_info.caseDate}</td>
                        <td>${case_info.victim}</td>
                        <td>${case_info.victimAge}</td>
                        <td>${case_info.district}</td>
                        <td>${case_info.division}</td>
                        <td>${case_info.officer}</td>


                    </tr>

                </table>
                        <h1 style="text-align: center">Case Documents</h1><br>
                <table class="table">

                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach items="${list_caseDoc}" var="u">
                        <tr>
                            <td>${u.name}</td>
                            <td>${u.type}</td>
                            <td>
                                <a href="${u.path}">Download</a>
                            </td>
                        </tr>
                    </c:forEach>       
                </table>

                <h1 style="text-align: center">Criminal Information</h1>
                <table class="table">
                    <tr>

                        <th>Case ID</th>
                        <th>Criminal ID</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${criminal_list}" var="u">
                        <tr>
                            <td>${u.caseId}</td>
                            <td>${u.criminalId}</td>
                            <td>
                                <a href="ps_criminalDetail?id=${u.criminalId}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="View Detail"/></a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>


            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
