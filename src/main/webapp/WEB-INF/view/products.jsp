<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Market</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function(){
           $("#prd_sort").change(function (){
               loadProducts(1);
           });
        });
    </script>
</head>

<body>

<!-- Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

    <!-- All Products -->

    <div class="small-container">
        <div class="row row-2">
            <h2>All Products</h2>
            <select class="prd_sort" id="prd_sort">
                <option selected="selected" value="productCode">추천순</option>
                <option value="price">낮은 가격순</option>
                <option value="priced">높은 가격순</option>
                <option value="dcrate">할인율순</option>
<%--                <option value="cnt">리뷰많은순</option>--%>
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
            <c:if test="${prevTF eq true}">
                <span id="prevShow" >←</span>
            </c:if>
            <c:forEach var="p" begin="${startPage}" end="${endPage}">
                <span onclick="loadProducts(${p})">${p}</span>
            </c:forEach>

<%--            <span onclick="loadProducts(${2})">2</span>--%>
<%--            <span>3</span>--%>
<%--            <span>4</span>--%>
            <c:if test="${nextTF eq true}">
                <span id="nextShow">→</span>
            </c:if>

        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

    <script>
        const loadProducts = (page) => {

            let f = document.createElement('form');

            let objSearchText = document.createElement('input');
            objSearchText.setAttribute('type', 'hidden');
            objSearchText.setAttribute('name', 'searchText');
            objSearchText.setAttribute('value', "");

            let objCurrentPage = document.createElement('input');
            objCurrentPage.setAttribute('type', 'hidden');
            objCurrentPage.setAttribute('name', 'currentPage');
            objCurrentPage.setAttribute('value', page);

            let objPageSize = document.createElement('input');
            objPageSize.setAttribute('type', 'hidden');
            objPageSize.setAttribute('name', 'pageSize');
            objPageSize.setAttribute('value', 12);

            let objOrderColumn = document.createElement('input');
            objOrderColumn.setAttribute('type', 'hidden');
            objOrderColumn.setAttribute('name', 'orderColumn');

            let orderBy = document.createElement('input');
            orderBy.setAttribute('type', 'hidden');
            orderBy.setAttribute('name', 'orderBy');
            if ($("#prd_sort").val() == "priced") {
                orderBy.setAttribute('value', 'desc');
                objOrderColumn.setAttribute('value', "price");
            } else {
                objOrderColumn.setAttribute('value', $("#prd_sort").val());
            }

            f.appendChild(objSearchText);
            f.appendChild(objOrderColumn);
            f.appendChild(objCurrentPage);
            f.appendChild(objPageSize);
            f.appendChild(orderBy)

            f.setAttribute('method', 'post');
            f.setAttribute('action', 'product');

            document.body.appendChild(f);
            f.submit();
        }

    </script>
</body>

</html>