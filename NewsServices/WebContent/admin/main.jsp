<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>主页</title>

		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			#head {
				height: 50px;
				background-color: gainsboro;
				margin-bottom: 10px;
				font-size: larger;
			}
			#exit {
				margin-top: 10px;
			}
			#right{
				height:1000px;
			}
			
			li p {
				size: b5;
			}
		</style>
	</head>

	<body>
		<!--导航-->
		<div id="head" class="row">
			<div id="exit" class="col-md-1 col-md-offset-10">
				<a href="${pageContext.request.contextPath}/userExitServlet"><button type="button" class="btn btn-info">退出</button></a>
			</div>
		</div>

		<!--主体-->
		<div class="container-fluid">
			<div class="row">
				<!--左面-->
				<div id="left" class="col-md-2">
					<ul class="list-group">
						<li class="list-group-item list-group-item-success">
							<a href="${pageContext.request.contextPath}/newsListServlet?currentPage=1" target="text_right">
								<p>主页</p>
							</a>
						</li>
						<li class="list-group-item list-group-item-info">
							<a href="${pageContext.request.contextPath}/admin/add.jsp" target="text_right">添加</a>
						</li>
						<li class="list-group-item list-group-item-warning">Porta ac consectetur ac</li>
						<li class="list-group-item list-group-item-danger">Vestibulum at eros</li>
					</ul>
				</div>
				<!--右面-->
				<div id="right" class="col-md-10 ">
					<iframe name="text_right" style="overflow:visible;" scrolling="no" frameborder="no" width="100%" height="100%;" src="${pageContext.request.contextPath}/img/bg.png" >
					</iframe>
				</div>
			</div>
		</div>
	</body>

</html>