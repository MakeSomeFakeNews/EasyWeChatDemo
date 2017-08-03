package cn.spring4.weixin;


import com.spring4.weixin.utils.HttpClientUtil;

public class TuLing {
	public static String  getMsg(String msg, String userid) {
		String key = "c9119da41b124ed18988a39b63cc6857";// PropertiesUtil.getTulingKey();
		String url = "http://www.tuling123.com/openapi/api";
		StringBuffer sb = new StringBuffer();
		sb.append("{\n\t");
		sb.append("\"key\": \"" + key + "\",\n\t");
		sb.append("\"info\": \"" + msg + "\",\n\t");
		sb.append("\"userid\": \"" + userid + "\"\n");
		sb.append("}");
		System.out.println(sb.toString());
		return HttpClientUtil.postJson(url, sb.toString());
	}
}
