<%@page import="cn.zjf.Util.FormatUtil"%>
<%@page import="cn.zjf.bean.Express"%>
<%@page import="java.util.List"%>
<%@page import="cn.zjf.service.ExpressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>快递列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../../assets/css/layui.css"  media="all">
</head>
<body>
  
 <script type="text/html" id="barDemo">
 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<table lay-filter="expresslist" id="expresslist">
  <thead>
    <tr>
      <th lay-data="{field:'id', width:80}">编号</th>
      <th lay-data="{field:'eNumber',edit: 'text', width:150}">快递单号</th>
      <th lay-data="{field:'company',edit: 'text', width:100}">快递公司</th>
      <th lay-data="{field:'username',edit: 'text', width:100}">收件人姓名</th>
      <th lay-data="{field:'userphone',edit: 'text', minWidth: 150}">收件人手机号</th>
      <th lay-data="{field:'status', minWidth: 100}">状态</th>
      <th lay-data="{field:'intime', minWidth: 100}">入库时间</th>
      <th lay-data="{field:'outtime', minWidth: 100}">出库时间</th>
      <th lay-data="{field:'code', minWidth: 100}">取件码</th>
      <th lay-data="{field:'inputtime', minWidth: 100}">录入人手机号</th>
      <th lay-data="{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}"></th>
    </tr> 
  </thead>
  <%
  	List<Express> data = ExpressService.findAll();
  %>
  <tbody>
    <%
    	for(Express e:data){
    		%>
    <tr>
    	<td><%=e.getId() %></td>
    	<td><%=e.geteNumber() %></td>
    	<td><%=e.getCompany() %></td>
    	<td><%=e.getUserName() %></td>
    	<td><%=e.getUserPhone() %></td>
    	<td><%=e.getStatus()==0?"未取件":"已取件" %></td>
    	<td><%=FormatUtil.sdf1.format(e.getInTime()) %></td>
    	<td><%=e.getOutTime()==null?"暂未取件":FormatUtil.sdf1.format(e.getOutTime()) %></td>
    	<td><%=e.getCode()==0?"已取件":e.getCode() %></td>
    	<td><%=e.getInputPhone() %></td>
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
  table.init('expresslist', { //转化静态表格
      //height: 'full-500'
   }); 
  
//监听单元格编辑
  table.on('edit(expresslist)', function(obj){
    var value = obj.value //得到修改后的值
    ,data = obj.data //得到所在行所有键值
    ,field = obj.field; //得到字段
    layer.msg('[ID: '+ data.username +'] ' + field + ' 字段更改为：'+ value);
  });
  
//监听状态操作
  form.on('switch(statusDemo)', function(obj){
    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
  });
 
//监听工具条
  table.on('tool(expresslist)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	  layer.load();
    	  $.getJSON("../../expressDelete.do","eNumber="+data.eNumber,function(data){
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