<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>

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
                            <c:choose>
                                <c:when test="${member==null}">
                                    <div class="top-con-quick-my">
                                        <a href="/chat2mingle/member/login">로그인/회원</a>
                                    </div>
                                </c:when>
                                <c:when test="${member!=null}">
                                    <div class="top-con-quick-my">
                                        <a href="/chat2mingle/member/logout">로그아웃</a>
                                    </div>
                                </c:when>
                            </c:choose>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="top-nav" id="header-area">
                <div class="top-nav-area2">
                    <ul>
                        <li><a href="/chat2mingle/admin/notice" class="nav-gift">공지</a></li>
                        <li><a href="/chat2mingle/admin/reporthistory" class="nav-new">신고</a></li>
                    </ul>
                    <div class="admin-header-container">
                        <h1 class="admin-header">관리페이지</h1>
                    </div>
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