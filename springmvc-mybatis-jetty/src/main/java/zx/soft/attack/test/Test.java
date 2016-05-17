package zx.soft.attack.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zx.soft.attack.service.ComputerService;

public class Test {

	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-weibo-config.xml"));
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession sqlSession = getSessionFactory().openSession();

		System.out.println(new ComputerService().getComputerData());
	}

}
