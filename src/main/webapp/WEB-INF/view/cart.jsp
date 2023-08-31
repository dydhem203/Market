<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function removeCart(productCode){
        if(typeof $("#isLogin").val() == "undefined"){
            let cartItems = JSON.parse(localStorage.getItem('cartItems'))
            if(cartItems != null){
                let tempCartitems = [];
                for (let i = 0; i < cartItems.length; i++) {
                    let temp = cartItems[i];
                    if (temp["productCode"] != productCode){
                        tempCartitems.push(cartItems[i]);
                    }
                }
                localStorage.removeItem('cartItems');
                if(tempCartitems.length > 0) localStorage.setItem('cartItems', JSON.stringify(tempCartitems));
                goCart();
            }
        }else{
            let f = document.createElement('form');
            let obj;
            obj = document.createElement('input');
            obj.setAttribute('type', 'hidden');
            obj.setAttribute('name', 'productCode');
            obj.setAttribute('value', productCode);

            f.appendChild(obj);
            f.setAttribute("id", "removeCartForm");
            f.setAttribute('method', 'post');
            f.setAttribute('Content-Type', 'application/json');
            f.setAttribute('action', '/cart/removeCart');
            document.body.appendChild(f);
            $("#removeCartForm").submit();
        }
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
                            <div>
                                <p style=" cursor: pointer;" onclick="location.href='/product/detail/${cart.productCode}';">${cart.productName}</p>
                                <small>Price: ${cart.dcPrice}</small>
                                <br>
                                <a href="javascript:removeCart(${cart.productCode});">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="${cart.cnt}"></td>
                    <td>${cart.dcPrice * cart.cnt}</td>
                    <c:set var="total" value="${total + cart.dcPrice * cart.cnt}" />
                </tr>
            </c:forEach>
        </table>
        <div class="total-price">
            <table>
                <tr>
                    <td>Total</td>
                    <td><c:out value="${total}원"></c:out></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit" class="btn">Register</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>