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

    $(function(){
        // checkbox 전체 선택 / 해제
        $("input[name=_select_all_]").on('change', function(){  $("input[name=_select_]").prop('checked', this.checked);});

        $("td[id=other]").prop('visibility', 'hidden');
        $("input[name=_select_]").prop('checked', true);
        $("input[name=_select_all_]").prop('checked', true);
    });

    function selectAllClick() {             // 전체 제어하는 체크박스 선택시
        var checkbox = $("input:checkbox[name=_select_]");
        totPrice = 0;

        checkbox.each(function(i) {     // 전체 가격 저장
            var tr = checkbox.parent().parent().eq(i);
            var td = tr.children();

            var price = td.eq(3).text();        // price
            totPrice += Number(price);
        });

        const allchkbox = document.getElementById("selectAll");

        if (allchkbox.checked) {        // 전체 선택시 price 값 변경
            $("#totPrice").text(totPrice);
        } else {
            $("#totPrice").text(0);
        }
    }

    function getCheckedItemPrice() {
        // 체크된 체크박스 가져오기
        var checkbox = $("input:checkbox[name=_select_]:checked");
        var totChkCnt = $("input:checkbox[name=_select_]").length;

        if (totChkCnt !== checkbox.length) {
            $("input[name=_select_all_]").prop('checked', false);
        } else {
            $("input[name=_select_all_]").prop('checked', true);
        }

        var totPrice = 0;

        checkbox.each(function(i) {
           // checkbox.parent(): checkbox의 부모 td.
           // checkbox.parent().parent() : td의 부모는 tr.
            var tr = checkbox.parent().parent().eq(i);
            var td = tr.children();

            var price = td.eq(3).text();        // price
            totPrice += Number(price);
        });
        console.log(totPrice)
        $("#totPrice").text(totPrice);
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
        <h2>장바구니</h2>
        <br>
        <table>
            <tr>
                <th style="text-align: center"><input type="checkbox" id="selectAll" name="_select_all_" onclick="selectAllClick()"/></th>
                <th>상품</th>
                <th>수량</th>
                <th>가격</th>
            </tr>
            <c:forEach items="${carts}" var="cart">
                <tr>
                    <td style="text-align: center">
                        <input type="checkbox" class="chkbox" name="_select_" onclick="getCheckedItemPrice()"/>
                    </td>
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
                    <td><span id="totPrice"><c:out value="${total}"/></span>원</td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <a href="javascript:buyItems();" class="buy_btn">Buy</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>