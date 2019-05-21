<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>update</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
#left {
	background-color: aquamarine;
}
</style>
</head>

<body>

	<!--主体-->
	<div class="container" id="body">
		<form action="${pageContext.request.contextPath}/updateNewsServlet"
			method="post">
				<div class="row">
					<div class="col-md-10">
						<table class="table table-striped">
							<tr>
								<td>
									<div class="input-group input-group-lg">
										<span class="input-group-addon" id="sizing-addon1">I D</span> <input
											type="text" value="${news.nid}" name="nid" class="form-control"
											name="id" aria-describedby="sizing-addon1">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="input-group input-group-lg">
										<span class="input-group-addon" id="sizing-addon1">类别</span> <input
											type="text" value="${news.cid}" class="form-control"
											name="category" aria-describedby="sizing-addon1">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="input-group input-group-lg">
										<span class="input-group-addon" id="sizing-addon1">标题</span> <input
											type="text" value="${news.title}" name="title"
											class="form-control" name="title"
											aria-describedby="sizing-addon1">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="input-group input-group-lg">
										<span class="input-group-addon" id="sizing-addon1">副标题</span> <input
											type="text" value="${news.digest}" name="digest"
											class="form-control" name="digest"
											aria-describedby="sizing-addon1">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="input-group input-group-lg">
										<span class="input-group-addon" id="sizing-addon1">来源</span> <input
											type="text" value="${news.source}" name="source"
											class="form-control" name="digest"
											aria-describedby="sizing-addon1">
									</div>
								</td>
							</tr>
							<tr>
								<td><textarea style="width: 100%;" name="content"
										class="form-control" rows="20">${news.body}</textarea></td>
							</tr>
						</table>
					</div>
				</div>

			<div class="row">
				<div class="col-xs-4 col-xs-offset-4">
					<p>
						<input type="submit" class="btn btn-primary btn-lg" value="提交"/>
					</p>
				</div>
			</div>
		</form>
	</div>
</body>

</html>