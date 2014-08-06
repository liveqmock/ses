<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>面试官面试情况表</title>
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

<script type="text/javascript" src="pages/tree.js"></script>

<script type="text/javascript">
$(document).ready(function () {
	
    //列表加载
    loadGrid();
    searchGrid();
    
    //日期
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd'
    });
    
    
    //关闭等待层
    if(window.parent.hidenLoading)
    	window.parent.hidenLoading();
});




//导出
function expGrid(){
	mygrid.exportGrid('xls');
}

//打印
function printGrid(){
	mygrid.printGrid();
}




//搜索
var searchForm=null;
function searchGrid(){
	$("#search").dialog({
		autoOpen: true,
		modal: true,
		resizable:false,
		width:470,
		buttons: {
			"确定":function(){
				if(searchForm.form()){
					$(this).dialog("close");
		    		mygrid.loadURL="report/searchPCD0307.do";
		    		mygrid.reload();
				}
			},
			"重置":function(){
				$("#searchForm").clearForm();
			},
			"关闭": function() {
				$(this).dialog("close");
			}
		},
		open:function(){
			//校验
			if(searchForm==null)
				searchForm=$("#searchForm").validate();
		}
	});
}









//参数设置
var pam=null;
function initPagePam(){
	pam={};
	var startdate=$("#startdate").val();
	pam.startdate=startdate;
	var enddate=$("#enddate").val();
	pam.enddate=enddate;
}





</script>




<script type="text/javascript">	
var mygrid=null;
function loadGrid(){
	var size=getGridSize();
	var grid_demo_id = "myGrid1";
	var dsOption= {
			fields :[
				{name : 'MAININTERVIEWERGUID'},
				{name : 'RECOMMENDPOSTGUID'},
				{name : 'HOLDTIME'},
				{name : 'MODITIMESTAMP'},
				{name : 'PERSONNUM_7'}
			]
		};
		var colsOption = [
			{id: 'RECOMMENDDEPTNAME' , header: "部门" , width :150 ,headAlign:'center',align:'left'},
			{id: 'MAININTERVIEWERNAME' , header: "面试官" , width :80 ,headAlign:'center',align:'left'},
			{id: 'RECOMMENDPOSTNAME' , header: "面试岗位" , width :120 ,headAlign:'center',align:'left'},
			{id: 'd1' , header: "认定的平均时间" , width :120 ,headAlign:'center',align:'left'},
			{id: 'd2' , header: "面试反馈的平均时间" , width :120 ,headAlign:'center',align:'left'},
			{id: 'PASSNUMBER' , header: "面试通过数" , width :150 ,headAlign:'center',align:'center'},
			{id: 'NUMBERS' , header: "安排面试数" , width :150 ,headAlign:'center',align:'center'},
			{id: 'PASSPCT' , header: "面试通过率" , width :100 ,headAlign:'center',align:'center',renderer:function(value ,record,colObj,grid,colNo,rowNo){
				var htm='';
        		htm+=value;
        		htm+='%';
    			return htm;
			}}
		];
	var gridOption={
		id : grid_demo_id,
		beforeLoad:function(reqParam){
			initPagePam();
			reqParam['parameters']=pam;
		},
		exportURL : 'report/searchPCD0307.do?export=true',
		beforeExport:function(){
			initPagePam();
			pam.expAll=$('input[name="xls"]:checked').val();
			mygrid.parameters=pam;
		},
		exportFileName : '面试官面试情况表.xls',
		width: "99.8%",//"100%", // 700,
		height: "100%",  //"100%", // 330,
		container : 'gridbox', 
		pageSizeList : [size,size*2,size*4,size*6,size*8,size*10],
		stripeRows: false,
		remoteFilter:true,
		showIndexColumn:true,
		selectRowByCheck:true,
		replaceContainer : true,
		showGridMenu : true,
		allowFreeze	: true ,
		allowHide	: true ,
		allowGroup	: true ,
		dataset : dsOption ,
		columns : colsOption,
		toolbarContent : 'nav | pagesize  state',
		pageSize:size,
		skin:getGridSkin()
	};
	mygrid=new Sigma.Grid( gridOption );
	Sigma.Util.onLoad( Sigma.Grid.render(mygrid) );
}

</script>

</head>
<body>

<div class="sort">
	<div class="sort-title">
		<h3>面试官面试情况表</h3>
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
					<a class="btn" href="javascript:searchGrid();"><i class="icon icon-search"></i><span>搜索</span></a>
					<a class="btn" href="javascript:expGrid();"><i class="icon icon-list-alt"></i><span>导出</span></a>
					<a class="btn" href="javascript:printGrid();"><i class="icon icon-print"></i><span>打印</span></a>
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



<!-- 搜索 -->
<div id="search" title="搜索条件设置" style="display:none;">
	<form action="" id="searchForm" class="form">
         <ul>
         	<li style="display:inline;">
			    <span>推荐时间从：</span>
			    <input id="startdate" name="startdate" class="{dateISO:true} inputselectstyle datepicker" style="width:80px;"/>
			    <div class="date-trigger" onclick="$('#startdate').focus();"/>
			</li>
            <li style="display:inline;">
			    <span style="width:16px;">至&nbsp;</span>
			     <input id="enddate" name="enddate" class="{dateISO:true} inputselectstyle datepicker" style="width:80px;"/>
			    <div class="date-trigger" onclick="$('#enddate').focus();"/>
			</li>
        </ul>
	</form>
</div>









</body>
</html>