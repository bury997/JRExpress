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
    	function add() {
			var cName = $("input:eq(0)").val();
			var cPhone = $("input:eq(1)").val();
			var cCard = $("input:eq(2)").val();
			var cPass = $("input:eq(3)").val();
			var sex = $("input:radio:checked").val();
			layer.load();
			$.getJSON("../../addCourier.do","cName="+cName+"&cPhone="+cPhone+"&cCard="+cCard+"&cPass="+cPass+"&sex="+sex,function(data){
				layer.closeAll();
				layer.msg(data.msg)
				if(data.status==0){
					$("input:not(input:button)").val("");
				}
			});
		}
    </script>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-header">添加快递员</div>
                <form class="layui-form layui-card-body" action="">
                  <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                      <input type="text" name="username" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-block">
                      <input type="text" name="phonenumber" required  lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">身份证号码</label>
                    <div class="layui-input-block">
                      <input type="text" name="idcard" required  lay-verify="required" placeholder="请输入身份证号码" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">密码框</label>
                    <div class="layui-input-block">
                      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
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
                      <input type="checkbox" name="switch" lay-skin="switch">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <input onclick="add()" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo" value="立即提交">
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