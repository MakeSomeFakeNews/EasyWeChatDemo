package cn.spring4.weixin;

import com.spring4.weixin.sdk.msg.in.InEquDataMsg;
import com.spring4.weixin.sdk.msg.in.InImageMessage;
import com.spring4.weixin.sdk.msg.in.InLinkMessage;
import com.spring4.weixin.sdk.msg.in.InLocationMessage;
import com.spring4.weixin.sdk.msg.in.InNotDefinedMessage;
import com.spring4.weixin.sdk.msg.in.InShortVideoMessage;
import com.spring4.weixin.sdk.msg.in.InSpeechRecognittionRes;
import com.spring4.weixin.sdk.msg.in.InTextMessage;
import com.spring4.weixin.sdk.msg.in.InVideoMessage;
import com.spring4.weixin.sdk.msg.in.InVoiceMessage;
import com.spring4.weixin.sdk.msg.in.card.InCardPassCheckEvent;
import com.spring4.weixin.sdk.msg.in.card.InCardPayOrderEvent;
import com.spring4.weixin.sdk.msg.in.card.InCardSkuRemindEvent;
import com.spring4.weixin.sdk.msg.in.card.InMerChantOrderEvent;
import com.spring4.weixin.sdk.msg.in.card.InUpdateMemberCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserConsumeCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserGetCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserGiftingCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserPayFromCardEvent;
import com.spring4.weixin.sdk.msg.in.event.InCustomEvent;
import com.spring4.weixin.sdk.msg.in.event.InEqubindEvent;
import com.spring4.weixin.sdk.msg.in.event.InMassEvent;
import com.spring4.weixin.sdk.msg.in.event.InMenuEvent;
import com.spring4.weixin.sdk.msg.in.event.InNotDefinedEvent;
import com.spring4.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.spring4.weixin.sdk.msg.in.event.InScanQRCodeEvent;
import com.spring4.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.spring4.weixin.sdk.msg.in.event.InSubscribeEvent;
import com.spring4.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.spring4.weixin.sdk.msg.in.event.InUpLoadLocationEvent;
import com.spring4.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.spring4.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.spring4.weixin.sdk.msg.in.event.InWifiEvent;
import com.spring4.weixin.sdk.msg.out.OutTextMessage;
import com.spring4.weixin.sdk.wx.DefaultHandel;

/**
 * 作者:周锦华 日期: 2017年8月3日 上午11:00:36 </br>
 * 自己定义的微信消息处理的类，需要实现DefaultHandel
 */
public class WeixinHandler extends DefaultHandel {

	@Override
	protected String processInTextMsg(InTextMessage inTextMsg) {
		OutTextMessage out = new OutTextMessage(inTextMsg);
		/*
		 *简单的实现公众号只能聊天 
		 */
		String msg = TuLing.getMsg(inTextMsg.getContent(), inTextMsg.getFromUserName());
		out.setContent(msg);
		return out.toXml();
	}

	@Override
	protected String processInImageMsg(InImageMessage inImageMsg) {
		OutTextMessage out = new OutTextMessage(inImageMsg);
		out.setContent("图片已收到");
		return out.toXml();
	}

	@Override
	protected String processInVoiceMsg(InVoiceMessage inVoiceMsg) {
		OutTextMessage out = new OutTextMessage(inVoiceMsg);
		out.setContent("语音已收到");
		return out.toXml();
	}

	@Override
	protected String processInVideoMsg(InVideoMessage inVideoMsg) {
		OutTextMessage out = new OutTextMessage(inVideoMsg);
		out.setContent("视频已收到");
		return out.toXml();
	}

	@Override
	protected String processInShortVideoMsg(InShortVideoMessage inShortVideoMsg) {
		return null;
	}

	@Override
	protected String processInLocationMsg(InLocationMessage inLocationMsg) {
		return null;
	}

	@Override
	protected String processInLinkMsg(InLinkMessage inLinkMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInCustomEvent(InCustomEvent inCustomEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInFollowEvent(InSubscribeEvent inFollowEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInQrCodeEvent(InScanQRCodeEvent inQrCodeEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInLocationEvent(InUpLoadLocationEvent inLocationEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInMassEvent(InMassEvent inMassEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInMenuEvent(InMenuEvent inMenuEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInSpeechRecognitionResults(InSpeechRecognittionRes inSpeechRecognitionResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInWifiEvent(InWifiEvent inWifiEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInUserCardEvent(InUserCardEvent inUserCardEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInUpdateMemberCardEvent(InUpdateMemberCardEvent inUpdateMemberCardEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInUserPayFromCardEvent(InUserPayFromCardEvent inUserPayFromCardEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInMerChantOrderEvent(InMerChantOrderEvent inMerChantOrderEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processIsNotDefinedMsg(InNotDefinedMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInUserGiftingCardEvent(InUserGiftingCardEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInUserGetCardEvent(InUserGetCardEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInUserConsumeCardEvent(InUserConsumeCardEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInCardSkuRemindEvent(InCardSkuRemindEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInCardPayOrderEvent(InCardPayOrderEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInCardPassCheckEvent(InCardPassCheckEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInEqubindEvent(InEqubindEvent msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String processInEquDataMsg(InEquDataMsg msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
