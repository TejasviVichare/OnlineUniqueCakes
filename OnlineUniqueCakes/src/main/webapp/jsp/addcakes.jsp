<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container mb-3 shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px">
<p class="text-primary text-center h2 m-3">Add Cake here!!</p>

<form action="/OnlineUniqueCakes/cakec"  method="post" enctype="multipart/form-data" >
<input type="hidden" name="action" value="addcake">
  <div class="mb-3">
    <label for="cakename" class="form-label mt-2">Cake Name</label>
    <input type="text" class="form-control" name="cakename" id="cakename" aria-describedby="emailHelp">
  </div>
  <div class="mb-1">
    <label for="exampleInputEmail1" class="form-label">Cake Type</label>
  </div>
  <div class="form-check float-start me-5">
  <input class="form-check-input" type="radio" name="caketype" id="flexRadioDefault1" value="veg">
  <label class="form-check-label" for="flexRadioDefault1">
    veg
  </label>
</div>
<div class="form-check">

  <input class="form-check-input " type="radio" name="caketype" id="flexRadioDefault2" value="non-veg">
  <label class="form-check-label" for="flexRadioDefault2">
    non-veg
  </label>
</div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-4">Cake Category</label>
<select class="form-select" aria-label="Default select example" name="cakecategory">
  <option selected>--- select cake---</option>
  <option value="birthday">birthday</option>
  <option value="wedding">wedding</option>
  <option value="anniversary">anniversary</option>
<option value="engagement">engagement</option>
<option value="new year">new year</option>

 
</select>  
</div>
 <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Cake Flavour</label>
<select class="form-select" aria-label="Default select example" name="cakeflavour">
  <option selected>--- select cake flavour---</option>
  <option value="Chocolate Cake">Chocolate Cake</option>
  <option value="Red Velvet Cake">Red Velvet Cake</option>
  <option value="Vanilla Cake">Vanilla Cake</option>
<option value="Black Forest Cake">Black Forest Cake</option>
<option value="Pineapple Cake">Pineapple Cake</option>
<option value="Gulabjam Cake">Gulabjam Cake</option>
<option value="rasmalai Cake">rasmalai Cake</option>

 
</select>  
</div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Cake weight</label>
    <input type="number" step="0.5" min=0.5 class="form-control" name="cakeweight" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Cake Price</label>
    <input type="text" class="form-control" name="cakeprice" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Add Image</label>
    <input type="file" class="form-control" name="cakeimage" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-primary w-100">Add Cake</button>
 
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>