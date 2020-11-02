<%@include file="ahq_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ahq_header.jsp" %>


        <div class="row">
            <%@include file="ahq_mainmenu.jsp" %>

        </div>


        <div class="row">
            <div class="mainview" >
                <div class="col-md-2">
                    
                </div>
                <div class="col-md-8">
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Police Station</th>
                        <th>District</th>
                        <th>Division</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${list}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.psName}</td>
                            <td>${u.district}</td>
                            <td>${u.division}</td>
                            <td>
                                <a href="view_edit?id=${u.id}"><input class="btn btn-success" type="submit"  value="Update"/></a>
                                <a href="delete?id=${u.id}" onclick="return confirm('Are you sure?')"><input class="btn btn-success" type="submit"  value="Remove"/></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                </div>
                
                <div class="col-md-2"></div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
