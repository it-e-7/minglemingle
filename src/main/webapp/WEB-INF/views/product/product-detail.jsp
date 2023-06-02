<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
    @import url("${pageContext.request.contextPath}/resources/css/product/product-detail.css");
    </style>
</head>
<body>
  <%-- 헤더 포함 --%>
 <%@ include file="/WEB-INF/views/global/header.jsp" %>
  <!-- 다른 내용 -->
<div class="product-detail-wrap wrap">
    <div class="brand-crumb">
    </div>
    <div class="prd-info">
    					<div class="prd-info-box left">

    						<div class="imgview">
    							<img class="cloudzoom" src="https://image.thehyundai.com/static/3/8/7/68/A1/40A1687835_0_600.jpg" data-cloudzoom="zoomImage: 'https://image.thehyundai.com/static/3/8/7/68/A1/40A1687835_0_1200.jpg', zoomSizeMode:'lens', zoomPosition:4, zoomOffsetX:38, zoomOffsetY:-40, maxMagnification:12, zoomFlyOut:false, animationTime:150, zoomMatchSize:true, captionSource:'#caption1', captionType:'html', startMagnification:2, tintOpacity:0, lazyLoadZoom:true" id="zoom1" width="530" height="530" onerror="this.src='https://image.thehyundai.com/hdmall/images/pd/no_image_480x480.jpg'">
    						</div>
    					</div>
    					<div class="prd-info-box">
    						<div class="prd-title">
    							<div class="prd-logo">
    								<img src="https://image.thehyundai.com/hdmall/images/specialshop/A002018_prd.jpg" alt="CHANEL">
    							</div>
    							<h2>
    								샤넬 레 조 드 샤넬 파리-파리 오 드 뚜왈렛 50ml
    							</h2>
    						</div>
    						<div class="prd-price-info-wrap">

    									<h3 class="blind">혜택가격정보</h3>
    									<div class="item">
    										<div class="txt"><span>판매가</span></div>
    										<div class="info">
    											<div class="price">
    												137,000
    												<span>원</span>
    											</div>
    										</div>
    									</div>
    							<div class="item last">
    								<div class="txt">상품코드</div>
    								<div class="info">40A1687835</div>
    							</div>
    						</div>
    						<form id="itemInfForm" name="itemInfForm" action="#" method="post">
    						</form>

    						<!-- 간편선택 move 영역 -->
    						<div class="option-floating-case">
    							<div class="option-floating" id="option-floating">
    								<div class="option-floating-btn">
    									<a href="#" class="btn-opt-toggle">간편 옵션선택</a>
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
    																<a href="javascript://" onclick="minusOrdQtyForNoUitm(this);" class="cnt-up">－</a>
    																<input type="text" name="ordQty" onkeyup="changeOrdQtyBasic(this);" value="1" maxlength="4" maxval="2" title="inputarea">
    																<input type="hidden" name="sellPossQty" value="4" title="inputarea">
    																<a href="#tooltip-sameopt-1" class="cnt-down tooltip" onclick="plusOrdQtyForNoUitm(this, 2);">＋</a>
    															</div>
    															<p class="price">137,000<span>원</span></p>
    														</div>
    													</li>
    										</ul>
    												<div class="sumprice">합계 <em id="totItemPrcSpan">137,000</em>원</div>
    									</div>

    								</div>
    								<form id="itemCalcForm" name="itemCalcForm" action="#" method="post">
    									<div class="btn-wrap prd-btn">
    											<div class="optinalbtn">
    											 <div class="optinalbtn-box">
                                                                   <a href="javascript:;" onclick="sendEcommerceSet('Checkout', 'checkout'); buyDirectGift();"><i class="icon gift"></i><span>선물하기</span><i class="icon-arrow right-arrow"></i></a>
                                                                </div>
    											</div>
    											<div class="mainbtn type1">
    													<button class="btn size6 color4" type="button" onclick="GA_Event('PC_상품상세', '찜', '샤넬 레 조 드 샤넬 파리-파리 오 드 뚜왈렛 50ml'); zzim('40A1687835', event, this)">찜</button>
    								                   			<button class="btn size6 color4" type="button" onclick="sendEcommerceSet('Add to Cart', 'add', '장바구니'); addCart(this);">장바구니</button>
    			                  									<span class="type-share-box">
    																	<button class="btn size6 color4 type-share"><span class="ico">공유</span></button>
    																	<span class="tooltip-share" style="display: none;">
    																		<span class="head">SHARING-POP_IN</span>
    																		<span class="sns-wrap">
    																			<a href="javascript://" onclick="goFacebook();"><i class="icon-sns facebook">페이스북 공유</i></a>
    																			<a href="javascript://" onclick="goKakaoStroy();"><i class="icon-sns kakaostory">카카오스토리 공유</i></a>
    																			<a href="javascript://" onclick="goTwitter();"><i class="icon-sns twitter">트위터 공유</i></a>
    																			<a href="javascript://" onclick="copyShortenUrl('40A1687835');"><i class="icon-sns url">단축URL 복사</i></a>
    																		</span>
    																		<span class="tooltip-arrow"></span>
    																	</span>
    																</span>
    			                  									<button class="btn size6 color9" type="button" onclick="sendEcommerceSet('Checkout', 'checkout', '바로구매'); setIsGiftN(); buyDirect();">바로구매</button>
    														<input type="hidden" name="buyYn" value="Y">
    											</div>
    											<div class="description text-left">
    											</div>
    									</div>
    								</form>
    							</div>
    						</div>
    					</div>
    				</div>
</div>
<h3>${productDetail}</h3>
  <%-- 푸터 포함 --%>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>
</body>
</html>
