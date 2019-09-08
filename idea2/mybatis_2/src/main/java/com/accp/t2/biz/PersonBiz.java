package com.accp.t2.biz;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.accp.t2.dao.IPersonDao;
import com.accp.t2.pojo.Address;
import com.accp.t2.pojo.Person;

public class PersonBiz {

	private Logger logger = Logger.getRootLogger();

	private SqlSessionFactory ssf;

	public PersonBiz() {
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		try {
			ssf = sfb.build(Resources.getResourceAsStream("config.xml"));
		} catch (Exception e) {
			logger.error("配置文件读取失败", e);
		}
	}


	public List<Address> findAddressList() {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			return dao.queryAllAdressWithPerson();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public List<Person> findPersonWithAddress() {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			return dao.queryAllPersonWithAddress();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public void addPerson(Person person) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			dao.savePersonWithAddress(person);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public void removePersonById(Integer pid) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			dao.deletePersonById(pid);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}
}
