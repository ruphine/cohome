<%-- 
    Document   : provaCommenti
    Created on : 18-mar-2014, 10.44.47
    Author     : Alessandro
--%>

<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="ejb.Commento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Commento> commenti= (List<Commento>)request.getAttribute("commenti"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% ListIterator<Commento> iter = commenti.listIterator();
                int c=0;
                while(iter.hasNext()){
                    Commento a=iter.next();
                    a.getAutore();
                    a.getCommento();
                    c++;
                }
         %>
    </body>
</html>
