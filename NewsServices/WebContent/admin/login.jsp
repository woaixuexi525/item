<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登陆</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body{
			background-color: #FFFFCC;
		}
		#c{
			margin-top: 300px;
		}
		#u{
	
			margin-bottom: 20px;
		}
		#p{
			margin-bottom: 50px;
		}
		/*#a{
			border-style: solid;
			border-width: 2px;
			border-color: burlywood;
		}
		#ac{
			border-style: solid;
			border-width: 2px;
			border-color: burlywood;
		}
		#can{
			border-style: solid;
			border-width: 2px;
			border-color: burlywood;
		}*/
	</style>
    
  </head>
  <body>
    <div class="container" id="c">
    	<form action="${pageContext.request.contextPath}/userLogin" method="post"> 
	    	<div class="row">
	    		<div class="row" id="u">
	    			<div class="col-md-2 col-md-offset-5">
	    				  <input class="form-control" required="required" name="name" type="text" id="formGroupInputLarge" placeholder="用户账户">
	    			</div>
	    		</div>
	    		<div class="row" id="p">
	    			<div class="col-md-2 col-md-offset-5">
	    				<input class="form-control" required="required"  type="password" name="passwd" id="formGroupInputLarge" placeholder="用户密码">
	    			</div>
	    		</div>
	    		<div class="row" id="a">
	    			<div class="col-md-2 col-md-offset-4" id="ac">
	    				<button type="submit" class="btn btn-primary btn-lg">登陆</button>
	    			</div>
	    			<div class="col-md-2 col-md-offset-1" id="can">
	    				<a href="#"><button type="button" class="btn btn-primary btn-lg">取消</button></a>
	    			</div>
	    		</div>
	    	</div>
    	</form>
    </div>
  </body>
</html>
