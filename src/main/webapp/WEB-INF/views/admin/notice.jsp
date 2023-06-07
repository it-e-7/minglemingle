<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-05-29
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>공지</title>
</head>
<style>
    @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
    @import url("${pageContext.request.contextPath}/resources/css/global/modal.css");
    @import url("${pageContext.request.contextPath}/resources/css/report/notice.css");

</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global/jquery-3.6.4.min.js"></script>
<body>
<%@ include file="/WEB-INF/views/global/adminHeader.jsp" %>
<div id="confirmation-modal" class="modal">
    <div class="modal-content">
        <p>다음 공지글을 게시하겠습니까?</p><br>
        <p id="notice-text-preview"></p>
        <hr>
        <div id="notice-category-preview"></div>
        <div class="modal-buttons">
            <button id="confirm-cancel-btn" class="modal-button" type="button">취소</button>
            <button id="confirm-accept-btn" class="modal-button" type="button">확인</button>
        </div>
    </div>
</div>
<div id="notice">
    <%--    <div class="overlay">--%>
    <form id="notice-form" action="" method="post">
        <div class="notice-h2">
            <h2>새로운 공지</h2>
        </div>
        <div class="notice-container">
            <h3 class="notice-h3"><label for="text-input">공지</label></h3>
            <textarea id="text-input" rows="5" required="true" autofocus="true" maxlength="100"
                      name="textInput"></textarea>
        </div>

        <div class="category-container">
            <h3 class="notice-h3">카테고리</h3>
            <div class="category-columns">
                <div class="category-column-row">
                    <div>
                        <input
                                type="checkbox"
                                id="cosmetics"
                                name="cosmetics"
                                value="cosmetics"
                                class="category-checkbox"
                        />
                        <label for="cosmetics">화장품</label>
                    </div>
                    <div>
                        <input
                                type="checkbox"
                                id="young-casual"
                                name="young-casual"
                                value="young-casual"
                                class="category-checkbox"

                        />
                        <label for="young-casual">영캐주얼</label>
                    </div>

                    <div>
                        <input
                                type="checkbox"
                                id="children"
                                name="children"
                                value="children"
                                class="category-checkbox"

                        />
                        <label for="children">유아동/문화</label>
                    </div>
                    <div>
                        <input type="checkbox" id="food" name="food" value="food" class="category-checkbox"/>
                        <label for="food">식품</label>
                    </div>
                </div>
                <div class="category-column-row">
                    <div>
                        <input type="checkbox" id="luxury" name="luxury" value="luxury" class="category-checkbox"/>
                        <label for="luxury">명품/잡화</label>
                    </div>

                    <div>
                        <input
                                type="checkbox"
                                id="mens-fashion"
                                name="mens-fashion"
                                value="mens-fashion"
                                class="category-checkbox"
                        />
                        <label for="mens-fashion">남성패션</label>
                    </div>

                    <div>
                        <input type="checkbox" id="sports" name="sports" value="sports" class="category-checkbox"/>
                        <label for="sports">스포츠/레저</label>
                    </div>

                    <div>
                        <input type="checkbox" id="pet" name="pet" value="pet" class="category-checkbox"/>
                        <label for="pet">반려동물</label>
                    </div>
                </div>

                <div class="category-column-row">
                    <div>
                        <input
                                type="checkbox"
                                id="womens-fashion"
                                name="womens-fashion"
                                value="womens-fashion"
                                class="category-checkbox"
                        />
                        <label for="womens-fashion">여성패션</label>
                    </div>

                    <div>
                        <input type="checkbox" id="jean" name="jean" value="jean" class="category-checkbox"/>
                        <label for="jean">진/이지</label>
                    </div>

                    <div>
                        <input
                                type="checkbox"
                                id="electronics"
                                name="electronics"
                                value="electronics"
                                class="category-checkbox"
                        />
                        <label for="electronics">리빙/가전</label>
                    </div>

                    <div>
                        <input type="checkbox" id="all" name="all" value="all" class="category-checkbox"/>
                        <label for="all">모두선택</label>
                    </div>
                </div>
            </div>
        </div>

        <div id="submit-container">
            <input class="report-btn" type="submit" value="확인"/>
        </div>
    </form>



<%--        <div id="myModal" class="modal">--%>
<%--            <div class="modal-content">--%>
<%--                <p>정말 신고하시겠습니까?</p>--%>
<%--                <div class="modal-buttons">--%>
<%--                    <button class="modal-button" id="confirmButton">확인</button>--%>
<%--                    <button class="modal-button cancel" id="cancelButton">취소</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>



    <%@ include file="/WEB-INF/views/global/footer.jsp" %>
</div>
<%--</div>--%>



</body>
<script src="/resources/js/admin/admin.js"></script>

</html>
