<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(function(){
        $('#submit').on("click",function () {
            var form1 = $("#review").serialize();
            $.ajax({
                type: "post",
                url : "/product/addReview",
                data: form1,
                success: function (data) {
                    alert("리뷰 등록에 성공했습니다.");
                    window.close();
                },
                error : function(e){
                    console.log(e);
                    alert("리뷰 등록에 실패했습니다.")
                }
            });
        });

        var point = '${review.point}';
        if(point != '' && point != null){
            $("#point").val(point).prop("selected", true);
        }
    });
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
<!-- Cart items details -->
<div class="small-container cart-page">
    <table>
        <tr>
            <td style="width: 20%">
                <img src="${product.image}" style=" cursor: pointer;">
            </td>
            <td style="width: 60%">
                ${product.productName}
            </td>
            <td style="width: 10%">
                ${product.dcPrice}원
            </td>

        </tr>
    </table>
    <form id="review" name="review">
        <table>
            <tr>
                <td>별점</td>
                <td>
                    <select id = "point" name="point">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>리뷰</td>
                <td>
                    <textarea style="width:100%; height: 100px;resize: none;" placeholder="내용을 입력해 주세요." name="contents">${review.contents}</textarea>
                </td>
            </tr>
        </table>
        <input type="hidden" name="productCode" value="${product.productCode}">
        <button class="btn" id="submit" type="button">리뷰 등록</button>
    </form>

</div>

</body>

</html>