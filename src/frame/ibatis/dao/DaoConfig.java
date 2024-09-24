package frame.ibatis.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

import java.io.Reader;


public class DaoConfig {
	private static final DaoManager	daoManager;

	static {
		try {
			String resource = "frame/ibatis/xml/DaoConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			daoManager = DaoManagerBuilder.buildDaoManager(reader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Could not initialize DaoConfig.  Cause: " + e);
		}
	}

	public static DaoManager getDaoManager() {
		return daoManager;
	}
}
