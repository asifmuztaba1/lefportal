<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<div class="col-md-12" style="margin:0px">
                        <div class="panel panel-default" style="">
                            <div class="panel-body" style="background-color: #ccccff;margin-top: 10px;margin-bottom: 10px">
                                <table class="table table-hover" style="">
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


                                        <tr style="font-size: 12px;color: #006666">
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
