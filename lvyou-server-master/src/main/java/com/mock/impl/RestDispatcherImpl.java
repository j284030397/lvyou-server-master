package com.mock.impl;

import com.dev.lvyou.InterfaceList;
import com.dev.lvyou.model.request.ReqPara;
import com.dev.lvyou.model.request.ReqPara.MsgHeader;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.Business;
import com.mock.ResponseUtil;
import com.mock.RestDispatcher;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("restDispatcher")
public class RestDispatcherImpl
  implements RestDispatcher
{
  private static final Logger log = LoggerFactory.getLogger(RestDispatcherImpl.class);
  private static final String LOGIN_ERROR_CODE = "9000010003";
  private static final String ARGMENTS_ERROR_CODE = "9000010002";
  private static final String SERVICES_ERROR_CODE = "9009999999";
  private static final String BIZE_NULL_CODE = "9000010001";
  ResponseHeader responseHeader = new ResponseHeader();
  RetInfo retinfo;

  @Autowired
  private Business business;

  public Response adaptRequest(String data, ReqPara reqPara)
    throws Exception
  {
    String bizCode = reqPara.getMsgreqheader().getBizCode();
    if ((bizCode == null) || (bizCode.equals(""))) {
      log.info("业务编码为空!");
      this.retinfo = new RetInfo("9000010001", "业务编码为空!");
      this.responseHeader.setRetinfo(this.retinfo);
      return ResponseUtil.responseMsg(this.responseHeader, null);
    }
    this.responseHeader.setRsp_seq(reqPara.getMsgreqheader().getReq_seq());
    this.responseHeader.setRsp_app(reqPara.getMsgreqheader().getReq_app());
    this.responseHeader.setRsp_time(reqPara.getMsgreqheader().getReq_time());
    this.responseHeader.setRsp_seq(reqPara.getMsgreqheader().getReq_seq());
    this.responseHeader.setRsp_app(reqPara.getMsgreqheader().getReq_app());
    this.responseHeader.setRsp_time(reqPara.getMsgreqheader().getReq_time());
    if ((bizCode != null) && (Arrays.asList(InterfaceList.intfcName).contains(bizCode))) {
      JSONObject jsonObject = JSONObject.fromObject(data);
      JSONObject msgBody = (JSONObject)jsonObject.get("msgbody");
      return adaptResponse(bizCode, this.responseHeader, msgBody);
    }
    log.info("业务编码为空!");
    this.retinfo = new RetInfo("9000010001", "业务编码不存在!");
    this.responseHeader.setRetinfo(this.retinfo);
    return ResponseUtil.responseMsg(this.responseHeader, null);
  }

  public Response adaptRequestNoLogin(String data, ReqPara reqPara) throws Exception
  {
    log.info("接收json参数! " + data);
    String bizCode = reqPara.getMsgreqheader().getBizCode();
    if ((bizCode == null) || (bizCode.equals(""))) {
      log.info("业务编码为空!");
      RetInfo retinfo = new RetInfo("9000010001", "业务编码为空!");
      this.responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(this.responseHeader, null);
    }
    this.responseHeader.setRsp_seq(reqPara.getMsgreqheader().getReq_seq());
    this.responseHeader.setRsp_app(reqPara.getMsgreqheader().getReq_app());
    this.responseHeader.setRsp_time(reqPara.getMsgreqheader().getReq_time());
    this.responseHeader.setRsp_seq(reqPara.getMsgreqheader().getReq_seq());
    this.responseHeader.setRsp_app(reqPara.getMsgreqheader().getReq_app());
    this.responseHeader.setRsp_time(reqPara.getMsgreqheader().getReq_time());
    if ((bizCode != null) && (Arrays.asList(InterfaceList.intfcName).contains(bizCode))) {
      JSONObject jsonObject = JSONObject.fromObject(data);
      JSONObject msgBody = (JSONObject)jsonObject.get("msgbody");
      return adaptResponse(bizCode, this.responseHeader, msgBody);
    }
    log.info("业务编码为空!");
    this.retinfo = new RetInfo("9000010001", "业务编码不存在!");
    this.responseHeader.setRetinfo(this.retinfo);
    return ResponseUtil.responseMsg(this.responseHeader, null);
  }

  public Response adaptResponse(String bizCode, ResponseHeader responseHeader, JSONObject msgBody) throws Exception
  {
    if (bizCode.equals("qryHotTouristSpotList")) {
      log.debug("bizCode qryHotTouristSpotList..");
      return this.business.getBusiDataQryHotTouristSpotList(responseHeader, msgBody);
    }
    if (bizCode.equals("userRegister")) {
      log.debug("bizCode userRegister..");
      return this.business.getBusiDataUserRegister(responseHeader, msgBody);
    }
    if (bizCode.equals("perfectInformation")) {
      log.debug("bizCode perfectInformation..");
      return this.business.getBusiDataPerfectInformation(responseHeader, msgBody);
    }
    if (bizCode.equals("checkUserAuth")) {
      log.debug("bizCode checkUserAuth..");
      return this.business.getBusiDataCheckUserAuth(responseHeader, msgBody);
    }
    if (bizCode.equals("updateWantToSpots")) {
      log.debug("bizCode updateWantToSpots..");
      return this.business.getBusiDataUpdateWantToSpots(responseHeader, msgBody);
    }
    if (bizCode.equals("qrySpotUserList")) {
      log.debug("bizCode qrySpotUserList..");
      return this.business.getBusiDataQrySpotUserList(responseHeader, msgBody);
    }
    if (bizCode.equals("publishMsg")) {
      log.debug("bizCode publishMsg..");
      return this.business.getBusiDataPublishMsg(responseHeader, msgBody);
    }
    if (bizCode.equals("qryHotCityList")) {
      log.debug("bizCode qryHotCityList..");
      return this.business.getBusiDataQryHotCityList(responseHeader, msgBody);
    }
    if (bizCode.equals("qryTouristSpotListByName")) {
      log.debug("bizCode qryTouristSpotListByName..");
      return this.business.getBusiDataQryTouristSpotListByName(responseHeader, msgBody);
    }
    if (bizCode.equals("qryCityListByName")) {
      log.debug("bizCode qryCityListByName..");
      return this.business.getBusiDataQryCityListByName(responseHeader, msgBody);
    }
    if (bizCode.equals("qryUserWantToSpotList")) {
      log.debug("bizCode qryUserWantToSpotList..");
      return this.business.getBusiDataQryUserWantToSpotList(responseHeader, msgBody);
    }
    if (bizCode.equals("qryUserWantToCityList")) {
      log.debug("bizCode qryUserWantToCityList..");
      return this.business.getBusiDataQryUserWantToCityList(responseHeader, msgBody);
    }
    if (bizCode.equals("albumManage")) {
      log.debug("bizCode albumManage..");
      return this.business.getBusiDataAlbumManage(responseHeader, msgBody);
    }
    if (bizCode.equals("qryAlbumList")) {
      log.debug("bizCode qryAlbumList..");
      return this.business.getBusiDataQryAlbumList(responseHeader, msgBody);
    }
    if (bizCode.equals("userImageManage")) {
      log.debug("bizCode userImageManage..");
      return this.business.getBusiDataUserImageManage(responseHeader, msgBody);
    }
    if (bizCode.equals("qryUserImageList")) {
      log.debug("bizCode qryUserImageList..");
      return this.business.getBusiDataQryUserImageList(responseHeader, msgBody);
    }
    if (bizCode.equals("photoWallManage")) {
      log.debug("bizCode photoWallManage..");
      return this.business.getBusiDataPhotoWallManage(responseHeader, msgBody);
    }
    if (bizCode.equals("queryUserInfoByUserName")) {
      log.debug("bizCode queryUserInfoByUserName..");
      return this.business.getBusiDataQueryUserInfoByUserName(responseHeader, msgBody);
    }
    if (bizCode.equals("queryDynamicinfo")) {
      log.debug("bizCode queryDynamicinfo..");
      return this.business.getBusiDataQueryDynamicinfo(responseHeader, msgBody);
    }
    if (bizCode.equals("dynamicinfoManage")) {
      log.debug("bizCode dynamicinfoManage..");
      return this.business.getBusiDataDynamicinfoManage(responseHeader, msgBody);
    }
    if (bizCode.equals("publicDynamicComment")) {
      log.debug("bizCode publicDynamicComment..");
      return this.business.getBusiDataPublicDynamicComment(responseHeader, msgBody);
    }
    if (bizCode.equals("updateLocation")) {
      log.debug("bizCode updateLocation..");
      return this.business.getBusiDataUpdateLocation(responseHeader, msgBody);
    }
    if (bizCode.equals("qryTouristSpotListBySid")) {
      log.debug("bizCode qryTouristSpotListBySid..");
      return this.business.getBusiDataQryTouristSpotListBySid(responseHeader, msgBody);
    }
    if (bizCode.equals("updateWantToCity")) {
      log.debug("bizCode updateWantToCity..");
      return this.business.getBusiDataUpdateWantToCity(responseHeader, msgBody);
    }
    if (bizCode.equals("qryCityUserList")) {
      log.debug("bizCode qryCityUserList..");
      return this.business.getBusiDataQryCityUserList(responseHeader, msgBody);
    }
    if (bizCode.equals("qryCityBySid")) {
      log.debug("bizCode qryCityBySid..");
      return this.business.getBusiDataQryCityBySid(responseHeader, msgBody);
    }
    if (bizCode.equals("qryDynamicInfo")) {
      log.debug("bizCode qryDynamicInfo..");
      return this.business.getBusiDataQryDynamicInfo(responseHeader, msgBody);
    }
    if (bizCode.equals("qryWantToHeadUrlList")) {
      log.debug("bizCode qryWantToHeadUrlList..");
      return this.business.getBusiDataQryWantToHeadUrlList(responseHeader, msgBody);
    }
    if (bizCode.equals("qryDynamicInfoById")) {
      log.debug("bizCode qryDynamicInfoById..");
      return this.business.getBusiDataQryDynamicInfoById(responseHeader, msgBody);
    }
    if (bizCode.equals("qryNearSpots")) {
      log.debug("bizCode qryNearSpots..");
      return this.business.getBusiDataQryNearSpots(responseHeader, msgBody);
    }
    if (bizCode.equals("togetherTourManage")) {
      log.debug("bizCode togetherTourManage..");
      return this.business.getBusiDataTogetherTourManage(responseHeader, msgBody);
    }
    if (bizCode.equals("qryTogetherTour")) {
      log.debug("bizCode qryTogetherTour..");
      return this.business.getBusiDataQryTogetherTour(responseHeader, msgBody);
    }
    if (bizCode.equals("qqLogin")) {
      log.debug("bizCode qqLogin..");
      return this.business.getBusiDataQqLogin(responseHeader, msgBody);
    }
    if (bizCode.equals("friendsList")) {
      log.debug("bizCode friendsList..");
      return this.business.getBusiDataFriendsList(responseHeader, msgBody);
    }
    if (bizCode.equals("friendsMeList")) {
      log.debug("bizCode friendsMeList..");
      return this.business.getBusiDataFriendMeList(responseHeader, msgBody);
    }
    if (bizCode.equals("friendManager")) {
      log.debug("bizCode friendManager..");
      return this.business.getBusiDataFriendManager(responseHeader, msgBody);
    }
    if (bizCode.equals("dynamicFabulous")) {
      log.debug("bizCode dynamicFabulous..");
      return this.business.getBusiDataDynamicFabulous(responseHeader, msgBody);
    }
    if (bizCode.equals("dynamicReport")) {
      log.debug("bizCode dynamicReport..");
      return this.business.getBusiDataDynamicReport(responseHeader, msgBody);
    }

    if (bizCode.equals("dynamicFabulousCount")) {
      log.debug("bizCode dynamicFabulousCount..");
      return this.business.getBusiDataDynamicFabulousCount(responseHeader, msgBody);
    }
    if (bizCode.equals("friendsListCount")) {
      log.debug("bizCode friendsListCount..");
      return this.business.getBusiDataFriendsListCount(responseHeader, msgBody);
    }
    if (bizCode.equals("friendMeListCount")) {
      log.debug("bizCode friendMeListCount..");
      return this.business.getBusiDataFriendMeListCount(responseHeader, msgBody);
    }
    this.retinfo = new RetInfo("0", "请求成功!");
    responseHeader.setRetinfo(this.retinfo);
    return ResponseUtil.responseMsg(responseHeader, null);
  }
}