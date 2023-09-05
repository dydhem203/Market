<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function addReview(productCode){
        var option = "width = 500, height = 500, top = 100, left = 200, location = no"
        window.open('/user/review/'+productCode, 'popup', option);
    }
</script>
<html>

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
    <!-- Cart items details -->
    <div class="small-container cart-page">
        <h2>구매내역</h2>
        <br>
        <table>
            <tr>
                <th>상품</th>
                <th>수량</th>
                <th>가격</th>
                <th>상태</th>
                <th>구매일자</th>
            </tr>
            <c:forEach items="${purchases}" var="purchase">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="${purchase.image}" style=" cursor: pointer;" onclick="location.href='/product/detail/${purchase.productCode}';">
                            <div>
                                <p style=" cursor: pointer;" onclick="location.href='/product/detail/${purchase.productCode}';">${purchase.productName}</p>
                                <small>Price: ${purchase.dcPrice}</small>
                                <br>
                                <a href="javascript:addReview(${purchase.no});">review</a>
                            </div>
                        </div>
                    </td>
                    <td>${purchase.cnt}</td>
                    <td>${purchase.dcPrice * purchase.cnt}</td>
                    <td>${purchase.stateName}</td>
                    <td>${purchase.purchaseDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>