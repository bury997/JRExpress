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
    	var cPhone = null;
    	function findCourier() {
			$("#content").fadeOut(2000);
    		layer.load();
    		cPhone = $("input:eq(0)").val();
    		$.getJSON("../../findCourier.do","cPhone="+cPhone,function(data){
    			layer.closeAll();
    			layer.msg(data.msg);
    			if(data.status==0){
    				$("#content").fadeIn(2000);
    				var e = data.data;
    				$("input:eq(2)").val(e.cName);
    				$("input:eq(3)").val(e.cPhone);
    				$("input:eq(4)").val(e.cCard);
    				$("input:eq(5)").val(e.pass);
    				$("input:eq(6)").val(e.sex);
    				$("input").attr("disabled","disabled");
    			}
    		});
		}
    	
    	function deleteCourier() {
			layer.load();
			$.getJSON("../../courierDelete.do","cPhone="+cPhone,function(data){
				layer.closeAll();
				layer.msg(data.msg);
				if(data.status==0){
					$("#content").fadeOut(2000);
				}
			});
		}
    	
    </script>
</head>
<body class="layui-view-body">
    <div class="layui-content">
    	<div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-header">删除快递员</div>
                <form class="layui-form layui-card-body" action="">
                  
                  <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-inline">
                      <input type="text" name="phonenumber" required  lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
                    </div>
                     <div class="layui-input-inline">
                      <input onclick="findCourier()" type="button" value="立即查找" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo">
                    </div>
                  </div>
                </form>  
            </div>
        </div>
        <div class="layui-row" id="content" style="display:none;">
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
                    <label class="layui-form-label">身份证号码</label>
                    <div class="layui-input-block">
                      <input type="text" name="idcard" required  lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input" value="412727200011118888">
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
                      <input onclick="deleteCourier()" value="确认删除"  type="button" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo">
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