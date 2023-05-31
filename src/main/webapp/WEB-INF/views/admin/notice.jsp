<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-05-29
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script
        src="https://code.jquery.com/jquery-3.6.4.min.js"
        integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
        crossorigin="anonymous"
></script>
<body>
<%--    <%@ include file="header.jsp" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/chat2mingle/resources/css/admin/admin.css"/>
</head>
<body>

<form action="/your-action-endpoint" method="post">
    <h2>새로운 공지</h2>
    <div class="notice-container">
        <h3><label for="text-input">공지</label></h3>
        <input type="text" id="text-input" name="textInput" />
    </div>

    <div class="category-container">
        <h3>카테고리</h3>
        <div class="category-columns">
            <div class="category-column-1">
                <div>
                    <input
                            type="checkbox"
                            id="cosmetics"
                            name="cosmetics"
                            value="cosmetics"
                    />
                    <label for="cosmetics">화장품</label>
                </div>
                <div>
                    <input
                            type="checkbox"
                            id="young-casual"
                            name="young-casual"
                            value="young-casual"
                    />
                    <label for="young-casual">영캐주얼</label>
                </div>

                <div>
                    <input
                            type="checkbox"
                            id="children"
                            name="children"
                            value="children"
                    />
                    <label for="children">유아동/문화</label>
                </div>
                <div>
                    <input type="checkbox" id="food" name="food" value="food" />
                    <label for="food">식품</label>
                </div>
            </div>
            <div class="category-column-2">
                <div>
                    <input type="checkbox" id="luxury" name="luxury" value="luxury" />
                    <label for="luxury">명품/잡화</label>
                </div>

                <div>
                    <input
                            type="checkbox"
                            id="mens-fashion"
                            name="mens-fashion"
                            value="mens-fashion"
                    />
                    <label for="mens-fashion">남성패션</label>
                </div>

                <div>
                    <input type="checkbox" id="sports" name="sports" value="sports" />
                    <label for="sports">스포츠/레저</label>
                </div>

                <div>
                    <input type="checkbox" id="pet" name="pet" value="pet" />
                    <label for="pet">반려동물</label>
                </div>
            </div>

            <div class="category-column-2">
                <div>
                    <input
                            type="checkbox"
                            id="womens-fashion"
                            name="womens-fashion"
                            value="womens-fashion"
                    />
                    <label for="womens-fashion">여성패션</label>
                </div>

                <div>
                    <input type="checkbox" id="jean" name="jean" value="jean" />
                    <label for="jean">진/이지</label>
                </div>

                <div>
                    <input
                            type="checkbox"
                            id="electronics"
                            name="electronics"
                            value="electronics"
                    />
                    <label for="electronics">리빙/가전</label>
                </div>

                <div>
                    <input type="checkbox" id="all" name="all" value="all" />
                    <label for="all">모두선택</label>
                </div>
            </div>
        </div>
    </div>

    <div>
        <input id="notice-submit" type="submit" value="Submit" />
    </div>
</form>



<div id="confirmationModal" class="modal fade" tabindex="-1" role="dialog">
    <div id="result"></div>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <p>다음 공지글을 게시하겠습니까?</p>
                <p id="notice-text-preview"></p>
                <ul id="notice-category-preview"></ul>
            </div>
            <div class="modal-footer">
                <button id="confirm-cancel-btn" type="button">취소</button>
                <button id="confirm-accept-btn" type="button">확인</button>
            </div>
        </div>
    </div>
</div>



</body>
<script src="/chat2mingle/resources/js/admin/admin.js" async defer></script>

</html>


<%--    <%@ include file="header.jsp" %>--%>

</body>
</html>
