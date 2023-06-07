<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        @import url("${pageContext.request.contextPath}/resources/css/product/product-detail.css");
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global/clipboard.css">
    <script
            src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
            crossorigin="anonymous"
    ></script>
</head>
<body>
<%-- 헤더 포함 --%>
<%@ include file="/WEB-INF/views/global/header.jsp" %>
<!-- 다른 내용 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="number" value="${productDetail.productPriceWon}"/>

<fmt:formatNumber value="${number}" pattern="#,##0" var="formattedNumber"/>

<div class="product-detail-wrap wrap">
    <div class="brand-crumb">
    </div>
    <div class="prd-info">
        <div class="prd-info-box left">

            <div class="imgview">
                <img class="cloudzoom" src="${productDetail.productImagePath}"
                     data-cloudzoom="zoomImage: 'https://image.thehyundai.com/static/3/8/7/68/A1/40A1687835_0_1200.jpg', zoomSizeMode:'lens', zoomPosition:4, zoomOffsetX:38, zoomOffsetY:-40, maxMagnification:12, zoomFlyOut:false, animationTime:150, zoomMatchSize:true, captionSource:'#caption1', captionType:'html', startMagnification:2, tintOpacity:0, lazyLoadZoom:true"
                     id="zoom1" width="530" height="530"
                     onerror="this.src='https://image.thehyundai.com/hdmall/images/pd/no_image_480x480.jpg'">
            </div>
        </div>
        <div class="prd-info-box">
            <div class="prd-title">
                <div class="prd-logo">
                    <c:choose>
                        <c:when test="${productDetail.productBrand = 'CHANEL'}">
                            <img src="https://image.thehyundai.com/hdmall/images/specialshop/A002018_prd.jpg"
                                 alt="CHANEL">
                        </c:when>
                        <c:otherwise>
                            <h3>${productDetail.productBrand}</h3>
                        </c:otherwise>
                    </c:choose>
                </div>
                <h2>
                    ${productDetail.productName}
                </h2>
            </div>
            <div class="prd-price-info-wrap">

                <h3 class="blind">혜택가격정보</h3>
                <div class="item">
                    <div class="txt"><span>판매가</span></div>
                    <div class="info">
                        <div class="price">
                            <c:out value="${formattedNumber}"/>

                            <span>원</span>
                        </div>
                    </div>
                </div>
                <div class="item last">
                    <div class="txt">상품코드</div>
                    <div id="product-code" class="info">${productDetail.productCode}</div>
                </div>
            </div>

            <!-- 간편선택 move 영역 -->
            <div class="option-floating-case">
                <div class="option-floating" id="option-floating">
                    <div class="option-floating-btn">
                        <a class="btn-opt-toggle">간편 옵션선택</a>
                    </div>
                    <div class="option-floating-scroll">
                        <div class="opt-sel-wrap">
                            <h3 class="blind">선택한 옵션</h3>
                            <ul class="opt-sel-box">
                                <li class="selected-uitm-wrap">
                                    <div class="selected-uitm">
                                        <p class="name" id="bsicUitmListItem">
                                            <input type="hidden" name="slitmCd" value="40A1687835">
                                            <input type="hidden" name="uitmCd" value="00001">
                                            <input type="hidden" name="optNm" value="50ML">

                                            구매수량

                                        </p>
                                        <div class="cnt-ctrl" id="ddOrdQtyArea">
                                            <a href="javascript://" onclick="minusOrdQtyForNoUitm(this);"
                                               class="cnt-up">－</a>
                                            <input type="text" name="ordQty" onkeyup="changeOrdQtyBasic(this);"
                                                   value="1" maxlength="4" maxval="2" title="inputarea">
                                            <input type="hidden" name="sellPossQty" value="4" title="inputarea">
                                            <a class="cnt-down tooltip"
                                               onclick="plusOrdQtyForNoUitm(this, 2);">＋</a>
                                        </div>
                                        <p class="price">
                                            <c:out value="${formattedNumber}"/><span>원</span></p>
                                    </div>
                                </li>
                            </ul>
                            <div class="sumprice">합계 <em id="totItemPrcSpan">
                                <c:out value="${formattedNumber}"/>

                            </em>원
                            </div>
                        </div>

                    </div>
                    <div class="btn-wrap prd-btn">
                        <div class="optinalbtn">
                            <div class="optinalbtn-box">
                                <a> <i class="icon-arrow right-arrow"></i></a>
                            </div>
                        </div>
                        <div class="mainbtn type1">
                            <button id="wishlist-btn" class="btn size6 color4 cursor-pointer" type="button">찜</button>
                            <button class="btn size6 color4 cursor-pointer" type="button">장바구니
                            </button>
                            <span class="type-share-box">
                                <button class="btn size6 color4 type-share cursor-pointer" onclick="copyCurrentLocationToClipboard()">
                                    <span class="ico">공유</span>
                                </button>
                            </span>
                            <button class="btn size6 color9 cursor-pointer" type="button">
                                바로구매
                            </button>
                        </div>
                        <div class="description text-left">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%-- 푸터 포함 --%>

<%@ include file="/WEB-INF/views/global/footer.jsp" %>

</body>
<script src="${pageContext.request.contextPath}/resources/js/product/product-detail.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/global/clipboard.js"></script>

</html>
