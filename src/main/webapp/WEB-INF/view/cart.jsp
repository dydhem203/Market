<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function goProductDetail2(productCode){
        $.get("/product/detail/" + productCode);
    }
    function goProductDetail(productCode){
        $.get("/product/detail/" + productCode, function (data, status) {
            console.log(`${status}`);
        });
    }
</script>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products | RedStore</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<!-- Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

    <!-- Cart items details -->
    <div class="small-container cart-page">
        <table>
            <tr>
                <th>상품</th>
                <th>수량</th>
                <th>가격</th>
            </tr>
            <c:forEach items="${carts}" var="cart">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="${cart.image}" style=" cursor: pointer;" onclick="location.href='/product/detail/${cart.productCode}';">
                            <div style=" cursor: pointer;" onclick="location.href='/product/detail/${cart.productCode}';">
                                <p>${cart.productName}</p>
                                <small>Price: ${cart.dcPrice}</small>
                                <br>
                                <a href="">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="${cart.cnt}"></td>
                    <td>${cart.dcPrice}</td>
                    <c:set var="total" value="${total + cart.dcPrice}" />
                </tr>
            </c:forEach>
        </table>
        <div class="total-price">
            <table>
                <tr>
                    <td>Subtotal</td>
                    <td>$200.00</td>
                </tr>
                <tr>
                    <td>Tax</td>
                    <td>$35.00</td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><c:out value="${total}원"></c:out></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>