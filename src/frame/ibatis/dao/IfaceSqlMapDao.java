package frame.ibatis.dao;

import java.util.List;
import java.util.Map;

/**
 * Interface 공통 <br>
 * 공통 Interface로 사용되며 현 Class와 다른 성격은 새로 작성하여 사용한다.
 */

public interface IfaceSqlMapDao {
	
	public void setAutoCommit(boolean bFlag);

	public int startTransaction();

	public int endTransaction();

	public int commitTransaction();
	public Map<Object, Object> procedureCall(String strXPath, Map<Object, Object> map);
	/**
	 * 조회 Method <br>
	 * 전체 내용을 조회에 사용한다.
	 * 
	 * @param map
	 * @param strXPath
	 * @return description
	 */
	public List<Object> getList(Map<Object, Object> map, String strXPath);

	/**
	 * 조회 Method <br>
	 * 목록형태의 조회에 사용한다.
	 * 
	 * @param map
	 * @param strXPath
	 * @return description
	 */
	public List<Object> getPageList(Map<Object, Object> map, String strXPath, int iRowStartPos, int iCount);

	/**
	 * 자료건수 Method. <br>
	 * 자료의 건수를 조회한다.
	 * 
	 * @param map
	 * @param strXPath
	 * @return description
	 */
	public int getCount(Map<Object, Object> map, String strXPath);

	/**
	 * 조회 Method. <br>
	 * 1건 조회형태(상세정보)에 사용한다.
	 * 
	 * @param Map
	 *            조회조건 항목
	 * @return java.util.Map
	 * @throws
	 */
	public Map<Object, Object> getView(Map<Object, Object> map, String strXPath);

	/**
	 * 입력 Method. <br>
	 * 입력형태에 사용한다.
	 * 
	 * @param Map
	 *            입력 항목
	 * @return 성공 1, 실패 :-1
	 * @throws
	 */

	public int insert(Map<Object, Object> map, String strXPath);
	
	
	/**
	 * 입력형태에서 묶음 트랜젝션
	 * @param map
	 * @param strXPath
	 * @return
	 */
	public int insert(Map<Object, Object> map, String... strXPath);

	/**
	 * 수정 Method. <br>
	 * 수정형태에 사용한다.
	 * 
	 * @param Map
	 *            수정 항목
	 * @return 성공 1, 실패 :-1
	 * @throws
	 */
	public int update(Map<Object, Object> map, String strXPath);

	/**
	 * 삭제 Method. <br>
	 * 삭제형태에 사용한다.
	 * 
	 * @param Map
	 *            수정 항목
	 * @return 성공 1, 실패 :-1
	 * @throws
	 */

	public int delete(Map<Object, Object> map, String strXPath);

	/**
	 * 숫자를 읽음
	 * 
	 * @param Map
	 *            숫자 항목
	 * @return int
	 * @throws
	 */

	public int getInt(Map<Object, Object> map, String strXPath);
}
