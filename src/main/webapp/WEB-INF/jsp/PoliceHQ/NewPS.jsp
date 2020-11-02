<%@include file="head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>


        <div class="row">
            <%@include file="mainmenu.jsp" %>

        </div>


        <div class="row">
            <div class="mainview" >
                <br>
                <script>
                    $(document).ready(function () {

                        setTimeout(function () {
                            $("#msg").slideUp(1000);
                        }, 10000);
                    });
                </script>

                <div class="col-md-3"></div>
                <div class="col-md-6" style="margin: auto;text-align: center;">
                    <div class="panel panel-default">
                        <div class="panel-body" style="color: #449D44;background-color: #F0F0F0">
                            <form class="form-horizontal" role="form" ModelAttribute="PoliceStationUser" action="addNewPS" method="POST">



                                <div class="form-group">
                                    <h3>PS Information</h3>
                                    <p id="msg" style="color: #e38d13">${sucsMsg} ${errMsg}</p><br>
                                    <div class="inp" style="margin-left: 90px">

                                        <label class="col-md-2 control-label">Division</label>
                                        <select class="form-control"  name="division" required style="width: 350px">
                                            <option value="">Select</option>
                                            <option value="Barishal">Barishal</option>
                                            <option value="Chittagong">Chittagong</option>
                                            <option value="Dhaka">Dhaka</option>
                                            <option value="Mymensingh">Mymensingh</option>
                                            <option value="Khulna">Khulna</option>
                                            <option value="Rajshahi">Rajshahi</option>
                                            <option value="Rangpur">Rangpur</option>
                                            <option value="ALL">ALL</option>
                                        </select><br>
                                        <label class="col-md-2 control-label">District</label>
                                        <select style="width: 350px;" class="form-control" name="district" required >
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
                                            <option value="ALL">ALL</option>
                                        </select><br>

                                        <label class="col-md-2 control-label">Role</label>
                                        <select class="form-control" id="focusedInput" name="role" required  style="width: 350px">
                                            <option value="">Select</option>
                                            <option value="PS_ADMIN">PS Admin</option>
                                            <option value="HQ_ADMIN">HQ Admin</option>
                                        </select><br>
                                        
                                        <label class="col-md-2 control-label">PS Name</label>
                                        <input class="form-control"  type="text" name="psName" required ><br>
                                        
                                        <label class="col-md-2 control-label">Username</label>
                                        <input class="form-control"  type="text" name="username" required><br>


                                        <label class="col-md-2 control-label">Password</label>
                                        <input class="form-control"  type="password" name="password" required><br>

                                        


                                    </div>
                                    <input style="width: 200px;" class="btn btn-success" type="submit" name="reg" value="Add"/>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-3"></div>


            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    

</body>




</html>
