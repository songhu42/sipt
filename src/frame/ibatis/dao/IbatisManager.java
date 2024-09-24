package frame.ibatis.dao;

import java.util.List;
import java.util.Map;


/**
 * Class Summary.1 <br>
 * Class Description.
 */
public class IbatisManager extends DaoAdmin {
	
	public void setAutoCommit(boolean bFlag) {
		super.setAutoCommit(bFlag);
	}

	public int startTransaction() {
		return super.startTransaction(); // 트랜잭션 객체를 생성
	}

	public int endTransaction() {
		return super.endTransaction(); // 트랜잭션 객체를 생성
	}

	public int commitTransaction() {
		return super.commitTransaction(); // 트랜잭션 객체를 생성
	}
    /**
     * 프로시저 콜
     */
	public Map<Object, Object> procedureCall(String strXPath, Map<Object, Object> map)
	{
		return super.procedureCall(strXPath, map);
	}
	/**
	 * 2건 이상의 데이타 조회. <br>
	 * 데이타베이스에서 조회된 모든 자료를 List Type으로 반환한다.
	 */
	public List<Object> getList(Map<Object, Object> prmMap, String strXPath) {
		return super.getList(prmMap, strXPath);
	}

	/**
	 * 2건 이상의 데이타 조회. <br>
	 * 데이타베이스에서 조회된 모든 자료를 List Type으로 반환한다.
	 */
	public List<Object> getList(String strXPath) {
		return getList(null, strXPath);
	}

	/**
	 * 게시판 형태의 자료 조회. <br>
	 * 데이타베이스에서 조회된 모든 자료를 시작위치와 Row 갯수 만큼만 List Type으로 반환한다.
	 */
	public List<Object> getPageList(Map<Object, Object> prmMap, String strXPath, int iRowStartPos, int iCount) {
		return super.getPageList(prmMap, strXPath, iRowStartPos, iCount);
	}

	/**
	 * 1건 데이타를 조회 <br>
	 * 상세정보 및 데이타가 1건인 자료만을 조회한다.<br>
	 * (주의사항) 2건 이상의 자료가 반환되면 오류가 발생을 한다.
	 * 
	 * @param prmMap
	 *            조회조건 파라메터
	 * @param strXPath
	 *            쿼리문장의 XML 경로
	 */
	public Map<Object, Object> getView(Map<Object, Object> prmMap, String strXPath) {
		return super.getView(prmMap, strXPath);
	}

	/**
	 * 데이타를 DB에 Insert. <br>
	 * prmMap에 있는 데이타를 저장한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 
	 */
	public int Insert(Map<Object, Object> prmMap, String strXPath) {
		return super.insert(prmMap, strXPath);
	}

	/**
	 * 데이타들을 DB에 Insert. <br>
	 * @param prmMap
	 * @param strXPath 배열
	 * @return
	 */
	public int Insert(Map<Object, Object> prmMap, String... strXPath) {
		return super.insert(prmMap, strXPath);
	}
	/**
	 * 데이타를 삭제한다. <br>
	 * prmMap에 있는 데이타를 삭제한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int Delete(Map<Object, Object> prmMap, String strXPath) {
		return super.delete(prmMap, strXPath);
	}

	/**
	 * 데이타를 수정한다. <br>
	 * prmMap에 있는 데이타를 수정한다.
	 * 
	 * @param prmMap
	 * @param strXPath
	 * @return int
	 */
	public int Update(Map<Object, Object> prmMap, String strXPath) {
		return super.update(prmMap, strXPath);
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
		return super.getCount(prmMap, strXPath);
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
		return super.getInt(prmMap, strXPath);
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
