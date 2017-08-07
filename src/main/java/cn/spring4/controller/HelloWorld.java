package cn.spring4.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring4.utils.StrKit;
import com.spring4.weixin.api.oauth.Oauth2Api;
import com.spring4.weixin.api.oauth.Oauth2Token;
import com.spring4.weixin.api.oauth.UserInfo;
import com.spring4.weixin.sdk.wx.Weixin;

/**
 * 作者:周锦华 日期: 2017年8月2日 下午2:54:09
 */
@Controller
public class HelloWorld {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * 接入微信，并且向微信返回信息</br>
	 * 接入流程请看 拦截器
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/weixin", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String weixin(HttpServletRequest request) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String outMsg = Weixin.getOutMsg(inputStream);
		return outMsg;
	}

	/**
	 * 获取用户授权，并且获取用户资料
	 * 
	 * @param code
	 * @param resp
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/oauth")
	public void oauth(String code, HttpServletResponse resp) throws IOException, NoSuchAlgorithmException {
		Oauth2Api o2 = new Oauth2Api();
		if (StrKit.isBlank(code)) {
			resp.sendRedirect(o2.getSnsapi_userinfoUrl());
			return;
		}
		Oauth2Token token = o2.login(code);
		UserInfo info = o2.getUserInfo(token.getAccess_token(), token.getOpenid());
		System.out.println("info==" + info.toString());
		return;
	}
}
