<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin login Page</title>
<style type="text/css">
html,
body,
.intro {
  height: 100%;
}

@media (min-width: 560px) and (max-width: 750px) {
  html,
  body,
  .intro {
    height: 830px;
  }
}

@media (min-width: 800px) and (max-width: 850px) {
  html,
  body,
  .intro {
    height: 830px;
  }
}

.gradient-custom {
  /* fallback for old browsers */
  background: #667eea;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to bottom, rgba(102, 126, 234, 1), rgba(118, 75, 162, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to bottom, rgba(102, 126, 234, 1), rgba(118, 75, 162, 1))
}</style>

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
  </div>
</nav>
<br>
<br>

</header>


<section class="intro">
  <div class="bg-image h-100" style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/search-box/img4.jpg');">
    <div class="mask d-flex align-items-center h-100" style="background-color: rgba(255,255,255,.6);">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card gradient-custom" style="border-radius: 1rem;">
              <div class="card-body p-5 text-white">

                <div class="my-md-5">

                  <div class="text-center pt-1">
                    <i class="fas fa-user-astronaut fa-3x"></i>
                    <h1 class="fw-bold my-5 text-uppercase">Admin Login</h1>
                  </div>
            
                 <form action="list" method="post">
                  <div class="form-outline form-white mb-4">
                    <input type="text" id="typeEmail" class="form-control form-control-lg"  name="tbName"/>
                    <label class="form-label" for="typeEmail">UserName</label>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <input type="password" id="typePassword" class="form-control form-control-lg" name="tbPass"/>
                    <label class="form-label" for="typePassword">Password</label>
                  </div>

                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      value=""
                      id="flexCheckDefault"
                    />
                    <label class="form-check-label" for="flexCheckDefault">
                      Remember me
                    </label>
                  </div>

                  <div class="text-center py-5">
                    <button class="btn btn-light btn-lg btn-rounded px-5" type="submit">Login</button>
                  </div>
                 </form>
                
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"
></script>
</body>
</html>