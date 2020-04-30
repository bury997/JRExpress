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
    	var eNumber = null;
    	function find() {
    		$("#content").fadeOut(2000);
			eNumber = $("input:eq(0)").val();
			layer.load();
			$.getJSON("../../expressFind.do","eNumber="+eNumber,function(data){
				layer.closeAll();
				layer.msg(data.msg);
				if(data.status==0){
					var e = data.data;
					$("#content").fadeIn(2000);
					$("input:eq(2)").val(e.eNumber);
					$("input:eq(3)").val(e.company);
					$("input:eq(4)").val(e.userName);
					$("input:eq(5)").val(e.userPhone);
					$("input:eq(6)").attr("disabled","disabled");
					$("input:eq(6)").val(e.status==0?"未取件":"已取件");
				}
			});
		}
    	function updateExpress() {
			var newEnumber = $("input:eq(2)").val();
			var company = $("input:eq(3)").val();
			var userName = $("input:eq(4)").val();
			var userPhone = $("input:eq(5)").val();
			layer.load();
			$.getJSON("../../expressUpdate.do","eNumber="+eNumber+"&newEnumber="+newEnumber+"&company="+company+"&userName="+userName+"&userPhone="+userPhone,function(data){
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
                <div class="layui-card-header">修改快件信息</div>
                <form class="layui-form layui-card-body" action="">
                  
                  <div class="layui-form-item">
                    <div class="layui-input-inline">
                      <input type="text" name="code" required  lay-verify="required" placeholder="请输入单号" autocomplete="off" class="layui-input">
                    </div>
                     <div class="layui-input-inline">
                      <input onclick="find()" value="立即查找" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo">
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
                    <label class="layui-form-label">快递单号</label>
                    <div class="layui-input-block">
                      <input type="text" name="code" required  lay-verify="required" placeholder="请输入快递单号" autocomplete="off" class="layui-input" value="101231313213001">
                    </div>
                  </div>
                   <div class="layui-form-item">
                    <label class="layui-form-label">快递公司</label>
                    <div class="layui-input-block">
                      <select name="company" lay-verify="" lay-search>
						<option >安能快递</option><option >安能物流</option><option >澳大利亚邮政</option><option >阿根廷邮政</option><option >爱沙尼亚邮政</option><option >阿联酋邮政</option><option >奥地利邮政</option><option >阿尔巴尼亚邮政</option><option >Aramex</option><option >巴西邮政</option><option >比利时邮政</option><option >百世快运</option><option >波兰邮政</option><option >白俄罗斯邮政</option><option >保加利亚邮政</option><option >巴基斯坦邮政</option><option >百福东方</option><option >包裹信件</option><option >晟邦物流</option><option >城市100</option><option >City-Link</option><option >COE</option><option >传喜物流</option><option >德邦快递</option><option >大田物流</option><option >递四方</option><option >DHL德国</option><option >DHL全球</option><option >DHL中国</option><option >EMS</option><option >EMS国际</option><option >EMS经济快递</option><option >FedEx中国</option><option >FedEx国际</option><option >FedEx美国</option><option >飞豹快递</option><option >凡宇快递</option><option >飞远配送</option><option >飞远(爱彼西)</option><option >法国邮政</option><option >芬兰邮政</option><option >国通快递</option><option >postco</option><option >百世快递</option><option >恒路物流</option><option >黄马甲配送</option><option >黑猫宅急便</option><option >华企快运</option><option >韩国邮政</option><option >佳吉快运</option><option >京东快递</option><option >佳怡物流</option><option "jinguangsudikuaijian">京广速递</option><option >日本邮政</option><option >筋斗云物流</option><option >捷克邮政</option><option >嘉里大通</option><option >加运美</option><option >快捷快递</option><option >跨越速运</option><option >克罗地亚邮政</option><option >联昊通</option><option >龙邦速递</option><option >黎巴嫩邮政</option><option >民航快递</option><option >秘鲁邮政</option><option >毛里求斯邮政</option><option >马耳他邮政</option><option >摩尔多瓦邮政</option><option >马其顿邮政</option><option >民邦快递</option><option "szml56">明亮物流</option><option >挪威邮政</option><option >南非邮政</option><option >OnTrac</option><option >葡萄牙邮政</option><option >全峰快递</option><option >全一快递</option><option >如风达</option><option >申通快递</option><option selected="selected">顺丰速运</option><option >速尔快递</option><option >盛丰物流</option><option >圣安物流</option><option >盛辉物流</option><option >瑞士邮政</option><option >苏宁快递</option><option >斯洛伐克邮政</option><option >沙特邮政</option><option >斯洛文尼亚邮政</option><option >塞尔维亚邮政</option><option >天天快递</option><option >天地华宇</option><option >土耳其邮政</option><option >泰国邮政</option><option >TNT</option><option >UPS</option><option >USPS</option><option >万象物流</option><option >乌克兰邮政</option><option >万家物流</option><option >信丰物流</option><option >新邦物流</option><option >西班牙邮政</option><option >匈牙利邮政</option><option >圆通速递</option><option >韵达快递</option><option >优速物流</option><option >银捷速递</option><option >远成物流</option><option >运通中港快递</option><option >邮政国内小包</option><option >英国皇家邮政</option><option >意大利邮政</option><option >印度邮政</option><option >亚美尼亚邮政</option><option >越丰物流</option><option >亚风速递</option><option >邮政国际包裹</option><option >中通快递</option><option >宅急送</option><option >中铁物流</option><option >增益速递</option><option >中铁快运</option><option >芝麻开门</option><option >中国邮政</option><option >智利邮政</option><option >中速快递</option>
					</select>

                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">收货人姓名</label>
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
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-block">
				      <input type="radio" name="status8" title="待取货" checked>
				      <input type="radio" name="status8" title="已签收">
				      <input type="radio" name="status8" title="已退回">
                    </div>
                  </div>
                  
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <input onclick="updateExpress()" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo" value="确认修改">
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