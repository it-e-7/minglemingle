<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>

<head>
<title>Home</title>
<style type="text/css">
@import url("/chat2mingle/resources/css/global/header.css");
@import url("/chat2mingle/resources/css/global/common.css");
</style>
</head>

<body>
	<header>
		<div class="top-wrap main">
			<div class="top-area-setting">
				<div class="top-con">
					<div class="top-con-logo">
						<h1>
							<a href=""><span class="blind"></span></a>
						</h1>
						<button class="gf-dropdown-btn">
							<span></span>
						</button>
					</div>
					<div class="top-con-search">
						<form name="formTopSearchPopup" id="formTopSearchPopup"
							method="get"
							action="https://www.thehyundai.com/front/dpo/hdSearch.thd">
							<input type="hidden" name="searchtype" id="js_searchtype">
							<input type="hidden" name="searchQuery" autocomplete="off">
							<div class="top-con-search-unit">
								<input type="text" class="top-con-search-input" maxlength="30"
									id="cs-token-input" value=""
									onfocus="return dq_setTextbox(0,event);"
									onmousedown="dq_setTextbox(1,event);"
									onkeydown="dq_setTextbox(1,event);" autocomplete="off">
								<button type="submit" class="top-con-search-btn"
									onclick="javascript:GA_Event('PC_공통','헤더_검색','검색'); goTopSearch(); return false;">
									<span class="blind"></span>
								</button>
							</div>
						</form>
					</div>
					<div class="top-con-quick">

						<ul>
							<li class="myshop-i nfo">
								<div class="top-con-quick-my">
									<a href="/chat2mingle/member/login">로그인/회원</a>
								</div>
							</li>
							<li class="user-info">
								<div class="top-con-quick-user">
									<a href="고객센터로 이동">고객센터</a>
								</div>
							</li>
							<li>
								<div class="top-con-quick-basket">
									<a href="장바구니로 이동">장바구니</a><span class="basket-num"
										id="quick_baskt_num"></span>
								</div>
							</li>
							<li class="user-quick-login">
								<div class="top-con-quick-login">
									<a href="바로접속으로 이동">바로접속</a>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="top-nav" id="header-area">
					<div class="top-nav-area2">
						<ul>
							<li onmouseover="showBanner()"><a class="nav-menu"
								id="banner-button"></a>
								<div class="in-depth-area type-category" id="in-depth-banner"
									onmouseout="hideBanner()">
									<ul>
										<li onmouseover="showLeftBarCosmetic()"><a
											href="/chat2mingle/product">화장품</a>
											<div class="in-cate-area cosmetic">
												<div class="menu">
													<ul>
														<li><a onclick="이동해야하는 세부 탭으로">스킨케어 </li>
														<li><a onclick="이동해야하는 세부 탭으로">메이크업 </li>
														<li><a onclick="이동해야하는 세부 탭으로">바디/헤어케어 </li>
														<li><a onclick="이동해야하는 세부 탭으로">기능성케어 </li>
														<li><a onclick="이동해야하는 세부 탭으로">향수/캔들 </li>
														<li><a onclick="이동해야하는 세부 탭으로">미용기기/용품 </li>
														<li><a onclick="이동해야하는 세부 탭으로">남성화장품 </li>
														<li><a onclick="이동해야하는 세부 탭으로">BrandSHOP </li>
													</ul>
												</div>

												<div class="brand">
													<ul>
														<li id="first-child-menu"><a onclick="이동해야하는 세부 탭으로">Other
																Stories </li>
														<li><a onclick="이동해야하는 세부 탭으로">BEAUTY </li>
														<li><a onclick="이동해야하는 세부 탭으로">Dior </li>
														<li><a onclick="이동해야하는 세부 탭으로">아모레퍼시픽 </li>
														<li><a onclick="이동해야하는 세부 탭으로">SISLEY </li>
														<li><a onclick="이동해야하는 세부 탭으로">LOCCITANE </li>
														<li><a onclick="이동해야하는 세부 탭으로">CREED </li>
														<li><a onclick="이동해야하는 세부 탭으로">Hermès </li>
														<li><a onclick="이동해야하는 세부 탭으로">TOM </li>
														<li><a onclick="이동해야하는 세부 탭으로">GUCCI </li>
														<li><a onclick="이동해야하는 세부 탭으로">LANCOME </li>
														<li><a onclick="이동해야하는 세부 탭으로">GUERLAIN </li>
														<li><a onclick="이동해야하는 세부 탭으로">GIVENCHY </li>
														<li><a onclick="이동해야하는 세부 탭으로">CLARINS </li>
														<li><a onclick="이동해야하는 세부 탭으로">LA </li>
														<li><a onclick="이동해야하는 세부 탭으로">VALMONT </li>
														<li><a onclick="이동해야하는 세부 탭으로">Oera </li>
														<li><a onclick="이동해야하는 세부 탭으로">SK-Ⅱ </li>
														<li><a onclick="이동해야하는 세부 탭으로">NARS </li>
														<li><a onclick="이동해야하는 세부 탭으로">메종 </li>
														<li><a onclick="이동해야하는 세부 탭으로">리바이리 </li>
													</ul>
												</div>

												<div class="banner">
													<ul>
														<li><a onclick="이동해야하는 세부 탭으로"></li>
													</ul>
												</div>

											</div></li>
										<li onmouseover="showLeftBarLuxury()"><a href="#">명품잡화</a>
											<div class="in-cate-area luxury">
												<div class="menu">
													<ul>
														<li><a onclick="이동해야하는 세부 탭으로">핸드백/가방 </li>
														<li><a onclick="이동해야하는 세부 탭으로">슈즈 </li>
														<li><a onclick="이동해야하는 세부 탭으로">지갑/벨트 </li>
														<li><a onclick="이동해야하는 세부 탭으로">시계 </li>
														<li><a onclick="이동해야하는 세부 탭으로">액세서리 </li>
														<li><a onclick="이동해야하는 세부 탭으로">기타잡화 </li>
														<li><a onclick="이동해야하는 세부 탭으로">웨딩밴드 전문관 </li>
													</ul>
												</div>

												<div class="brand">
													<ul>
														<li><a onclick="이동해야하는 세부 탭으로">Mansion Margiela </li>
														<li><a onclick="이동해야하는 세부 탭으로">Mullberry </li>
														<li><a onclick="이동해야하는 세부 탭으로">JIMMY CHOO </li>
														<li><a onclick="이동해야하는 세부 탭으로">GOLDEN GOOSE </li>
														<li><a onclick="이동해야하는 세부 탭으로">TUMI </li>
														<li><a onclick="이동해야하는 세부 탭으로">MONTBLANC </li>
														<li><a onclick="이동해야하는 세부 탭으로">LONGINES </li>
														<li><a onclick="이동해야하는 세부 탭으로">LONGCHANP </li>
														<li><a onclick="이동해야하는 세부 탭으로">루즈앤라운지 </li>
														<li><a onclick="이동해야하는 세부 탭으로">덕케 </li>
														<li><a onclick="이동해야하는 세부 탭으로">TOTEME </li></li>
										<li><a onclick="이동해야하는 세부 탭으로">메터스 </li>
									</ul>
								</div>

								<div class="banner">
									<ul>
										<li><a onclick="이동해야하는 세부 탭으로"></li>
									</ul>
								</div>
					</div>
					</li>
					<li><a href="#">여성패션</a></li>
					<li><a href="#">영캐주얼</a></li>
					<li><a href="#">남성패션</a></li>
					<li><a href="#">진/이지</a></li>
					<li><a href="#">유아동/문화</a></li>
					<li><a href="#">스포츠/레저</a></li>
					<li><a href="#">리빙/가전</a></li>
					<li><a href="#">식품</a></li>
					<li><a href="#">반려동물</a></li>
					</ul>
					<script src="/chat2mingle/resources/js/banner-script.js"></script>
					</li>
					<li><a href="해당주소로이동" class="nav-gift">Gift</a></li>
					<li><a href="해당주소로이동" class="nav-new">New</a></li>
					<li><a href="해당주소로이동" class="nav-store">Store In</a></li>
					<li><a href="해당주소로이동" class="nav-show">Show-Room</a></li>
					<li><a href="해당주소로이동" class="nav-green">Re.Green</a></li>
					<li><a href="해당주소로이동" class="nav-event">Event</a></li>
					</ul>
				</div>
			</div>
			<div class="sky-left sub" id="leftBanner_skyScrpr"></div>
			<div class="sky-left main" id="leftBanner_skyScrpr"></div>
			<div class="sky-right"></div>
			<div class="theme-flag-box"></div>
		</div>
		</div>
	</header>
</body>

</html>