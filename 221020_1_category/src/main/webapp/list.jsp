<%@page import="com.tjoeun.vo.CategoryList"%>
<%@page import="com.tjoeun.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>리스트</title>
<link rel="stylesheet" href="./css/css.css">
<script type="text/javascript" src="./js/category.js" defer></script>
</head>

<%
	// 테이블에 저장된 전체 카테고리 목록을 얻어와서 CategoryList 클래스의 ArrayList에 저장한 후 CategoryList 클래스 객체를 Request 영역에 저장해서 카테고리 목록을 출력하는 페이지(category.jsp)로 넘겨준다.
	CategoryList categoryList = CategoryService.getInstance().selectList();
	request.setAttribute("categoryList", categoryList);
	pageContext.forward("category.jsp");
%>
	
</body>
</html>
























