package org.apache.jsp.pages.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>角色管理</title>\r\n");
      out.write("<base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseUrl }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\"/>\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\"/>\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\"/>    \r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"skins/css/style.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"skins/css/form.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"skins/css/jquery-ui-1.8.15.custom.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/tree/zTreeStyle.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/tree/zTreeIcons.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/gt_grid.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/skin/default/skinstyle.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/skin/green/skinstyle.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/skin/mac/skinstyle.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/skin/china/skinstyle.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/skin/vista/skinstyle.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugin/grid/calendar/calendar-blue.css\"  />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"skins/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"skins/js/public.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"skins/js/jquery.layout.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"skins/js/jquery-ui-1.8.5.custom.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"skins/js/jquery.json-2.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/tree/jquery.ztree.all.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/form/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/form/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/form/lib/jquery.metadata.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/grid/calendar/calendar.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/grid/calendar/calendar-en.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/grid/calendar/calendar-setup.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/grid/gt_grid_all.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"plugin/grid/gt_msg_cn.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"pages/tree.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"pages/bpmn/workflow.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t//tab页\r\n");
      out.write("\tloadTab();\r\n");
      out.write("\t\r\n");
      out.write("\t//加载布局\r\n");
      out.write("\t$('#myContent').layout({\r\n");
      out.write("        west: {size:\"300\",resizable:false,spacing_open:0,spacing_closed:0}\r\n");
      out.write("    });\r\n");
      out.write("\t\r\n");
      out.write("    \r\n");
      out.write("  \t//加载树\r\n");
      out.write(" \tbuildRoleTree();\r\n");
      out.write("  \t\r\n");
      out.write("  \t\r\n");
      out.write("    //加载表单验证\r\n");
      out.write("    $(\"#myForm\").validate();\r\n");
      out.write("    $('#myForm').ajaxForm(function(data) {\r\n");
      out.write("        //节点处理\r\n");
      out.write("    \tvar nameValue=data.rolename;\r\n");
      out.write("    \t\r\n");
      out.write("    \tif(add){//新增\r\n");
      out.write("    \t\tif(selectNode!=null&&selectNode.id!=null)\r\n");
      out.write("    \t\t\tselectNode=selectNode.getParentNode();\r\n");
      out.write("    \t\tvar newNode = {id:data.roleid, name:nameValue,iconSkin:'role'};\r\n");
      out.write("       \t\tzTree.addNodes(selectNode, newNode);\r\n");
      out.write("        }else{\r\n");
      out.write("        \tselectNode.name = nameValue;\r\n");
      out.write("   \t\t\tzTree.updateNode(selectNode);\r\n");
      out.write("   \t\t\tzTree.selectNode(selectNode);\r\n");
      out.write("        }\r\n");
      out.write("    \tadd=false;\r\n");
      out.write("    \t//不可编辑\r\n");
      out.write("    \tformDisabled(true);\r\n");
      out.write("    \t//取消状态\r\n");
      out.write("    \tonCancel();\r\n");
      out.write("    });\r\n");
      out.write(" \t//把表单置为不可编辑\r\n");
      out.write("    formDisabled(true);\r\n");
      out.write("    \r\n");
      out.write("    //关闭等待层\r\n");
      out.write("    if(window.parent.hidenLoading)\r\n");
      out.write("    \twindow.parent.hidenLoading();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//tab页\r\n");
      out.write("var tabIndex=0;\r\n");
      out.write("function loadTab(){\r\n");
      out.write("\t$(\"#mytab\").tabs({\r\n");
      out.write("    \tselect: function(event, ui) {\r\n");
      out.write("    \t\ttabIndex=ui.index;\r\n");
      out.write("    \t\t$(\".gruop_hidden\").hide();\r\n");
      out.write("    \t\t$(\"#group\"+tabIndex).show();\r\n");
      out.write("    \t\t$(\"#tab\"+tabIndex).show();\r\n");
      out.write("    \t\t\r\n");
      out.write("\r\n");
      out.write("    \t\t//刷新关系\r\n");
      out.write("    \t\tif(tabIndex==1){\r\n");
      out.write("    \t\t\tbuildFunctionTree();\r\n");
      out.write("    \t\t}else if(tabIndex==2){\r\n");
      out.write("    \t\t\tbuildUserTree();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t}\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//树\r\n");
      out.write("var zTree;\r\n");
      out.write("//选中节点\r\n");
      out.write("var selectNode=null;\r\n");
      out.write("function buildRoleTree(){\r\n");
      out.write("\tvar setting = {callback:{beforeClick: function(treeId, treeNode){\r\n");
      out.write("\t\tselectNode=treeNode;\r\n");
      out.write("\t\tformDisabled(true);\r\n");
      out.write("\t\t//出现按钮组一\r\n");
      out.write("\t\t$('#b1').show();\r\n");
      out.write("\t\t$('#b2').hide();\r\n");
      out.write("\t\t//控制新增编辑\r\n");
      out.write("\t\tif(treeNode.id==null){\r\n");
      out.write("\t\t\t$('#new').show();\r\n");
      out.write("\t\t\t$('#edit').hide();\r\n");
      out.write("\t\t\t$('#del').hide();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$('#edit').show();\r\n");
      out.write("\t\t\t$('#new').show();\r\n");
      out.write("\t\t\t$('#del').show();\r\n");
      out.write("\r\n");
      out.write("\t\t\t//取数据\r\n");
      out.write("\t\t\tloadData(treeNode.id);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}},\r\n");
      out.write("\tview: {\r\n");
      out.write("\t\tfontCss: getDeptFontCss\r\n");
      out.write("\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t$.getJSON(\"system/buildRoleTree.do\",function(tdata) {\r\n");
      out.write("\t\tzTree = $.fn.zTree.init($(\"#tree\"),setting, tdata);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//邦定定位事件\r\n");
      out.write("    \t$(\"#myMarker\").bind(\"keyup\",markTreeNode);\r\n");
      out.write("    \t$(\"#myMarker\").bind(\"blur\",markSelectTreeNode);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//节点搜索变色\r\n");
      out.write("function markTreeNode(e) {\r\n");
      out.write("\tif(!nodeState){\r\n");
      out.write("\t\tnodeState=true;\r\n");
      out.write("\t\tvar value=\"\";\r\n");
      out.write("\t\tvalue = $.trim($(\"#myMarker\").val());\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tchangeNodesColor(false);\r\n");
      out.write("\t\tif (value === \"\"){\r\n");
      out.write("\t\t\tnodeState=false;\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tnodeList = zTree.getNodesByParamFuzzy(\"name\", value);\r\n");
      out.write("\t\tchangeNodesColor(true);\r\n");
      out.write("\t\tnodeState=false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function changeNodesColor(highlight) {\r\n");
      out.write("\tif(nodeList.length<=0)\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\tfor( var i=0, l=nodeList.length; i<l; i++) {\r\n");
      out.write("\t\tvar node=nodeList[i];\r\n");
      out.write("\t\tnode.highlight = highlight;\r\n");
      out.write("\t\tzTree.updateNode(nodeList[i]);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//节点搜索定位\r\n");
      out.write("function markSelectTreeNode(){\r\n");
      out.write("\tvar value=\"\";\r\n");
      out.write("\tvalue = $.trim($(\"#myMarker\").val());\r\n");
      out.write("\tif (value != \"\"){\r\n");
      out.write("\t\tnodeList = zTree.getNodesByParamFuzzy(\"name\", value);\r\n");
      out.write("\t\tif(nodeList.length<=0)\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\tfor( var i=0, l=nodeList.length; i<l; i++) {\r\n");
      out.write("\t\t\tvar node=nodeList[i];\r\n");
      out.write("\t\t\tif(i==0){\r\n");
      out.write("\t\t\t\tzTree.selectNode(node);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getDeptFontCss(treeId, treeNode) {\r\n");
      out.write("\treturn (!!treeNode.highlight) ? {color:\"#ff0000\", \"font-weight\":\"bold\"} : {color:\"#333\", \"font-weight\":\"normal\"};\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//取数据\r\n");
      out.write("function loadData(tid) {\r\n");
      out.write("\t$(\"#myForm\").clearForm();\r\n");
      out.write("\tif(tid!=null&&tid!=''&&tid!='null')\r\n");
      out.write("\t\t$.getJSON(\"system/getRoleById.do\", {id:tid}, function(data) {\r\n");
      out.write("\t\t\tfor (var key in data) {\r\n");
      out.write("\t\t        var el = $('#' + key);\r\n");
      out.write("\t\t        if(el) \r\n");
      out.write("\t\t            el.val(data[key]);\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("    \t\t//刷新关系\r\n");
      out.write("    \t\tif(tabIndex==1){\r\n");
      out.write("    \t\t\tbuildFunctionTree();\r\n");
      out.write("    \t\t}else if(tabIndex==2){\r\n");
      out.write("    \t\t\tbuildUserTree();\r\n");
      out.write("    \t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//新增\r\n");
      out.write("var add=false;\r\n");
      out.write("function addNode(){\r\n");
      out.write("\t$('#b1').hide();\r\n");
      out.write("\t$('#b2').show();\r\n");
      out.write("\t$(\"#myForm\").clearForm();\r\n");
      out.write("\tformDisabled(false);\r\n");
      out.write("\tadd=true;\r\n");
      out.write("\t\r\n");
      out.write("\t$('#state').val(1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//编辑\r\n");
      out.write("function editNode(){\r\n");
      out.write("\t$('#b1').hide();\r\n");
      out.write("\t$('#b2').show();\r\n");
      out.write("\tformDisabled(false);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//保存\r\n");
      out.write("function save(){\r\n");
      out.write("\t$('#myForm').submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//取消\r\n");
      out.write("function onCancel(){\r\n");
      out.write("\t//取数据\r\n");
      out.write("\tif(selectNode!=null)\r\n");
      out.write("\t\tloadData(selectNode.id);\r\n");
      out.write("\t\r\n");
      out.write("\tformDisabled(true);\r\n");
      out.write("\t$('#b1').show();\r\n");
      out.write("\t$('#b2').hide();\r\n");
      out.write("\t\r\n");
      out.write("\t$('#del').show();\r\n");
      out.write("\t$('#edit').show();\r\n");
      out.write("\t$('#new').show();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//删除\r\n");
      out.write("function delNode(){\r\n");
      out.write("\tif(selectNode==null)\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\tif(!confirm('确认要删除吗？')){\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t$.post(\"system/delRoleById.do\",{id:selectNode.id}, function() {\r\n");
      out.write("\t\tzTree.removeNode(selectNode);\r\n");
      out.write("\t\t$(\"#myForm\").clearForm();\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t$('#b1').show();\r\n");
      out.write("\t\t$('#b2').hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#del').hide();\r\n");
      out.write("\t\t$('#edit').hide();\r\n");
      out.write("\t\t$('#new').hide();\r\n");
      out.write(" \t\tformDisabled(true);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//菜单树\r\n");
      out.write("var funTree;\r\n");
      out.write("function buildFunctionTree(){\r\n");
      out.write("\tvar roleid= $(\"#roleid\").val();\r\n");
      out.write("\tif(roleid==null||roleid=='')\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#funTree\").html(null);\r\n");
      out.write("    $.getJSON(\"system/buildRoleRightTree.do\",{roleid:roleid}, function(tdata) {\r\n");
      out.write("    \t//配置项\r\n");
      out.write("    \tvar setting = {check: {\r\n");
      out.write("\t\t\tenable: true\r\n");
      out.write("\t\t}};\r\n");
      out.write("    \tfunTree = $.fn.zTree.init($(\"#funTree\"),setting, tdata);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//保存关系\r\n");
      out.write("function savePostFunction(){\r\n");
      out.write("\tvar roleid= $(\"#roleid\").val();\r\n");
      out.write("\tif(roleid==null||roleid=='')\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\r\n");
      out.write("\tvar nodes=funTree.getCheckedNodes(true);\r\n");
      out.write("\t\r\n");
      out.write("\tvar array=new Array();\r\n");
      out.write("\tfor(var i=0;i<nodes.length;i++){\r\n");
      out.write("\t\tvar node=nodes[i];\r\n");
      out.write("\t\tif(node.id!=null&&node.id!=''){\r\n");
      out.write("\t\t\tvar obj={};\r\n");
      out.write("\t\t\tobj.roleid=roleid;\r\n");
      out.write("\t\t\tobj.funid=node.id;\r\n");
      out.write("\t\t\tarray.push(obj);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//参数\r\n");
      out.write("\tvar data={roleid:roleid,list:array};\r\n");
      out.write("\t$.ajax({  \r\n");
      out.write("        url: \"system/saveRoleFunction.do\",  \r\n");
      out.write("        contentType: \"application/json; charset=utf-8\",  \r\n");
      out.write("        type: \"POST\",  \r\n");
      out.write("        dataType: \"json\",  \r\n");
      out.write("        data: JSON.stringify(data),\r\n");
      out.write("        success: function(result) { \r\n");
      out.write("        \talert('授权成功！');\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//用户树\r\n");
      out.write("var userTree;\r\n");
      out.write("function buildUserTree(){\r\n");
      out.write("\tvar roleid= $(\"#roleid\").val();\r\n");
      out.write("\tif(roleid==null||roleid=='')\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#userTree\").html(null);\r\n");
      out.write("    $.getJSON(\"system/buildRoleUserTree.do\",{roleid:roleid}, function(tdata) {\r\n");
      out.write("    \t//配置项\r\n");
      out.write("    \tvar setting = {\r\n");
      out.write("    \t\t\tasync: {\r\n");
      out.write("    \t\t\t\tenable: true,\r\n");
      out.write("    \t\t\t\turl: getUrl\r\n");
      out.write("    \t\t\t},\r\n");
      out.write("    \t\t\tcheck: {\r\n");
      out.write("\t\t    \t\tenable: true\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tonAsyncSuccess: onAsyncSuccess,\r\n");
      out.write("\t\t\t\tonAsyncError: onAsyncError\r\n");
      out.write("    \t\t};\r\n");
      out.write("    \tuserTree = $.fn.zTree.init($(\"#userTree\"),setting, tdata);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//异步数据\r\n");
      out.write("function getUrl(treeId, treeNode) {\r\n");
      out.write("\treturn \"system/asyncRoleUserTree.do?deptid=\" + treeNode.id+\"&roleid=\"+selectNode.id;\r\n");
      out.write("}\r\n");
      out.write("function onAsyncSuccess(event, treeId, treeNode, msg) {\r\n");
      out.write("\tif(!msg || msg.length == 0) {return;}\r\n");
      out.write("\tzTree.updateNode(treeNode);\r\n");
      out.write("}\r\n");
      out.write("function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//保存关系\r\n");
      out.write("function saveRoleUser(){\r\n");
      out.write("\tvar roleid= $(\"#roleid\").val();\r\n");
      out.write("\tif(roleid==null||roleid=='')\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\r\n");
      out.write("\tvar array=new Array();\r\n");
      out.write("\tvar checknodes=userTree.getCheckedNodes(true);\r\n");
      out.write("\tvar unchecknodes=userTree.getCheckedNodes(false);\r\n");
      out.write("\t//打勾的节点\r\n");
      out.write("\tfor(var i=0;i<checknodes.length;i++){\r\n");
      out.write("\t\tvar node=checknodes[i];\r\n");
      out.write("\t\tif(node.id!=null&&node.id!=''&&node.code=='user'){\r\n");
      out.write("\t\t\tvar obj={};\r\n");
      out.write("\t\t\tobj.roleid=roleid;\r\n");
      out.write("\t\t\tobj.userguid=node.id;\r\n");
      out.write("\t\t\tobj.checked=node.checked;\r\n");
      out.write("\t\t\tarray.push(obj);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//没有打勾的节点\r\n");
      out.write("\tfor(var i=0;i<unchecknodes.length;i++){\r\n");
      out.write("\t\tvar node=unchecknodes[i];\r\n");
      out.write("\t\tif(node.id!=null&&node.id!=''&&node.code=='user'){\r\n");
      out.write("\t\t\tvar obj={};\r\n");
      out.write("\t\t\tobj.roleid=roleid;\r\n");
      out.write("\t\t\tobj.userguid=node.id;\r\n");
      out.write("\t\t\tobj.checked=node.checked;\r\n");
      out.write("\t\t\tarray.push(obj);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//参数\r\n");
      out.write("\tvar data={roleid:roleid,list:array};\r\n");
      out.write("\t$.ajax({  \r\n");
      out.write("        url: \"system/saveRoleUser.do\",  \r\n");
      out.write("        contentType: \"application/json; charset=utf-8\",  \r\n");
      out.write("        type: \"POST\",  \r\n");
      out.write("        dataType: \"json\",  \r\n");
      out.write("        data: JSON.stringify(data),\r\n");
      out.write("        success: function(result) { \r\n");
      out.write("        \talert('授权成功！');\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("//公司回调\r\n");
      out.write("function callBackCompany(){\r\n");
      out.write("\t$(\"#deptid\").val(null);\r\n");
      out.write("\t$(\"#deptname\").val(null);\r\n");
      out.write("\t\r\n");
      out.write("\t//部门选择回调\r\n");
      out.write("\tcallbackDept();\r\n");
      out.write("}\r\n");
      out.write("//部门选择回调\r\n");
      out.write("function callbackDept(){\r\n");
      out.write("\t$(\"#postid\").val(null);\r\n");
      out.write("\t$(\"#postname\").val(null);\r\n");
      out.write("}\r\n");
      out.write("//岗位回调\r\n");
      out.write("function callbackpost(){\r\n");
      out.write("\tvar postid=$(\"#postid\").val();\r\n");
      out.write("\tvar quotaid=$(\"#quotaid\").val();\r\n");
      out.write("\tvar state=$(\"#state\").val();\r\n");
      out.write("\tvar budgettype=$(\"#budgettype\").val();\r\n");
      out.write("\t$.post(\"quota/checkQuotaByPostIdAndBudgettype.do\",{quotaid:quotaid,postid:postid,budgettype:budgettype,state:state}, function(data) {\r\n");
      out.write("\t\tif(data!=null&&data!=\"\"){\r\n");
      out.write("\t\t\talert(data);\r\n");
      out.write("\t\t\t$(\"#postid\").val(null);\r\n");
      out.write("\t\t\t$(\"#postname\").val(null);\r\n");
      out.write("\t\t}\r\n");
      out.write("    });\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"sort\">\r\n");
      out.write("\t<div class=\"sort-title\">\r\n");
      out.write("\t\t<h3>角色管理</h3>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"sort-cont sort-table\">\r\n");
      out.write("\t\t<div class=\"table\">\r\n");
      out.write("\t\t\t<div class=\"table-bar\">\r\n");
      out.write("\t\t\t\t<div class=\"table-title\">\r\n");
      out.write("\t\t\t\t\t表格名称\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"table-ctrl\">\r\n");
      out.write("\t\t\t\t\t<span id=\"group0\" class=\"gruop_hidden\">\r\n");
      out.write("\t\t\t\t\t   \t<span id=\"b1\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"new\" class=\"btn\" href=\"javascript:addNode();\" style=\"display:none;\"><i class=\"icon icon-plus\"></i><span>新增</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"edit\" class=\"btn\" href=\"javascript:editNode();\" style=\"display:none;\"><i class=\"icon icon-pencil\"></i><span>修改</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"del\"  class=\"btn\"  href=\"javascript:delNode();\" style=\"display:none;\"><i class=\"icon icon-trash\"></i><span>删除</span></a>\r\n");
      out.write("\t\t\t\t   \t\t</span>\r\n");
      out.write("\t\t\t\t   \t\t<span id=\"b2\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn\"  href=\"javascript:save();\"><i class=\"icon icon-check\"></i><span>保存</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn\"  href=\"javascript:onCancel();\"><i class=\"icon icon-share\"></i><span>取消</span></a>\r\n");
      out.write("\t\t\t\t   \t\t</span>\r\n");
      out.write("\t\t\t\t   \t\t\r\n");
      out.write("\t\t\t\t   \t</span>\r\n");
      out.write("\t\t\t\t   \t<span id=\"group1\" class=\"gruop_hidden\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t   \t\t<a class=\"btn\"  href=\"javascript:savePostFunction();\"><i class=\"icon icon-check\"></i><span>保存</span></a>\r\n");
      out.write("\t\t\t\t   \t</span>\r\n");
      out.write("\t\t\t\t   \t\r\n");
      out.write("\t\t\t\t   \t<span id=\"group2\" class=\"gruop_hidden\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"btn\"  href=\"javascript:saveRoleUser();\"><i class=\"icon icon-check\"></i><span>保存</span></a>\r\n");
      out.write("\t\t\t\t   \t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"table-wrapper\" id=\"myContent\" style=\"height:550px;\">\r\n");
      out.write("\t\t\t\t<div class=\"ui-layout-west\" id=\"myWest\" style=\"overflow:auto;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"ui-layout-north\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"100%\" height=\"100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"padding-left:1px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"myMarker\" id=\"myMarker\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"ui-layout-center\" style=\"border-right:0px;\">\r\n");
      out.write("\t\t\t\t\t\t<ul id=\"tree\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"ui-layout-center\" style=\"overflow:hidden;\">\r\n");
      out.write("\t\t\t\t\t<div id=\"mytab\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#tab0\">基本信息</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#tab1\">菜单授权</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#tab2\">用户授权</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#tab3\">用户授权新实现</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#tab4\">用户列表</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab0\">\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"system/saveOrUpdateRole.do\" method=\"post\" id=\"myForm\" class=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"roleid\" name=\"roleid\" type=\"hidden\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"state\" name=\"state\" type=\"hidden\" value=\"1\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<legend>基本信息</legend>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <span><em class=\"red\">* </em>排序号：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <input id=\"dorder\" name=\"dorder\" class=\"{required:true,number:true} inputstyle\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <span><em class=\"red\">* </em>角色名称：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <input id=\"rolename\" name=\"rolename\" class=\"{required:true,maxlength:20} inputstyle\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t                <li>\r\n");
      out.write("\t\t\t\t\t\t                    <span>描述：</span>\r\n");
      out.write("\t\t\t\t\t\t                    <textarea id=\"description\" name=\"description\"  rows=\"3\" cols=\"40\" class=\"{maxlength:500} areastyle\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t                </li>\r\n");
      out.write("\t\t\t\t\t\t            </ul>\r\n");
      out.write("\t\t\t\t\t\t   \t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t       </form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab1\" style=\"display:none;overflow:auto;height:508px;\"> \r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"funTree\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab2\" style=\"display:none;overflow:auto;height:508px;\"> \r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"userTree\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab3\" style=\"display:none;overflow:auto;height:508px;\" class=\"table-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"quota/saveOrUpdateQuota.do\" method=\"post\" id=\"myForm\" class=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"quotaid\" name=\"quotaid\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"quotacode\" name=\"quotacode\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"state\" name=\"state\" type=\"hidden\" value=\"1\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"modiuser\" name=\"modiuser\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"modimemo\" name=\"modimemo\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"moditimestamp\" name=\"moditimestamp\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"runprocess\" name=\"runprocess\" value=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 流程信息 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"variables_commit\" name=\"variables['rate']\" type=\"hidden\" value=\"2\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"variables_commitNum\" name=\"variables['commitNum']\" type=\"hidden\" value=\"1\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t                <span><em class=\"red\">* </em>公司名称：</span>\r\n");
      out.write("\t\t\t\t\t\t                <input id=\"companyid\" name=\"companyid\" type=\"hidden\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <input id=\"companyname\" name=\"companyname\" class=\"{required:true} inputselectstyle\" onclick=\"$('#companyname').attr('readonly',false);chooseMyHasCompanyTree('#companyid','#companyname',callBackCompany);\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <div class=\"search-trigger\" onclick=\"$('#companyname').attr('readonly',false);chooseMyHasCompanyTree('#companyid','#companyname',callBackCompany);\"/>\r\n");
      out.write("\t\t\t\t\t\t            </li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <span><em class=\"red\">* </em>部门名称：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <input id=\"deptid\" name=\"deptid\" type=\"hidden\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <input id=\"deptname\" name=\"deptname\" class=\"{required:true} inputselectstyle\" onclick=\"$('#deptname').attr('readonly',false);chooseOneCompanyDeptTree('#deptid','#deptname',$('#companyid').val(),callbackDept);\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <div class=\"search-trigger\" onclick=\"$('#deptname').attr('readonly',false);chooseOneCompanyDeptTree('#deptid','#deptname',$('#companyid').val(),callbackDept);\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <span><em class=\"red\">* </em>岗位名称：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <input id=\"postid\" name=\"postid\" type=\"hidden\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <input id=\"postname\" name=\"postname\" class=\"inputselectstyle\" onclick=\"$('#postname').attr('readonly',false);choosePostTree('#postid','#postname',$('#deptid').val(),callbackpost);\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <div class=\"select-trigger\" onclick=\"$('#postname').attr('readonly',false);choosePostTree('#postid','#postname',$('#deptid').val());\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("  \t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
