<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container d-flex align-items-center justify-content-center" style="min-height:100vh;">
  <div class="card shadow p-4" style="max-width:420px; width:100%;">
    <h1 class="h4 mb-3 text-center">Login</h1>
    <form action="login" method="post">
      <div class="mb-3">
        <label for="email" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
        <div class="form-text">We'll never share your email with anyone else.</div>
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">Password</label>
        <input type="password" class="form-control" id="pwd" name="password" placeholder="Password">
      </div>
      <div class="form-check mb-3">
        <input type="checkbox" class="form-check-input" id="remember">
        <label class="form-check-label" for="remember">Remember me</label>
      </div>
      <button type="submit" class="btn btn-primary w-100">Sign In</button>
    </form>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>