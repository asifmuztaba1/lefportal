<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
                <br>
                <h1 style="text-align: center">Assistance Requests</h1>
                <table class="table" style="padding-bottom:50px;">
                    <tr>
                        <th>ID</th>
                        <th>Case ID</th>
                        <th>Message</th>
                        <th>From</th>
                        <th>Date</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${list}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.caseId}</td>
                            <td><textarea class="form-control" id="focusedInput" type="text" name="message" style="height: 130px;width: 400px" textarea>
                                
                                    ${u.message}</textarea></td>
                            <td>${u.generator}</td>
                            <td>${u.createDate}</td>
                            <td>
                                <a href="ps_viewCase?id=${u.caseId}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="View Detail"/></a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <hr size="30" style='border-width:5px;border-bottom-style:dotted;color: #449D44 '>
                <br>
                <h1 style="text-align: center">Citizens Provided Informations</h1>
                <br>
                <table class="table">
                    <tr>
                        <th>Criminal ID</th>
                        <th>Information</th>
                        <th>Post Date</th>
                        <th>Citizen ID</th>

                    </tr>
                    <c:forEach items="${comments}" var="u">
                        <tr>
                            <td>${u.criminalId}</td>
                            <td><textarea class="form-control" id="focusedInput" type="text" name="message" style="height: 130px;width: 400px" textarea>${u.text}</textarea></td>
                            <td>${u.postDate}</td>
                            <td>${u.userId}</td>
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
