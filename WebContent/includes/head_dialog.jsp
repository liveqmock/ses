<%@ page contentType="text/html;charset=GBK" %> 
<%@ page import="com.icbc.cte.base.*" %>
<%@ taglib uri="CTPTLD" prefix="ctp" %>
<%
String sysid = "0";
String path=CTEConstance.getAppFullWebPathBeforeLogon(sysid);
%>
<jsp:useBean id="utb" scope="page" class="com.icbc.cte.cs.html.CTEJspContextServices">
<%
   try{
		utb.initialize(request);
   }catch(Exception ex){
        out.println("<error>您的会话已经超时,请关闭当前对话框，并重新登录系统！</error>");
	return;
   }
%>
</jsp:useBean>
<%
	// sessionId
	String sessionId = utb.getSessionId();

	// sessionCtx
	com.icbc.cte.base.Context sessionCtx = utb.getSessionContext();
	if(sessionId == null || sessionCtx == null){
		response.sendRedirect(path+"sesserror.jsp");
	}
	///////////////////////////////////////////////////////////////////
	/*
	 * ????????????Context???icbc.cmis.base.Context?
	 *			 com.icbc.cte.base.Context??????Context????
	 * ?????2004-07-08
	 * ???????
	 */
	// op context
	//Context context = utb.getContext();
	com.icbc.cte.base.Context context = utb.getContext();
	//////////////////////////////////////////////////////////////////
	// base path
	String basePath = utb.getBaseWebPath();

	String exPathInfo = utb.getExtraPathInfo();
	//full path
	String fullPath = utb.getAppFullWebPath(sessionId);
	String internation = (String)sessionCtx.getValueAt("Language");
%>
