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
                    <c:forEach items="${criminal_info}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.name}</td>
                            <td>${u.father}</td>
                            <td>${u.contact}</td>
                            <td>${u.address}</td>
                            <td>${u.district}</td>
                            <td>${u.division}</td>

                        </tr>
                    </c:forEach>
                </table>
                <table class="table">

                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Action</th>
                    </tr>
                    <tr>
                        <td>${docs.name}</td>
                        <td>${docs.type}</td>
                        <td>
                            <a href="${docs.path}">Download</a>
                        </td>
                    </tr>

                </table>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
