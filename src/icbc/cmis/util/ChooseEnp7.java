package icbc.cmis.util;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import icbc.cmis.base.*;
import icbc.missign.Employee;
import icbc.cmis.util.Decode;

public class ChooseEnp7 extends HttpServlet {
  private static final int PAGE_LINES = 15;
  private static final int BUFFER_LINES = 10 * PAGE_LINES;
  private static final String CONTENT_TYPE = "text/xml; charset=GBK";
//  private static final String CONTENT_TYPE = "text/xml";
  /**Initialize global variables*/
  public void init() throws ServletException {
  }
  /**Process the HTTP Get request*/
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
 }

  /**Clean up resources*/
  public void destroy() {
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    CMisSessionMgr session = new CMisSessionMgr(request);

    try {
      if(!CMisSessionMgr.checkSession(request)){
        outTime(out,"  当前会话已失效，请重新登录");
        return;
      }

      String flag = request.getParameter("flag");
      String page = request.getParameter("page");

      //判断标志，根据标志转向不同处理
      if(flag.equals("newQuery")) {
        newQuery(request,session,out);
      } else if(flag.equals("query")) {
        query(session,out,page);
      } else if(flag.equals("done")) {
        String ccode = Decode.decode(request.getParameter("ccode"));
        String cname = Decode.decode(request.getParameter("cname"));
        clear(session,out,ccode,cname);
      }

    }
    catch (TranFailException ex) {
        outTime(out,"数据提取失败！" + ex.getErrorCode()+"" + ex.getErrorLocation()+"" + ex.getDisplayMessage()+"" + ex.getErrorMsg()+"");
    }
    catch (Exception ex) {
        outTime(out,"数据提取失败！" + ex.getMessage());
    }

  }

  public void newQuery(HttpServletRequest request,CMisSessionMgr session,PrintWriter out) throws TranFailException {
    //新查询，取出查询参数，调用数据查询模块得到结果，将结果放入SESSION
    //返回结果集的第一页
    try {
      //取参数
      Employee employee = (Employee)session.getSessionData("Employee");
      String TA200011001 = request.getParameter("TA200011001");
      if(TA200011001 == null) TA200011001 = "";
      String TA200011003 = request.getParameter("TA200011003");
      if(TA200011003 == null) TA200011003 = "";
      TA200011003 = Decode.decode(TA200011003);
      String TA200011005 = request.getParameter("TA200011005");
      if(TA200011005 == null) TA200011005 = "";
      String TA200011010 = request.getParameter("TA200011010");
      if(TA200011010 == null) TA200011010 = "";
      String TA200011011 = request.getParameter("TA200011011");
      if(TA200011011 == null) TA200011011 = "";
      String TA200011012 = request.getParameter("TA200011012");
      if(TA200011012 == null) TA200011012 = "";
      String TA200011014 = request.getParameter("TA200011014");
      if(TA200011014 == null) TA200011014 = "";
      String TA200011016 = request.getParameter("TA200011016");
      if(TA200011016 == null) TA200011016 = "";
      String TA200011031 = request.getParameter("TA200011031");
      if(TA200011031 == null) TA200011031 = "";
      String queryType = request.getParameter("queryType");

      Hashtable paras = new Hashtable();
      Enumeration pnames = request.getParameterNames();
      while (pnames.hasMoreElements()) {
        String tname = (String)pnames.nextElement();
        paras.put(tname,request.getParameter(tname));
      }

      //调用数据查询模块得到结果，将结果放入SESSION
      ChooseEnp3DAO dao = new ChooseEnp3DAO(new icbc.cmis.operation.DummyOperation());
      String sql[] = dao.genSQL(queryType,employee,TA200011001,TA200011003,TA200011005,TA200011010,TA200011011,TA200011012,TA200011014,TA200011016,TA200011031,paras);
      session.updateSessionData("sql3GB2U",sql);
      int rowCount = dao.getRecordCount(sql[0]);
      session.updateSessionData("recordCount3GB2U",String.valueOf(rowCount));
      session.updateSessionData("bufferBegin3GB2U",null);
      session.updateSessionData("bufferEnd3GB2U",null);
      session.updateSessionData("data3GB2U",null);

      //返回结果集的第一页
      query(session,out,"1");
    } catch(TranFailException ex) {
      throw ex;
    } catch(Exception ex) {
      throw new TranFailException("cmisUTIL801","",ex.getMessage(),ex.getMessage());
    }

  }

  public void query(CMisSessionMgr session,PrintWriter out,String spage) throws TranFailException{
    //从SESSION中取回结果集，根据页号返回结果
    try {
      //从SESSION中取回数据
      String sql[] = (String[])session.getSessionData("sql3GB2U");
      int rowCount = Integer.parseInt((String)session.getSessionData("recordCount3GB2U"));
      int bufferBegin = 0;
      int bufferEnd = 0;
      Vector datas = null;

      try {
        bufferBegin = Integer.parseInt((String)session.getSessionData("bufferBegin3GB2U"));
      }
      catch (Exception ex) {
      }
      try {
        bufferEnd = Integer.parseInt((String)session.getSessionData("bufferEnd3GB2U"));
      }
      catch (Exception ex) {
      }

      String warning = "";

      //取记录集大小
      int last = rowCount;
      int pages = (last - 1)/ PAGE_LINES + 1;

      //计算应取回的记录起始和终止编号
      int page = Integer.parseInt(spage);
      int begin = (page - 1) * PAGE_LINES + 1;
      int end   = (page) * PAGE_LINES;
      if (end > last) {
        end = last;
      }


      //检查是否已缓存
      if(begin < bufferBegin || end > bufferEnd) {
        if(begin < bufferBegin) {
          bufferBegin = begin / this.BUFFER_LINES * this.BUFFER_LINES + 1;
          bufferEnd = bufferBegin + this.BUFFER_LINES - 1;
        }else{
          bufferEnd = ((end - 1)/ this.BUFFER_LINES + 1) * this.BUFFER_LINES;
          bufferBegin = bufferEnd - this.BUFFER_LINES + 1;
        }

        if (bufferBegin > begin) {
          bufferBegin = begin;
        }
        if (bufferEnd < end) {
          bufferEnd = end;
        }
        if (bufferEnd > last) {
          bufferEnd = last;
        }
        if (bufferBegin < 1) {
          bufferBegin = 1;
        }
//updated by chenj 20030526
        //
        String newString = new String(sql[1]);
        newString += "ROWNUM <= "+ bufferEnd +" ) WHERE rnum >= "+ bufferBegin ;


        ChooseEnp3DAO dao = new ChooseEnp3DAO(new icbc.cmis.operation.DummyOperation());
        datas = dao.query(newString,bufferBegin,bufferEnd);
        session.updateSessionData("bufferBegin3GB2U",String.valueOf(bufferBegin));
        session.updateSessionData("bufferEnd3GB2U",String.valueOf(bufferEnd));
        session.updateSessionData("data3GB2U",datas);

        //System.out.println("new buffer:" + bufferBegin + " -> " + bufferEnd);
      }else{
        try {
          datas = (Vector)session.getSessionData("data3GB2U");
        }
        catch (Exception ex) {
          throw new TranFailException("cmisUTIL803","icbc.cmis.util.ChooseEnp4",ex.getMessage(),"取缓存数据出错！");
        }
      }


      //返回结果
      out.println("<?xml version=\"1.0\" encoding=\"GBK\"?>");
      out.print("<datas page='" + page + "' pages='" + pages + "' lines='" + last + "' warning='" + warning + "'>");
      if(datas != null && !datas.isEmpty()) {
        for(int i = 0; i <= end - begin; i++) {
          String[] row = (String[])datas.get(begin - bufferBegin + i);
          out.print("<en o='" + row[4] + "' c='" + row[0] + "' n='" + row[1] + "' j='" + row[2] + "' d='" + row[3] + "' />");
        }
      }
      out.print("</datas>");
    } catch (TranFailException ex) {
      throw ex;
    } catch(Exception ex) {
      throw new TranFailException("cmisUTIL801","icbc.cmis.util.ChooseEnp4",ex.getMessage(),"取数据出错！");
    }

  }

  public void clear(CMisSessionMgr session,PrintWriter out,String ccode,String cname) {
    //清除SESSION中的相关数据
    try {
      //System.out.println("clear enterprise3GB2U!!!");
      session.removeSessionData("sql3GB2U");
      session.removeSessionData("recordCount3GB2U");
      session.removeSessionData("bufferBegin3GB2U");
      session.removeSessionData("bufferEnd3GB2U");
      session.removeSessionData("data3GB2U");
      session.addSessionData("CustomerCodeInSession",ccode);
      session.addSessionData("CustomerNameInSession",cname);
    }
    catch (Exception ex) {};
    out.println("<?xml version=\"1.0\" encoding=\"GBK\"?>");
    out.println("<ok />");
  }

  public void outTime(PrintWriter out,String info) {
    out.println("<?xml version=\"1.0\"?>");
    out.println("<error>");
    out.println(info);
    out.println("</error>");
  }
}