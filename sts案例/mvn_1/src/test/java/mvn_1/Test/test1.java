package mvn_1.Test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class test1 {

	@Test
	public void testQueryAll() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao =null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			List<Map<String,Object>> data = dao.selectList("com.accp.sum.queryAll");
			for (Map<String, Object> map : data) {
				System.out.println(map.get("name"));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			dao.close();
		}
	}
}
