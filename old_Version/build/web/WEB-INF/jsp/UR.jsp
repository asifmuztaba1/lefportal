<%@page import="com.police.entity.PUser"%>
<%
    PUser user = (PUser) session.getAttribute("session");
    String role = user.getRole();
    String district=user.getDistrict();
    
    
    if (!role.equals("public_user")) {
        response.sendRedirect("error");
    }
    else
        response.sendRedirect("u_dash?district="+district);
%>
<script type="text/javascript">
    alert('Succesful...');
</script>