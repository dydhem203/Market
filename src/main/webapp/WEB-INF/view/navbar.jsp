<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <div class="navbar">
        <div class="logo">
            <a href="/"><img src="/images/logo.png" alt="logo" width="125px"></a>
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="/">Market</a></li>
                <li><a href="products.jsp">상품</a></li>
                <li><a href="/member/login">계정</a></li>
            </ul>
        </nav>
        <a href="/cart/main"><img src="/images/cart.png" width="30px" height="30px"></a>
        <img src="/images/menu.png" class="menu-icon" onclick="menutoggle()">
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