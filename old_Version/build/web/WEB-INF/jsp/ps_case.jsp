
<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
                <form class="form-inline"  role="form" action="ps_documents" method="POST">
                    <input class="form-control" id="focusedInput" type="hidden" name="district" value= <%= user.getDistrict() %>>
                    <input style="width: 200px;" class="form-control" id="focusedInput" type="date" name="caseDate" required >
                    <input style="width: 200px;margin-left: 30px" class="btn btn-success" type="submit" value="Search by Date"/>
                </form><br>
                <form class="form-inline"  role="form" action="ps_documentID" method="POST">
                    <input class="form-control" id="focusedInput" type="hidden" name="district" value= <%= user.getDistrict() %>>
                    <input style="width: 200px;"class="form-control" id="focusedInput" type="number" name="id" required >
                    <input style="width: 200px;margin-left: 30px" class="btn btn-success" type="submit" value="Search by ID"/>
                </form><br><br>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Case Name</th>
                        <th>Case Date</th>
                        <th>Victim</th>
                        <th>Officer</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${list}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.caseName}</td>
                            <td>${u.caseDate}</td>
                            <td>${u.victim}</td>
                            <td>${u.officer}</td>
                            <td>
                                <a href="ps_upDocuments?id=${u.id}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="New Upload"/></a>
                                <a href="ps_editDocuments?id=${u.id}" onclick="return confirm('Are you sure?')"><input class="btn btn-success" type="submit"  value="Edit"/></a>
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
