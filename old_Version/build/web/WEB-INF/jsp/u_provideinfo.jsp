<%@ include file = "u_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="u_header.jsp" %>

        <div class="row">
            <div class="mainview" >

                <br>
                <form class="form-horizontal" modelAttribute="Comments"  role="form" action="provideinfo" method="POST">
                    <input class="form-control" id="focusedInput" type="hidden" name="userId" value="<%= user.getId() %>"  required >
                    <input class="form-control" id="focusedInput" type="hidden" name="criminalId" value="${criminalId}"  required>
                    <input class="form-control" id="focusedInput" type="text" name="policeStation" value="${policeStation}" readonly required >
                    <textarea class="form-control" id="focusedInput" type="text" name="text" style="height: 230px;width: 700px;margin-left: 150px" ></textarea><br>
                    <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" value="Sibmit"/>
                </form>
                <br>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
