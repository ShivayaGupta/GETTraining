<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login form</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<body>

  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-12 col-sm-10 col-md-8 col-lg-5">

        <div class="card shadow-sm rounded-3">
          <div class="card-body p-4">
            <h1 class="h3 text-center mb-4">Login</h1>

            <form action="login" method="get">
              <div class="mb-3 row">
                <label for="userId" class="col-sm-3 col-form-label">UserName</label>
                <div class="col-sm-9">
                  <input
                    type="text"
                    class="form-control"
                    id="userId"
                    name="userId"
                    placeholder="Enter username"
                    required
                  />
                </div>
              </div>

              <div class="mb-3 row">
                <label for="inputPassword" class="col-sm-3 col-form-label">Password</label>
                <div class="col-sm-9">
                  <input
                    type="password"
                    class="form-control"
                    id="inputPassword"
                    name="pwd"
                    placeholder="Enter password"
                    required
                  />
                </div>
              </div>

              <div class="d-grid mt-4">
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
            </form>

          </div>
        </div>

      </div>
    </div>
  </div>

  <!-- Bootstrap 5 JS (optional, for components that need JS) -->
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
