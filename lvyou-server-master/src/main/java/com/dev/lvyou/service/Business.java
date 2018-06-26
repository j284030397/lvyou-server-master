package com.dev.lvyou.service;

import com.dev.lvyou.model.request.ResponseHeader;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;

public abstract interface Business
{
  public abstract Response getBusiDataQryHotTouristSpotList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataUserRegister(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataPerfectInformation(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataCheckUserAuth(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataUpdateWantToSpots(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQrySpotUserList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataPublishMsg(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryHotCityList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryTouristSpotListByName(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryCityListByName(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryUserWantToSpotList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryUserWantToCityList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataAlbumManage(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryAlbumList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataUserImageManage(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryUserImageList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataPhotoWallManage(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQueryUserInfoByUserName(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQueryDynamicinfo(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataDynamicinfoManage(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataPublicDynamicComment(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataUpdateLocation(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryTouristSpotListBySid(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataUpdateWantToCity(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryCityUserList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryCityBySid(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryDynamicInfo(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryWantToHeadUrlList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryDynamicInfoById(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryNearSpots(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataTogetherTourManage(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQryTogetherTour(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataQqLogin(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataFriendsList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataFriendManager(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataFriendMeList(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataDynamicReport(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataDynamicFabulous(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataDynamicFabulousCount(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataFriendsListCount(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;

  public abstract Response getBusiDataFriendMeListCount(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws JsonProcessingException, Exception;
}