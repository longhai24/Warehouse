package com.accp.t3.biz;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.accp.t3.dao.IPersonDao;
import com.accp.t3.pojo.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PersonBiz {
	private SqlSessionFactory ssf;
	private Logger logger = Logger.getRootLogger();

	public PersonBiz() {
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		try {
			ssf = sfb.build(Resources.getResourceAsStream("config.xml"));
		} catch (Exception e) {
			logger.error("配置文件解析失败", e);
		}
	}

	public Integer addPerson(Person person) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			dao.savePerson(person);
			session.commit();
			return person.getPid();
		} catch (Exception ex) {
			session.rollback();
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public List<Person> findPersonList() {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			return dao.queryAllPersons();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public PageInfo<Person> findPersonListByPage(Integer pageNum, Integer pageSize) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			PageHelper.startPage(pageNum, pageSize);// 开始分页
			List<Person> data = dao.queryAllPersons();
			PageInfo<Person> pageInfo = new PageInfo<Person>(data);// 分页信息
			return pageInfo;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public List<Person> findPersonListWithNameAndSex(String name, Integer sex) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			return dao.queryAllPersonsByParam1(name, sex);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public List<Person> findPersonListByNameList(List<String> names) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			return dao.queryAllPersonsByParam2(names);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}

	public void modifyPerson(Person person) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			IPersonDao dao = session.getMapper(IPersonDao.class);
			dao.updatePerson(person);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			throw new RuntimeException(ex);
		} finally {
			session.close();
		}
	}
}
