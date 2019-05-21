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

		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			#left {
				background-color: aquamarine;
			}
		</style>
	</head>

	<body>

		<!--主体-->
		<div class="container-fluid">
			<form action="${pageContext.request.contextPath }/newsAdd" method="post">
			<div class="row">
				<div class="col-md-10">
					<table class="table table-striped">
						<!--<tr>
							<td>
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1">I  D</span>
									<input type="text" class="form-control"  aria-describedby="sizing-addon1">
								</div>
							</td>
						</tr>-->
						<tr>
							<td>
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1">分类</span>
									<select name="category" class="form-control"  aria-describedby="sizing-addon1">
										<option value="1">焦点</option>
										<option value="2">国内</option>
										<option value="3">国际</option>
										<option value="4">军事</option>
										<option value="5">体育</option>
										<option value="6">科技</option>
										<option value="7">汽车</option>
										<option value="8">财经</option>
										<option value="9">游戏</option>
										<option value="10">女性</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1">标题</span>
									<input type="text" class="form-control" name="title" aria-describedby="sizing-addon1">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1">副标题</span>
									<input type="text" class="form-control" name="digest" aria-describedby="sizing-addon1">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1">来源</span>
									<input type="text" class="form-control" name="source" aria-describedby="sizing-addon1">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<textarea style="width: 100%;" name="content" class="form-control" rows="20"></textarea>
							</td>
						</tr>
					</table>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-4 col-md-offset-3">
					<input type="submit" class="btn btn-primary btn-lg btn-block" value="确定"/>
				</div>
			</div>
			</form>
		</div>
	</body>

</html>