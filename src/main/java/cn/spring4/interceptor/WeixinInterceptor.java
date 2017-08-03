package cn.spring4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring4.weixin.sdk.msg.WeiXinAccess;
import com.spring4.weixin.utils.PropertiesUtil;

/**
 * 作者:周锦华 日期: 2017年8月2日 下午3:25:22
 */
public class WeixinInterceptor implements HandlerInterceptor {
	/**
	 * 如果请求为get，则为微信认证接入
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			return true;
		}
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		boolean checkSignature = WeiXinAccess.checkSignature(PropertiesUtil.getToken(), signature, timestamp, nonce);
		if (!checkSignature) {
			System.out.println("请确认请求是否来自微信");
			return false;
		}
		response.getOutputStream().write(echostr.getBytes("utf-8"));
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
