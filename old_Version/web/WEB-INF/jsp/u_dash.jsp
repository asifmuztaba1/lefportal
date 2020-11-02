<%@ include file = "u_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="u_header.jsp" %>

        <div class="row">
            <div class="mainview" >

                <br>
                <h1>Criminals in <%= user.getDistrict()%></h1><br>
                <table class="table">
                    <tr>
                        
                        <th>Name</th>
                        <th>Father</th>
                        <th>Address</th>
                        <th>District</th>
                        <th>Division</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${criminal}" var="u">
                        <tr>
                            <td>${u.name}</td>
                            <td>${u.father}</td>
                            <td>${u.address}</td>
                            <td>${u.district}</td>
                            <td>${u.division}</td>
                            <td>
                            <a href="u_criminalcase?criminalId=${u.id}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="Provide info"/></a>
                            
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
