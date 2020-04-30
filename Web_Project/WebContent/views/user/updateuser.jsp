<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../../assets/css/layui.css">
    <link rel="stylesheet" href="../../assets/css/view.css"/>
    <title></title>
    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript">
    var uPhone = null;
	function find() {
		$("#content").fadeOut(2000);
		layer.load();
		uPhone = $("input:eq(0)").val();
		$.getJSON("../../findUser.do","uPhone="+uPhone,function(data){
			layer.closeAll();
			layer.msg(data.msg);
			if(data.status==0){
				var e = data.data;
				$("#content").fadeIn(2000);
				$("input:eq(2)").val(e.uName);
				$("input:eq(3)").val(e.uPhone);
				$("input:eq(4)").val(e.uPass);
				$("input:radio:checked").val(e.uSex);
			}
		});
	}
	function updateUser() {
		layer.load();
		var uName = $("input:eq(2)").val();
		var newUphone = $("input:eq(3)").val();
		var uPass = $("input:eq(4)").val();
		var uSex = $("input:radio:checked").val();
		$.post("../../updateUser.do","uPhone="+uPhone+"&uName="+uName+"&newUphone="+newUphone+"&uPass="+uPass+"&uSex="+uSex,function(data){
			layer.closeAll();
			layer.msg(data.msg);
			if(data.status==0){
				$("#content").fadeOut(2000);
			}
		},"JSON");
	}
    </script>
</head>
<body class="layui-view-body">
    <div class="layui-content">
    	<div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-header">修改用户</div>
                <form class="layui-form layui-card-body" action="">
                  
                  <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-inline">
                      <input type="text" name="phonenumber" required  lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
                    </div>
                     <div class="layui-input-inline">
                      <input value="立即查找" onclick="find()" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo" type="button">
                    </div>
                  </div>
                </form>  
            </div>
        </div>
        <div class="layui-row" id="content" style="display: none;">
            <div class="layui-card">
                <div class="layui-card-header">查找信息如下</div>
                <form class="layui-form layui-card-body" action="">
                  <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                      <input type="text" name="username" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" value="小泽马老师">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-block">
                      <input type="text" name="phonenumber" required  lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input" value="13888888888">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="123456">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                      <input type="radio" name="sex" value="男" title="男">
                      <input type="radio" name="sex" value="女" title="女" checked>
                    </div>
                  </div>
                   <div class="layui-form-item">
                    <label class="layui-form-label">是否激活</label>
                    <div class="layui-input-block">
                      <input type="checkbox" name="switch" lay-skin="switch" checked>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <input onclick="updateUser()" value="确认修改" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo" type="button">
                      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                  </div>
                </form>  
            </div>
        </div>
    </div>
    <script src="../../assets/layui.all.js"></script>
    <script>
      var form = layui.form
        ,layer = layui.layer;
    </script>
</body>
</html>