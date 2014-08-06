<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>面试地点管理</title>
<base href="${baseUrl }"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="skins/css/style.css"/>
<link rel="stylesheet" type="text/css" href="skins/css/form.css"/>
<link rel="stylesheet" type="text/css" href="skins/css/jquery-ui-1.8.15.custom.css"/>
<link rel="stylesheet" type="text/css" href="plugin/tree/zTreeStyle.css"/>
<link rel="stylesheet" type="text/css" href="plugin/tree/zTreeIcons.css"/>

<script type="text/javascript" src="skins/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="skins/js/public.js"></script>
<script type="text/javascript" src="skins/js/jquery.json-2.2.min.js"></script>
<script type="text/javascript" src="skins/js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="skins/js/jquery.ajaxupload.3.6.js"></script>
<script type="text/javascript" src="plugin/tree/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="plugin/form/jquery.form.js"></script>
<script type="text/javascript" src="plugin/form/jquery.validate.js"></script>
<script type="text/javascript" src="plugin/form/lib/jquery.metadata.js"></script>

<script type="text/javascript" src="pages/tree.js"></script>

<script type="text/javascript">
var tid='${param.id}';
$(document).ready(function() {
	
	
    //加载表单验证
    $("#myForm").validate({submitHandler:function(form) {
	    	$(form).ajaxSubmit(function(data) {
	    		window.parent.convertView(null);
	        });
		}
	});
    
    
  	//加載數據
    loadData();
    
    
    //日期
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
       	beforeShow: function(input, inst) {
   			if($(input).attr("readonly"))
   				inst.inline=true;
   		}
    });
});







//取数据
function loadData() {
	if(tid!=null&&tid!=''&&tid!='null')
		$.getJSON("audition/getAuditionAddressById.do", {id:tid}, function(data) {
			if(data!=null){
				for(var key in data){
					if($('#myForm #'+key)){
						$('#myForm #'+key).val(data[key]);
						
					}
				}
				//判定下状态
				butstate();
			}
		});
	else
		$("#valid").hide();
}





//保存
function save(){
	
	$('#myForm').submit();
}





//返回
function back(){
	window.parent.convertView('');
}

//失效及恢复
function validContract(state){
	$("#state").val(state);
	save();
}

//页面状态
function butstate(){
	
		var valid=$("#state").val();
	
		//失效的数据显示还原按钮
		if(valid==0){
			formDisabled(true);
			$("#save").hide();
			$("#revert").show();
			$("#valid").hide();
		}else{
			$("#revert").hide();
			$("#valid").show();
			$("#save").show();
		}
}

</script>
</head>

<body>
<div class="sort">
	<div class="sort-title">
		<h3>面试地点管理</h3>
		<div class="title-ctrl">
			<a class="btn-ctrl" href="javascript:chevronUpDown('.sort-cont',false);"><i class="icon icon-chevron-up"></i></a>
			<a class="btn-ctrl" href="javascript:chevronUpDown('.sort-cont',true);"><i class="icon icon-chevron-down"></i></a>
		</div>
	</div>
<div class="table">
	<div class="table-bar">
		<div class="table-title">
			面试地点
		</div>
		<div class="table-ctrl">
			<a class="btn" id="save" href="javascript:save();"><i class="icon icon-check"></i><span>保存</span></a>
			<a  id="valid" class="btn"  href="javascript:validContract(0);" ><i class="icon icon-trash"></i><span>失效</span></a>
			<a class="btn" id="revert"  href="javascript:validContract(1);" style="display:none"><i class="icon icon-retweet"></i><span>恢复</span></a>
			<a class="btn" href="javascript:back();"><i class="icon icon-share-alt"></i><span>返回列表</span></a>
		</div>
	</div>
	<div class="table-wrapper">
		<form action="audition/saveOrUpdateAuditionAddress.do" method="post" id="myForm" class="form">
			<input type="hidden" id="auditionaddressguid" name="auditionaddressguid" value=""/>
			<input type="hidden" id="state" name="state" value="1"/>
			<input type="hidden" id="modiuser" name="modiuser" value=""/>
			<input type="hidden" id="moditimestamp" name="moditimestamp" value=""/>
			<input type="hidden" id="modimemo" name="modimemo" value=""/>
			
			<fieldset>
				<legend>基本信息</legend>
				<ul>
					<li>
						<span><em class="red">* </em>面试地点：</span>
                		<input id="auditionaddress" name="auditionaddress" class="{required:true,maxlength:100} inputstyle" style="width:200px;"/>
					</li>
				</ul>
				<ul>
					<li>
						<span>备注：</span>
						<textarea id="memo" name="memo"  rows="5" style="width:570px;" class="{maxlength:500} areastyle"></textarea>
					</li>
				</ul>
			</fieldset>
		</form>
		</div>
		<br>
		<br>
		<br>
		<br>
</div>
</div>
</body>
</html>
