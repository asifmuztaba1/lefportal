<%@ include file = "head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>

        <div class="row">
            <div class="mainview" >
                        <h1 style="text-align: center">Criminal Details</h1>
                        <br>
                                    <table class="table">
                    <tr>
                        
                        <th>Name</th>
                        <th>Father</th>
                        <th>Contact</th>
                        <th>Address</th>
                        <th>District</th>
                        <th>Division</th>
                    </tr>
                   
                        <tr>
                            
                            <td>${criminal.name}</td>
                            <td>${criminal.father}</td>
                            <td>${criminal.contact}</td>
                            <td>${criminal.address}</td>
                            <td>${criminal.district}</td>
                            <td>${criminal.division}</td>

                        </tr>
                  
                </table>
                            
                            <h1 style="text-align: center">Case Details</h1>
                            <table class="table">
                    <tr>
                        <th>Case ID</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach items="${list}" var="u">
                        <tr>
                            
                            <td>${u.caseId}</td>
                            <td>${u.status}</td>

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
