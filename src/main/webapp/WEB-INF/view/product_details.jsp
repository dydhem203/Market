<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function addCart(productCode){
        var data = JSON.stringify ({"cartItems" : [{"productCode" : productCode, "cnt" : $("#cnt").val()}]});
        $.ajax({
            url : "/cart/addCart",
            type : "POST",
            data : data,
            contentType : 'application/json',
            success : function(){
                alert("장바구니 등록이 완료되었습니다.");
            },
            error : function(e){
                console.log(e);
            }
        });
    }
</script>

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
<!-- Single Products -->
<div class="small-container single-product">
    <div class="row">
        <div class="col-2">
            <img src="${product.image}" width="100%" id="ProductImg">
        </div>
        <div class="col-2">
            <p>Home / T-Shirt</p>
            <h2>${product.productName}</h2>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <table>
                <tr>
                    <td><p>${product.price}</p></td>
                    <td><h4>${product.dcPrice}</h4></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>브랜드</td>
                    <td>${product.brand}</td>
                </tr>
                <tr>
                    <td>판매단위</td>
                    <td>${product.unit}</td>
                </tr>
                <tr>
                    <td>중량</td>
                    <td>${product.amt}</td>
                </tr>
                <tr>
                    <td>원산지</td>
                    <td>${product.origin}</td>
                </tr>
                <tr>
                    <td>알레르기</td>
                    <td>${product.allergy}</td>
                </tr>
                <tr>
                    <td>유통기한</td>
                    <td>${product.expDate}</td>
                </tr>
            </table>
            <div id="addToCart">
                <input type="number" value="1" id="cnt">
                <a href="javascript:addCart(${product.productCode});" class="btn">Add To Cart</a>
            </div>

            <h3>Product Details <i class="fa fa-indent"></i></h3>
            <br>
            <p>${product.details}</p>
        </div>
    </div>
</div>
<!-- title -->
<div class="small-container">
    <div class="row row-2">
        <h2>Product Details</h2>
        <p>View More</p>
    </div>
</div>
<!-- Product detail -->
<div class="small-container">
    <c:forEach begin="0" end="${fn:length(product.productImageList)}" var="i">
        <c:forEach var="image" items="${product.productImageList}">
            <c:if test="${image.imgOrder eq i}">
                <div class="col-4"><img src="${image.image}"></div>
            </c:if>
        </c:forEach>
    </c:forEach>
</div>

<!-- Product review -->
<div class="small-container">

</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
