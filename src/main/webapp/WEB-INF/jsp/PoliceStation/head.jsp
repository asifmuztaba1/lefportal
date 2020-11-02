<%@page import="com.police.entity.PoliceStationUser"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
            PoliceStationUser user = (PoliceStationUser) session.getAttribute("user");

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../resources/js/jquery-3.3.1.min.js"></script>
        <spring:url value="../resources/css/style.css" var="coreCss"/>
        <spring:url value="../resources/css/bootstrap.min.css" var="bootminCss"/>
        <spring:url value="../resources/css/bootstrap.css" var="bootCss"/>


        <link href="${coreCss}" rel="stylesheet"/>
        <link href="${bootminCss}" rel="stylesheet"/>
        <link href="${bootCss}" rel="stylesheet"/>


        
        <spring:url value="../resources/js/bootstrap.min.js" var="bootminjs"/>


       
        <script type="text/javascript" src="${bootminjs}"></script>

        <link rel="stylesheet" type="text/css" href="../resources/DataTables/datatables.min.css"/>

        <script type="text/javascript" src="../resources/DataTables/datatables.min.js"></script>

        <title>${ps}</title>


    </head>