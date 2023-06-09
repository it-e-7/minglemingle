<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>

<html>

<head>
    <title>Home</title>
    <style type="text/css">
        @import url("${pageContext.request.contextPath}/resources/css/global/header.css");
        @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
        @import url("${pageContext.request.contextPath}/resources/css/home/home.css");
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global/jquery-3.6.4.min.js"></script>
</head>

<body>
<header>
    <div class="top-wrap main">
        <div class="top-area-setting">
            <div class="top-con">
                <div class="top-con-logo">
                    <h1>
                        <a href="/"><span class="blind"></span></a>
                    </h1>
                    <button class="gf-dropdown-btn">
                        <span></span>
                    </button>
                </div>
                <div class="top-con-search">
                    <input type="hidden" name="searchtype" id="js_searchtype">
                    <input type="hidden" name="searchQuery" autocomplete="off">
                    <div class="top-con-search-unit">
                        <input type="text" class="top-con-search-input" maxlength="30"
                               id="cs-token-input" value="">
                        <button type="submit" class="top-con-search-btn">
                            <span class="blind"></span>
                        </button>
                    </div>
                </div>
                <div class="top-con-quick">

                    <ul>
                        <li class="myshop-info">
                            <c:choose>
                                <c:when test="${member==null}">
                                    <div class="top-con-quick-my">
                                        <a href="/member/login">로그인</a>
                                    </div>
                                </c:when>
                                <c:when test="${member!=null}">
                                    <div class="top-con-quick-my">
                                        <a href="/member/logout">로그아웃</a>
                                    </div>
                                </c:when>
                            </c:choose>

                        </li>
                        <li class="user-info">
                            <div class="top-con-quick-user">
                                <a href="고객센터로 이동">고객센터</a>
                            </div>
                        </li>
                        <li>
                            <div class="top-con-quick-basket">
                                <a id="get-wishlist">
                                    위시리스트
                                </a>
                            </div>
                        </li>
                        <li class="user-quick-login">
                            <div class="top-con-quick-login">
                                <a class="chat-text" href="javascript:void(0)"
                                   onclick="openChatWindow('/chattingList', 500, 400)">
                                    채팅바로이동
                                    <span class="chat-background"></span>
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="top-nav" id="header-area">
                <div class="top-nav-area2">
                    <ul>
                        <li onmouseover="showBanner()"><a class="nav-menu" id="banner-button"></a>
                            <div class="in-depth-area type-category" id="in-depth-banner"
                                 onmouseout="hideBanner()">
                                <ul>
                                    <li onmouseover="showLeftBarCosmetic()"><a
                                            href="/product/home">화장품</a>
                                        <div class="in-cate-area cosmetic">
                                            <div class="menu">
                                                <ul>
                                                    <li><a >스킨케어</li>
                                                    <li><a >메이크업</li>
                                                    <li><a >바디/헤어케어</li>
                                                    <li><a >기능성케어</li>
                                                    <li><a >향수/캔들</li>
                                                    <li><a >미용기기/용품</li>
                                                    <li><a >남성화장품</li>
                                                    <li><a >BrandSHOP</li>
                                                </ul>
                                            </div>

                                            <div class="brand">
                                                <ul>
                                                    <li id="first-child-menu"><a
                                                            >Other
                                                        Stories</li>
                                                    <li><a >BEAUTY</li>
                                                    <li><a >Dior</li>
                                                    <li><a >아모레퍼시픽</li>
                                                    <li><a >SISLEY</li>
                                                    <li><a >LOCCITANE</li>
                                                    <li><a >CREED</li>
                                                    <li><a >Hermès</li>
                                                    <li><a >TOM</li>
                                                    <li><a >GUCCI</li>
                                                    <li><a >LANCOME</li>
                                                    <li><a >GUERLAIN</li>
                                                    <li><a >GIVENCHY</li>
                                                    <li><a >CLARINS</li>
                                                    <li><a >LA</li>
                                                    <li><a >VALMONT</li>
                                                    <li><a >Oera</li>
                                                    <li><a >SK-Ⅱ</li>
                                                    <li><a >NARS</li>
                                                    <li><a >메종</li>
                                                    <li><a >리바이리</li>
                                                </ul>
                                            </div>

                                            <div class="banner">
                                                <ul>
                                                    <li><a ></li>
                                                </ul>
                                            </div>

                                        </div>
                                    </li>
                                    <li onmouseover="showLeftBarLuxury()"><a href="#">명품잡화</a>
                                        <div class="in-cate-area luxury">
                                            <div class="menu">
                                                <ul>
                                                    <li><a >핸드백/가방</li>
                                                    <li><a >슈즈</li>
                                                    <li><a >지갑/벨트</li>
                                                    <li><a >시계</li>
                                                    <li><a >액세서리</li>
                                                    <li><a >기타잡화</li>
                                                    <li><a >웨딩밴드 전문관</li>
                                                </ul>
                                            </div>

                                            <div class="brand">
                                                <ul>
                                                    <li><a >Mansion Margiela
                                                    </li>
                                                    <li><a >Mullberry</li>
                                                    <li><a >JIMMY CHOO</li>
                                                    <li><a >GOLDEN GOOSE</li>
                                                    <li><a >TUMI</li>
                                                    <li><a >MONTBLANC</li>
                                                    <li><a >LONGINES</li>
                                                    <li><a >LONGCHANP</li>
                                                    <li><a >루즈앤라운지</li>
                                                    <li><a >덕케</li>
                                                    <li><a >TOTEME</li>
                                    </li>
                                            </ul>
                                            </div>

                                            <div class="banner">
                                                <ul>
                                                    <li><a ></li>
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
                                <script src="${pageContext.request.contextPath}/resources/js/global/banner-script.js"></script>
                        </li>
                        <li><a class="nav-gift">Gift</a></li>
                        <li><a class="nav-new">New</a></li>
                        <li><a class="nav-store">Store In</a></li>
                        <li><a class="nav-show">Show-Room</a></li>
                        <li><a class="nav-green">Re.Green</a></li>
                        <li><a class="nav-event">Event</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
<script src="${pageContext.request.contextPath}/resources/js/header/header.js"></script>

</html>