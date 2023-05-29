<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page session="false" %>
            <html>

            <head>
                <title>Home</title>
                <style type="text/css">
                    @import url("/chat2mingle/resources/css/global/header.css");
                </style>
            </head>

            <body>
                <header>
                    <div class="top-wrap main">
                        <div class="top-area-setting">
                            <div class="top-con">
                                <div class="top-con-logo">
                                    <h1><a href=""><span class="blind"></span></a></h1>
                                    <button class="gf-dropdown-btn"><span></span></button>
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
                                                    class="blind"></span></button>
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
                                                <a href="장바구니로 이동">장바구니</a><span
                                                    class="basket-num" id="quick_baskt_num"></span></div>
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
                                        <li>
                                            <a href="해당주소로이동" class="">|||</a>
                                        </li>
                                        <li> <a href="해당주소로이동" class="">Gift</a></li>
                                        <li> <a href="해당주소로이동" class="">New</a></li>
                                        <li> <a href="해당주소로이동" class="">Store In</a></li>
                                        <li> <a href="해당주소로이동" class="">Show-Room</a></li>
                                        <li> <a href="해당주소로이동" class="">Re.Green</a></li>
                                        <li> <a href="해당주소로이동" class="">Event</a></li>
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