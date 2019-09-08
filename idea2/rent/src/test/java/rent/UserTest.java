package rent;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.accp.biz.UserBiz;
import com.accp.dao.IUserDao;
import com.accp.pojo.District;
import com.accp.pojo.House;
import com.accp.pojo.Province;
import com.accp.pojo.user;
import com.accp.util.CgLibTransProxyUtil;
import com.accp.vo.HouseFabuVo;
import com.accp.vo.LikeHouseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class UserTest {
	UserBiz biz = CgLibTransProxyUtil.getTransProxyObject(UserBiz.class);

	@Test
	public void find() {
		Integer num = 1;
		for (; true;) {
			Scanner in = new Scanner(System.in);
//			System.out.println("输入当前页");
//			Integer num = in.nextInt();
			PageHelper.startPage(num, 2);
			PageInfo<user> pageInfo = new PageInfo<user>(biz.findUsers());
			System.out.println("上一页,下一页(1-2)");
			String cao = in.nextLine();
			if ("1".equals(cao)) { // 上一页
				if (pageInfo.isHasPreviousPage()) {
					num--;
					PageHelper.startPage(num, 2);
					pageInfo = new PageInfo<user>(biz.findUsers());
				}else {
					System.out.println("没有上一页----------------------------------------------------------------");
				}
			} else if ("2".equals(cao)) { // 下一页
				if (pageInfo.isHasNextPage()) {
					num++;
					PageHelper.startPage(num, 2);
					pageInfo = new PageInfo<user>(biz.findUsers());
				}else {
					System.out.println("没有下一页---------------------------------------------------------------");
				}
			}

			List<user> list = pageInfo.getList();
			for (user user : list) {
				System.out.println(user);
			}
			System.out.println("当前页"+pageInfo.getPageNum()+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
	}

	@Test
	public void findUser() {
		UserBiz biz = CgLibTransProxyUtil.getTransProxyObject(UserBiz.class);
		user u = biz.findUser("李棋", "123456");
		List<House> list = biz.findHouses(u);
		for (House h : list) {
			System.out.println(h);
		}

	}

	@Test
	public void dis() {
		List<District> dis = biz.findDis("1");
		System.out.println(dis);
	}

	@Test
	public void addHouse() {
		user u = new user();
		u.setUid(1);
		HouseFabuVo vo = new HouseFabuVo("李棋", "img", "1", "400", "3000", "2019-02-13", "1", "12345678912", "草泥马", u);
		biz.addHouse(vo);
	}

	@Test
	public void findHouse() {
		House h = biz.findHouse("4");
		System.out.println(h.getHtype().getTname());
		System.out.println(h);
	}

	@Test
	public void likeHouses() {
		LikeHouseVo l = new LikeHouseVo("皇上", "1", null, "1", null, "1", "400");
		List<House> list = biz.likeHouses(l);
		for (House h : list) {
			System.out.println(h);
		}
	}
	/**
	 * 查询省
	 */
	@Test
	public void findProvinces() {
		List<Province> list = biz.findProvinces();
		for (Province p : list) {
			System.out.println(p);
		}
	}
}
