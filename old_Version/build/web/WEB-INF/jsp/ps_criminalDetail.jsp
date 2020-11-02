<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
                <h1>Criminal Information</h1><br>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Father</th>
                        <th>Contact</th>
                        <th>Address</th>
                        <th>District</th>
                        <th>Division</th>
                    </tr>

                    <tr>
                        <td>${criminal.id}</td>
                        <td>${criminal.name}</td>
                        <td>${criminal.father}</td>
                        <td>${criminal.contact}</td>
                        <td>${criminal.address}</td>
                        <td>${criminal.district}</td>
                        <td>${criminal.division}</td>

                    </tr>

                </table>

                <table class="table">

                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach items="${docs}" var="u">
                        <tr>
                            <td>${u.name}</td>
                            <td>${u.type}</td>
                            <td>
                                <a href="${u.path}">Download</a>
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
