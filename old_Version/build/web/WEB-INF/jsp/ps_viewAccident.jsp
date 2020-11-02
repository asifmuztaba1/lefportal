<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
                <h1>Case Information</h1><br>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Case Name</th>
                        <th>Case Type</th>
                        <th>Crime Date</th>
                        <th>Case Date</th>
                        <th>Victim</th>
                        <th>Victim Age</th>
                        <th>Police Station</th>
                        <th>District</th>
                        <th>Division</th>
                        <th>Officer</th>
                        <th>Action</th>
                    </tr>
                        <c:forEach items="${case_info}" var="u">
                    <tr>
                        
                        <td>${u.id}</td>
                        <td>${u.caseName}</td>
                        <td>${u.type}</td>
                        <td>${u.crimeDate}</td>
                        <td>${u.caseDate}</td>
                        <td>${u.victim}</td>
                        <td>${u.victimAge}</td>
                        <td>${u.policeStation}
                        <td>${u.district}</td>
                        <td>${u.division}</td>
                        <td>${u.officer}</td>

                        <td>
                            <a href="ps_casedoc?id=${u.id}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="View Detail"/></a>

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
