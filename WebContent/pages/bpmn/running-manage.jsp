<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>运行中的流程</title>
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
<link rel="stylesheet" type="text/css" href="plugin/grid/gt_grid.css" />
<link rel="stylesheet" type="text/css" href="plugin/grid/skin/default/skinstyle.css" />
<link rel="stylesheet" type="text/css" href="plugin/grid/skin/green/skinstyle.css" />
<link rel="stylesheet" type="text/css" href="plugin/grid/skin/mac/skinstyle.css" />
<link rel="stylesheet" type="text/css" href="plugin/grid/skin/china/skinstyle.css" />
<link rel="stylesheet" type="text/css" href="plugin/grid/skin/vista/skinstyle.css" />
<link rel="stylesheet" type="text/css" href="plugin/grid/calendar/calendar-blue.css"  />


<script type="text/javascript" src="skins/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="skins/js/public.js"></script>
<script type="text/javascript" src="skins/js/jquery.json-2.2.min.js"></script>
<script type="text/javascript" src="skins/js/jquery.layout.js"></script>
<script type="text/javascript" src="skins/js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="plugin/tree/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="plugin/form/jquery.form.js"></script>
<script type="text/javascript" src="plugin/form/jquery.validate.js"></script>
<script type="text/javascript" src="plugin/form/lib/jquery.metadata.js"></script>

<script type="text/javascript" src="plugin/grid/calendar/calendar.js"></script>
<script type="text/javascript" src="plugin/grid/calendar/calendar-en.js"></script>
<script type="text/javascript" src="plugin/grid/calendar/calendar-setup.js"></script>
<script type="text/javascript" src="plugin/grid/gt_grid_all.js"></script>
<script type="text/javascript" src="plugin/grid/gt_msg_cn.js"></script>

<script type="text/javascript" src="pages/bpmn/workflow.js"></script>


<script type="text/javascript">

$(document).ready(function() {
    
    //加載數據
    loadGrid();
    
    
    
  	//按钮hover
    $('.more a').hover(
		function() {$(this).addClass('ui-state-hover');}, 
		function() {$(this).removeClass('ui-state-hover');}
	);
	//日期
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
       	beforeShow: function(input, inst) {
   			if($(input).attr("readonly"))
   				inst.inline=true;
   		}
    });
  	//关闭等待层
    if(window.parent.hidenLoading)
    	window.parent.hidenLoading();
	
});









//导出
function expData(){
	$("#dialog_exp").dialog({
		autoOpen: true,
		modal: true,
		model:true,
		resizable:false,
		width:470,
		height:130,
		buttons: {
			"确定": function() {
				mygrid.exportGrid('xls');
				$(this).dialog("close");
			},
			"取消": function() {
				$(this).dialog("close");
			}
		},
		close: function() {
		}
	});
}











//删除
function remove(){
	var array=new Array();
	var cords=mygrid.getSelectedRecords();
	for(var i=0;i<cords.length;i++){
		var obj=cords[i];
		array.push(obj.processInstanceId);
	}
	if(array.length<=0){
		alert('请选择要删除的数据！');
		return;
	}
	if(!confirm('确认要删除选中数据吗？')){
		return;
	}
   	$.post("bpmn/deleteProcessInstance.do",{ids:array.toString()}, function() {
		mygrid.reload();
    });
}









//激活、挂起
function suspended(id,state){
	if(!confirm('确认要'+(state==1?'激活':'挂起')+'流程吗？')){
		return;
	}
 	$.post("bpmn/activateProcessInstanceById.do",{processinstanceid:id,state:state}, function() {
		mygrid.reload();
  });
}





//参数设置
var pam=null;
function initPagePam(){
	pam={};
	pam.expAll=0;
	
}





//切换视图
function convertView(url){
	if ($(".list").css("display")!="none") {
		$(".list").hide();
		$("#detail").show();		
		showLoading();
		$("#detail").attr("src",url);
	}else{
		$("#detail").removeAttr("src");
		$(".list").show();
		if(url==null)
			mygrid.reload();
	}
}



</script>
<script type="text/javascript">	
var mygrid=null;
function loadGrid(){
	var size=getGridSize();
	var grid_demo_id = "myGrid1";
	var dsOption = {
	        fields :[
	            {name : 'id'},
	        	{name : 'processInstanceId'},
	        	{name : 'processDefinitionId'},
	        	{name : 'activityname'},
	        	{name : 'suspended'}
	        ]
	    };
	    var colsOption = [
			{isCheckColumn:true,editable:false,headAlign:'center',align:'center'},
			{id: 'id' , header: "执行IDssss" , width :100,headAlign:'center',align:'left'},
			{id: 'processDefinitionId' , header: "流程定义ID" , width :150,headAlign:'center',align:'left'},
	        {id: 'processInstanceId' , header: "流程实例ID" , width :100,headAlign:'center',align:'left'},
	        {id: 'activityname' , header: "当前节点" , width :200,headAlign:'center',align:'left',renderer:function(value ,record,colObj,grid,colNo,rowNo){
				return '<a href="javascript:graphTrace(\''+record.id+'\');" title="点击查看流程图">'+value+'</a>';
			}},
	        {id: 'suspended' , header: "是否挂起" , width :100,headAlign:'center',align:'center',renderer:function(value ,record,colObj,grid,colNo,rowNo){
				if(value)
					return value+' | <a href="javascript:suspended(\''+record.id+'\',1);">激活</a>';
				return value+' | <a href="javascript:suspended(\''+record.id+'\',0);">挂起</a>';
			}}
	    ];
	
	var gridOption={
		id : grid_demo_id,
		loadURL : 'bpmn/searchRunningPrcessInstance.do', 
		beforeLoad:function(reqParam){
			initPagePam();
			reqParam['parameters']=pam;
		},
		exportURL : 'bpmn/searchRunningPrcessInstance.do?export=true',
		exportFileName : '流程定义列表.xls',
		beforeExport:function(){
			initPagePam();
			pam.expAll=$('input[name="xls"]:checked').val();
			mygrid.parameters=pam;
		},
		width: "99.9%",//"100%", // 700,
		height: "100%",  //"100%", // 330,
		container : 'gridbox', 
		pageSizeList : [size,size*2,size*4,size*6,size*8,size*10],
		stripeRows: false,
		showIndexColumn:true,
		selectRowByCheck:true,
		replaceContainer : true,
		dataset : dsOption ,
		columns : colsOption,
		toolbarContent : 'nav | pagesize  state',
		pageSize:size,
		skin:getGridSkin(),
		onDblClickCell:function(value, record , cell, row, colNO, rowNO,columnObj,grid){
			if(colNO!=0)
				convertView('workorder.do?page=form&id='+record.workorderguid);
		}
	};
		
	mygrid=new Sigma.Grid( gridOption );
	Sigma.Util.onLoad( Sigma.Grid.render(mygrid) );
}

</script>
</head>

<body>


<div class="sort">
	<div class="sort-title">
		<h3>运行中的流程</h3>
		<div class="title-ctrl">
			<a class="btn-ctrl" href="javascript:chevronUpDown('.sort-cont',false);"><i class="icon icon-chevron-up"></i></a>
			<a class="btn-ctrl" href="javascript:chevronUpDown('.sort-cont',true);"><i class="icon icon-chevron-down"></i></a>
		</div>
	</div>
	
	<div class="sort-cont sort-table">
		<div class="table">
			<div class="table-bar">
				<div class="table-title">
					表格名称
				</div>
				<div class="table-ctrl">
					<a class="btn" href="javascript:remove();"><i class="icon icon-remove"></i><span>删除</span></a>
				</div>
			</div>
			<div class="table-wrapper">
				<div id="myTable" style="height:550px;margin:5px auto;">
					<div id="gridbox" ></div>
                </div>
			</div>
		</div>
	</div>
</div>













<!-- 导出 -->
<div id="dialog_exp" style="display:none" title="数据导出" >
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td >
				&nbsp;
			  	&nbsp;
			  	&nbsp;
				<label for="xls1">
					<input id="xls1" type="radio" name="xls" value="0" checked="true" class="checkboxstyle"/>导出本页
				</label>
			  	&nbsp;
			  	&nbsp;
			  	&nbsp;
			  	<label for="xls2">
			  		<input id="xls2" type="radio" name="xls" value="1" class="checkboxstyle"/>全部导出
			  	</label>
			</td>
		</tr>
	</table>
</div>


</body>
</html>