package com.minglemingle.chat2mingle.util;

/**
 * JSP 상수를 정의한 클래스
 * 페이지의 콘텐츠 유형과 JSTL 태그 라이브러리에 대한 상수를 포함합니다.
 * @version : 1.0.0
 * @author : noino
 * @see : PAGE_CONTENT_TYPE UTF8을 지원합니다
 * @see : JSTL_C JSTL라이브러를 지원합니다
 */
public class JSPConst {
    public static final String PAGE_CONTENT_TYPE = "text/html; charset=UTF-8";
    public static final String PAGE_CHARACTER_ENCODING = "UTF-8";
    public static final String JSTL_C = "<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>";
}