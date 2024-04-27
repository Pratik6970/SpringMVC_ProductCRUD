<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
</head>
<body>



	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Fill Product</h1>
				<form action="handle-product" method="post">

					<div class="form-group">
						<label for="name">Product name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							name="name" placeholder="Enter Name here">

					</div>

					<div class="form-group">
						<label for="description">Product description</label>
						<textarea class="form-control" name="description" id="description"
							rows="5" placeholder="Enter the product description here"></textarea>



					</div>

					<div class="form-group">
						<label for="name">Product price</label> <input type="text"
							class="form-control" id="price" name="price"
							placeholder="Enter price here">

					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>

						<button type="submit" class="btn btn-primary">Add</button>
					</div>

				</form>
			</div>
		</div>

	</div>


</body>
</html>