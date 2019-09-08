import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.IPlane;
import pojo.Plane;

public class PlaneTest {
	private SqlSession session;
	Scanner input = new Scanner(System.in);
	Integer upp = 1;
	Integer dpp = 1;

	@Before
	public void init() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = null;
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			session = ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void release() {
		session.close();
	}

	@Test
	public void test1() {
		System.out.println("*****************欢迎使用航班");
		System.out.println("请选择操作（1.列出所有航班2.按起飞时间查询3.安目的地查询4.删除航班5.更新航班）");
		Integer num = input.nextInt();
		switch (num) {
		case 1:
			for (;;) {
				List<Plane> plist = SelAll(upp, dpp);
				if (plist != null && !plist.isEmpty()) {
					for (Plane plane : plist) {
						System.out.println("编号：" + plane.getId() + " 航班号：" + plane.getFlight_number() + " 目的地："
								+ plane.getDestination() + " 时间：" + plane.getFlight_date());
						System.out.println("1.查看下一页2.查看上一页");
					}
				} else {
					System.out.println("没了");
					break;
				}
				Integer num2 = input.nextInt();
				if (num2 == 1) {
					upp += 1;
					continue;
				} else {
					upp -= 1;
					continue;
				}
			}
			break;
		case 2:
			System.out.println("请输入日期：");
			String date = input.next();

			for (;;) {
				List<Plane> plist = SelSomeByDate(upp, dpp, date);
				if (plist != null && !plist.isEmpty()) {
					for (Plane plane : plist) {
						System.out.println("编号：" + plane.getId() + " 航班号：" + plane.getFlight_number() + " 目的地："
								+ plane.getDestination() + " 时间：" + plane.getFlight_date());
						System.out.println("1.查看下一页2.查看上一页");
					}
				} else {
					System.out.println("没了");
					break;
				}
				Integer num2 = input.nextInt();
				if (num2 == 1) {
					upp += 1;
					continue;
				} else {
					upp -= 1;
					continue;
				}
			}
			break;
		case 3:
			System.out.println("请输入目的地：");
			String address = input.next();
			for (;;) {
				List<Plane> plist = SelSomeByAddress(upp, dpp, address);
				if (plist != null && !plist.isEmpty()) {
					for (Plane plane : plist) {
						System.out.println("编号：" + plane.getId() + " 航班号：" + plane.getFlight_number() + " 目的地："
								+ plane.getDestination() + " 时间：" + plane.getFlight_date());
						System.out.println("1.查看下一页2.查看上一页");
					}
				} else {
					System.out.println("没了");
					break;
				}
				Integer num2 = input.nextInt();
				if (num2 == 1) {
					upp += 1;
					continue;
				} else {
					upp -= 1;
					continue;
				}
			}
			break;
		case 4:
			System.out.println("请输入要删除的航班编号：");
			Integer did = input.nextInt();
			DelByid(did);
			break;
		case 5:
			System.out.println("请输入要更新的航班编号：");
			Integer uid = input.nextInt();
			System.out.println("请输入新的航班号：");
			String unum = input.next();
			System.out.println("请输入新的目的地：");
			String uaddress = input.next();
			System.out.println("请输入新的起飞日期：");
			String udate = input.next();
			Plane pl1 = new Plane();
			pl1.setId(uid);
			pl1.setFlight_date(udate);
			pl1.setFlight_number(unum);
			pl1.setDestination(uaddress);
			UpdatePlane(pl1);
			break;
		default:
			break;
		}
	}

	// 查询所有航班
	public List<Plane> SelAll(Integer pageNum, Integer pageSize) {
		IPlane dao = session.getMapper(IPlane.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Plane> pageInfo = new PageInfo<Plane>(dao.SelAll());
		return pageInfo.getList();
	}

	// 根据时间查询航班
	public List<Plane> SelSomeByDate(Integer pageNum, Integer pageSize, String date) {
		IPlane dao = session.getMapper(IPlane.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Plane> pageInfo = new PageInfo<Plane>(dao.SelSomebyDate(date));
		return pageInfo.getList();
	}

	// 根据目的地查询航班
	public List<Plane> SelSomeByAddress(Integer pageNum, Integer pageSize, String address) {
		IPlane dao = session.getMapper(IPlane.class);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Plane> pageInfo = new PageInfo<Plane>(dao.SelSomebyAddress(address));
		return pageInfo.getList();
	}

	// 根据航班编号删除航班
	public void DelByid(Integer did) {
		IPlane dao = session.getMapper(IPlane.class);
		Integer check = dao.Del(did);
		if (check != 0) {
			System.out.println("删除成功");
			session.commit();
		} else {
			System.out.println("删除失败");
			session.rollback();
		}
	}
	//根据航班编号修改航班
	public void UpdatePlane(Plane p) {
		IPlane dao = session.getMapper(IPlane.class);
		Integer check2 = dao.Update(p);
		if (check2!=0) {
			System.out.println("修改成功");
			session.commit();
		}else {
			System.out.println("修改失败");
			session.rollback();
		}
	}
}
