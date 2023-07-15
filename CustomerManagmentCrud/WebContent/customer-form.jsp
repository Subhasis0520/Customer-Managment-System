<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
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
    h2{
    text-align: center;
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
          <a class="nav-link active" aria-current="page" href="table"><i class="fas fa-store"></i>Customer</a>
        </li>
      </ul>

    </div>
  </div>
</nav>

</header>
<br> <br>

<div class="container" style="width:40%">

<c:if test="${customer == null}">

<form action="add" method="post">
<h2 >Add Customer Details </h2>

</c:if>

<c:if test="${customer != null}">

<form action="edit" method="post">
<h2 >Edit Customer Details </h2>

</c:if>



   <div class="mb-3" hidden="hidden">
  <input value="<c:out value="${customer.id}"></c:out>" type="text" id="typeEx" name="tbEx" class="form-control" />
</div>
  
    <div class="mb-3">
      <label class="form-label" for="typeName">Name</label>
  <input type="text" value="<c:out value="${customer.name}"></c:out>" id="typeName" name="tbName" class="form-control" required="required" placeholder="enter your name" />
</div>

<div class="mb-3">
<label class="form-label" for="typeEmail">Email</label>
  <input type="email" value="<c:out value="${customer.email}"></c:out>" id="typeEmail" name="tbMail" class="form-control" required="required" placeholder="enter your mail id"/>  
</div>

<div class="mb-3">
  <label class="form-label" for="typeMobile">Mobile No</label>
  <input type="tel" value="<c:out value="${customer.mobile}"></c:out>" id="typeMobile" name="tbMobile" class="form-control" required="required" placeholder="enter your phone number"/>
</div>

<div>
<button class="btn btn-success">Save</button>
</div>
</form>

</div>





<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"
></script>
</body>
</html>