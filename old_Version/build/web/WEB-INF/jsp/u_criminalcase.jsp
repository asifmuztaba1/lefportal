<%@ include file = "u_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="u_header.jsp" %>

        <div class="row">
            <div class="mainview" >

                <br>
                
                <table class="table">
                    <br>
                    <h1 style="text-align: center">Case Details</h1>
                    <br>
                    
                    <tr>
                        
                        <th>Case Name</th>
                        <th>Type</th>
                        <th>Crime Date</th>
                        <th>Victim</th>
                        <th>District</th>
                        <th>Police Station</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${caseDetail}" var="u">
                        <tr>
                            <td>${u.caseName}</td>
                            <td>${u.type}</td>
                            <td>${u.crimeDate}</td>
                            <td>${u.victim}</td>
                            <td>${u.district}</td>
                             <td>${u.policeStation}</td>
                            <td>
                            <a href="u_provideinfo?criminalId=${criminalId}&ps=${u.policeStation}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="Provide info"/></a>
                            
                        </td>
                        </tr>
                    </c:forEach>
                </table>


                <br>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
