<%@include file="head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>


        <div class="row">
            <%@include file="mainmenu.jsp" %>

        </div>
        <script>
            $(document).ready(function () {

                setTimeout(function () {
                    $("#msg").slideUp(1000);
                }, 10000);

                $("#viewTable").dataTable();
                
            });
        </script>

        <div class="row">
            <div class="mainview" >
                <h3 style="text-align: center;color: #67b168">POLICE STATION LIST</h3>
                <p id="msg" style="color: #e38d13;text-align: center">${sucsMsg}</p><br>
                
                <div class="col-md-12" style="margin:0px">
                    <div class="panel panel-default" style="">
                        <div class="panel-body" style="min-height: 400px">
                            <table class="table table-hover" id="viewTable">
                                <thead style="color: #a94442">
                                    <tr>
                                        <th>#</th>
                                        <th>PS NAME</th>
                                        <th>DISTRICT</th>
                                        <th>DIVISION</th>
                                        <th>ROLE</th>
                                        <th style="width: 160px">ACTION</th>
                                    </tr>
                                </thead>
                                <%
                                    int i = 1;
                                %>
                                <c:forEach items="${psList}" var="ps">


                                    <tr style="font-size: 12px;color: #006666;">
                                        <td><%= i++%></td>
                                        <td>${ps.psName}</td>
                                        <td>${ps.district}</td>
                                        <td>${ps.division}</td>
                                        <td>${ps.role}</td>
                                        <td>
                                            <a href="psEdit?id=${ps.id}"><button class="btn btn-info" style="height: 28px;width: 70px">Edit</button></a> 
                                            <a href="psDelete?id=${ps.id}"><button class="btn btn-danger" style="height: 28px;width: 70px" onclick="return confirm('Are you sure?\nYou want to delete this item?');">Delete</button></a>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>


                    </div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    

</body>




</html>
