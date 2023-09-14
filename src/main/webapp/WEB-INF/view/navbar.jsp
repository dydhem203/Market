<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container">
    <div class="navbar">
        <div class="logo">
            <a href="/"><img src="/images/logo.png" alt="logo" width="125px"></a>
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="/">Market</a></li>
                <li><a onclick="showProducts()" style="cursor: pointer" >Products</a></li>
                <sec:authorize access="isAnonymous()"><li><a href="/user/loginPage">Login</a></li></sec:authorize>
                <sec:authorize access="isAuthenticated()"><li><a href="/user/purchasePage">Purchase details</a></li></sec:authorize>
                <sec:authorize access="isAuthenticated()"><li><a href="/user/logout">Logout</a></li></sec:authorize>
                <sec:authorize access="isAuthenticated()"><input type="hidden" id="isLogin" name="isLogin" value="true"></sec:authorize>
            </ul>
        </nav>
        <a onclick="goCart()"><img src="/images/cart.png" width="30px" height="30px"></a>
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
        f.setAttribute('action', '/product');
        document.body.appendChild(f);
        f.submit();
    }

    function goCart(){
        let f = document.createElement('form');
        var cartItems = JSON.stringify (JSON.parse(localStorage.getItem('cartItems')));
        let obj;
        obj = document.createElement('input');
        obj.setAttribute('type', 'hidden');
        obj.setAttribute('name', 'cartItems');
        obj.setAttribute('value', cartItems);

        f.appendChild(obj);
        f.setAttribute("id", "cartForm");
        f.setAttribute('method', 'post');
        f.setAttribute('Content-Type', 'application/json');
        f.setAttribute('action', '/cart/main');
        document.body.appendChild(f);
        $("#cartForm").submit();
        console.log(cartItems)
    }

</script>