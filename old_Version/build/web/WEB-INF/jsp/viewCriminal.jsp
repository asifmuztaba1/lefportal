<%@ include file = "head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>

        <div class="row">
            <div class="mainview" >
                        <h1 style="text-align: center">Matching Criminals</h1>
                                        <table class="table">
                    <tr>
                        
                        <th>Name</th>
                        <th>Father</th>
                        <th>Contact</th>
                        <th>Address</th>
                        <th>District</th>
                        <th>Division</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${criminal_list}" var="u">
                        <tr>
                            
                            <td>${u.name}</td>
                            <td>${u.father}</td>
                            <td>${u.contact}</td>
                            <td>${u.address}</td>
                            <td>${u.district}</td>
                            <td>${u.division}</td>
                            <td>
                                <a href="criminalDetails?id=${u.id}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="View Detail"/></a>
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
