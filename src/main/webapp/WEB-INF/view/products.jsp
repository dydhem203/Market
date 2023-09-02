<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Market</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
</head>

<body>

<!-- Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

<!-- All Products -->

<div class="small-container">
    <div class="row row-2">
        <h2>All Products</h2>
        <select class="prd_sort" id="prd_sort">
            <option value="productCode">추천순</option>
            <%-- selected="selected" --%>
            <option value="price">낮은 가격순</option>
            <option value="priced">높은 가격순</option>
            <option value="dcrate">할인율순</option>
            <%--                <option value="cnt">리뷰많은순</option>--%>
        </select>
    </div>

    <div class="search">
        <form method="post">
            <input class="searchText" name="searchText" type="text" placeholder="&#61442;"/>
        </form>
    </div>

    <br>
    <br>


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
        <c:if test="${prevTF eq true}">
            <span id="prevShow">←</span>
        </c:if>
        <c:forEach var="p" begin="${startPage}" end="${endPage}">
            <c:choose>
                <c:when test="${currentPage == p}">
                    <strong>${p}</strong>
                </c:when>
                <c:otherwise>
                    <span onclick="loadProducts(${p})">${p}</span>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${nextTF eq true}">
            <span id="nextShow">→</span>
        </c:if>
    </div>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

<script>
    $(document).ready(function () {
        $("#prd_sort").change(function () {
            loadProducts(1);
        });
    });

    const loadProducts = (page) => {

        let chk = $("#prd_sort option:selected").text();
        $("#prd_sort option:eq(chk)").prop("selected", true);


        let f = document.createElement('form');

        let objSearchText = document.createElement('input');
        objSearchText.setAttribute('type', 'hidden');
        objSearchText.setAttribute('name', 'searchText');
        objSearchText.setAttribute('value', "");

        let objPageSize = document.createElement('input');
        objPageSize.setAttribute('type', 'hidden');
        objPageSize.setAttribute('name', 'pageSize');
        objPageSize.setAttribute('value', 12);

        let orderBy = document.createElement('input');
        orderBy.setAttribute('type', 'hidden');
        orderBy.setAttribute('name', 'orderBy');
        if ($("#prd_sort").val() == "priced") {
            orderBy.setAttribute('value', 'desc');
        }

        f.appendChild(objSearchText);
        f.appendChild(objPageSize);
        f.appendChild(orderBy)

        f.setAttribute('method', 'post');
        f.setAttribute('action', '/product?currentPage='+page+'&sort='+$("#prd_sort").val());

        document.body.appendChild(f);
        f.submit();
    }

</script>
</body>
</html>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",0);
    if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>