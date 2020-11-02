<%@include file="head.jsp" %>

<body>
    <div class="container-fluid">

        <%@include file="header.jsp" %>

        <div class="row">
            <%@include file="mainmenu.jsp" %>

        </div>

        <script>



            $(document).ready(function () {
                $("#fileForm").submit(function () {
                    uploadFile();
                    return false;


                });
                function _(el) {
                    return document.getElementById(el);
                }

                function uploadFile() {
                    var file = _("file1").files[0];
// alert(file.name+" | "+file.size+" | "+file.type);
                    var fileName = $("#fileName").val();
                    var criminalId = $("#criminalId").val();
                    var fileType = $("#fileType").val();

                    var formdata = new FormData();
                    formdata.append("file1", file);
                    formdata.append("fileName", fileName);
                    formdata.append("criminalId", criminalId);
                    formdata.append("fileType", fileType);


                    var ajax = new XMLHttpRequest();
                    ajax.upload.addEventListener("progress", progressHandler, false);
                    ajax.addEventListener("load", completeHandler, false);
                    ajax.addEventListener("error", errorHandler, false);
                    ajax.addEventListener("abort", abortHandler, false);
                    ajax.open("POST", "uploadCriminalFile");
                    ajax.send(formdata);


                }

                function progressHandler(event) {
                    _("loaded_n_total").innerHTML = "Uploaded " + event.loaded + " bytes of " + event.total;
                    var percent = (event.loaded / event.total) * 100;
                    _("progressBar").value = Math.round(percent);
                    _("status").innerHTML = Math.round(percent) + "% Uploaded... Please wait";
                }

                function completeHandler(event) {
                    _("status").innerHTML = event.target.responseText;
                    _("progressBar").value = 0; //wil clear progress bar after successful upload

                    location.reload();

                }

                function errorHandler(event) {
                    _("status").innerHTML = "Upload Failed";
                }

                function abortHandler(event) {
                    _("status").innerHTML = "Upload Aborted";
                }


                $("#formCriminal").submit(function () {

                    var caseID = $("#caseId").val();
                    var criminalName = $("#criminalName").val();
                    var criminalFather = $("#criminalFather").val();
                    var criminalBirth = $("#criminalBirth").val();
                    var address = $("#address").val();
                    var district = $("#district").val();
                    var division = $("#division").val();
                    var policeStation = $("#policeStation").val();

                    $.ajax({
                        type: "POST",
                        url: "addCriminal",
                        data: {
                            caseID: caseID,
                            criminalName: criminalName,
                            criminalFather: criminalFather,
                            criminalBirth: criminalBirth,
                            address: address,
                            district: district,
                            division: division,
                            policeStation: policeStation
                        },

                        success: function (data, textStatus, jqXHR) {
                            var res = data.toString();
                            $("#responseMsg").val(res);
                            location.reload();
                        }

                    });
                    return false;
                });
            });
        </script>

        <!-- Modal Document-->
        <div class="modal fade" id="addFileModel" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" style="color: #337ab7;text-align: center">Add Case File </h4>
                    </div>
                    <div class="modal-body" style="color: #122B40">
                        <form class="form-horizontal" id="fileForm" action="#" enctype="multipart/form-data" method="POST">
                            <input type="hidden" value="${criminal.criminalId}" name="criminalId" id="criminalId">
                            <label class="col-md-3 control-label">File Name : </label>
                            <input type="text" class="form-control" style="width: 350px" name="fileName" id="fileName" required>
                            <br>

                            <label class="col-md-3 control-label">Choose File : </label>
                            <input class="form-control" style="width: 350px" type="file" name="file1" id="file1"  required> 
                            <br>

                            <label class="col-md-3 control-label">File Type :  </label>
                            <select class="form-control" name="fileType" id="fileType" style="width: 350px" required>
                                <option value="">Select</option>
                                <option value="Image">Image</option>
                                <option value="Documents">Documents</option>
                            </select>
                            <br>

                            <label class="col-md-3 control-label"> </label>
                            <input type="submit" class="btn btn-info"  value="ADD">
                        </form>

                        <br>
                        <progress  id="progressBar" value="0" max="100" style="width: 563px"></progress>
                        <h3 id="status" style="color: #337ab7;text-align: center"></h3>
                        <p id="loaded_n_total"style="color: #337ab7;text-align: center"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>







        <!-- Modal Criminal-->
        <div class="modal fade" id="addCriminalModel" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" style="color: #337ab7;text-align: center">Add Criminal </h4>
                    </div>
                    <div class="modal-body" style="color: #122B40">
                        <form class="form-horizontal" action="#" id="formCriminal" method="POST" >
                            <input type="hidden" value="${caseObj.caseId}" name="caseId" id="caseId">

                            <label class="col-md-3 control-label">Criminal Name : </label>
                            <input type="text" class="form-control" style="width: 350px" name="criminalName" id="criminalName" required>
                            <br>

                            <label class="col-md-3 control-label">Father Name : </label>
                            <input type="text" class="form-control" style="width: 350px" name="criminalFather" id="criminalFather" required>
                            <br>

                            <label class="col-md-3 control-label">Birth Date : </label>
                            <input type="date" class="form-control" style="width: 350px" name="criminalBirth" id="criminalBirth" required>
                            <br>

                            <label class="col-md-3 control-label">Address : </label>
                            <textarea type="date" class="form-control" style="width: 350px" name="address" id="address" required></textarea>
                            <br>

                            <label class="col-md-3 control-label">District</label>
                            <select style="width: 350px;" class="form-control" name="district" id="district" required >
                                <option value="">Select</option>
                                <option value="B.baria">B.baria</option>
                                <option value="Bagerhat">Bagerhat</option>
                                <option value="Bandarban">Bandarban</option>
                                <option value="Barguna">Barguna</option>
                                <option value="Barishal">Barishal</option>
                                <option value="Bhola">Bhola</option>
                                <option value="Bogura">Bogura</option>
                                <option value="C. nawabganj">C. nawabganj</option>
                                <option value="Chandpur">Chandpur</option>
                                <option value="Chattogram">Chattogram</option>
                                <option value="Chuadanga">Chuadanga</option>
                                <option value="Cumilla">Cumilla</option>
                                <option value="Cox's bazar">Cox's bazar</option>
                                <option value="Dhaka">Dhaka</option>
                                <option value="Dinajpur">Dinajpur</option>
                                <option value="Faridpur">Faridpur</option>
                                <option value="Feni">Feni</option>
                                <option value="Gaibandha">Gaibandha</option>
                                <option value="Gazipur">Gazipur</option>
                                <option value="Gopalganj">Gopalganj</option>
                                <option value="Habiganj">Habiganj</option>
                                <option value="Jamalpur">Jamalpur</option>
                                <option value="Jashore">Jashore</option>
                                <option value="Jhalokathi">Jhalokathi</option>
                                <option value="Jhenaidah">Jhenaidah</option>
                                <option value="Joypurhat">Joypurhat</option>
                                <option value="Khagrachari">Khagrachari</option>
                                <option value="Khulna">Khulna</option>
                                <option value="Kishoreganj">Kishoreganj</option>
                                <option value="Kurigram">Kurigram</option>
                                <option value="Kushtia">Kushtia</option>
                                <option value="Kushtia">Lalmonirhat</option>
                                <option value="Laxmipur">Laxmipur</option>
                                <option value="Madaripur">Madaripur</option>
                                <option value="Magura">Magura</option>
                                <option value="Manikganj">Manikganj</option>
                                <option value="Meherpur">Meherpur</option>
                                <option value="Moulvibazar">Moulvibazar</option>
                                <option value="Munshiganj">Munshiganj</option>
                                <option value="Mymensingh">Mymensingh</option>
                                <option value="Naogaon">Naogaon</option>
                                <option value="Narail">Narail</option>
                                <option value="Narayanganj">Narayanganj</option>
                                <option value="Narshingdi">Narshingdi</option>
                                <option value="Natore">Natore</option>
                                <option value="Netrokona">Netrokona</option>
                                <option value="Nilphamari">Nilphamari</option>
                                <option value="Noakhali">Noakhali</option>
                                <option value="Pabna">Pabna</option>
                                <option value="Panchagarh">Panchagarh</option>
                                <option value="Patuakhali">Patuakhali</option>
                                <option value="Perojpur">Perojpur</option>
                                <option value="Rajbari">Rajbari</option>
                                <option value="Rajshahi">Rajshahi</option>
                                <option value="Rangamati">Rangamati</option>
                                <option value="Rangpur">Rangpur</option>
                                <option value="Satkhira">Satkhira</option>
                                <option value="Sirajganj">Sirajganj</option>
                                <option value="Sirajganj">Shariatpur</option>
                                <option value="Sherpur">Sherpur</option>
                                <option value="Sunamganj">Sunamganj</option>
                                <option value="Sylhet">Sylhet</option>
                                <option value="Tangail">Tangail</option>
                                <option value="Thakurgaon">Thakurgaon</option>

                            </select><br>

                            <label class="col-md-3 control-label">Division</label>
                            <select class="form-control"  name="division" id="division" required style="width: 350px">
                                <option value="">Select</option>
                                <option value="Barishal">Barishal</option>
                                <option value="Chittagong">Chittagong</option>
                                <option value="Dhaka">Dhaka</option>
                                <option value="Mymensingh">Mymensingh</option>
                                <option value="Khulna">Khulna</option>
                                <option value="Rajshahi">Rajshahi</option>
                                <option value="Rangpur">Rangpur</option>

                            </select><br>
                            <input type="hidden" name="policeStation" id="policeStation" value="<%= user.getPsName()%>" required>
                            <label class="col-md-3 control-label"> </label>
                            <input type="submit" class="btn btn-info" id="submitCriminalBtn"  value="Add">
                        </form>

                        <br>
                        
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>




        <div class="row">
            <div class="mainview" >
                <h3 style="color: #122B40;text-align: center">Criminal Information <b style="color: #ff3333">${criminal.criminalName}</b></h3>
                <div class="panel panel-default">
                    <div class="panel-body" style="color: #122B40;background-color: #F0F0F0;display: flex;width: 100%;min-height: 400px">
                        <div class="col-md-4" style="border-right: 1px dashed #449D44;min-height:inherit;flex: 1;"> 

                            <h4 style="color: #337ab7" class="col-md-4 control-label">Summary </h4>

                            <br>
                            <hr style="display: block;border-top: 1px solid #449D44;height: 1px;">
                            
                            <label>Name : </label><p>${criminal.criminalName}</p>
                            <label>Father : </label><p>${criminal.criminalFather}</p>
                            <label>Birth date : </label><p>${criminal.criminalBirth}</p>
                            <label>Address : </label><p>${criminal.address}</p>
                            <label>District: </label><p>${criminal.district}</p>
                            <label>Division : </label><p>${criminal.division}</p>
                            <label>PS : </label><p>${criminal.policeStation}</p>
                            
                            
                            
                        </div>
                        <div class="col-md-4" style="border-right: 1px dashed #449D44;flex: 1;;min-height: inherit">
                            <h4 style="color: #337ab7" class="col-md-4 control-label">Files </h4>
                            <button class="btn btn-info" data-toggle="modal" data-target="#addFileModel"  class="form-horizontal" style="float: right">Add</button>
                            <br>

                            <hr style="display: block;border-top: 1px solid #449D44;height: 1px;">

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Type</th>
                                        <th style="width: 80px">Action</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${crimDocList}" var="cd">
                                    <tr>
                                        <td>${cd.fileName}</td>
                                        <td>${cd.fileType}</td>
                                        <td><a href="download?file=${cd.filePath}"><button class="btn bg-primary">Download</button></a></td>
                                    </tr>
                                </c:forEach>
                            </table>

                        </div>
                        <div class="col-md-4" style="min-height: inherit;flex: 1;">

                            <h4 style="color: #337ab7" class="col-md-3 control-label">Cases</h4>
                            <button class="btn btn-info" data-toggle="modal" data-target="#addCriminalModel"   class="form-horizontal" style="float: right">Add</button>

                            <br>

                            <hr style="display: block;border-top: 1px solid #449D44;height: 1px;">

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Case ID</th>
                                        <th>Status</th>
                                        <th style="width: 80px">Action</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${crimCaseList}" var="cc">
                                    <tr>
                                        <td>${cc.caseId}</td>
                                        <td>${cc.status}</td>
                                        <td><a href=CaseManagement?caseId=${cc.caseId}><button class="btn bg-primary">View</button></a></td>
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
