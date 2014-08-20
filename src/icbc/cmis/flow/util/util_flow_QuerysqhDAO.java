
package icbc.cmis.flow.util;

import java.sql.*;
import icbc.missign.*;
import java.util.*;
import icbc.cmis.util.Decode;
import icbc.cmis.util.Util_MuiQueryDAO;


/*************************************************************
 * 
 * <b>��������: </b> 2005-10-25<br>
 * <b>����: </b>�������̲�ѯ<br>
 * <b>������: </b>�õ�ҵ������<br>
 * <br>
 * <p>Copyright: Copyright (c)2005</p>
 * <p>Company: </p>
 * 
 * @author DongMiaoying
 * 
 * @version 
 * 
 * @since 
 * 
 * @see 
 * 
 *************************************************************/

public class util_flow_QuerysqhDAO extends Util_MuiQueryDAO {
	/**
	 * <b>���캯��</b><br>
	 * 
	 */
	public util_flow_QuerysqhDAO() {
		
	}
	/** 
			 * <b>��������: </b>���û���ҳ��<br>
			 * <p>  </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getBufferPages()
			 * @return int ����ҳ��
			 * 
			 */
			public int getBufferPages() {
				return 10;
			}

			/** 
			 * <b>��������: </b>����ÿҳ��ʾ����<br>
			 * <p>  </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getPageLines()
			 * @return int ÿҳ��ʾ����
			 * 
			 */
			public int getPageLines() {
				return 20;
			}

			/** 
			 * <b>��������: </b>���ز�ѯ����ֶθ���<br>
			 * <p>  </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getFieldNumber()
			 * @return int �ֶθ���
			 * 
			 */
			public int getFieldNumber() {
				return 5;
			}

			/** 
			 * <b>��������: </b>������ʾ���ֶ�<br>
			 * <p>  </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getFieldNames()
			 * @return String[] ���ز�ѯ����������ֶ�����
			 * 
			 */
			public String[] getFieldNames() {
				//String[] ret = {"���", "�����","ҵ���","��ҵ����","������" };
				String[] ret = {super.propertyResourceReader.getPublicStr("P000019"), super.propertyResourceReader.getPublicStr("P000027"),super.propertyResourceReader.getPublicStr("P000028"),super.propertyResourceReader.getPrivateStr("C000067"),super.propertyResourceReader.getPrivateStr("C000068") };
				return ret;
			}

			/** 
			 * <b>��������: </b>���ظ��ֶ���ʾ����<br>
			 * <p>  -1��ʾ��ָ������,0��ʾ����ʾ</p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getFieldsWidth()
			 * @return int[] ���ֶ���ʾ���� �� null
			 * 
			 */
			public int[] getFieldsWidth() {
				int[] ret = { -1, -1, -1,-1,-1 };
				//int[] ret = {50,100,400,100,200};
				return ret;
			}

			/** 
			 * <b>��������: </b>������ѯ���������SQL���<br>
			 * <p>�������� select count(*) from ��ʼ�������ô�������ݿ����ӡ���Ա���Զ��������֯SQL��� </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getCountSQL(java.sql.Connection, icbc.missign.Employee, java.util.Hashtable)
			 * @param conn ��ǰ���õ����ݿ�����
			 * @param employee ��ǰ��Ա
			 * @param paras �û������Զ������
			 * @return ����SQL���
			 * @throws Exception
			 * 
			 */
			public String getCountSQL(
				Connection conn,
				Employee employee,
				Hashtable paras)
				throws Exception {

				String kh_code = (String) paras.get("kh_code"); //�ͻ�����
	
				String kindCode = (String)paras.get("kindCode");//��������
				String queryStr = "select count(distinct record002) from mrecord "
		+ "  where record001 = ?  and record005=? and record011 in (select area_code from mag_area start with area_code=? connect by belong_bank=prior area_code)";

				return queryStr;

			}

			/** 
			 * <b>��������: </b>������ѯSQL���<br>
			 * <p>��佨��������½ṹ֮һ��<br>
			 * select * from (select RANK() OVER (ORDER BY ����) rnk,���� FROM ����) WHERE rnk &lt;= ? AND rnk &gt;= ? <br>
			 * select * from (select rownum rnk,���� FROM ���� where ���� and rownum &lt;= ?) WHERE rnk &gt;= ?
			 * �����ô�������ݿ����ӡ���Ա���Զ��������֯SQL���
			 * </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getQuerySQL(java.sql.Connection, icbc.missign.Employee, java.util.Hashtable)
			 * @param conn ��ǰ���õ����ݿ�����
			 * @param employee  ��ǰ��Ա,�ڲ�ѯ���Ա�����й�ʱ����
			 * @param paras �û������Զ������
			 * @return ��ѯSQL���
			 * @throws Exception
			 * 
			 */
			public String getQuerySQL(
				Connection conn,
				Employee employee,
				Hashtable paras)
				throws Exception {
					
					 //					
        //					String kh_code = (String) paras.get("kh_code"); //�ͻ�����
        //		
        //					String kindCode = (String)paras.get("kindCode");//��������
        //					
        //					String areaCode = (String)paras.get("areacode");

        String queryStr = ""; //��ѯ�Ӿ�

        queryStr =
            "select distinct record002,record012,record001,record003 "
                + " from mrecord "
                + "  where record001 = ?  and record005=? and record011 in (select area_code from mag_area start with area_code=? connect by belong_bank=prior area_code)"
                + " order by record002";

        String sql = "select *   from ( select rownum rnk,temp_tab.* from ( " + queryStr + ") temp_tab where rownum <= ? ) where  rnk >= ?";

				return sql;
			}

			/** 
			 * <b>��������: </b>�󶨲�ѯ����<br>
			 * <p>ע����SQL����� </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#setParameters(boolean, java.sql.PreparedStatement, java.util.Hashtable, int, int)
			 * @param notCountQuery ������ѯʱΪtrue,���ݲ�ѯʱΪfalse
			 * @param pstmt PreparedStatement
			 * @param paras �Զ��������
			 * @param begin ��ʼ��¼���
			 * @param end ������¼���
			 * @throws Exception
			 * 
			 */
			public void setParameters(
				boolean notCountQuery,
				PreparedStatement pstmt,
				Hashtable paras,
				int begin,
				int end)
				throws Exception {
					String kh_code = (String) paras.get("kh_code"); //�ͻ�����
	
					String kindCode = (String)paras.get("kindCode");//��������
					
        String areaCode = (String)paras.get("areacode");
        
				int i = 0;
        
				pstmt.setString(++i, kh_code);
				pstmt.setString(++i, kindCode);
        pstmt.setString(++i, areaCode);
				
				if (notCountQuery) {
					pstmt.setInt(++i, end);
					pstmt.setInt(++i, begin);
				}
			}

			/** 
			 * <b>��������: </b>������ʾ�ֶ�<br>
			 * <p>0��ʾ��Ҫ��ʾ��1��ʾ����ֶ�Ҫ��ʾ    </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getAskFields()
			 * @return
			 * 
			 */
			public int[] getAskFields() {
				int[] ret = { 0, 0, 0, 0, 0 };

				return ret;
			}

			/** 
			 * <b>��������: </b>���ö��뷽ʽ��0����� 1�Ҷ���<br>
			 * <p>  </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getFieldsAlign()
			 * @return ���뷽ʽ
			 * 
			 */
			public int[] getFieldsAlign() {
				int[] ret = { 0, 0, 0, 0, 0 };

				return ret;
			}

			/** 
			 * <b>��������: </b>������Ҫ��ͨ�ò�����ȡֵ���ֶ�<br>
			 * <p>0�������ôӲ�����ȡֵ������Ϊ��Ӧ��PARATYPE    </p>
			 * @see icbc.cmis.rams.util.util_QueryDAO#getFieldsGenPara()
			 * @return ͨ�ò������ֶ�
			 * 
			 */
			public int[] getFieldsGenPara() {
				int[] ret = { 0, 0, 0, 0 ,0};

				return ret;
			}
      /* ���� Javadoc��
       * @see icbc.cmis.util.Util_MuiQueryDAO#getMuiDef()
       */
      protected String getMuiDef() {
        // TODO �Զ����ɷ������
        return "icbc.cmis.flow.FLOW_UTILE";
      
      }

}