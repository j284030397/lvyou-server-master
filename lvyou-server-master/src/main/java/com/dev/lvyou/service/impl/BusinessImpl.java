package com.dev.lvyou.service.impl;

import com.dev.base.cache.Memory;
import com.dev.base.constants.Constants;
import com.dev.base.spring.SpringContextHolder;
import com.dev.base.util.DateUtil2;
import com.dev.base.util.PageObj;
import com.dev.base.util.StringUtil;
import com.dev.base.util.map.BeanToMapUtil;
import com.dev.common.QueryObject;
import com.dev.common.QueryParam;
import com.dev.lvyou.constants.LyConstant;
import com.dev.lvyou.dao.model.LyAlbumDetailImage;
import com.dev.lvyou.dao.model.LyAreaInfo;
import com.dev.lvyou.dao.model.LyHotCity;
import com.dev.lvyou.dao.model.LyHotTouristSpots;
import com.dev.lvyou.dao.model.LyTouristSpots;
import com.dev.lvyou.dao.model.LyTouristSpotsDetail;
import com.dev.lvyou.dao.model.LyUserFriend;
import com.dev.lvyou.dao.model.LyUserImage;
import com.dev.lvyou.dao.model.LyUserInfo;
import com.dev.lvyou.dao.model.LyUserSessionInfo;
import com.dev.lvyou.dao.model.LyUserWantToCity;
import com.dev.lvyou.dao.model.LyWantTo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.Business;
import com.dev.lvyou.service.LyAlbumDetailImageService;
import com.dev.lvyou.service.LyAlbumInfoService;
import com.dev.lvyou.service.LyAlbumService;
import com.dev.lvyou.service.LyAreaInfoService;
import com.dev.lvyou.service.LyDynamicFabulousService;
import com.dev.lvyou.service.LyDynamicReportInfoService;
import com.dev.lvyou.service.LyDynamiccommentinfoService;
import com.dev.lvyou.service.LyDynamicinfoService;
import com.dev.lvyou.service.LyHotCityService;
import com.dev.lvyou.service.LyHotTouristSpotsService;
import com.dev.lvyou.service.LyPhotoWallService;
import com.dev.lvyou.service.LyTogetherTourService;
import com.dev.lvyou.service.LyTouristSpotsDetailService;
import com.dev.lvyou.service.LyTouristSpotsService;
import com.dev.lvyou.service.LyUserFriendService;
import com.dev.lvyou.service.LyUserImageService;
import com.dev.lvyou.service.LyUserInfoService;
import com.dev.lvyou.service.LyUserSessionInfoService;
import com.dev.lvyou.service.LyUserWantToCityService;
import com.dev.lvyou.service.LyWantToService;
import com.dev.lvyou.web.controller.dto.Location;
import com.dev.lvyou.web.controller.dto.LyAlbumDetailImageDto;
import com.dev.lvyou.web.controller.dto.LyAlbumDto;
import com.dev.lvyou.web.controller.dto.LyAlbumInfoDto;
import com.dev.lvyou.web.controller.dto.LyAreaInfoDto;
import com.dev.lvyou.web.controller.dto.LyDynamiccommentinfoDto;
import com.dev.lvyou.web.controller.dto.LyDynamicinfoDto;
import com.dev.lvyou.web.controller.dto.LyTouristSpotsDetailDto;
import com.dev.lvyou.web.controller.dto.LyTouristSpotsDto;
import com.dev.lvyou.web.controller.dto.LyUserInfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.ResponseUtil;
import io.rong.RongCloud;
import io.rong.messages.TxtMessage;
import io.rong.methods.Message;
import io.rong.methods.User;
import io.rong.models.CodeSuccessReslut;
import io.rong.models.TokenReslut;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("business")
public class BusinessImpl
  implements Business
{
  private static final Logger log = LoggerFactory.getLogger(BusinessImpl.class);

  @Autowired
  private LyTouristSpotsService lyTouristSpotsService;

  @Autowired
  private LyHotTouristSpotsService lyHotTouristSpotsService;

  @Autowired
  private LyUserInfoService lyUserInfoService;

  @Autowired
  private LyUserSessionInfoService lyUserSessionInfoService;

  @Autowired
  private LyWantToService lyWantToService;

  @Autowired
  private LyUserImageService lyUserImageService;

  @Autowired
  LyAreaInfoService lyAreaInfoService;

  @Autowired
  LyHotCityService lyHotCityService;

  @Autowired
  LyUserWantToCityService lyUserWantToCityService;

  @Autowired
  LyAlbumService lyAlbumService;

  @Autowired
  LyAlbumInfoService lyAlbumInfoService;

  @Autowired
  LyPhotoWallService lyPhotoWallService;

  @Autowired
  LyDynamicinfoService lyDynamicinfoService;

  @Autowired
  LyDynamiccommentinfoService lyDynamiccommentinfoService;

  @Autowired
  LyTogetherTourService lyTogetherTourService;

  @Autowired
  LyTouristSpotsDetailService lyTouristSpotsDetailService;

  @Autowired
  private LyAlbumDetailImageService lyAlbumDetailImageService;

  @Autowired
  private LyUserFriendService lyUserFriendService;

  @Autowired
  private LyDynamicFabulousService lyDynamicFabulousService;

  @Autowired
  private LyDynamicReportInfoService lyDynamicReportInfoService;

  public Response getBusiDataQryHotTouristSpotList(ResponseHeader responseHeader, JSONObject msgBody) throws Exception { String userName = (String)msgBody.get("userName");
    QueryObject queryObject = new QueryObject();
    if ((userName == null) || (userName.equals(""))) {
      queryObject.setSelectId("query_HotTouristSpotListNoLogin");
    } else {
      queryObject.setSelectId("query_HotTouristSpotList");
      queryObject.getStaticParam().put("userName", userName);
    }

    JSONObject requestPage = (JSONObject)msgBody.get("pageObj");
    PageObj pageObj = new PageObj();
    if (requestPage != null) {
      int curPage = requestPage.getInt("currPage");
      int pageSize = LyConstant.pageSize;

      pageObj.setCurrPage(Integer.valueOf(curPage));

      pageObj.setPageSize(Integer.valueOf(pageSize));
      queryObject.setPageObj(pageObj);
    }

    queryObject = this.lyHotTouristSpotsService.query(queryObject);
    List queryList = queryObject.getResults();
    List<LyTouristSpotsDto> newList = new ArrayList();
    newList = BeanToMapUtil.convertListMap2ListBean(queryList, LyTouristSpotsDto.class);
    for (LyTouristSpotsDto touristSpotDto : newList) {
      Location location = new Location();
      location.setLat(touristSpotDto.getLat());
      location.setLng(touristSpotDto.getLng());
      touristSpotDto.setcLocation(location);
    }
    Map msgResBody = new HashMap();
    msgResBody.put("touristSpotList", newList);
    int total = queryObject.getTotalCount();
    pageObj.setTotalPage(Integer.valueOf(total));
    msgResBody.put("pageObj", pageObj);
    return ResponseUtil.responseMsg(responseHeader, msgResBody); }

  public Response getBusiDataUserRegister(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("userRegister方法...");
    try {
      LyUserInfo lyUserInfo = new LyUserInfo();
      String userName = (String)msgBody.get("userName");
      String userPassword = (String)msgBody.get("userPassword");

      lyUserInfo.setUserName(userName);
      lyUserInfo.setUserPassword(userPassword);
      this.lyUserInfoService.createLyUserInfo(lyUserInfo);
      RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

      TokenReslut userGetTokenResult = rongCloud.user.getToken(String.valueOf(lyUserInfo.getSid()), 
        lyUserInfo.getUserName(), "http://www.rongcloud.cn/images/logo.png");
      lyUserInfo.setToken(userGetTokenResult.getToken());
      this.lyUserInfoService.updateLyUserInfo(lyUserInfo);
      log.debug(userGetTokenResult.getToken() + ":=: " + lyUserInfo.getToken());
      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("'" + lyUserInfo.getUserName() + "'");
      params.add(qp);
      queryObject.setParameters(params);
      List lyUserInfoList = this.lyUserInfoService.queryLyUserInfo(queryObject).getResults();
      Map lyUserInfoMap = (Map)lyUserInfoList.get(0);
      lyUserInfoMap.put(StringUtil.underscoreName("token"), lyUserInfo.getToken());

      String userJson = new ObjectMapper().writeValueAsString(lyUserInfoMap);
      log.debug(userJson);

      LyUserInfoDto lyUserInfoDto = (LyUserInfoDto)JSONObject.toBean(JSONObject.fromObject(userJson), 
        LyUserInfoDto.class);
      Memory memory = (Memory)SpringContextHolder.getBean("memory");
      memory.saveLyUserInfoDto(lyUserInfoDto);
      Map msgResBody = new HashMap();
      msgResBody.put("userInfo", lyUserInfoDto);
      RetInfo retinfo = new RetInfo("0", "注册成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataPublishMsg(ResponseHeader responseHeader, JSONObject msgBody) throws Exception
  {
    log.debug("publishMsg方法...");
    try
    {
      String fromUserId = (String)msgBody.get("fromUserId");
      String toUserId = (String)msgBody.get("toUserId");
      String content = (String)msgBody.get("content");
      RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

      String[] messagePublishSystemToUserId = { toUserId };
      TxtMessage messagePublishSystemTxtMessage = new TxtMessage(content, "helloExtra");
      CodeSuccessReslut messagePublishSystemResult = rongCloud.message.PublishSystem(fromUserId, 
        messagePublishSystemToUserId, messagePublishSystemTxtMessage, "thisisapush", 
        "{\"pushData\":\"hello\"}", Integer.valueOf(0), Integer.valueOf(0));

      RetInfo retinfo = new RetInfo("0", "发送消息成功！");
      responseHeader.setRetinfo(retinfo);
      return Response.status(200).entity(new ObjectMapper().writeValueAsString(responseHeader)).build();
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", "发送消息失败！");
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataUpdateWantToSpots(ResponseHeader responseHeader, JSONObject msgBody) throws Exception
  {
    log.debug("updateWantToSpots方法...");

    String userName = (String)msgBody.get("userName");
    String spotSid = (String)msgBody.get("spotSid");
    String type = (String)msgBody.get("type");

    QueryObject queryObject = new QueryObject();
    Collection params = new ArrayList();
    QueryParam qp = new QueryParam();
    qp.setKey("UserName");
    qp.setLogicOper(" = ");
    qp.setValue("'" + userName + "'");
    params.add(qp);
    QueryParam qp2 = new QueryParam();
    qp2.setKey("SpotSid");
    qp2.setLogicOper(" = ");
    qp2.setValue(spotSid);
    params.add(qp2);
    queryObject.setParameters(params);
    List list = this.lyWantToService.queryLyWantTo(queryObject).getResults();
    int tourSpotSid = Integer.parseInt(spotSid);

    String sql = "select count(*) from t_ly_wantto t where t.SpotSid=?";
    List countParam = new ArrayList();
    countParam.add(Integer.valueOf(tourSpotSid));
    if ((type.equals("0")) && 
      (list.size() > 0)) {
      Map map = (Map)list.get(0);
      int totalPeople = this.lyWantToService.countByCondtion(sql, countParam);
      this.lyWantToService.removeLyWantTo(Integer.valueOf(Integer.parseInt((String)map.get(StringUtil.underscoreName("SID")))));
      String sql2 = "select count(*) from t_ly_HotTouristSpots  a where a.SpotSid=?";
      List sqlParam = new ArrayList();
      sqlParam.add(Integer.valueOf(tourSpotSid));
      int isExsitHot = this.lyHotTouristSpotsService.countByCondtion(sql, sqlParam);

      if (isExsitHot > 0)
      {
        Collection lyHotTouristSpotsList = this.lyHotTouristSpotsService
          .queryLyHotTouristSpotsByField("lyTouristSpots.sid", Integer.valueOf(tourSpotSid));
        Iterator iter = lyHotTouristSpotsList.iterator();
        if (iter.hasNext()) {
          LyHotTouristSpots lyHotTouristSpots = (LyHotTouristSpots)iter.next();
          lyHotTouristSpots.setTotalPeople(Integer.valueOf(totalPeople - 1));
          this.lyHotTouristSpotsService.updateLyHotTouristSpots(lyHotTouristSpots);
        }
      }
      else {
        LyHotTouristSpots lyHotTouristSpots = new LyHotTouristSpots();
        lyHotTouristSpots.setTotalPeople(Integer.valueOf(totalPeople - 1));
        lyHotTouristSpots.setCTime(new Timestamp(new Date().getTime()));
        LyTouristSpots lyTouristSpots = this.lyTouristSpotsService.queryLyTouristSpots(Integer.valueOf(tourSpotSid));
        lyHotTouristSpots.setLyTouristSpots(lyTouristSpots);
        lyHotTouristSpots.setMemo("");
        this.lyHotTouristSpotsService.createLyHotTouristSpots(lyHotTouristSpots);
      }

    }

    if ((type.equals("1")) && 
      (list.size() <= 0)) {
      LyWantTo lyWantTo = new LyWantTo();
      LyTouristSpots lyTouristSpots = new LyTouristSpots();
      lyTouristSpots.setSid(Integer.valueOf(Integer.parseInt(spotSid)));
      lyWantTo.setSpotSid(Integer.valueOf(Integer.parseInt(spotSid)));
      lyWantTo.setUserName(userName);

      lyWantTo.setCTime(new Timestamp(new Date().getTime()));
      lyWantTo.setMemo("");

      int totalPeople = this.lyWantToService.countByCondtion(sql, countParam);
      this.lyWantToService.createLyWantTo(lyWantTo);
      String sql2 = "select count(*) from t_ly_HotTouristSpots  a where a.SpotSid=?";
      List sqlParam = new ArrayList();
      sqlParam.add(Integer.valueOf(tourSpotSid));
      int isExsitHot = this.lyHotTouristSpotsService.countByCondtion(sql, sqlParam);

      if (isExsitHot > 0) {
        Collection lyHotTouristSpotsList = this.lyHotTouristSpotsService
          .queryLyHotTouristSpotsByField("lyTouristSpots.sid", Integer.valueOf(tourSpotSid));
        Iterator iter = lyHotTouristSpotsList.iterator();

        if (iter.hasNext())
        {
          LyHotTouristSpots lyHotTouristSpots = (LyHotTouristSpots)iter.next();
          lyHotTouristSpots.setTotalPeople(Integer.valueOf(totalPeople + 1));
          this.lyHotTouristSpotsService.updateLyHotTouristSpots(lyHotTouristSpots);
        }
      }
      else
      {
        LyHotTouristSpots lyHotTouristSpots = new LyHotTouristSpots();
        lyHotTouristSpots.setTotalPeople(Integer.valueOf(totalPeople + 1));
        lyHotTouristSpots.setCTime(new Timestamp(new Date().getTime()));
        LyTouristSpots lyTouristSpots1 = this.lyTouristSpotsService.queryLyTouristSpots(Integer.valueOf(tourSpotSid));
        lyHotTouristSpots.setLyTouristSpots(lyTouristSpots1);
        lyHotTouristSpots.setMemo("");
        this.lyHotTouristSpotsService.createLyHotTouristSpots(lyHotTouristSpots);
      }

    }

    int totalPeople = this.lyWantToService.countByCondtion(sql, countParam);
    RetInfo retinfo = new RetInfo("0", "标记成功！");
    responseHeader.setRetinfo(retinfo);
    return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataUpdateWantToCity(ResponseHeader responseHeader, JSONObject msgBody) throws JsonProcessingException, Exception
  {
    log.debug("updateWantToCity方法...");
    try {
      String userName = (String)msgBody.get("userName");
      String citySid = (String)msgBody.get("citySid");
      String type = (String)msgBody.get("type");

      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey("UserName");
      qp.setLogicOper(" = ");
      qp.setValue("'" + userName + "'");
      params.add(qp);
      QueryParam qp2 = new QueryParam();
      qp2.setKey("CitySid");
      qp2.setLogicOper(" = ");
      qp2.setValue(citySid);
      params.add(qp2);
      queryObject.setParameters(params);

      List list = this.lyUserWantToCityService.queryLyUserWantToCity(queryObject).getResults();
      int cityId = Integer.parseInt(citySid);
      String sql = "select count(*) from t_ly_userwanttocity t where t.CitySid=?";
      List countParam = new ArrayList();
      countParam.add(Integer.valueOf(cityId));
      if ((type.equals("0")) && 
        (list.size() > 0)) {
        int totalPeople = this.lyUserWantToCityService.countByCondtion(sql, countParam);
        this.lyUserWantToCityService.removeLyUserWantToCity(Integer.valueOf(Integer.parseInt((String)((Map)list.get(0)).get("sid"))));
        String sql2 = "select count(*) from t_ly_hotcity  a where a.CitySid=?";
        List sqlParam = new ArrayList();
        sqlParam.add(Integer.valueOf(cityId));
        int isExsitHot = this.lyHotCityService.countByCondtion(sql2, sqlParam);

        if (isExsitHot > 0)
        {
          Collection lyHotCityList = this.lyHotCityService.queryLyHotCityByField("lyAreaInfo.sid", 
            Integer.valueOf(cityId));
          Iterator iter = lyHotCityList.iterator();
          if (iter.hasNext())
          {
            LyHotCity lyHotCity = (LyHotCity)iter.next();
            lyHotCity.setTotalPeople(Integer.valueOf(totalPeople - 1));
            this.lyHotCityService.updateLyHotCity(lyHotCity);
          }

        }
        else
        {
          LyHotCity lyHotCity = new LyHotCity();
          lyHotCity.setTotalPeople(Integer.valueOf(totalPeople - 1));
          lyHotCity.setCTime(new Timestamp(new Date().getTime()));
          LyAreaInfo lyAreaInfo = this.lyAreaInfoService.queryLyAreaInfo(Integer.valueOf(cityId));
          lyHotCity.setLyAreaInfo(lyAreaInfo);
          lyHotCity.setMemo("");
          this.lyHotCityService.createLyHotCity(lyHotCity);
        }

      }

      if ((type.equals("1")) && 
        (list.size() <= 0))
      {
        LyUserWantToCity lyUserWantToCity = new LyUserWantToCity();
        lyUserWantToCity.setUserName(userName);
        lyUserWantToCity.setCitySid(Integer.valueOf(cityId));
        lyUserWantToCity.setCTime(new Timestamp(new Date().getTime()));
        lyUserWantToCity.setMemo("");

        int totalPeople = this.lyWantToService.countByCondtion(sql, countParam);

        this.lyUserWantToCityService.createLyUserWantToCity(lyUserWantToCity);

        String sql2 = "select count(*) from t_ly_hotcity  a where a.CitySid=?";
        List sqlParam = new ArrayList();
        sqlParam.add(Integer.valueOf(cityId));
        int isExsitHot = this.lyHotCityService.countByCondtion(sql2, sqlParam);

        if (isExsitHot > 0)
        {
          Collection lyHotCityList = this.lyHotCityService.queryLyHotCityByField("lyAreaInfo.sid", 
            Integer.valueOf(cityId));
          Iterator iter = lyHotCityList.iterator();
          if (iter.hasNext())
          {
            LyHotCity lyHotCity = (LyHotCity)iter.next();
            lyHotCity.setTotalPeople(Integer.valueOf(totalPeople + 1));
            this.lyHotCityService.updateLyHotCity(lyHotCity);
          }
        }
        else
        {
          LyHotCity lyHotCity = new LyHotCity();
          lyHotCity.setTotalPeople(Integer.valueOf(totalPeople + 1));
          lyHotCity.setCTime(new Timestamp(new Date().getTime()));
          LyAreaInfo lyAreaInfo = this.lyAreaInfoService.queryLyAreaInfo(Integer.valueOf(cityId));
          lyHotCity.setLyAreaInfo(lyAreaInfo);
          lyHotCity.setMemo("");
          this.lyHotCityService.createLyHotCity(lyHotCity);
        }

      }

      RetInfo retinfo = new RetInfo("0", "标记成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQqLogin(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qqLogin方法...");
    try
    {
      String userName = (String)msgBody.get("userName");
      String userSid = (String)msgBody.get("userSid");
      String userNickName = (String)msgBody.get("userNickName");
      String birthday = (String)msgBody.get("birthday");
      String headImg = (String)msgBody.get("headImg");

      int sex = msgBody.getInt("sex");
      String year = (String)msgBody.get("year");

      LyUserInfo lyUserInfo = this.lyUserInfoService.querySysUserByUK(StringUtil.underscoreName("UserName"), userName);
      if (lyUserInfo == null) {
        lyUserInfo = new LyUserInfo();
        lyUserInfo.setUserName(userName);
        lyUserInfo.setUserPassword("123456");
        if (StringUtil.isNotNull(userNickName)) {
          lyUserInfo.setUserNickName(userNickName);
        }
        StringUtil.isNotNull(birthday);

        if (StringUtil.isNotNull(Integer.valueOf(sex))) {
          lyUserInfo.setSex(Integer.valueOf(sex));
        }
        if (StringUtil.isNotNull(headImg))
        {
          lyUserInfo.setHeadImg(headImg);

          LyUserImage lyUserImage = new LyUserImage();
          lyUserImage.setImageUrl(headImg);
          lyUserImage.setUserName(userName);
          lyUserImage.setIsDefault(Integer.valueOf(1));
          this.lyUserImageService.createLyUserImage(lyUserImage);
        }

        log.isDebugEnabled();

        this.lyUserInfoService.createLyUserInfo(lyUserInfo);

        RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

        TokenReslut userGetTokenResult = rongCloud.user.getToken(String.valueOf(lyUserInfo.getSid()), 
          lyUserInfo.getUserName(), headImg);
        lyUserInfo.setToken(userGetTokenResult.getToken());
        this.lyUserInfoService.updateLyUserInfo(lyUserInfo);

        log.debug(userGetTokenResult.getToken() + ":=: " + lyUserInfo.getToken());
        QueryObject queryObject = new QueryObject();
        Collection params = new ArrayList();
        QueryParam qp = new QueryParam();
        qp.setKey(StringUtil.underscoreName("UserName"));
        qp.setLogicOper(" = ");
        qp.setValue("'" + lyUserInfo.getUserName() + "'");
        params.add(qp);
        queryObject.setParameters(params);

        List lyUserInfoList = this.lyUserInfoService.queryLyUserInfo(queryObject).getResults();
        Map lyUserInfoMap = (Map)lyUserInfoList.get(0);
        lyUserInfoMap.put(StringUtil.underscoreName("token"), lyUserInfo.getToken());

        String userJson = new ObjectMapper().writeValueAsString(lyUserInfoMap);
        log.debug(userJson);

        LyUserInfoDto lyUserInfoDto = (LyUserInfoDto)JSONObject.toBean(JSONObject.fromObject(userJson), LyUserInfoDto.class);
        Map msgResBody = new HashMap();
        msgResBody.put("userInfo", lyUserInfoDto);
        RetInfo retinfo = new RetInfo("0", "注册成功！");
        Memory memory = (Memory)SpringContextHolder.getBean("memory");
        memory.saveLyUserInfoDto(lyUserInfoDto);
        responseHeader.setRetinfo(retinfo);
        return ResponseUtil.responseMsg(responseHeader, msgResBody);
      }

      if ((lyUserInfo.getToken() == null) || (lyUserInfo.getToken().equals(""))) {
        RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

        TokenReslut userGetTokenResult = rongCloud.user.getToken(String.valueOf(lyUserInfo.getSid()), 
          lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
        lyUserInfo.setToken(userGetTokenResult.getToken());
      } else {
        RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

        CodeSuccessReslut result = rongCloud.user.refresh(String.valueOf(lyUserInfo.getSid()), 
          lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
        TokenReslut userGetTokenResult = rongCloud.user.getToken(String.valueOf(lyUserInfo.getSid()), 
          lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
        lyUserInfo.setToken(userGetTokenResult.getToken());

        System.out.println(lyUserInfo.getHeadImg());
      }

      LyUserSessionInfo lyUserSessionInfo = new LyUserSessionInfo();
      lyUserSessionInfo.setUserName(userName);

      lyUserSessionInfo.setUserSid(lyUserInfo.getSid());

      lyUserSessionInfo.setStatus(Integer.valueOf(0));

      lyUserSessionInfo.setCTime(new Timestamp(new Date().getTime()));
      lyUserSessionInfo.setChannelCode(responseHeader.getRsp_app());
      lyUserSessionInfo.setLoginTime(new Timestamp(new Date().getTime()));
      lyUserSessionInfo.setLastLiveTime(new Timestamp(new Date().getTime()));
      lyUserSessionInfo.setExpireTime(new Timestamp(new Date().getTime()));

      this.lyUserSessionInfoService.createLyUserSessionInfo(lyUserSessionInfo);
      this.lyUserInfoService.updateLyUserInfo(lyUserInfo);

      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("'" + lyUserInfo.getUserName() + "'");
      params.add(qp);
      queryObject.setParameters(params);
      List lyUserInfoList = this.lyUserInfoService.queryLyUserInfo(queryObject).getResults();
      Map lyUserInfoMap = (Map)lyUserInfoList.get(0);

      String userJson = new ObjectMapper().writeValueAsString(lyUserInfoMap);

      LyUserInfoDto lyUserInfoDto = (LyUserInfoDto)JSONObject.toBean(JSONObject.fromObject(userJson), 
        LyUserInfoDto.class);
      Map msgResBody = new HashMap();
      msgResBody.put("userInfo", lyUserInfoDto);
      RetInfo retinfo = new RetInfo("0", "登录成功！");

      Memory memory = (Memory)SpringContextHolder.getBean("memory");
      memory.saveLyUserInfoDto(lyUserInfoDto);

      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataCheckUserAuth(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("checkUserAuth方法...");
    try
    {
      String userName = (String)msgBody.get("userName");
      String userPassword = (String)msgBody.get("userPassword");

      String token = (String)msgBody.get("token");

      Collection clyUserInfo = this.lyUserInfoService.queryByFields(
        new String[] { StringUtil.underscoreName("UserName"), 
        StringUtil.underscoreName("UserPassword") }, 
        new String[] { " = ", " = " }, new Object[] { userName, userPassword });

      if (clyUserInfo.size() > 0) {
        LyUserInfo lyUserInfo = (LyUserInfo)clyUserInfo.iterator().next();

        if ((lyUserInfo.getToken() == null) || (lyUserInfo.getToken().equals(""))) {
          RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

          TokenReslut userGetTokenResult = rongCloud.user.getToken(String.valueOf(lyUserInfo.getSid()), 
            lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
          lyUserInfo.setToken(userGetTokenResult.getToken());
        } else {
          RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

          CodeSuccessReslut result = rongCloud.user.refresh(String.valueOf(lyUserInfo.getSid()), 
            lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
          TokenReslut userGetTokenResult = rongCloud.user.getToken(String.valueOf(lyUserInfo.getSid()), 
            lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
          lyUserInfo.setToken(userGetTokenResult.getToken());
        }

        LyUserSessionInfo lyUserSessionInfo = new LyUserSessionInfo();
        lyUserSessionInfo.setUserName(userName);

        lyUserSessionInfo.setUserSid(lyUserInfo.getSid());

        lyUserSessionInfo.setStatus(Integer.valueOf(0));
        lyUserSessionInfo.setToken(token);
        lyUserSessionInfo.setCTime(new Timestamp(new Date().getTime()));
        lyUserSessionInfo.setChannelCode(responseHeader.getRsp_app());
        lyUserSessionInfo.setLoginTime(new Timestamp(new Date().getTime()));
        lyUserSessionInfo.setLastLiveTime(new Timestamp(new Date().getTime()));
        lyUserSessionInfo.setExpireTime(new Timestamp(new Date().getTime()));

        this.lyUserSessionInfoService.createLyUserSessionInfo(lyUserSessionInfo);
        this.lyUserInfoService.updateLyUserInfo(lyUserInfo);

        QueryObject queryObject = new QueryObject();
        Collection params = new ArrayList();
        QueryParam qp = new QueryParam();
        qp.setKey(StringUtil.underscoreName("UserName"));
        qp.setLogicOper(" = ");
        qp.setValue("'" + lyUserInfo.getUserName() + "'");
        params.add(qp);
        queryObject.setParameters(params);
        List lyUserInfoList = this.lyUserInfoService.queryLyUserInfo(queryObject).getResults();
        Map lyUserInfoMap = (Map)lyUserInfoList.get(0);
        String userJson = new ObjectMapper().writeValueAsString(lyUserInfoMap);
        LyUserInfoDto lyUserInfoDto = (LyUserInfoDto)JSONObject.toBean(JSONObject.fromObject(userJson), 
          LyUserInfoDto.class);
        Map msgResBody = new HashMap();
        msgResBody.put("userInfo", lyUserInfoDto);
        RetInfo retinfo = new RetInfo("0", "登录成功！");

        Memory memory = (Memory)SpringContextHolder.getBean("memory");
        memory.saveLyUserInfoDto(lyUserInfoDto);

        responseHeader.setRetinfo(retinfo);
        return ResponseUtil.responseMsg(responseHeader, msgResBody);
      }

      RetInfo retinfo = new RetInfo("99999000", "用户名密码错误！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, null);
    }
    catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQrySpotUserList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qrySpotUserList方法...");
    QueryObject queryObject = new QueryObject();
    try
    {
      String spotSid = (String)msgBody.get("spotSid");
      Collection<LyWantTo> lyWantTos = this.lyWantToService
        .queryLyWantToByField(StringUtil.underscoreName("SpotSid"), Integer.valueOf(Integer.parseInt(spotSid)));
      String usersIds = "";
      for (LyWantTo lyWantTo : lyWantTos) {
        usersIds = usersIds + "'" + lyWantTo.getUserName() + "',";
      }
      if (usersIds.length() > 0) {
        usersIds = usersIds.substring(0, usersIds.length() - 1);
        String citySid = (String)msgBody.get("citySid");
        String age = (String)msgBody.get("age");
        String sex = (String)msgBody.get("sex");
        String profess = (String)msgBody.get("profess");
        String auth = (String)msgBody.get("auth");
        String searchKey = (String)msgBody.get("searchKey");

        JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
        PageObj pageObj = new PageObj();
        if (jsonPageObject != null)
        {
          int pageSize = LyConstant.pageSize;
          int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
          pageObj.setPageSize(Integer.valueOf(pageSize));
          pageObj.setCurrPage(Integer.valueOf(curPage));
          queryObject.setPageObj(pageObj);
        }
        Collection params = new ArrayList();

        QueryParam sidQp = new QueryParam();
        sidQp.setKey("UserName");
        sidQp.setLogicOper(" in ");
        sidQp.setValue("( " + usersIds + " )");
        params.add(sidQp);
        if ((citySid != null) && (!citySid.equals(""))) {
          QueryParam areaQp = new QueryParam();
          areaQp.setKey("AreaSid");
          areaQp.setLogicOper(" = ");
          areaQp.setValue(citySid);
          params.add(areaQp);
        }
        if ((age != null) && (!age.equals(""))) {
          QueryParam ageQp = new QueryParam();
          ageQp.setKey("Age");
          ageQp.setLogicOper(" = ");
          ageQp.setValue(age);
          params.add(ageQp);
        }
        if ((sex != null) && (!sex.equals(""))) {
          QueryParam sexQp = new QueryParam();
          sexQp.setKey("Sex");
          sexQp.setLogicOper(" = ");
          sexQp.setValue(sex);
          params.add(sexQp);
        }
        if ((profess != null) && (!profess.equals(""))) {
          QueryParam professQp = new QueryParam();
          professQp.setKey("Profess");
          professQp.setLogicOper(" = ");
          professQp.setValue(profess);
          params.add(professQp);
        }
        if ((auth != null) && (!auth.equals(""))) {
          QueryParam idCardStatuQp = new QueryParam();
          idCardStatuQp.setKey("IdCardAuthStatus");
          idCardStatuQp.setLogicOper(" = ");
          idCardStatuQp.setValue(auth);
          params.add(idCardStatuQp);
        }
        if ((searchKey != null) && (!searchKey.equals(""))) {
          QueryParam userNameQp = new QueryParam();
          userNameQp.setKey("UserNickName");
          userNameQp.setLogicOper(" like ");
          userNameQp.setValue("'" + searchKey + "%'");
          params.add(userNameQp);
        }
        log.debug("查询userInfo...");
        queryObject.setParameters(params);
        queryObject = this.lyUserInfoService.queryLyUserInfo(queryObject);
        List lyUserInfoList = queryObject.getResults();

        String userJson = new ObjectMapper().writeValueAsString(lyUserInfoList);
        List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyUserInfoDto.class);

        Map msgResBody = new HashMap();
        msgResBody.put("userList", newList);
        if (jsonPageObject != null) {
          pageObj.setTotalPage(Integer.valueOf(queryObject.getTotalCount()));
          msgResBody.put("pageObj", pageObj);
        }
        RetInfo retinfo = new RetInfo("0", "");
        responseHeader.setRetinfo(retinfo);
        return ResponseUtil.responseMsg(responseHeader, msgResBody);
      }
      RetInfo retinfo = new RetInfo("0", "没有数据！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryCityUserList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryCityUserList方法...");
    QueryObject queryObject = new QueryObject();
    try
    {
      String citySid = (String)msgBody.get("citySid");
      Collection<LyUserWantToCity> lyUserWantToCity = this.lyUserWantToCityService.queryLyUserWantToCityByField(
        StringUtil.underscoreName("CitySid"), Integer.valueOf(Integer.parseInt(citySid)));
      String usersIds = "";
      for (LyUserWantToCity lyWantToCity : lyUserWantToCity) {
        usersIds = usersIds + "'" + lyWantToCity.getUserName() + "',";
      }
      if (usersIds.length() > 0) {
        usersIds = usersIds.substring(0, usersIds.length() - 1);

        String age = (String)msgBody.get("age");
        String sex = (String)msgBody.get("sex");
        String profess = (String)msgBody.get("profess");
        String auth = (String)msgBody.get("auth");
        String searchKey = (String)msgBody.get("searchKey");

        JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
        PageObj pageObj = new PageObj();
        if (jsonPageObject != null) {
          log.debug("jsonPageObject!=null..");
          int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());

          int pageSize = LyConstant.pageSize;
          pageObj.setCurrPage(Integer.valueOf(curPage));
          pageObj.setPageSize(Integer.valueOf(pageSize));
          queryObject.setPageObj(pageObj);
        }
        Collection params = new ArrayList();

        QueryParam sidQp = new QueryParam();
        sidQp.setKey("UserName");
        sidQp.setLogicOper(" in ");
        sidQp.setValue("( " + usersIds + " )");
        params.add(sidQp);

        if ((age != null) && (!age.equals(""))) {
          QueryParam ageQp = new QueryParam();
          ageQp.setKey("Age");
          ageQp.setLogicOper(" = ");
          ageQp.setValue(age);
          params.add(ageQp);
        }
        if ((sex != null) && (!sex.equals(""))) {
          QueryParam sexQp = new QueryParam();
          sexQp.setKey("Sex");
          sexQp.setLogicOper(" = ");
          sexQp.setValue(sex);
          params.add(sexQp);
        }
        if ((profess != null) && (!profess.equals(""))) {
          QueryParam professQp = new QueryParam();
          professQp.setKey("Profess");
          professQp.setLogicOper(" = ");
          professQp.setValue(profess);
          params.add(professQp);
        }
        if ((auth != null) && (!auth.equals(""))) {
          QueryParam idCardStatuQp = new QueryParam();
          idCardStatuQp.setKey("IdCardAuthStatus");
          idCardStatuQp.setLogicOper(" = ");
          idCardStatuQp.setValue(auth);
          params.add(idCardStatuQp);
        }
        if ((searchKey != null) && (!searchKey.equals(""))) {
          QueryParam userNameQp = new QueryParam();
          userNameQp.setKey("UserNickName");
          userNameQp.setLogicOper(" like ");
          userNameQp.setValue("'" + searchKey + "%'");
          params.add(userNameQp);
        }
        log.debug("查询userInfo...");
        queryObject.setParameters(params);
        queryObject = this.lyUserInfoService.queryLyUserInfo(queryObject);
        List lyUserInfoList = queryObject.getResults();

        String userJson = new ObjectMapper().writeValueAsString(lyUserInfoList);

        List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyUserInfoDto.class);
        Map msgResBody = new HashMap();
        msgResBody.put("userList", newList);
        if (jsonPageObject != null) {
          pageObj.setTotalPage(Integer.valueOf(queryObject.getTotalCount()));
          msgResBody.put("pageObj", pageObj);
        }
        RetInfo retinfo = new RetInfo("0", "");
        responseHeader.setRetinfo(retinfo);
        return ResponseUtil.responseMsg(responseHeader, msgResBody);
      }
      RetInfo retinfo = new RetInfo("0", "没有数据！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataPerfectInformation(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("perfectInformation方法...");
    try
    {
      String userSid = (String)msgBody.get("userSid");
      String userNickName = (String)msgBody.get("userNickName");
      String sex = (String)msgBody.get("sex");
      String citySid = (String)msgBody.get("citySid");
      String birthday = (String)msgBody.get("birthday");
      String signName = (String)msgBody.get("signName");
      String profess = (String)msgBody.get("profess");
      LyUserInfo lyUserInfo = this.lyUserInfoService.queryLyUserInfo(Integer.valueOf(Integer.parseInt(userSid)));

      lyUserInfo.setUserNickName(userNickName);
      lyUserInfo.setSex(Integer.valueOf(Integer.parseInt(sex)));

      if (StringUtil.isNotNull(citySid)) {
        lyUserInfo.setAreaSid(Integer.valueOf(Integer.parseInt(citySid)));
      }

      if (StringUtil.isNotNull(birthday)) {
        lyUserInfo.setBirthday(DateUtil2.getTimeStamp(birthday));
      }

      lyUserInfo.setSignName(signName);

      if (StringUtil.isNotNull(profess)) {
        lyUserInfo.setProfess(Integer.valueOf(Integer.parseInt(profess)));
      }
      this.lyUserInfoService.updateLyUserInfo(lyUserInfo);

      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("'" + lyUserInfo.getUserName() + "'");
      params.add(qp);
      queryObject.setParameters(params);
      List lyUserInfoList = this.lyUserInfoService.queryLyUserInfo(queryObject).getResults();
      Map lyUserInfoMap = (Map)lyUserInfoList.get(0);

      QueryObject imgQueryObject = new QueryObject();
      Collection imgParams = new ArrayList();
      QueryParam imgQp = new QueryParam();
      imgQp.setKey(StringUtil.underscoreName("UserName"));
      imgQp.setLogicOper(" = ");
      imgQp.setValue("('" + lyUserInfo.getUserName() + "')");
      imgParams.add(imgQp);
      imgQueryObject.setParameters(imgParams);
      imgQueryObject = this.lyUserImageService.queryLyUserImage(imgQueryObject);
      List userImageList = imgQueryObject.getResults();
      lyUserInfoMap.put("userImageList", userImageList);

      String userJson = new ObjectMapper().writeValueAsString(lyUserInfoMap);
      LyUserInfoDto lyUserInfoDto = (LyUserInfoDto)JSONObject.toBean(JSONObject.fromObject(userJson), 
        LyUserInfoDto.class);
      Map msgResBody = new HashMap();
      msgResBody.put("userInfo", lyUserInfoDto);

      RetInfo retinfo = new RetInfo("0", "提交成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryHotCityList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryHotCityList方法...");
    String userName = (String)msgBody.get("userName");
    QueryObject queryObject = new QueryObject();

    if ((userName == null) || (userName.equals(""))) {
      queryObject.setSelectId("query_HotCityListNoLogin");
    } else {
      queryObject.setSelectId("query_HotCityList");
      queryObject.getStaticParam().put("userName", userName);
    }
    PageObj pageObj = new PageObj();
    pageObj.setCurrPage(Integer.valueOf(1));
    pageObj.setPageSize(Integer.valueOf(10));
    queryObject.setPageObj(pageObj);
    try
    {
      List queryList = this.lyAreaInfoService.query(queryObject).getResults();
      List<LyAreaInfoDto> newList = new ArrayList();

      newList = BeanToMapUtil.convertListMap2ListBean(queryList, LyAreaInfoDto.class);

      for (LyAreaInfoDto lyAreaInfoDto : newList) {
        Location location = new Location();
        location.setLat(lyAreaInfoDto.getLat());
        location.setLng(lyAreaInfoDto.getLng());
        lyAreaInfoDto.setcLocation(location);
      }
      Map msgResBody = new HashMap();

      msgResBody.put("citiesList", newList);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", "查询热门城市列表失败！", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryTouristSpotListByName(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryTouristSpotListByName方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String spotName = (String)msgBody.get("spotName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj.setPageSize(Integer.valueOf(pageSize));
        pageObj.setCurrPage(Integer.valueOf(curPage));
        queryObject.setPageObj(pageObj);
      }

      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey("SpotName");
      if (spotName.equals("")) {
        qp.setLogicOper(" = ");
        qp.setValue("('" + spotName + "')");
      } else {
        qp.setLogicOper(" like ");
        qp.setValue("('" + spotName + "%')");
      }

      params.add(qp);
      queryObject.setParameters(params);

      queryObject = this.lyTouristSpotsService.queryLyTouristSpots(queryObject);

      List queryList = queryObject.getResults();

      List<LyTouristSpotsDto> newList = new ArrayList();
      if ((queryList != null) && (queryList.size() > 0))
      {
        newList = BeanToMapUtil.convertListMap2ListBean(queryList, LyTouristSpotsDto.class);
      }

      for (LyTouristSpotsDto lyTouristSpotsDto : newList) {
        Location location = new Location();
        location.setLat(lyTouristSpotsDto.getLat());
        location.setLng(lyTouristSpotsDto.getLng());
        lyTouristSpotsDto.setcLocation(location);
      }

      Map msgResBody = new HashMap();

      msgResBody.put("touristSpotList", newList);
      if (jsonPageObject != null) {
        int total = queryObject.getTotalCount();
        pageObj.setTotalPage(Integer.valueOf(total));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "提交成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryTouristSpotListBySid(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryTouristSpotListBySid方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String spotSid = (String)msgBody.get("spotSid");
      String userName = (String)msgBody.get("userName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());

        pageObj.setPageSize(Integer.valueOf(pageSize));
        pageObj.setCurrPage(Integer.valueOf(curPage));
        queryObject.setPageObj(pageObj);
      }
      List queryList;
      //List queryList;
      if ((userName != null) && (!userName.equals("")))
        queryList = this.lyTouristSpotsService.queryForList(
          "select t.SID AS sid,t.SpotName AS spotName,t.Address AS address,t.telephone AS telephone,t.Uid AS uid,t.Location AS location,t.Lat AS lat,t.Lng AS lng,t.StreetId AS streetId,t.IsDetail AS isDetail,t.ProvinceSid AS provinceSid,t.CitySid AS citySid,h.TotalPeople AS totalPeople,t.CTime AS cTime,t.Memo AS memo,h.totalPeople,(select count(*) from  t_ly_wantto w where w.SpotSid=t.SID and w.UserName='" + 
          userName + 
          "') as attention,(select count(*) from t_ly_wantto w2 left join t_ly_userinfo u on w2.UserName=u.UserName left join t_ly_areainfo a2 on u.AreaSid=a2.SID where u.AreaSid=a2.SID and w2.SpotSid=t.SID) as totalPeopleCity from (SELECT SID AS sid,SpotName AS spotName,Address AS address,telephone AS telephone,Uid AS uid,Location AS location,Lat AS lat,Lng AS lng,StreetId AS streetId,IsDetail AS isDetail,ProvinceSid AS provinceSid,CitySid AS citySid,TotalPeople AS totalPeople,CTime AS cTime,Memo AS memo FROM T_Ly_TouristSpots WHERE 1=1 AND SID IN(" + 
          spotSid + 
          ")) h left join T_Ly_TouristSpots t on h.sid=t.SID  where 1=1 order by h.totalPeople DESC");
      else {
        queryList = this.lyTouristSpotsService.queryForList(
          "SELECT t.SID As sid,t.SpotName As spotName,t.Address As address,t.telephone As telephone,t.Uid As uid,t.Location As location,t.Lat As lat,t.Lng As lng,t.StreetId As streetId,t.IsDetail As isDetail,t.ProvinceSid As provinceSid,t.CitySid As citySid,h.TotalPeople As totalPeople,t.CTime As cTime,t.Memo As memo FROM (SELECT SID As sid,SpotName As spotName,Address As address,telephone As telephone,Uid As uid,Location As location,Lat As lat,Lng As lng,StreetId As streetId,IsDetail As isDetail,ProvinceSid As provinceSid,CitySid As citySid,TotalPeople As totalPeople,CTime As cTime,Memo As memo FROM T_Ly_TouristSpots WHERE 1=1 AND SID IN(" + 
          spotSid + 
          ")) h LEFT JOIN T_Ly_TouristSpots t ON t.SID=h.sid WHERE 1=1 ORDER BY h.totalPeople DESC");
      }

      List<LyTouristSpotsDto> newList = new ArrayList();

      newList = BeanToMapUtil.convertListMap2ListBean(queryList, LyTouristSpotsDto.class);

      for (LyTouristSpotsDto lyTouristSpotsDto : newList) {
        Location location = new Location();
        location.setLat(lyTouristSpotsDto.getLat());
        location.setLng(lyTouristSpotsDto.getLng());
        lyTouristSpotsDto.setcLocation(location);
      }
      Map msgResBody = new HashMap();

      msgResBody.put("touristSpotList", newList);
      RetInfo retinfo = new RetInfo("0", "提交成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryCityBySid(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryCityBySid方法...");
    String userName = (String)msgBody.get("userName");
    String citySid = (String)msgBody.get("citySid");
    QueryObject queryObject = new QueryObject();
    queryObject.setSelectId("query_CityListBySid");
    queryObject.getStaticParam().put("userName", userName);
    queryObject.getStaticParam().put("citySid", citySid);
    PageObj pageObj = new PageObj();
    pageObj.setCurrPage(Integer.valueOf(1));
    pageObj.setPageSize(Integer.valueOf(10));
    queryObject.setPageObj(pageObj);
    try
    {
      List queryList = this.lyAreaInfoService.query(queryObject).getResults();
      List<LyAreaInfoDto> newList = new ArrayList();

      newList = BeanToMapUtil.convertListMap2ListBean(queryList, LyAreaInfoDto.class);

      for (LyAreaInfoDto lyAreaInfoDto : newList) {
        Location location = new Location();
        location.setLat(lyAreaInfoDto.getLat());
        location.setLng(lyAreaInfoDto.getLng());
        lyAreaInfoDto.setcLocation(location);
      }
      Map msgResBody = new HashMap();

      msgResBody.put("citiesList", newList);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", "查询热门城市列表失败！", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryCityListByName(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryCityListByName方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String cityName = (String)msgBody.get("cityName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());

        pageObj.setPageSize(Integer.valueOf(pageSize));
        pageObj.setCurrPage(Integer.valueOf(curPage));
        queryObject.setPageObj(pageObj);
      }

      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("AreaName"));
      qp.setLogicOper(" like ");
      qp.setValue("('" + cityName + "%')");
      QueryParam qp1 = new QueryParam();
      qp1.setKey(StringUtil.underscoreName("AreaType"));
      qp1.setLogicOper("=");
      qp1.setValue("2");

      params.add(qp);
      params.add(qp1);
      queryObject.setParameters(params);

      queryObject = this.lyAreaInfoService.queryLyAreaInfo(queryObject);

      List queryList = queryObject.getResults();
      List<LyAreaInfoDto> newList = new ArrayList();

      newList = BeanToMapUtil.convertListMap2ListBean(queryList, LyAreaInfoDto.class);

      for (LyAreaInfoDto lyAreaInfoDto : newList) {
        Location location = new Location();
        location.setLat(lyAreaInfoDto.getLat());
        location.setLng(lyAreaInfoDto.getLng());
        lyAreaInfoDto.setcLocation(location);
      }
      Map msgResBody = new HashMap();

      msgResBody.put("cityList", newList);
      if (jsonPageObject != null) {
        int total = queryObject.getTotalCount();
        pageObj.setTotalPage(Integer.valueOf(total));
        msgResBody.put("pageObj", pageObj);
      }
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryUserWantToSpotList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryUserWantToSpotList方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String userName = (String)msgBody.get("userName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj.setCurrPage(Integer.valueOf(curPage));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      }

      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("('" + userName + "')");
      params.add(qp);
      queryObject.setParameters(params);

      List<Map> queryList = this.lyWantToService.queryLyWantTo(queryObject).getResults();

      List newList = new ArrayList();
      String ids = "";
      for (Map map : queryList) {
        ids = ids + map.get(StringUtil.underscoreName("SpotSid")) + ",";
      }
      List<LyTouristSpotsDto> touristSpotList = new ArrayList();
      QueryObject queryObjectHot = new QueryObject();
      if ((ids != null) && (ids.length() > 0)) {
        ids = ids.substring(0, ids.length() - 1);

        Collection paramsHot = new ArrayList();
        QueryParam qpHot = new QueryParam();
        qpHot.setKey("SID");
        qpHot.setLogicOper(" in ");
        qpHot.setValue("( " + ids + " )");
        paramsHot.add(qpHot);
        queryObjectHot.setParameters(paramsHot);

        queryObjectHot = this.lyTouristSpotsService.queryLyTouristSpots(queryObjectHot);
        List touristQueryList = queryObjectHot.getResults();

        if ((touristQueryList != null) && (touristQueryList.size() > 0))
        {
          touristSpotList = BeanToMapUtil.convertListMap2ListBean(touristQueryList, LyTouristSpotsDto.class);
          for (LyTouristSpotsDto touristSpotDto : touristSpotList) {
            Location location = new Location();
            location.setLat(touristSpotDto.getLat());
            location.setLng(touristSpotDto.getLng());
            touristSpotDto.setcLocation(location);
          }
        }
      }

      Map msgResBody = new HashMap();
      msgResBody.put("touristSpotList", touristSpotList);
      if (jsonPageObject != null) {
        int total = queryObjectHot.getTotalCount();
        pageObj.setTotalPage(Integer.valueOf(total));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "查询成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryUserWantToCityList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryUserWantToCityList方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String userName = (String)msgBody.get("userName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj.setCurrPage(Integer.valueOf(curPage));
        pageObj.setPageSize(Integer.valueOf(pageSize));
      }

      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("('" + userName + "')");
      params.add(qp);
      queryObject.setParameters(params);

      List<Map> queryList = this.lyUserWantToCityService.queryLyUserWantToCity(queryObject)
        .getResults();

      List newList = new ArrayList();
      String ids = "";
      for (Map map : queryList) {
        ids = ids + map.get(StringUtil.underscoreName("CitySid")) + ",";
      }
      List<LyAreaInfoDto> lyCityList = new ArrayList();
      if ((ids != null) && (ids.length() > 0)) {
        ids = ids.substring(0, ids.length() - 1);
        QueryObject queryObjectHot = new QueryObject();
        Collection paramsHot = new ArrayList();
        QueryParam qpHot = new QueryParam();
        qpHot.setKey("SID");
        qpHot.setLogicOper(" in ");
        qpHot.setValue("( " + ids + " )");
        paramsHot.add(qpHot);
        queryObjectHot.setParameters(paramsHot);
        queryObjectHot.setPageObj(pageObj);
        queryObjectHot = this.lyAreaInfoService.queryLyAreaInfo(queryObjectHot);
        List touristQueryList = queryObjectHot.getResults();

        lyCityList = BeanToMapUtil.convertListMap2ListBean(touristQueryList, LyAreaInfoDto.class);
        for (LyAreaInfoDto lyAreaInfoDto : lyCityList) {
          Location location = new Location();
          location.setLat(lyAreaInfoDto.getLat());
          location.setLng(lyAreaInfoDto.getLng());
          lyAreaInfoDto.setcLocation(location);
        }
      }
      Object msgResBody = new HashMap();
      ((Map)msgResBody).put("cityList", lyCityList);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return (Response)ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataAlbumManage(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    try
    {
      return this.lyAlbumService.createLyAlbumManager(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryAlbumList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryAlbumList方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String userName = (String)msgBody.get("userName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj.setCurrPage(Integer.valueOf(curPage));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      }

      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("('" + userName + "')");
      params.add(qp);
      queryObject.setParameters(params);

      queryObject = this.lyAlbumService.queryLyAlbum(queryObject);

      List queryList = queryObject.getResults();
      List<LyAlbumDto> lyAlbumList = new ArrayList();
      if ((queryList != null) && (queryList.size() > 0)) {
        lyAlbumList = BeanToMapUtil.convertListMap2ListBean(queryList, LyAlbumDto.class);
      }
      for (LyAlbumDto lyAlbumDto : lyAlbumList) {
        int count = this.lyAlbumInfoService.countLyAlbumInfoByField(
          StringUtil.underscoreName("AlbumSid"), lyAlbumDto.getAlbumSid());
        lyAlbumDto.setPhotoNum(count);
      }
      Map msgResBody = new HashMap();
      msgResBody.put("albumList", lyAlbumList);
      if (jsonPageObject != null) {
        int total = queryObject.getTotalCount();
        pageObj.setTotalPage(Integer.valueOf(total));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataUserImageManage(ResponseHeader responseHeader, JSONObject msgBody) throws JsonProcessingException, Exception
  {
    try
    {
      return this.lyAlbumInfoService.createLyAlbumInfoManager(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryUserImageList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryUserImageList方法...");
    QueryObject queryObject = new QueryObject();
    try {
      String albumSid = (String)msgBody.get("albumSid");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = new PageObj();
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj.setCurrPage(Integer.valueOf(curPage));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      }

      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("AlbumSid"));
      qp.setLogicOper(" = ");
      qp.setValue("('" + albumSid + "')");
      params.add(qp);
      queryObject.setParameters(params);

      queryObject = this.lyAlbumInfoService.queryLyAlbumInfo(queryObject);

      List queryList = queryObject.getResults();
      List lyAlbumInfoList = new ArrayList();
      if ((queryList != null) && (queryList.size() > 0)) {
        lyAlbumInfoList = BeanToMapUtil.convertListMap2ListBean(queryList, LyAlbumInfoDto.class);
      }

      Map msgResBody = new HashMap();
      msgResBody.put("userImageList", lyAlbumInfoList);
      if (jsonPageObject != null) {
        int total = queryObject.getTotalCount();
        pageObj.setTotalPage(Integer.valueOf(total));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataPhotoWallManage(ResponseHeader responseHeader, JSONObject msgBody) throws JsonProcessingException, Exception
  {
    try
    {
      return this.lyPhotoWallService.createPhotoWallManager(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQueryUserInfoByUserName(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    String userName = (String)msgBody.get("userName");
    try {
      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("UserName"));
      qp.setLogicOper(" = ");
      qp.setValue("'" + userName + "'");
      params.add(qp);
      queryObject.setParameters(params);
      List lyUserInfoList = this.lyUserInfoService.queryLyUserInfo(queryObject).getResults();
      Map lyUserInfoMap = (Map)lyUserInfoList.get(0);

      if ((lyUserInfoMap.get("areaSid") != null) && (!lyUserInfoMap.get("areaSid").equals(""))) {
        String areaSid = lyUserInfoMap.get("areaSid").toString();
        Collection areaInfos = this.lyAreaInfoService.queryLyAreaInfoByField("sid", 
          Integer.valueOf(Integer.parseInt(areaSid)));
        if ((areaInfos != null) && (areaInfos.size() > 0)) {
          LyAreaInfo areaInfo = (LyAreaInfo)areaInfos.iterator().next();
          lyUserInfoMap.put("cityName", areaInfo.getAreaName());
        }
      }

      String userJson = new ObjectMapper().writeValueAsString(lyUserInfoMap);
      LyUserInfoDto lyUserInfoDto = (LyUserInfoDto)JSONObject.toBean(JSONObject.fromObject(userJson), 
        LyUserInfoDto.class);
      Map msgResBody = new HashMap();
      msgResBody.put("userInfo", lyUserInfoDto);

      RetInfo retinfo = new RetInfo("0", "查询成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQueryDynamicinfo(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    String userName = (String)msgBody.get("userName");
    try {
      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("username"));
      qp.setLogicOper(" = ");
      qp.setValue("'" + userName + "'");
      params.add(qp);
      queryObject.setParameters(params);
      List<Map> lyDynamicinfoList = this.lyDynamicinfoService.queryLyDynamicinfo(queryObject)
        .getResults();

      for (Map lyDynamicinfo : lyDynamicinfoList) {
        QueryObject queryCommentObject = new QueryObject();
        Collection commentParams = new ArrayList();
        QueryParam commentQp = new QueryParam();
        commentQp.setKey(StringUtil.underscoreName("dynamicid"));
        commentQp.setLogicOper(" = ");
        commentQp.setValue(lyDynamicinfo.get(StringUtil.underscoreName("sid")).toString());
        commentParams.add(commentQp);
        queryCommentObject.setParameters(commentParams);
        List lyDynamicCommentinfoList = this.lyDynamiccommentinfoService
          .queryLyDynamiccommentinfo(queryCommentObject).getResults();
        lyDynamicinfo.put("comInfoList", lyDynamicCommentinfoList);
        lyDynamicinfo.put("comCount", Integer.valueOf(lyDynamicCommentinfoList.size()));

        Collection lyUserInfos = this.lyUserInfoService.queryLyUserInfoByField(StringUtil.underscoreName("UserName"), userName);
        LyUserInfo lyUserInfo = (LyUserInfo)lyUserInfos.iterator().next();
        lyDynamicinfo.put("userImage", lyUserInfo.getHeadImg() == null ? "" : lyUserInfo.getHeadImg());
        QueryObject imgQueryObject = new QueryObject();
        Collection imgParams = new ArrayList();
        QueryParam imgQp = new QueryParam();
        imgQp.setKey(StringUtil.underscoreName("dynamicid"));
        imgQp.setLogicOper(" = ");
        imgQp.setValue(lyDynamicinfo.get(StringUtil.underscoreName("sid")).toString());
        imgParams.add(imgQp);
        imgQueryObject.setParameters(imgParams);
        imgQueryObject = this.lyAlbumDetailImageService.queryLyAlbumDetailImage(imgQueryObject);
        List imageList = imgQueryObject.getResults();
        lyDynamicinfo.put("imageList", imageList);
      }

      String userJson = new ObjectMapper().writeValueAsString(lyDynamicinfoList);
      Object classMap = new HashMap();
      ((Map)classMap).put("comInfoList", LyDynamiccommentinfoDto.class);
      ((Map)classMap).put("imageList", LyAlbumDetailImageDto.class);
      List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyDynamicinfoDto.class, 
        (Map)classMap);

      Map msgResBody = new HashMap();
      msgResBody.put("dynamicList", newList);
      RetInfo retinfo = new RetInfo("0", "查询成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return (Response)ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataDynamicinfoManage(ResponseHeader responseHeader, JSONObject msgBody) throws JsonProcessingException, Exception
  {
    try
    {
      return this.lyDynamicinfoService.createDynamicinfoManage(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataPublicDynamicComment(ResponseHeader responseHeader, JSONObject msgBody) throws JsonProcessingException, Exception
  {
    try
    {
      return this.lyDynamiccommentinfoService.createDynamicCommentinfo(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataUpdateLocation(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("updateLocation方法...");
    try
    {
      String userSid = (String)msgBody.get("userSid");
      String locTime = (String)msgBody.get("locTime");

      LyUserInfo lyUserInfo = this.lyUserInfoService.queryLyUserInfo(Integer.valueOf(Integer.parseInt(userSid)));
      JSONObject locationObj = (JSONObject)msgBody.get("location");
      if (StringUtil.isNotNull(locationObj)) {
        Double lat = Double.valueOf(Double.parseDouble((String)locationObj.get("lat")));
        Double lng = Double.valueOf(Double.parseDouble((String)locationObj.get("lng")));
        lyUserInfo.setLat(lat);
        lyUserInfo.setLng(lng);
        lyUserInfo.setLocTime(new Timestamp(new Date().getTime()));
      }

      this.lyUserInfoService.updateLyUserInfo(lyUserInfo);
      Map msgResBody = new HashMap();
      RetInfo retinfo = new RetInfo("0", "记录坐标成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  @Deprecated
  public Response getBusiDataQryDynamicInfo(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("getBusiDataQryDynamicInfo方法...");
    QueryObject queryObject = new QueryObject();
    try
    {
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = null;
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj = new PageObj(curPage);
        pageObj.setPageSize(Integer.valueOf(pageSize));
      }

      String userName = (String)msgBody.get("userName");
      if ((userName == null) || (userName.equals(""))) {
        throw new Exception("用户名不能为空！");
      }
      Collection params = new ArrayList();

      QueryParam param = new QueryParam();
      param.setKey("UserName");
      param.setLogicOper(" = ");
      param.setValue("( '" + userName + "' )");
      params.add(param);
      queryObject.setParameters(params);
      queryObject = this.lyDynamicinfoService.queryLyDynamicinfo(queryObject);
      List<Map> lyDynamicinfoList = queryObject.getResults();
      for (Map dynamicInfo : lyDynamicinfoList) {
        Integer dynamicid = (Integer)dynamicInfo.get("dynamicid");

        QueryObject imgQueryObject = new QueryObject();

        Collection imgParams = new ArrayList();
        QueryParam imgQp = new QueryParam();
        imgQp.setKey("dynamicid");
        imgQp.setLogicOper(" = ");
        imgQp.setValue("(" + dynamicid + ")");
        imgParams.add(imgQp);
        imgQueryObject.setParameters(imgParams);

        imgQueryObject = this.lyAlbumDetailImageService.queryLyAlbumDetailImage(imgQueryObject);
        List userImageList = imgQueryObject.getResults();
        dynamicInfo.put("imageList", userImageList);
      }

      String userJson = new ObjectMapper().writeValueAsString(lyDynamicinfoList);
      Object classMap = new HashMap();
      ((Map)classMap).put("imageList", LyAlbumDetailImage.class);

      List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyDynamicinfoDto.class, 
        (Map)classMap);
      Map msgResBody = new HashMap();
      msgResBody.put("dynamicList", newList);
      if (jsonPageObject != null) {
        pageObj.setTotalPage(Integer.valueOf(queryObject.getTotalCount()));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return (Response)ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryDynamicInfoById(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    String dynamicId = (String)msgBody.get("dynamicId");
    try {
      QueryObject queryObject = new QueryObject();
      Collection params = new ArrayList();
      QueryParam qp = new QueryParam();
      qp.setKey(StringUtil.underscoreName("sid"));
      qp.setLogicOper(" = ");
      qp.setValue(dynamicId);
      params.add(qp);
      queryObject.setParameters(params);
      List lyDynamicinfoList = this.lyDynamicinfoService.queryLyDynamicinfo(queryObject)
        .getResults();

      if ((lyDynamicinfoList != null) && (lyDynamicinfoList.size() > 0)) {
        Map lyDynamicinfo = (Map)lyDynamicinfoList.get(0);
        QueryObject queryCommentObject = new QueryObject();
        Collection commentParams = new ArrayList();
        QueryParam commentQp = new QueryParam();
        commentQp.setKey(StringUtil.underscoreName("dynamicid"));
        commentQp.setLogicOper(" = ");
        commentQp.setValue(lyDynamicinfo.get(StringUtil.underscoreName("sid")).toString());
        commentParams.add(commentQp);
        queryCommentObject.setParameters(commentParams);
        List lyDynamicCommentinfoList = this.lyDynamiccommentinfoService
          .queryLyDynamiccommentinfo(queryCommentObject).getResults();
        lyDynamicinfo.put("comInfoList", lyDynamicCommentinfoList);
        lyDynamicinfo.put("comCount", Integer.valueOf(lyDynamicCommentinfoList.size()));

        QueryObject queryUserObject = new QueryObject();
        Collection userParams = new ArrayList();
        QueryParam userQp = new QueryParam();
        userQp.setKey(StringUtil.underscoreName("username"));
        userQp.setLogicOper(" = ");
        log.debug(
          "++++++++++++C_USERNAME+++++++++++++++" + StringUtil.underscoreName("username"));
        log.debug("+++++++++++++++++++++++++++" + 
          lyDynamicinfo.get(StringUtil.underscoreName("username")));
        userQp.setValue("'" + lyDynamicinfo.get(StringUtil.underscoreName("username")) + "'");
        userParams.add(userQp);
        queryUserObject.setParameters(userParams);

        List userImageList = this.lyUserImageService.queryLyUserImage(queryUserObject)
          .getResults();
        if ((userImageList != null) && (userImageList.size() > 0)) {
          Map lyUserUserImage = (Map)userImageList.get(0);
          lyUserUserImage.get(StringUtil.underscoreName("ImageUrl"));
          lyDynamicinfo.put("userImage", 
            lyUserUserImage.get(StringUtil.underscoreName("ImageUrl")));
        } else {
          lyDynamicinfo.put("userImage", "");
        }

        QueryObject imgQueryObject = new QueryObject();
        Collection imgParams = new ArrayList();
        QueryParam imgQp = new QueryParam();
        imgQp.setKey(StringUtil.underscoreName("dynamicid"));
        imgQp.setLogicOper(" = ");
        imgQp.setValue(lyDynamicinfo.get(StringUtil.underscoreName("sid")).toString());
        imgParams.add(imgQp);
        imgQueryObject.setParameters(imgParams);
        imgQueryObject = this.lyAlbumDetailImageService.queryLyAlbumDetailImage(imgQueryObject);
        List imageList = imgQueryObject.getResults();
        lyDynamicinfo.put("imageList", imageList);
      }

      String userJson = new ObjectMapper().writeValueAsString(lyDynamicinfoList);
      Map classMap = new HashMap();
      classMap.put("comInfoList", LyDynamiccommentinfoDto.class);
      classMap.put("imageList", LyAlbumDetailImageDto.class);
      List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyDynamicinfoDto.class, 
        classMap);

      Map msgResBody = new HashMap();
      msgResBody.put("dynamicinfo", newList.get(0));
      RetInfo retinfo = new RetInfo("0", "查询成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryWantToHeadUrlList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("查询景点想去人头像url方法...");
    QueryObject queryObject = new QueryObject();
    Map touristSpot = new HashMap();
    List headUrlList = new ArrayList();
    try {
      String spotSid = (String)msgBody.get("spotSid");
      Collection params = new ArrayList();

      QueryParam param = new QueryParam();
      param.setKey("SpotSid");
      param.setLogicOper(" = ");
      param.setValue(spotSid);
      params.add(param);
      queryObject.setParameters(params);
      PageObj pageObj = new PageObj(1);
      pageObj.setPageSize(Integer.valueOf(3));
      queryObject.setPageObj(pageObj);
      queryObject.setDir("desc");
      queryObject.setSort(StringUtil.underscoreName("CTime"));
      queryObject = this.lyWantToService.queryLyWantTo(queryObject);
      List<Map> lyWantToList = queryObject.getResults();
      for (Map lyWantTo : lyWantToList) {
        String userName = lyWantTo.get(StringUtil.underscoreName("UserName")).toString();
        Collection userInfos = this.lyUserInfoService.queryLyUserInfoByField(StringUtil.underscoreName("UserName"), userName);
        LyUserInfo lyUserInfo = (LyUserInfo)userInfos.iterator().next();
        Map imgUrlMap = new HashMap();
        imgUrlMap.put("imgUrl", lyUserInfo.getHeadImg());
        headUrlList.add(imgUrlMap);
      }

      touristSpot.put("headUrlList", headUrlList);
      Map msgResBody = new HashMap();
      msgResBody.put("touristSpot", touristSpot);
      RetInfo retinfo = new RetInfo("0", "成功！");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataTogetherTourManage(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    try
    {
      return this.lyTogetherTourService.createLyTogetherTourManager(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryNearSpots(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryNearSpots方法...");
    QueryObject queryObject = new QueryObject();
    Map touristSpot = new HashMap();
    List headUrlList = new ArrayList();
    try {
      String citySid = (String)msgBody.get("citySid");
      Collection params = new ArrayList();
      QueryParam param = new QueryParam();
      param.setKey("CitySid");
      param.setLogicOper(" = ");
      param.setValue(citySid);
      params.add(param);

      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = null;
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj = new PageObj(curPage);
        pageObj.setPageSize(Integer.valueOf(3));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      }

      queryObject.setParameters(params);
      queryObject.setDir("desc");

      queryObject = this.lyTouristSpotsService.queryLyTouristSpots(queryObject);
      ObjectMapper mapper = new ObjectMapper();
      List queryList = queryObject.getResults();
      String myjson = mapper.writeValueAsString(queryList);

      List<LyTouristSpotsDetailDto> tourDtoList = new ArrayList();

      tourDtoList = BeanToMapUtil.convertListMap2ListBean(queryList, LyTouristSpotsDetailDto.class);
      for (LyTouristSpotsDetailDto touristSpotDetailDto : tourDtoList) {
        Location location = new Location();

        LyTouristSpotsDetail lyTouristSpotsDetail = this.lyTouristSpotsDetailService
          .queryLyTouristSpotsDetail(touristSpotDetailDto.getSid());
        touristSpotDetailDto.setCheckinNum(lyTouristSpotsDetail.getCheckinNum());
        touristSpotDetailDto.setFavoriteNum(lyTouristSpotsDetail.getFavoriteNum());
        touristSpotDetailDto.setCommentNum(lyTouristSpotsDetail.getCommentNum());
        touristSpotDetailDto.setDiscountNum(lyTouristSpotsDetail.getDiscountNum());

        touristSpotDetailDto.setGrouponNum(lyTouristSpotsDetail.getGrouponNum());
        touristSpotDetailDto.setImageNum(lyTouristSpotsDetail.getImageNum());
        touristSpotDetailDto.setTechnologyRating(lyTouristSpotsDetail.getTechnologyRating());
        touristSpotDetailDto.setHygieneRating(lyTouristSpotsDetail.getHygieneRating());
        touristSpotDetailDto.setFacilityRating(lyTouristSpotsDetail.getFacilityRating());

        touristSpotDetailDto.setEnvironmentRating(lyTouristSpotsDetail.getEnvironmentRating());
        touristSpotDetailDto.setServiceRating(lyTouristSpotsDetail.getServiceRating());
        touristSpotDetailDto.setTasteRating(lyTouristSpotsDetail.getTasteRating());
        touristSpotDetailDto.setOverallRating(lyTouristSpotsDetail.getOverallRating());
        touristSpotDetailDto.setShopHours(lyTouristSpotsDetail.getShopHours());

        touristSpotDetailDto.setPrice(lyTouristSpotsDetail.getPrice());
        touristSpotDetailDto.setDetailUrl(lyTouristSpotsDetail.getDetailUrl());
        touristSpotDetailDto.setTag(lyTouristSpotsDetail.getTag());
        touristSpotDetailDto.setType(lyTouristSpotsDetail.getType());
        touristSpotDetailDto.setDistance(lyTouristSpotsDetail.getDistance());
        touristSpotDetailDto.setMemo(lyTouristSpotsDetail.getMemo());

        location.setLat(touristSpotDetailDto.getLat());
        location.setLng(touristSpotDetailDto.getLng());
        touristSpotDetailDto.setcLocation(location);
      }

      Map msgResBody = new HashMap();
      msgResBody.put("touristSpotList", tourDtoList);

      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataQryTogetherTour(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("qryTogetherTour方法...");
    QueryObject queryObject = new QueryObject();
    Map touristSpot = new HashMap();
    List headUrlList = new ArrayList();
    try
    {
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = null;
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj = new PageObj(curPage);
        pageObj.setPageSize(Integer.valueOf(3));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      } else {
        pageObj = new PageObj(1);
        pageObj.setPageSize(Integer.valueOf(10));
        queryObject.setPageObj(pageObj);
      }

      queryObject = this.lyTogetherTourService.queryLyTogetherTour(queryObject);
      List<Map> queryList = queryObject.getResults();

      Map userInfoCache = new HashMap();
      Collection<LyUserInfo> lyUserInfos = this.lyUserInfoService.queryAllLyUserInfo();
      for (LyUserInfo userInfo : lyUserInfos) {
        String userName = userInfo.getUserName();
        userInfoCache.put(userName, userInfo);
        System.out.println(userInfo.toString());
      }

      for (Map together : queryList) {
        String userName = together.get("userName").toString();
        LyUserInfo userInfo = (LyUserInfo)userInfoCache.get(userName);
        together.put("imgUrl", userInfo.getHeadImg());
        together.put("nickName", userInfo.getUserNickName());
        System.out.println(userInfo.getUserNickName());
      }
      Map msgResBody = new HashMap();
      msgResBody.put("touristSpotList", queryList);
      if (jsonPageObject != null) {
        int total = queryObject.getTotalCount();
        pageObj.setTotalPage(Integer.valueOf(total));
        msgResBody.put("pageObj", pageObj);
      }
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    } catch (Exception e) {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataFriendManager(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("FriendManager方法...");
    try {
      return this.lyUserFriendService.createLyUserFriendManager(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataFriendsList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("FriendsList方法...");
    QueryObject queryObject = new QueryObject();
    try
    {
      String userName = (String)msgBody.get("userName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = null;
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj = new PageObj(curPage);
        pageObj.setPageSize(Integer.valueOf(3));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      } else {
        pageObj = new PageObj(1);
        pageObj.setPageSize(Integer.valueOf(10));
        queryObject.setPageObj(pageObj);
      }

      Collection friends = this.lyUserFriendService.queryLyUserFriendByField(StringUtil.underscoreName("UserName"), userName);

      Iterator iter = friends.iterator();
      StringBuffer friendsIds = new StringBuffer();
      while (iter.hasNext()) {
        friendsIds.append("'" + ((LyUserFriend)iter.next()).getFriendUserName() + "',");
      }

      String ids = friendsIds.toString();
      if (ids.length() > 0) {
        ids = ids.substring(0, ids.length() - 1);
      }

      Collection params = new ArrayList();
      QueryParam param = new QueryParam();
      param.setKey("UserName");
      param.setLogicOper(" in ");
      param.setValue("(" + ids + ")");
      params.add(param);

      queryObject.setParameters(params);
      queryObject = this.lyUserInfoService.queryLyUserInfo(queryObject);
      List lyUserInfoList = queryObject.getResults();

      String userJson = new ObjectMapper().writeValueAsString(lyUserInfoList);
      List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyUserInfoDto.class);

      Map msgResBody = new HashMap();
      msgResBody.put("userList", newList);
      if (jsonPageObject != null) {
        pageObj.setTotalPage(Integer.valueOf(queryObject.getTotalCount()));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataFriendMeList(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("FriendsMeList方法...");
    QueryObject queryObject = new QueryObject();
    try
    {
      String userName = (String)msgBody.get("userName");
      JSONObject jsonPageObject = (JSONObject)msgBody.get("pageObj");
      PageObj pageObj = null;
      if (jsonPageObject != null) {
        int curPage = Integer.parseInt(jsonPageObject.get("currPage").toString());
        int pageSize = Integer.parseInt(jsonPageObject.get("pageSize").toString());
        pageObj = new PageObj(curPage);
        pageObj.setPageSize(Integer.valueOf(3));
        pageObj.setPageSize(Integer.valueOf(pageSize));
        queryObject.setPageObj(pageObj);
      } else {
        pageObj = new PageObj(1);
        pageObj.setPageSize(Integer.valueOf(10));
        queryObject.setPageObj(pageObj);
      }

      Collection friends = this.lyUserFriendService.queryLyUserFriendByField(StringUtil.underscoreName("FriendUserName"), userName);

      Iterator iter = friends.iterator();
      StringBuffer friendsIds = new StringBuffer();
      while (iter.hasNext()) {
        friendsIds.append("'" + ((LyUserFriend)iter.next()).getFriendUserName() + "',");
      }

      String ids = friendsIds.toString();
      if (ids.length() > 0) {
        ids = ids.substring(0, ids.length() - 1);
      }

      Collection params = new ArrayList();
      QueryParam param = new QueryParam();
      param.setKey("UserName");
      param.setLogicOper(" in ");
      param.setValue("(" + ids + ")");
      params.add(param);

      queryObject.setParameters(params);
      queryObject = this.lyUserInfoService.queryLyUserInfo(queryObject);
      List lyUserInfoList = queryObject.getResults();

      String userJson = new ObjectMapper().writeValueAsString(lyUserInfoList);
      List newList = JSONArray.toList(JSONArray.fromObject(userJson), LyUserInfoDto.class);

      Map msgResBody = new HashMap();
      msgResBody.put("userList", newList);
      if (jsonPageObject != null) {
        pageObj.setTotalPage(Integer.valueOf(queryObject.getTotalCount()));
        msgResBody.put("pageObj", pageObj);
      }
      RetInfo retinfo = new RetInfo("0", "");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataDynamicFabulous(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("dynamicFabulous方法...");
    try {
      return this.lyDynamicFabulousService.createDynamicFabulous(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataDynamicReport(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("dynamicReport方法...");
    try {
      return this.lyDynamicReportInfoService.createDynamicReport(responseHeader, msgBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataDynamicFabulousCount(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("DynamicFabulousCount方法...");
    try {
      String dynamicId = (String)msgBody.get("dynamicId");
      int fabulousNum = this.lyDynamicFabulousService.countLyDynamicFabulousByField(StringUtil.underscoreName("dynamicid"), dynamicId);

      Map msgResBody = new HashMap();
      msgResBody.put("fabulousNum", Integer.valueOf(fabulousNum));
      RetInfo retinfo = new RetInfo("0", "");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataFriendsListCount(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("FriendsListCount方法...");
    try {
      String userName = (String)msgBody.get("userName");
      int friendNum = this.lyUserFriendService.countLyUserFriendByField(StringUtil.underscoreName("UserName"), userName);

      Map msgResBody = new HashMap();
      msgResBody.put("friendNum", Integer.valueOf(friendNum));
      RetInfo retinfo = new RetInfo("0", "");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }

  public Response getBusiDataFriendMeListCount(ResponseHeader responseHeader, JSONObject msgBody)
    throws JsonProcessingException, Exception
  {
    log.debug("FriendMeListCount方法...");
    try {
      String userName = (String)msgBody.get("userName");
      int friendMeNum = this.lyUserFriendService.countLyUserFriendByField(StringUtil.underscoreName("FriendUserName"), userName);

      Map msgResBody = new HashMap();
      msgResBody.put("friendMeNum", Integer.valueOf(friendMeNum));
      RetInfo retinfo = new RetInfo("0", "");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, msgResBody);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }
}