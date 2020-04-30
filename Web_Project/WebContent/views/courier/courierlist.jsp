<%@page import="cn.zjf.service.CourierService"%>
<%@page import="cn.zjf.bean.Courier"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>快递员列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../../assets/css/layui.css"  media="all">
</head>
<body>
  
 <script type="text/html" id="barDemo">
 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<table lay-filter="courierlist" id="courierlist">
  <thead>
    <tr>
      <th lay-data="{field:'id', width:80}">编号</th>
      <th lay-data="{field:'cname',edit: 'text', width:100}">姓名</th>
      <th lay-data="{field:'cphone',edit: 'text', minWidth: 200}">手机号码</th>
      <th lay-data="{field:'ccard',edit: 'text', minWidth: 200}">身份证</th>
      <th lay-data="{field:'cpass',edit: 'text', width:200}">密码</th>
      <th lay-data="{field:'csex', minWidth: 100}">性别</th>
      <th lay-data="{field:'active', minWidth: 100}">是否激活</th>
      <th lay-data="{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}"></th>
    </tr> 
  </thead>
  <%
  	List<Courier> data = CourierService.findAll();
  %>
  <tbody>
	<%
		for(Courier c:data){
			%>
	<tr>
		<td><%=c.getId() %></td>
		<td><%=c.getcName() %></td>
		<td><%=c.getcPhone() %></td>
		<td><%=c.getcCard() %></td>
		<td><%=c.getPass() %></td>
		<td><%=c.getSex() %></td>
		<td><%=c.getActive()==0?"否":"是" %></td>
	</tr>		
			<%
		}
	%>
  </tbody>
</table>
               
          
<script src="../../assets/layui.js" charset="utf-8"></script>
<script>
layui.use('table', function(){
  var table = layui.table,form = layui.form;;
  table.init('courierlist', { //转化静态表格
      //height: 'full-500'
   }); 
  
//监听单元格编辑
  table.on('edit(courierlist)', function(obj){
    var value = obj.value //得到修改后的值
    ,data = obj.data //得到所在行所有键值
    ,field = obj.field; //得到字段
    layer.msg('[ID: '+ data.username +'] ' + field + ' 字段更改为：'+ value);
  });
  //监听性别操作
  form.on('switch(sexDemo)', function(obj){
    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
  });
  
  //监听锁定操作
  form.on('checkbox(lockDemo)', function(obj){
    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
  });
//监听工具条
  table.on('tool(courierlist)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        layer.load();
        $.getJSON("../../courierDelete.do","cPhone="+data.cPhone,function(data){
        	layer.closeAll();
   			layer.msg(data.msg);
   			if(data.status==0){
   				obj.del();
   			}
        });
      });
    }
  });
});


</script>

</body>
</html>