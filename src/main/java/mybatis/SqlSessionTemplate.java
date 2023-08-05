package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		/*[참고]
		 * SqlSessionFactory 객체의 openSession()을 호출해서 SqlSession을 읽는다.
		 * SqlSeession은 MyBatis에서 실제 SQL 실행을 담당하는 컴퍼넌트이다.
		 * 즉 SQL을 실행하려면 SqlSession이 필요하며, 이 객체가 JDBC 드라이버를 사용한다.
		*/
		
		SqlSession session = null;
		String resource = "config/mybatis-config.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSesscionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			session = sqlSesscionFactory.openSession(true);	// 자동커밋
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;	//생성된 SqlSession 리턴
	}
}
