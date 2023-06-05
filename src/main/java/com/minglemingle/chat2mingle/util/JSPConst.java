package com.minglemingle.chat2mingle.util;

import java.util.HashMap;
import java.util.LinkedHashMap;

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
    public static final HashMap <String, String> CATEGORY_TITLES;

    static {
        CATEGORY_TITLES = new LinkedHashMap<>();
        CATEGORY_TITLES.put("화장품", "화장품 브랜드 유아른을 아시나요?");
        CATEGORY_TITLES.put("명품잡화", "2023 패션 트렌드 키워드, 데님 포켓!");
        CATEGORY_TITLES.put("여성패션", "시크 패미닌 VS 센슈얼 어떤 감성이 좋으신가요?");
        CATEGORY_TITLES.put("영캐주얼", "아버지를 위한 선물, 이제는 제가 드릴게요");
        CATEGORY_TITLES.put("남성패션", "이번주 주말, 캠핑을 위한 패션으로 뭘 입을까요?");
        CATEGORY_TITLES.put("진/이지", "우리 아이를 위한 옷을 고를 떄 가장 중요하게 생각하는 기준은?");
        CATEGORY_TITLES.put("유아동/문화", "일상에서 태어난 아웃도어 VS 자연에서 태어난 아웃도어");
        CATEGORY_TITLES.put("스포츠/레저", "결혼 선물로 꼭 받고싶은 선물은?");
        CATEGORY_TITLES.put("리빙/가전", "부담없이 선물 맏을 수 있는 가격대는 어디까지인가요?");
        CATEGORY_TITLES.put("식품", "내가 가장 좋아하는 명품 브랜드는 무엇인가요?");
        CATEGORY_TITLES.put("반려동물", "부드러운 마약방석 VS 튼튼한 멍멍이 하우스, 우리 아이를 위한 선택은?");
    }
}