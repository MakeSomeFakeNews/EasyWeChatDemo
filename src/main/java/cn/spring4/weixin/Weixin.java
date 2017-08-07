package cn.spring4.weixin;

import java.util.ArrayList;
import java.util.List;

import com.spring4.weixin.api.menu.MenuApi;
import com.spring4.weixin.api.menu.WeixinMenu;
import com.spring4.weixin.api.token.Access_Token;
import com.spring4.weixin.api.token.TokenApi;

/**
 * Weixin.java文件：作用简介</br>
 * 这个类演示一些常用的操作</br>
 * 作者:周锦华</br>
 * 日期: 2017年8月3日 上午11:33:19
 */
public class Weixin {
	/**
	 * 创建菜单操作
	 */
	public void menuTest() {
		//一级菜单
		WeixinMenu weixinMenu = new WeixinMenu();
		weixinMenu.setName("一级菜单");
		//点开后的菜单
		WeixinMenu wm = new WeixinMenu();
		wm.setName("打开百度");
		wm.setType("view");
		wm.setUrl("http://www.baidu.com/");
		// 创建子菜单
		List<WeixinMenu> list = new ArrayList<WeixinMenu>();
		list.add(wm);
		weixinMenu.setSub_button(list);
		MenuApi menu = new MenuApi();
		//获取基础access_token
		TokenApi token = new TokenApi();
		Access_Token access_token = token.get_access_token();
		menu.createMenu(weixinMenu, access_token.getAccess_token());
	}
}
