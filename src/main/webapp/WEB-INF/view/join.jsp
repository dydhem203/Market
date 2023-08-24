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
<script>
    $(document).ready(function(){
        var errorMessage = '${errorMessage}';
        if(errorMessage != null && errorMessage != ''){
            alert(errorMessage);
        }
    });
</script>

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
                    <div class="form-container2">
                        <div class="form-btn">
                            <span class="account-title">Join</span>
                            <hr id="Indicator">
                        </div>
                        <form id="join" action="/user/join" method="post">
                            <table>
                                <tr>
                                    <td width="30%"><span style="color:red">*</span>ID</td>
                                    <td width="70%"><input type="text" placeholder="Id" name="userId"></td>
                                </tr>
                                <tr>
                                    <td><span style="color:red">*</span>Password</td>
                                    <td><input type="password" placeholder="Password" name="pw"></td>
                                </tr>
                                <tr>
                                    <td><span style="color:red">*</span>Username</td>
                                    <td><input type="text" placeholder="Username" name="name"></td>
                                </tr>
                                <tr>
                                    <td><span style="color:red">*</span>Email</td>
                                    <td><input type="email" placeholder="Email" name="email"></td>
                                </tr>
                                <tr>
                                    <td><span style="color:red">*</span>Gender</td>
                                    <td>
                                        <table>
                                            <tr>
                                                <td><input type="radio" name="gender" value="1"/></td>
                                                <td><span style="width: 10%">남자</span></td>
                                                <td><input type="radio" name="gender" value="2"/></td>
                                                <td><span style="width: 10%">여자</span></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span style="color:red">*</span>Hp</td>
                                    <td><input type="text" placeholder="Hp" name="hp"></td>
                                </tr>
                                <tr>
                                    <td><span style="color:red">*</span>Addr1</td>
                                    <td><input type="text" placeholder="Addr1" name="addr1"></td>
                                </tr>
                                <tr>
                                    <td>Addr2</td>
                                    <td><input type="text" placeholder="Addr2" name="addr2"></td>
                                </tr>
                                <tr>
                                    <td>Birthday</td>
                                    <td><input type="date" placeholder="Birthday" name="birthday"></td>
                                </tr>
                            </table>
                            <button type="submit" class="btn">Register</button>
                            <a href="/user/loginPage">Login</a>
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