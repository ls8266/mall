package com.ls.junit;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.ls.dao.AddressDao;
import com.ls.dao.GoodsDao;
import com.ls.dao.GoodsPhotoDao;
import com.ls.dao.OrderDao;
import com.ls.dao.OrderGoodsDao;
import com.ls.dao.UserDao;
import com.ls.domain.Address;
import com.ls.domain.Goods;
import com.ls.domain.GoodsPhoto;
import com.ls.domain.Order;
import com.ls.domain.OrderGoods;
import com.ls.domain.User;
import com.ls.utils.SpringUtils;

public class JunitTest {

	@Test
	public void userTest() {
		ApplicationContext context = SpringUtils.getApplicationContext();
		UserDao userDao = (UserDao) context.getBean("userDao");
		for(int i=0;i<15;i++){
			User user = new User();
			user.setUsername(i+"");
			userDao.add(user);
		}
		User user = (User) userDao.getFieldById(User.class, 7);
		System.out.println("user:"+user.getId()+"  ----  "+user.getUsername());
		List list = userDao.getUsers(1);
		Iterator it = list.iterator();
		while(it.hasNext()){
			User u = (User) it.next();
			System.out.println("iterator user:"+u.getId()+"  ----  "+u.getUsername());
		}
		System.out.println("user count:"+userDao.getUserCount());
		System.out.println("------------");
		AddressDao addressDao = (AddressDao) context.getBean("addressDao");
		for(int i=0;i<10;i++){
			Address address = new Address();
			address.setAddress("昆明"+i);
			address.setPhone("13575548547----"+i);
			address.setUser(user);
			try{
				addressDao.add(address);
			}catch(RuntimeException e){
				System.out.println("一个用户最多只能保留五个收货地址");
			}
		}
		
		Address addressById = (Address) addressDao.getFieldById(1);
		System.out.println("addressById: "+addressById.getAddress()+"  --  "+addressById.getPhone());
		List addList = addressDao.getFieldByUser(user);
		it = addList.iterator();
		while(it.hasNext()){
			Address addressByUser = (Address) it.next();
			System.out.println("addressByUser: "+addressByUser.getAddress()+"  --  "+addressByUser.getPhone());
		}
	}
	
	@Test
	public void goodsTest(){
		ApplicationContext context = SpringUtils.getApplicationContext();
		GoodsDao goodsDao = (GoodsDao) context.getBean("goodsDao");
		GoodsPhotoDao goodsPhotoDao = (GoodsPhotoDao) context.getBean("goodsPhotoDao");
		for(int i=0;i<15;i++){
			Goods goods = new Goods();
			goods.setName("商品--"+i);
			goods.setNumber(100+i);
			goodsDao.add(goods);
		}
		Goods goodsById = (Goods) goodsDao.getFieldById(8);
		System.out.println("goodsById:"+ goodsById.getName()+" 还剩："+goodsById.getNumber());
		List list = goodsDao.getGoods(2);
		Iterator it = list.iterator();
		while(it.hasNext()){
			Goods goods = (Goods) it.next();
			System.out.println("goods:"+ goods.getName()+" 还剩："+goods.getNumber());
		}
		
		System.out.println("总共有商品："+goodsDao.getGoodsCount());
		for(int i=0;i<13;i++){
			GoodsPhoto goodsPhoto = new GoodsPhoto();
			goodsPhoto.setGoods(goodsById);
			goodsPhoto.setPhotoName(i+".jpg");
			try{
				goodsPhotoDao.add(goodsPhoto);
			}catch(RuntimeException e){
				System.out.println("一件商品只能保存10张图片");
			}
		}
		GoodsPhoto goodsPhotoById = (GoodsPhoto) goodsPhotoDao.getFieldById(4);
		System.out.println("goodsPhotoById"+goodsPhotoById.getPhotoName());
		list = goodsPhotoDao.getGoodsPhotos(goodsById);
		it = list.iterator();
		while(it.hasNext()){
			GoodsPhoto goodsPhotoByGoods = (GoodsPhoto) it.next();
			System.out.println("goodsPhotoByGoods"+goodsPhotoByGoods.getPhotoName());
		}
	}
	
	//出现问题 疑似懒加载 学习后解决
	@Test
	public void orderTest(){
		ApplicationContext context = SpringUtils.getApplicationContext();
		OrderDao orderDao = (OrderDao) context.getBean("orderDao");
		OrderGoodsDao orderGoodsDao = (OrderGoodsDao) context.getBean("orderGoodsDao");
		User user = new User();
		((UserDao) context.getBean("userDao")).add(user);
		for(int i=0;i<45;i++){
			Order order = new Order();
			if(i<15){ 
				order.setStatus(0);
			}else if(i>=15&&i<30){ 
				order.setStatus(1);
			}else if(i>=30){
				order.setStatus(2);
			}
			order.setUser(user);
			orderDao.add(order);
		}
		Order order = (Order) orderDao.getFieldById(4);
		System.out.println("orderById:"+order.getStatus());
		List list = orderDao.getOffOrder(user, 1);
		Iterator it = list.iterator();
		while(it.hasNext()){
			order = (Order) it.next();
			System.out.println("offorder:"+order.getId()+"----"+order.getStatus());
		}
		System.out.println("offCount"+orderDao.getOffOrderCount(user));
		list = orderDao.getPayOrder(user, 2);
		it = list.iterator();
		while(it.hasNext()){
			order = (Order) it.next();
			System.out.println("payorder:"+order.getId()+"----"+order.getStatus());
		}
		System.out.println("payCount"+orderDao.getPayOrderCount(user));
		list = orderDao.getSuccessOrder(user, 1);
		it = list.iterator();
		while(it.hasNext()){
			order = (Order) it.next();
			System.out.println("successOrder:"+order.getId()+"----"+order.getStatus());
		}
		System.out.println("successCount"+orderDao.getSuccessOrderCount(user));
		System.out.println("----------------------------------------");
		Goods goods = new Goods();
		goods.setName("云南山泉");
		((GoodsDao) context.getBean("goodsDao")).add(goods);
		for(int i=0;i<12;i++){
			OrderGoods orderGoods= new OrderGoods();
			orderGoods.setGoods(goods);
			orderGoods.setOrder(order);
			orderGoodsDao.add(orderGoods);
		}
		OrderGoods orderGoodsById = (OrderGoods) orderGoodsDao.getFieldById(6);
		//懒加载出现问题处
		System.out.println("byId 商品："+orderGoodsById.getGoods().getName()+"订单："+orderGoodsById.getOrder().getId());
		list = orderGoodsDao.getOrderGoods(order);
		it = list.iterator();
		while(it.hasNext()){
			OrderGoods orderGoodsByOrder = (OrderGoods) it.next();
			System.out.println("orderGoodsByOrder 商品："+orderGoodsByOrder.getGoods().getName()+"订单："+orderGoodsByOrder.getOrder().getId());
		}
	}
}
