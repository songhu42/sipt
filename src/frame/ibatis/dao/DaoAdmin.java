package frame.ibatis.dao;

import com.ibatis.dao.client.DaoManager;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public class DaoAdmin {

	/* Constants */

	private DaoManager daoManager = DaoConfig.getDaoManager();

	private IfaceSqlMapDao sqlMapDao;

	private	Logger logger = Logger.getLogger(DaoAdmin.class);
	/* Constructors */

	public DaoAdmin() {
		try {
			sqlMapDao = (IfaceSqlMapDao) daoManager.getDao(IfaceSqlMapDao.class);
		} catch (Exception e) {
			// System.out.println("DaoMamager() : " + e.toString());
			logger.error("[" + this.getClass().getName() + "] : " + e.getMessage());
		}
	}

	public void setAutoCommit(boolean bFlag) {
		sqlMapDao.setAutoCommit(bFlag);
	}

	public int startTransaction() {
		return sqlMapDao.startTransaction(); // 트랜잭션 객체를 생성
	}

	public int endTransaction() {
		return sqlMapDao.endTransaction(); // 트랜잭션 객체를 생성
	}

	public int commitTransaction() {
		return sqlMapDao.commitTransaction(); // 트랜잭션 객체를 생성
	}
	public Map<Object, Object> procedureCall(String strXPath, Map<Object, Object> map) {
		return sqlMapDao.procedureCall(strXPath, map);
	}
	/**
	 * 2건 이상의 데이타 조회. <br>
	 * 데이타베이스에서 조회된 모든 자료를 List Type으로 반환한다.
	 * 
	 * @param prmMap
	 *            조회조건 파라메터
	 * @param strXPath
	 *            쿼리문장의 XML 경로
	 * @return List
	 */
	public List<Object> getList(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.getList(prmMap, strXPath);
	}

	/**
	 * 2건 이상의 데이타 조회. <br>
	 * 데이타베이스에서 조회된 모든 자료를 List Type으로 반환한다.
	 * 
	 * @param prmMap
	 *            조회조건 파라메터
	 * @param strXPath
	 *            쿼리문장의 XML 경로
	 * @return List
	 */
	public List<Object> getList(String strXPath) {
		return getList(null, strXPath);
	}

	/**
	 * 게시판 형태의 자료 조회. <br>
	 * 데이타베이스에서 조회된 모든 자료를 시작위치와 Row 갯수 만큼만 List Type으로 반환한다.
	 * 
	 * @param prmMap 조회조건 파라메터
	 * @param strXPath 쿼리문장의 XML 경로
	 * @param iRowStartPos Row의 시작위치
	 * @param iCount 시작위치 부터 조회할 데이타 건수
	 * @return List
	 */
	public List<Object> getPageList(Map<Object, Object> prmMap, String strXPath, int iRowStartPos, int iCount) {
		return sqlMapDao.getPageList(prmMap, strXPath, iRowStartPos, iCount);
	}

	/**
	 * 1건 데이타를 조회 <br>
	 * 상세정보 및 데이타가 1건인 자료만을 조회한다.<br>
	 * (주의사항) 2건 이상의 자료가 반환되면 오류가 발생을 한다.
	 * 
	 * @param prmMap 조회조건 파라메터
	 * @param strXPath  쿼리문장의 XML 경로
	 * @return Map
	 */
	public Map<Object, Object> getView(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.getView(prmMap, strXPath);
	}

	/**
	 * 데이타를 DB에 Insert. <br>
	 * prmMap에 있는 데이타를 저장한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int insert(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.insert(prmMap, strXPath);
	}
	
	/**
	 * 데이타들을 DB에 Insert. <br>
	 * @param prmMap
	 * @param strXPath
	 * @return
	 */
	public int insert(Map<Object, Object> prmMap, String... strXPath) {
		return sqlMapDao.insert(prmMap, strXPath);
	}
	/**
	 * 데이타를 삭제한다. <br>
	 * prmMap에 있는 데이타를 삭제한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int delete(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.delete(prmMap, strXPath);
	}

	/**
	 * 데이타를 수정한다. <br>
	 * prmMap에 있는 데이타를 수정한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int update(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.update(prmMap, strXPath);
	}

	/**
	 * 데이타 건수 조회. <br>
	 * 데이타 건수를 조회한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int getCount(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.getCount(prmMap, strXPath);
	}

	/**
	 * 데이타 건수 조회. <br>
	 * 데이타 건수를 조회한다.
	 * 
	 * @param strXPath
	 * @return int
	 */
	public int getCount(String strXPath) {
		return getCount(null, strXPath);
	}

	/**
	 * int 타입의 자료를 조회.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int getInt(Map<Object, Object> prmMap, String strXPath) {
		return sqlMapDao.getInt(prmMap, strXPath);
	}

	/**
	 * int 타입의 자료를 조회.
	 * 
	 * @param strXPath
	 * @return int
	 */
	public int getInt(String strXPath) {
		return getInt(null, strXPath);
	}

}
