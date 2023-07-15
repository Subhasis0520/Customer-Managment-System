<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.company.model.Customer"%>
    <%@page import="java.util.ArrayList"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
  rel="stylesheet"
/>

<style type="text/css">
          table,th,td{
            border:2px solid black;
            text-align:center;
          }
          th{
            text-style:italic;
            font-size:20px;
          }
          td{
            color:blue;
          }
          table a{
             color: violet;
             text-decoration: underline;
          }         
          a:hover{
            color:red;
            
          }
</style>
</head>
<body>

<header>

 <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Customer Management</a>
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarTogglerDemo02"
      aria-controls="navbarTogglerDemo02"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page"  href="table"><i class="fas fa-store"></i>Customer</a>
        </li>
      </ul>

    </div>
  </div>
</nav>
<br>
<br>

</header>


<div class="container">
       
       <h2 align="center">Customers List</h2> <hr>
 
   <form action="insertForm">
   <button class="btn btn-warning">Add Customer</button>
   </form>
   <br>
   
   <table class="table">
  <thead>
    <tr>
          <th scope="col">Id</th>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Mobile</th>
          <th scope="col">Actions</th>
   </tr>
  </thead>
  
  <tbody>
  
  <c:forEach var="i" items="${al}">
  <tr>
     <td> <c:out value="${i.id}"></c:out> </td>
      <td><c:out value="${i.name}"></c:out></td>
       <td><c:out value="${i.email}"></c:out></td>
        <td><c:out value="${i.mobile}"></c:out></td>
         <td> 
         <a href="editForm?id=<c:out value="${i.id}"></c:out>">Edit</a>
          &nbsp;&nbsp; 
          <a href="delete?id=<c:out value="${i.id}"></c:out>">Delete</a>
         </td>
  </tr>
  </c:forEach>
  
  </tbody>
  </table> 
</div>

<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js">
  </script>

</body>
</html>