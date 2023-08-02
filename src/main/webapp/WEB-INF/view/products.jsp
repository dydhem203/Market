<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Market</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<!-- Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

    <!-- All Products -->

    <div class="small-container">
        <div class="row row-2">
            <h2>All Products</h2>
            <select>
                <option>Default Sort</option>
                <option>Sort By Price</option>
                <option>Sort By Popularity</option>
                <option>Sort By Rating</option>
                <option>Sort By Sale</option>
            </select>
        </div>
        <ul class="row">
            <c:forEach var="item" items="${products}">
                <li class="col-4">
                    <a href="/product/detail/${item.productCode}"><img src="${item.image}"></a>
                    <h5>${item.productName}</h5>
                    <div class="opt-price">
                        <em class="market-price"><fmt:formatNumber value="${item.price}" pattern="#,###"/></em>
                        <span class="market_tx">원</span>
                    </div>
                    <div class="rating">
                        <c:forEach begin="1" end="${item.scope}">
                            <i class="fa fa-star"></i>
                        </c:forEach>
                        <c:forEach begin="${item.scope}" end="4">
                            <i class="fa fa-star-o"></i>
                        </c:forEach>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div class="page-btn">
            <span>1</span>
            <span>2</span>
            <span>3</span>
            <span>4</span>
            <span>&#8594;</span>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>