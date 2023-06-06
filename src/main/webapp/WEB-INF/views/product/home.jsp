<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>

<html>
<style type="text/css">
    @import url("${pageContext.request.contextPath}/resources/css/product/product-home.css");
</style>

<head>
    <title>Product</title>
</head>

<body>
<%-- 헤더 포함 --%>
<%@ include file="/WEB-INF/views/global/header.jsp" %>

<div class="product-wrapper" id="product">
    <div class="product-top">
        <div class="product-top-left">
            <div class="group-wrap">
                <ul>
                    <li><a>카테고리</a></li>
                    <li><a>스킨케어</a></li>
                    <li><a>메이크업</a></li>
                    <li><a>바디/헤어케어</a></li>
                    <li><a>기능성케어</a></li>
                    <li><a>향수/캔들</a></li>
                    <li><a>미용기기/용품</a></li>
                    <li><a>남성화장품</a></li>
                    <li><a>BRAND SHOP</a></li>
                </ul>
            </div>

            <div class="group-wrap">
                <ul>
                    <li><a>가격대</a></li>
                    <label class="checkbox-label" style="white-space: normal">
                        <input type="checkbox" name="brandCheckBox" value="BrandCode01"
                               class="checkBox"> <span>~5만원</span>
                    </label>
                    <label class="checkbox-label" style="white-space: normal">
                        <input type="checkbox" name="brandCheckBox" value="BrandCode01"
                               class="checkBox"> <span>~5만원~20만원</span>
                    </label>
                    <label class="checkbox-label" style="white-space: normal">
                        <input type="checkbox" name="brandCheckBox" value="BrandCode01"
                               class="checkBox"> <span>~20만원~30만원</span>
                    </label>
                    <label class="checkbox-label" style="white-space: normal">
                        <input type="checkbox" name="brandCheckBox" value="BrandCode01"
                               class="checkBox"> <span>~30만원~50만원</span>
                    </label>
                    <label class="checkbox-label" style="white-space: normal">
                        <input type="checkbox" name="brandCheckBox" value="BrandCode01"
                               class="checkBox"> <span>50만원~</span>
                    </label>
                </ul>
            </div>
            <div class="input-direct">
                <p>
                    <input type="text" id="startsell_prc" name="startsell_prc"
                           value="" class="onlyNumberInput"> <span class="unit">원</span>
                    <span>~</span> <input type="text" id="endsell_prc"
                                          name="endsell_prc" value="" class="onlyNumberInput"> <span
                        class="unit">원</span>
                </p>
                <p>
                    <button class="btn size2 color5" onclick="검색" type="button">적용</button>
                </p>
            </div>

        </div>
        <div class="product-top-right">
            <div class="cosmetic-slide"></div>
            <div class="top-area">
                <div class="count">9개 상품</div>
                <div class="sort">
                    <div class="selectric-wrapper" style="width: 150px;">
                        <div class="selectric-hide-select">
                            <select title="selectbox" name="prdListSize" id="prdListSize"
                                    onchange="javascript:searchItem();" tabindex="0"
                                    style="display: none;">
                                <option value="" selected="selected">추천순</option>
                                <option value="sale_cost_l">낮은가격순</option>
                                <option value="sale_cost_u">높은가격순</option>
                                <option value="new_item">최신상품순</option>
                                <option value="sale_cnt">인기상품순</option>
                            </select>
                        </div>
                        <div class="selectric">
                            <p class="label">추천순</p>
                            <b class="button">▾</b>
                        </div>
                        <div class="selectric-items" tabindex="-1"
                             style="width: 148.961px;">
                            <div class="selectric-scroll">
                                <ul>
                                    <li data-index="0" class="selected">추천순</li>
                                    <li data-index="1" class="">낮은가격순</li>
                                    <li data-index="2" class="">높은가격순</li>
                                    <li data-index="3" class="">최신상품순</li>
                                    <li data-index="4" class="last">인기상품순</li>
                                </ul>
                            </div>
                        </div>
                        <input class="selectric-input" tabindex="0">
                    </div>

                </div>
            </div>
            <div class="goods-area">


                <ul>


                    <li>
                        <a class="btn-to-link" href="/product/A0761805"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '[불리][선물포장] 레 비지날 바디로션 190ml (7종 택1)');
                                                                                                            itemDetailView('186124','40A0761805', 'N');return false;">
                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/0/8/1/76/A0/40A0761805_0_600.jpg"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">


                                <div class="name">[불리][선물포장] 레 비지날 바디로션 190ml (7종 택1)</div>
                                <div class="price">85,000원</div>


                            </div>
                        </a>


                    </li>


                    <li>

                        <a class="btn-to-link" href="/product/40A0486788"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '샤넬 가브리엘 샤넬 오 드 빠르펭 35ml'); itemDetailView('186124','40A0486788', 'N');return false;">
                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/8/7/6/48/A0/40A0486788_0_600.jpg"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">


                                <div class="name">샤넬 가브리엘 샤넬 오 드 빠르펭 35ml</div>
                                <div class="price">126,000원</div>


                            </div>
                        </a>


                    </li>


                    <li>

                        <a class="btn-to-link" href="/product/40A1444905"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '샤넬 N1 DE CHANEL 레드 까멜리아 세럼 30ml'); itemDetailView('186124','40A1444905', 'N');return false;">
                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/0/9/4/44/A1/40A1444905_0_600.jpg"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">


                                <div class="name">샤넬 N1 DE CHANEL 레드 까멜리아 세럼 30ml</div>
                                <div class="price">151,000원</div>
                            </div>
                        </a>


                    </li>


                    <li>

                        <a class="btn-to-link" href="/product/60A1653133"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '샤넬 NEW 코코 마드모아젤 헤어 미스트 35ml'); itemDetailView('186124','60A1653133', 'N');return false;">

                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/3/1/3/65/A1/60A1653133_0_600.jpg"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">


                                <div class="name">샤넬 NEW 코코 마드모아젤 헤어 미스트 35ml</div>
                                <div class="price">79,000원</div>


                            </div>
                        </a>


                    </li>


                    <li>

                        <a class="btn-to-link" href="/product/75920698"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '[레노마]남성 손수건 선물 SET 1'); itemDetailView('186124','2075920698', 'N');return false;">

                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/9/6/0/92/75/2075920698_0_600.JPG"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">


                                <div class="name">[레노마]남성 손수건 선물 SET 1</div>
                                <div class="price">21,000원</div>


                            </div>
                        </a>


                    </li>

                    <li>

                        <a class="btn-to-link" href="/product/40A0620501"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '샤넬 블루 드 샤넬 빠르펭 100ML'); itemDetailView('186124','40A0620501', 'N');return false;">

                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/0/5/0/62/A0/40A0620501_0_600.jpg"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">
                                <div class="name">샤넬 블루 드 샤넬 빠르펭 100ML</div>
                                <div class="price">220,000원</div>
                            </div>
                        </a>
                    </li>
                    <li>

                        <a class="btn-to-link" href="/prodcut/40A1139891"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '샤넬 루쥬 코코 플래쉬'); itemDetailView('186124','40A1139891', 'N');return false;">
                            <div class="img-box">
                                <img
                                        src="https://image.thehyundai.com//static/9/8/9/13/A1/40A1139891_0_600.jpg"
                                        alt="상품이미지">
                            </div>
                            <div class="info-box">
                                <div class="name">샤넬 루쥬 코코 플래쉬</div>
                                <div class="price">55,000원</div>
                            </div>

                        </a>
                    </li>
                    <li>

                        <a class="btn-to-link" href="/product/A1271652"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '[닥스] 기본체크 손수건 2매세트 (D) 5종 택1'); itemDetailView('186124','40A1349665', 'N');return false;">

                            <div class="img-box">
                                <img
                                        src="https://image.thehyundai.com//static/6/6/9/34/A1/40A1349665_0_600.jpg"
                                        alt="상품이미지">

                            </div>
                            <div class="info-box">
                                <div class="name">[닥스] 기본체크 손수건 2매세트 (D) 5종 택1</div>
                                <div class="price">31,000원</div>
                            </div>

                        </a>

                    </li>
                    <li>

                        <a class="btn-to-link" href="/product/40A1379135"
                           onclick="javascript:sendGAEvent('선물하기', '상품', '샤넬 레 베쥬 워터 틴트 블러셔'); itemDetailView('186124','40A1379135', 'N');return false;">

                            <div class="img-box">

                                <img
                                        src="https://image.thehyundai.com//static/3/1/9/37/A1/40A1379135_0_600.jpg"
                                        alt="상품이미지">
                            </div>
                            <div class="info-box">
                                <div class="name">샤넬 레 베쥬 워터 틴트 블러셔</div>
                                <div class="price">72,000원</div>
                            </div>

                        </a>

                    </li>
                </ul>
            </div>
        </div>

    </div>
    <div class="product-bottom">
        <div class="product-bottom-left"></div>
        <div class="product-bottom-right"></div>
    </div>
</div>
<%-- 푸터 포함 --%>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>
</body>

</html>