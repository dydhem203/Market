<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Market</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<!-- Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

    <!-- Account Page -->
    <div class="account-page">
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <img src="/images/image1.png" width="100%">
                </div>
                <div class="col-2">
                    <div class="form-container">
                        <div class="form-btn">
                            <span>Login</span>
                            <hr id="Indicator">
                        </div>
                        <form id="login">
                            <input type="text" placeholder="Username">
                            <input type="password" placeholder="Password">
                            <button type="submit" class="btn">Login</button>
                            <a href="/user/joinPage">Join</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>