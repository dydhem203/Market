<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 | Market</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<!DOCTYPE html>
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
<div class="container">
    <div class="navbar">
        <div class="logo">
            <a href="home.jsp"><img src="/images/logo.png" alt="logo" width="125px"></a>
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="products.jsp">Products</a></li>
                <li><a href="">About</a></li>
                <li><a href="">Contact</a></li>
                <li><a href="account.jsp">Account</a></li>
            </ul>
        </nav>
        <a href="cart.jsp"><img src="/images/cart.png" width="30px" height="30px"></a>
        <img src="/images/menu.png" class="menu-icon" onclick="menutoggle()">
    </div>
</div>

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

            <input type="number" value="1">
            <a href="" class="btn">Add To Cart</a>

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
    <c:forEach begin="0" end="${fn:length(product.productImages)}" var="i">
        <c:forEach var="image" items="${product.productImages}">
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
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="footer-col-1">
                <h3>Download Our App</h3>
                <p>Download App for Android and ios mobile phone.</p>
                <div class="app-logo">
                    <img src="/images/play-store.png">
                    <img src="/images/app-store.png">
                </div>
            </div>
            <div class="footer-col-2">
                <img src="/images/logo-white.png">
                <p>Our Purpose Is To Sustainably Make the Pleasure and Benefits of Sports Accessible to the Many.
                </p>
            </div>
            <div class="footer-col-3">
                <h3>Useful Links</h3>
                <ul>
                    <li>Coupons</li>
                    <li>Blog Post</li>
                    <li>Return Policy</li>
                    <li>Join Affiliate</li>
                </ul>
            </div>
            <div class="footer-col-4">
                <h3>Follow Us</h3>
                <ul>
                    <li>Facebook</li>
                    <li>Twitter</li>
                    <li>Instagram</li>
                    <li>Youtube</li>
                </ul>
            </div>
        </div>
        <hr>
        <p class="copyright">Copyright 2020 - Samwit Adhikary</p>
    </div>
</div>

<!-- javascript -->

<script>
    var MenuItems = document.getElementById("MenuItems");
    MenuItems.style.maxHeight = "0px";
    function menutoggle() {
        if (MenuItems.style.maxHeight == "0px") {
            MenuItems.style.maxHeight = "200px"
        }
        else {
            MenuItems.style.maxHeight = "0px"
        }
    }
</script>

<!-- product gallery -->
<script>
    var ProductImg = document.getElementById("ProductImg");
    var SmallImg = document.getElementsByClassName("small-img");

    SmallImg[0].onclick = function () {
        ProductImg.src = SmallImg[0].src;
    }
    SmallImg[1].onclick = function () {
        ProductImg.src = SmallImg[1].src;
    }
    SmallImg[2].onclick = function () {
        ProductImg.src = SmallImg[2].src;
    }
    SmallImg[3].onclick = function () {
        ProductImg.src = SmallImg[3].src;
    }

</script>
</body>

</html>
