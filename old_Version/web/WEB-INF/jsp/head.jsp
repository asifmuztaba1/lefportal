<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%session.invalidate();
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <spring:url value="resources/css/style.css" var="coreCss"/>
        <spring:url value="resources/css/bootstrap.min.css" var="bootminCss"/>
        <spring:url value="resources/css/bootstrap.css" var="bootCss"/>
        <spring:url value="resources/css/bootstrap-theme.css" var="boot-themeCss"/>
        <spring:url value="resources/css/bootstrap-theme.min.css" var="boot-theme.minCss"/>
        
        <link href="${coreCss}" rel="stylesheet"/>
        <link href="${bootminCss}" rel="stylesheet"/>
        <link href="${bootCss}" rel="stylesheet"/>
        <link href="${boot-themeCss}" rel="stylesheet"/>
        <link href="${boot-theme.minCss}" rel="stylesheet"/>
        
        
        
    </head>