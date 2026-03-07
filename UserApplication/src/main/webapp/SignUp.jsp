<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<body>

  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-12 col-sm-10 col-md-8 col-lg-5">

        <div class="card shadow-sm rounded-3">
          <div class="card-body p-4">
            <h1 class="h3 text-center mb-4">SignUp</h1>
<form action="SignUp" method="post">
    

  <!-- User ID -->
  <div class="mb-3 row">
    <label for="userId" class="col-sm-3 col-form-label">User ID</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="userId" name="userId" placeholder="Enter User ID">
    </div>
  </div>

  <!-- Username -->
  <div class="mb-3 row">
    <label for="uname" class="col-sm-3 col-form-label">User Name</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter username">
    </div>
  </div>

  <!-- Password -->
  <div class="mb-3 row">
    <label for="pwd" class="col-sm-3 col-form-label">Password</label>
    <div class="col-sm-9">
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
    </div>
  </div>

  <!-- Email -->
  <div class="mb-3 row">
    <label for="emailid" class="col-sm-3 col-form-label">Email</label>
    <div class="col-sm-9">
      <input type="email" class="form-control" id="emailid" name="emailid" placeholder="Enter email">
    </div>
  </div>

  <!-- Mobile -->
  <div class="mb-3 row">
    <label for="mobileno" class="col-sm-3 col-form-label">Mobile No.</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="mobileno" name="mobileno" placeholder="Enter mobile number">
    </div>
  </div>

  <!-- Button -->
  <div class="d-grid mt-3">
    <button type="submit" class="btn btn-primary">Confirm Identity</button>
  </div>

</form>  



          </div>
        </div>

      </div>
    </div>
  </div>

</body>
</html>