<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>OA信息管理</title>
<base href="${baseUrl }"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="skins/css/style.css"/>
<link rel="stylesheet" type="text/css" href="skins/css/form.css"/>
<link rel="stylesheet" type="text/css" href="skins/css/jquery-ui-1.8.15.custom.css"/>

<script type="text/javascript" src="skins/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="skins/js/public.js"></script>
<script type="text/javascript" src="skins/js/jquery-ui-1.8.5.custom.min.js"></script>


<script type="text/javascript">
var tid='${param.id}';
var interfacecode='${param.interfacecode}';
var pageState=false;

$(document).ready(function() {
	//tab页
	loadTab();
	
	
	//加载数据
	$("#detail").attr("src","recruitprogram.do?page=recruitprogramaudit/form&id="+tid);
	
});



//tab页
 var tabIndex=0;
function loadTab(){
	
	$("#mytab").tabs({
    	select: function(event, ui) {
    		tabIndex=ui.index;
    		//刷新
    		if(tabIndex==0){
    			$("#detail").attr("src","recruitprogram.do?page=recruitprogramaudit/form&id="+tid);
    		}else if(tabIndex==1){
    			$("#detail").attr("src","recruitprogram.do?page=recruitprogramaudit/form_recruitprogram&id="+tid);
    		}else if(tabIndex==2){
  				$("#detail").attr("src","http://125.210.208.58/workflow/request/ViewRequest.jsp?isovertime=0&requestid="+interfacecode);
    		}
    	}
    });
} 





//切换视图
function convertView(url){
	window.parent.convertView(url);
}




//页面保存状态
function callbackPageState(state){
	pageState=state;
}

</script>


</head>
<body>

<div class="sort">
	<div class="sort-title">
		<h3>OA信息管理</h3>
		<div class="title-ctrl">
			<a class="btn-ctrl" href="javascript:chevronUpDown('.sort-cont',false);"><i class="icon icon-chevron-up"></i></a>
			<a class="btn-ctrl" href="javascript:chevronUpDown('.sort-cont',true);"><i class="icon icon-chevron-down"></i></a>
		</div>
	</div>
	
	<div class="sort-cont sort-table">
		<div id="mytab">
			<ul>
				<li><a href="#tab0">基本信息</a></li>
				<li><a href="#tab0">招聘计划</a></li>
				<li><a href="#tab0">OA信息</a></li>
			</ul>
			<div id="tab0">
				<iframe id="detail" name="detail" width="100%" height="100%" frameborder="0" scrolling="no" src="" ></iframe>
			</div>
		</div>
	</div>
</div>




</body>
</html>