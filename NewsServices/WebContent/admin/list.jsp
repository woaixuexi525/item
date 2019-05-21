<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>List</title>

		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			#left {
				background-color: aquamarine;
			}
			
		</style>
	</head>

	<body>
		<div class="container" id="tab">
			<div class="row">
				<div class="col-md-12">
					<table class="table table-bordered">
						<tr>
							<th>编号</th>
							<th>类别</th>
							<th>标题</th>
							<th>副标题</th>
							<th>内容</th>
							<th colspan="2">操作</th>
						</tr>
						<c:forEach items="${pageBean.list}" var="bean">
							<tr>
								<td>${bean.nid}</td>
								<td>${bean.cid}</td>
								<td>${fn:substring(bean.title,1,10)}...</td>
								<td>${fn:substring(bean.digest,1,10)}...</td>
								<td>${fn:substring(bean.body,1,20)}...</td>
								<td><a href="${pageContext.request.contextPath}/newsForwardServlet?nid=${bean.nid}">编辑</a></td>
								<td><a href="${pageContext.request.contextPath}/deleteNewsServlet?nid=${bean.nid}">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<!--分页-->
			<div class="row">
				<div id="fenye" class="col-sm-6 col-sm-offset-4">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							
							<c:if test="${pageBean.currPage != 1}">
								<li>
									<a href="${pageContext.request.contextPath}/newsListServlet?currentPage=${pageBean.currPage - 1}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
							</c:if>
							
							<c:forEach begin="1" end="${pageBean.totalPage}" var="n">
								<c:if test="${pageBean.currPage != n}">
									<li><a href="${pageContext.request.contextPath}/newsListServlet?currentPage=${n}">${n}</a></li>
								</c:if>
							</c:forEach>
							
							<c:if test="${pageBean.currPage != pageBean.totalPage}">
								<li>
									<a href="${pageContext.request.contextPath}/newsListServlet?currentPage=${pageBean.currPage + 1}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</body>

</html>