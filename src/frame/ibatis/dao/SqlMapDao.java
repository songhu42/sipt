package frame.ibatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

/**
 * SQLMapDao. <br>
 * SQLMap을 이용하기 위한 Method
 */

public class SqlMapDao extends SqlMapDaoTemplate implements IfaceSqlMapDao {

	private	Logger logger = Logger.getLogger(SqlMapDao.class);
	
    boolean	bAutoCommit	= true;

    public SqlMapDao(DaoManager daoManager) {
        super(daoManager);
    }

    public void setAutoCommit(boolean bFlag) {
        this.bAutoCommit = bFlag;
    }
    public Map<Object, Object> procedureCall(String strXPath, Map<Object, Object> map ){
    	super.queryForObject(strXPath, map);
    	return map;
    }
    public int startTransaction() {

        int iRet = 1;
        try {
            daoManager.startTransaction(); // 트랜잭션 객체를 생성
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        }
        return iRet;
    }

    public int endTransaction() {

        int iRet = 1;
        try {
            daoManager.endTransaction(); // 트랜잭션 객체를 생성
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        }
        return iRet;
    }

    public int commitTransaction() {

        int iRet = 1;
        try {
            daoManager.commitTransaction(); // 트랜잭션 객체를 생성
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        }
        return iRet;
    }

    public int insert(Map<Object, Object> map, String strXPath) {

        int iRet = 1;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // 트랜잭션 객체를 생성
            super.insert(strXPath, map);

            if (bAutoCommit)
                daoManager.commitTransaction(); // Commit
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction(); // 트랜잭션 객체를 종료
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
                iRet = -1;
            }
        }
        return iRet;
    }

    public int insert(Map<Object, Object> map, String... strXPath) {

        int iRet = 1;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // 트랜잭션 객체를 생성

            for (String xPath : strXPath) {
                super.insert(xPath, map);
            }

            if (bAutoCommit)
                daoManager.commitTransaction(); // Commit
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction(); // 트랜잭션 객체를 종료
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
                iRet = -1;
            }
        }
        return iRet;
    }

    public int update(Map<Object, Object> map, String strXPath) {

        int iRet = 1;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            iRet = super.update(strXPath, map);
            if (bAutoCommit)
                daoManager.commitTransaction(); // Commit
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction(); // 트랜잭션 객체를 종료
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
                iRet = -1;
            }
        }
        return iRet;
    }

    public int delete(Map<Object, Object> map, String strXPath) {

        int iRet = 1;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            iRet = super.delete(strXPath, map);
            if (bAutoCommit)
                daoManager.commitTransaction();
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            iRet = -1;
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction(); // 트랜잭션 객체를 종료
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
                iRet = -1;
            }
        }
        return iRet;
    }

    @SuppressWarnings("unchecked")
    public List<Object> getList(Map<Object, Object> map, String strXPath) {
        List<Object> lstRs = null;

        try {

            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            // lstRs = super.queryForList(strXPath, map);
            lstRs = super.queryForList(strXPath, map);
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction();
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            }
        }
        return lstRs;
    }

    @SuppressWarnings("unchecked")
    public List<Object> getPageList(Map<Object, Object> map, String strXPath, int iRowStartPos, int iCount) {
        List<Object> lstRs = null;

        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            lstRs = super.queryForList(strXPath, map, iRowStartPos, iCount);
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction();
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            }
        }
        return lstRs;
    }

    @SuppressWarnings("unchecked")
    public Map<Object, Object> getView(Map<Object, Object> map, String strXPath) {

        Map<Object, Object> rsMap = null;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            rsMap = (Map<Object, Object>) super.queryForObject(strXPath, map);
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction();
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            }
        }
        return rsMap;

    }

    public int getCount(Map<Object, Object> map, String strXPath) {

        int iCount = 0;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            iCount = Integer.parseInt(super.queryForObject(strXPath, map).toString());
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction();
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            }
        }
        return iCount;
    }

    public int getInt(Map<Object, Object> map, String strXPath) {

        int iCount = 0;
        try {
            if (bAutoCommit)
                daoManager.startTransaction(); // - 트랜잭션 객체를 생성
            iCount = Integer.parseInt(super.queryForObject(strXPath, map).toString());
        } catch (Exception e) {
        	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
        } finally {
            try {
                if (bAutoCommit)
                    daoManager.endTransaction();
            } catch (Exception e) {
            	logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
            }
        }
        return iCount;
    }

}