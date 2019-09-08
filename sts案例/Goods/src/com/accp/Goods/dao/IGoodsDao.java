package com.accp.Goods.dao;

import java.util.ArrayList;

import com.accp.Goods.entity.Most1;
import com.accp.Goods.entity.Productdescription;
import com.accp.Goods.entity.Users;

public interface IGoodsDao {

	Users Login(Integer uid, String upwd);

	//����µ��û�
	int addUser(Users user);

	// �����Ʒ
	int addProuduct(Productdescription pro);

	// ����������Ʒ
	ArrayList<Productdescription> SelectAllPro();

	//ע���û�
	Integer LogoutUser(Integer lid);

	//��ѯ��ע�����˺�
	ArrayList<Users> SelLogoutUser();

	// ������Ʒid������ƷͼƬ
	String SelProImg(String pid);

	// ������Ʒ����޸���Ʒ����
	int UpdatePro(Productdescription pro);

	// ������Ʒ���ɾ����Ӧ��Ʒ
	int DeletePro(String did);

	//�������ƻ��̱���ͺŽ��в�ѯ
	ArrayList<Productdescription> SelProBySome(String type, String word);

	//�����û���Żָ���ע�����û�
	int RecoverUser(Integer uid);

	//��ѯ�����û�
	ArrayList<Most1> SelAllUser();

	//�����û����ɾ���û�
	int DelUser(Integer did);

	//�����û�����޸��û���Ϣ
	int UpdateUser(Users user);

	//�����û���Ų��Ҷ�Ӧ�û�
	Users SelectUserById(Integer uid);

}