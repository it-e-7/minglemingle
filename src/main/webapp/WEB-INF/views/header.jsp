<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page session="false" %>
            <html>

            <head>
                <title>Home</title>
            </head>

            <body>
                <header>
                    <div class="top-wrap main">
                        <div class="top-area-setting">
                            <div class="top-con">
                                <div class="top-con-logo">
                                    <h1><a href=""><span class="blind">The HYUNDAI</span></a></h1>
                                </div>
                                <div class="top-con-search">
                                    <form name="formTopSearchPopup" id="formTopSearchPopup" method="get"
                                        action="https://www.thehyundai.com/front/dpo/hdSearch.thd">
                                        <input type="hidden" name="searchtype" id="js_searchtype">
                                        <input type="hidden" name="searchQuery" autocomplete="off">
                                        <div class="top-con-search-unit">
                                            <input type="text" class="top-con-search-input" maxlength="30"
                                                id="cs-token-input" value="" onfocus="return dq_setTextbox(0,event);"
                                                onmousedown="dq_setTextbox(1,event);"
                                                onkeydown="dq_setTextbox(1,event);" autocomplete="off">
                                            <button type="submit" class="top-con-search-btn"
                                                onclick="javascript:GA_Event('PC_공통','헤더_검색','검색'); goTopSearch(); return false;"><span
                                                    class="blind">검색</span></button>
                                        </div>
                                    </form>
                                </div>
                                <div class="top-con-quick">

                                    <ul>
                                        <li class="myshop-info">
                                            <div class="top-con-quick-my">


                                                <a
                                                    href="javascript:GA_Event('PC_공통','헤더_메뉴','로그인/회원'); openLoginPopup();">로그인/회원</a>



                                            </div>

                                            <!-- 20190118 추가 레이어팝업 -->
                                            <div class="myshop-info-layer logout">
                                                <!-- logout:비 로그인 상태, login:로그인 상태 -->
                                                <div class="myshop-cont">
                                                    <ul class="myshop-cont-top">
                                                        <li class="myshop-hyundai"><a
                                                                onclick="GA_Event('PC_공통','헤더_메뉴','마이현대');"
                                                                href="a">마이현대</a>
                                                        </li>
                                                        <li class="myshop-join"><a
                                                                onclick="GA_Event('PC_공통','헤더_메뉴','회원가입');"
                                                                href="a">회원가입</a>
                                                        </li>
                                                        <li class="myshop-logout"><a
                                                                href="javascript:logOut();">로그아웃</a></li>
                                                    </ul>

                                                </div>
                                            </div>
                                            <!-- // 20190118 추가 레이어팝업 -->


                                        </li>
                                        <li>
                                            <div class="top-con-quick-basket"><a
                                                    onclick="GA_Event('PC_공통','헤더_메뉴', '장바구니');"
                                                    href="https://www.thehyundai.com/front/odb/basktList.thd?MainpageGroup=Util&amp;GroupbannerName=GNB_Basket">장바구니</a><span
                                                    class="basket-num" id="quick_baskt_num"></span></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="top-nav">
                                <div class="top-nav-area2"></div>
                            </div>
                            <div class="sky-left sub" id="leftBanner_skyScrpr"></div>
                            <div class="sky-left main" id="leftBanner_skyScrpr"></div>
                            <div class="sky-right"></div>
                            <div class="theme-flag-box"></div>
                        </div>
                    </div>
                </header>
            </body>
            a

            </html>