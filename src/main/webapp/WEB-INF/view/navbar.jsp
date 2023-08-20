<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <div class="navbar">
        <div class="logo">
            <a href="/"><img src="/images/logo.png" alt="logo" width="125px"></a>
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="/">Market</a></li>
<%--                <li><a onclick="showProducts()" style="cursor: pointer" >상품</a></li>--%>
                <li><a onclick="showProducts()" style="cursor: pointer" >상품</a></li>
                <li><a href="/user/loginPage">계정</a></li>
<%--                <li><a sec:authorize="isAnonymous()" th:href="@{/user/login}">로그인</a></li>--%>
<%--                <li><a sec:authorize="isAuthenticated()" th:href="@{/user/logout}">로그아웃</a></li>--%>
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

    function showProducts() {
        let f = document.createElement('form');
        f.setAttribute('method', 'post');
        f.setAttribute('action', 'product');
        document.body.appendChild(f);
        f.submit();
    }
</script>