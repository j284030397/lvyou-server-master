package com.dev.system.web;

import java.io.File;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dev.base.constants.Constants;
import com.dev.base.util.FilePathUtil;
import com.dev.base.util.StringUtil;
import com.dev.lvyou.dao.model.LyAlbum;
import com.dev.lvyou.dao.model.LyAlbumDetailImage;
import com.dev.lvyou.dao.model.LyAlbumInfo;
import com.dev.lvyou.dao.model.LyDynamicinfo;
import com.dev.lvyou.dao.model.LyPhotoWall;
import com.dev.lvyou.dao.model.LyUserImage;
import com.dev.lvyou.dao.model.LyUserInfo;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyAlbumDetailImageService;
import com.dev.lvyou.service.LyAlbumInfoService;
import com.dev.lvyou.service.LyAlbumService;
import com.dev.lvyou.service.LyDynamicinfoService;
import com.dev.lvyou.service.LyPhotoWallService;
import com.dev.lvyou.service.LyUserImageService;
import com.dev.lvyou.service.LyUserInfoService;
import com.dev.system.dao.model.SysUploadfile;
import com.dev.system.service.SysUploadfileService;
import com.dev.system.tool.ImgCompress;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.rong.RongCloud;
import io.rong.models.CodeSuccessReslut;

@Controller
public class UploadFileController
{
  private static final Logger log = LoggerFactory.getLogger(UploadFileController.class);
  private static final long serialVersionUID = 1L;
  private static final String UPLOAD_ROOT = "uploadfile";
  public static final String FILE_SEPARATOR = System.getProperty("file.separator");

  @Autowired
  private SysUploadfileService sysUploadfileService;

  @Autowired
  private LyUserInfoService lyUserInfoService;

  @Autowired
  private LyUserImageService lyUserImageService;

  @Autowired
  private LyDynamicinfoService lyDynamicinfoService;

  @Autowired
  private LyAlbumDetailImageService lyAlbumDetailImageService;

  @Autowired
  private LyAlbumInfoService lyAlbumInfoService;

  @Autowired
  private LyPhotoWallService lyPhotoWallService;

  @Autowired
  private LyAlbumService lyAlbumService;
  private static long IMG_FILE_SIZE_LIMIT = 102400L;

  private static long FILE_SIZE_LIMIT = 20971520L;

  private static long PRIVATEFILE_SIZE_LIMIT = 3145728L;

  private static String PRIVATEFILE_SIZE_LIMIT_ALERT = "3MB";

  private static String uploadPath = null;

  private static String relativePath = null;
  private MultipartFile file;

  @ResponseBody
  @RequestMapping({"/showView"})
  public List showView() { ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("viewName");
    System.out.println("showView...");
    List list = new ArrayList();
    Map map = new HashMap();
    map.put("id", "987543");
    map.put("name", "xiaojianjun");
    Map map2 = new HashMap();
    map2.put("id", "987543");
    map2.put("name", "xiaojianjun");
    list.add(map);
    list.add(map2);
    modelAndView.addObject(" 需要放到 model 中的属性名称 ", " 对应的属性值，它是一个对象 ");
    return list;
  }

 /* @RequestMapping({"/maSearch"})
  public String maSearchFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session)
  {
    String animalOption = request.getParameter("animalOption");
    String inputScopeOption = request.getParameter("inputScopeOption");
    String scopeOption = request.getParameter("scopeOption");
    String homeWildOption = request.getParameter("homeWildOption");
    String oddOption = request.getParameter("oddOption");

    String colorOption = request.getParameter("colorOption");
    String bigOption = request.getParameter("bigOption");
    String headOption = request.getParameter("headOption");
    String endOption = request.getParameter("endOption");
    String codeOption = request.getParameter("codeOption");

    String animalTypeOption = request.getParameter("animalTypeOption");
    String noInputCodeOption = request.getParameter("noInputCodeOption");
    String noHomeWildOption = request.getParameter("noHomeWildOption");
    String noOddOption = request.getParameter("noOddOption");
    String noColorOption = request.getParameter("noColorOption");

    String noBigOption = request.getParameter("noBigOption");
    String noHeadOption = request.getParameter("noHeadOption");
    String noEndOption = request.getParameter("noEndOption");
    String noCodeOption = request.getParameter("noCodeOption");
    String noAnimalOption = request.getParameter("noAnimalOption");

    String lessthan = request.getParameter("lessthan");
    String morethan = request.getParameter("morethan");

    StringBuffer buffer = new StringBuffer();
    String[] arrayOfString1;
    String str14;
    if ((codeOption != null) && (!codeOption.equals(""))) {
      String[] codeOptionArray = codeOption.split(",");
      String codeSql = "";
      StringBuffer codeStr = new StringBuffer();
     // str14 = (arrayOfString1 = codeOptionArray).length; 
      for (int i = 0; i < codeOptionArray.length; i++) {
    	  String code = arrayOfString1[i];
        codeStr.append("'");
        codeStr.append(code);
        codeStr.append("',");
      }
      codeSql = codeStr.toString();
      codeSql = codeSql.substring(0, codeSql.length() - 1);
      buffer.append(" and code in(" + codeSql + ")");
    }
    if ((inputScopeOption != null) && (!inputScopeOption.equals(""))) {
      inputScopeOption = inputScopeOption.trim();
      String[] inputScopeOptionArray = null;
      if (inputScopeOption.indexOf(",") > 0)
        inputScopeOptionArray = inputScopeOption.split(",");
      else if (inputScopeOption.indexOf(".") > 0) {
        inputScopeOptionArray = inputScopeOption.split(".");
      }

      String inputScopeSql = "";
      StringBuffer inputScopeStr = new StringBuffer();
      //str14 = (arrayOfString1 = inputScopeOptionArray).length; 
      
      for (int i = 0; i < inputScopeOptionArray.length; i++) { 
    	  String inputScope = arrayOfString1[i];
        inputScopeStr.append("'");
        inputScopeStr.append(inputScope);
        inputScopeStr.append("',");
      }
      inputScopeSql = inputScopeStr.toString();
      inputScopeSql = inputScopeSql.substring(0, inputScopeSql.length() - 1);
      buffer.append(" and code in(" + inputScopeSql + ")");
    }

    if ((animalTypeOption != null) && (!animalTypeOption.equals(""))) {
      String[] animalTypeOptionArray = animalTypeOption.split(",");
      String animalTypeSql = "";
      StringBuffer animalTypeStr = new StringBuffer();
      //str14 = (arrayOfString1 = animalTypeOptionArray).length; 
      for (int i = 0; i  < animalTypeOptionArray.length; i++) { 
    	  String animal = arrayOfString1[i];
        animalTypeStr.append("'");
        animalTypeStr.append(animal);
        animalTypeStr.append("',");
      }
      animalTypeSql = animalTypeStr.toString();
      animalTypeSql = animalTypeSql.substring(0, animalTypeSql.length() - 1);
      buffer.append(" and t12.name in(" + animalTypeSql + ")");
    }
  //  String[] arrayOfString5;
    if ((endOption != null) && (!endOption.equals(""))) {
      String[] endOptionArray = endOption.split(",");
      String endSql = "";
      StringBuffer endStr = new StringBuffer();
      endStr.append(" and (");
      int index = 0;
    //  i = (arrayOfString5 = endOptionArray).length; 
      for (int i = 0; i  <endOptionArray.length; i++) { 
    	  String end = endOptionArray[i];
        if (index == 0) {
          endStr.append("t_end.name='");
          endStr.append(end);
          endStr.append("'");
        } else {
          endStr.append(" or t_end.name='");
          endStr.append(end);
          endStr.append("'");
        }
        index++;
      }
      endStr.append(")");
      endSql = endStr.toString();
      buffer.append(endSql);
    }
    String head;
    if ((headOption != null) && (!headOption.equals(""))) {
      String[] headOptionArray = headOption.split(",");
      String headSql = "";
      StringBuffer headStr = new StringBuffer();
      headStr.append(" and (");
      int index = 0;
      i = (arrayOfString5 = headOptionArray).length; for (str14 = 0; str14 < i; str14++) { head = arrayOfString5[str14];
        if (index == 0) {
          headStr.append("t_head.name='");
          headStr.append(head);
          headStr.append("'");
        } else {
          headStr.append(" or t_head.name='");
          headStr.append(head);
          headStr.append("'");
        }
        index++;
      }
      headStr.append(")");
      headSql = headStr.toString();
      buffer.append(headSql);
    }
    if ((noHeadOption != null) && (!noHeadOption.equals(""))) {
      String[] noHeadOptionArray = noHeadOption.split(",");
      String noHeadSql = "";
      StringBuffer noHeadStr = new StringBuffer();
      String[] arrayOfString2;
      str14 = (arrayOfString2 = noHeadOptionArray).length; for (String str4 = 0; str4 < str14; str4++) { String noHead = arrayOfString2[str4];

        noHeadStr.append(" and t_head.name!='");
        noHeadStr.append(noHead);
        noHeadStr.append("'");
      }
      noHeadSql = noHeadStr.toString();
      buffer.append(noHeadSql);
    }
    Object localObject2;
    String color;
    if ((colorOption != null) && (!colorOption.equals(""))) {
      String[] colorOptionArray = colorOption.split(",");
      String colorSql = "";
      StringBuffer colorStr = new StringBuffer();
      int index = 0;
      colorStr.append("and (");
      int j = (arrayOfString5 = colorOptionArray).length; for (localObject2 = 0; localObject2 < j; localObject2++) { color = arrayOfString5[localObject2];
        if (index == 0) {
          colorStr.append("t_color.name='");
          colorStr.append(color);
          colorStr.append("'");
        } else {
          colorStr.append(" or t_color.name='");
          colorStr.append(color);
          colorStr.append("'");
        }
        index++;
      }
      colorStr.append(")");
      colorSql = colorStr.toString();
      buffer.append(colorSql);
    }

    if ((lessthan != null) && (!lessthan.equals("")))
    {
      StringBuffer lessthanStr = new StringBuffer();

      lessthanStr.append(" and code < " + lessthan);

      buffer.append(lessthanStr.toString());
    }

    if ((morethan != null) && (!morethan.equals("")))
    {
      StringBuffer morethanStr = new StringBuffer();

      morethanStr.append(" and code > " + morethan);

      buffer.append(morethanStr.toString());
    }
    String homeWild;
    if ((homeWildOption != null) && (!homeWildOption.equals(""))) {
      String[] homeWildOptionArray = homeWildOption.split(",");
      String homeWildSql = "";
      StringBuffer homeWildStr = new StringBuffer();
      String[] arrayOfString3;
      localObject2 = (arrayOfString3 = homeWildOptionArray).length; for (Object localObject1 = 0; localObject1 < localObject2; localObject1++) { homeWild = arrayOfString3[localObject1];
        homeWildStr.append(" and t_home.name='");
        homeWildStr.append(homeWild);
        homeWildStr.append("',");
      }
      homeWildSql = homeWildStr.toString();
      homeWildSql = homeWildSql.substring(0, homeWildSql.length() - 1);
      buffer.append(homeWildSql);
    }
    if ((bigOption != null) && (!bigOption.equals(""))) {
      String[] bigOptionArray = bigOption.split(",");
      StringBuffer bigStr = new StringBuffer();
      String str5 = (localObject2 = bigOptionArray).length; for (homeWild = 0; homeWild < str5; homeWild++) { String big = localObject2[homeWild];
        if (big.equals("大")) {
          bigStr.append(" and code>24");
        }
        else {
          bigStr.append(" and code<25");
        }

      }

      buffer.append(bigStr.toString());
    }
    if ((noBigOption != null) && (!noBigOption.equals(""))) {
      String[] noBigOptionArray = noBigOption.split(",");
      StringBuffer bigStr = new StringBuffer();
      String str6 = (localObject2 = noBigOptionArray).length; for (homeWild = 0; homeWild < str6; homeWild++) { String big = localObject2[homeWild];
        if (big.equals("大")) {
          bigStr.append(" and code>24");
        }
        else {
          bigStr.append(" and code<25");
        }

      }

      buffer.append(bigStr.toString());
    }
    String str15;
    String odd;
    if ((oddOption != null) && (!oddOption.equals(""))) {
      String[] oddOptionArray = oddOption.split(",");
      String oddSql = "";
      StringBuffer oddStr = new StringBuffer();
      int index = 0;
      oddStr.append(" and (");
      int k = (arrayOfString5 = oddOptionArray).length; for (str15 = 0; str15 < k; str15++) { odd = arrayOfString5[str15];
        if (index == 0) {
          oddStr.append(" t_odd_even.name='");
          oddStr.append(odd);
          oddStr.append("'");
        } else {
          oddStr.append(" or  t_odd_even.name='");
          oddStr.append(odd);
          oddStr.append("'");
        }

        index++;
      }

      oddStr.append(")");
      oddSql = oddStr.toString();
      buffer.append(oddSql);
    }
    String[] arrayOfString4;
    if ((noOddOption != null) && (!noOddOption.equals(""))) {
      String[] noOddOptionArray = noOddOption.split(",");
      String noOddSql = "";
      StringBuffer noOddStr = new StringBuffer();
      str15 = (arrayOfString4 = noOddOptionArray).length; for (String str7 = 0; str7 < str15; str7++) { String noOdd = arrayOfString4[str7];
        noOddStr.append(" and  t_odd_even.name!='");
        noOddStr.append(noOdd);
        noOddStr.append("'");
      }
      noOddSql = noOddStr.toString();
      buffer.append(noOddSql);
    }

    if ((animalOption != null) && (!animalOption.equals(""))) {
      String[] animalOptionArray = animalOption.split(",");
      String animalSql = "";
      StringBuffer animalStr = new StringBuffer();
      String str16 = (arrayOfString4 = animalOptionArray).length; for (String str8 = 0; str8 < str16; str8++) { String animal = arrayOfString4[str8];
        animalStr.append("'");
        animalStr.append(animal);
        animalStr.append("',");
      }
      animalSql = animalStr.toString();
      animalSql = animalSql.substring(0, animalSql.length() - 1);
      buffer.append(" and t12.name in(" + animalSql + ")");
    }

    if ((noHomeWildOption != null) && (!noHomeWildOption.equals(""))) {
      String[] noHomeWildOptionArray = noHomeWildOption.split(",");
      String noHomeWildSql = "";
      StringBuffer noHomeWildStr = new StringBuffer();
      String str17 = (arrayOfString4 = noHomeWildOptionArray).length; for (String str9 = 0; str9 < str17; str9++) { String noHomeWild = arrayOfString4[str9];
        noHomeWildStr.append(" and t_home.name!='");
        noHomeWildStr.append(noHomeWild);
        noHomeWildStr.append("',");
      }
      noHomeWildSql = noHomeWildStr.toString();
      noHomeWildSql = noHomeWildSql.substring(0, noHomeWildSql.length() - 1);
      buffer.append(noHomeWildSql);
    }
    if ((noInputCodeOption != null) && (!noInputCodeOption.equals(""))) {
      noInputCodeOption = noInputCodeOption.trim();
      String[] noInputCodeOptionArray = null;
      if (noInputCodeOption.indexOf(",") > 0)
        noInputCodeOptionArray = noInputCodeOption.split(",");
      else if (noInputCodeOption.indexOf(".") > 0) {
        noInputCodeOptionArray = noInputCodeOption.split(".");
      }

      String noInputCodeSql = "";
      StringBuffer noInputCodeStr = new StringBuffer();
      String str18 = (arrayOfString4 = noInputCodeOptionArray).length; for (String str10 = 0; str10 < str18; str10++) { String noInputCode = arrayOfString4[str10];
        noInputCodeStr.append("'");
        noInputCodeStr.append(noInputCode);
        noInputCodeStr.append("',");
      }
      noInputCodeSql = noInputCodeStr.toString();
      noInputCodeSql = noInputCodeSql.substring(0, noInputCodeSql.length() - 1);
      buffer.append(" and code not in(" + noInputCodeSql + ")");
    }

    if ((noColorOption != null) && (!noColorOption.equals("")))
    {
      System.out.println(noColorOption);

      String[] noColorOptionArray = noColorOption.split(",");
      String colorSql = "";
      StringBuffer colorStr = new StringBuffer();

      String str19 = (arrayOfString4 = noColorOptionArray).length; for (String str11 = 0; str11 < str19; str11++) { String color = arrayOfString4[str11];
        colorStr.append("and (!");
        String[] couple = color.split("");
        System.out.println(couple.length);
        colorStr.append(" (t_color.name='");
        colorStr.append(couple[0]);
        colorStr.append("'");
        colorStr.append(" and t_odd_even.name='");
        colorStr.append(couple[1]);
        colorStr.append("'))");
      }

      colorSql = colorStr.toString();
      buffer.append(colorSql);
    }
    if ((noEndOption != null) && (!noEndOption.equals(""))) {
      String[] noEndOptionArray = noEndOption.split(",");
      String endSql = "";
      StringBuffer endStr = new StringBuffer();
      String str20 = (arrayOfString4 = noEndOptionArray).length; for (String str12 = 0; str12 < str20; str12++) { String end = arrayOfString4[str12];
        endStr.append(" and t_end.name!='");
        endStr.append(end);
        endStr.append("',");
      }
      endSql = endStr.toString();
      endSql = endSql.substring(0, endSql.length() - 1);
      buffer.append(endSql);
    }

    if ((noAnimalOption != null) && (!noAnimalOption.equals(""))) {
      String[] noAnimalOptionArray = noAnimalOption.split(",");
      String noAnimalSql = "";
      StringBuffer noAnimalStr = new StringBuffer();
      String str21 = (arrayOfString4 = noAnimalOptionArray).length; for (String str13 = 0; str13 < str21; str13++) { String animal = arrayOfString4[str13];
        noAnimalStr.append("'");
        noAnimalStr.append(animal);
        noAnimalStr.append("',");
      }
      noAnimalSql = noAnimalStr.toString();
      noAnimalSql = noAnimalSql.substring(0, noAnimalSql.length() - 1);
      buffer.append(" and t12.name not in(" + noAnimalSql + ")");
    }

    String sql = "select t.code as code,t12.name as animal,t_color.name as color,t_odd_even.name as odd_even,t_home.name as home_wild,t_boy.name as boy_girl,t_sky.name as sky_earth,t_5.name five_attri,t_end.name end_number from t_code t left join t_animal_12 t12  on(t.animal_12=t12.sid) left join t_attribe_5 t_5  on(t.attribe_5=t_5.sid) left join t_color_3 t_color  on(t.color_3=t_color.sid) left join t_home_wild t_home  on(t.animal_home_wild=t_home.sid) left join t_boy_girl t_boy  on(t.animal_boy_girl=t_boy.sid) left join t_sky_earth t_sky on(t.animal_sky_earth=t_sky.sid) left join t_end on(t.end=t_end.sid) left join t_head on(t.head=t_head.sid) left join t_odd_even on(t.odd_even=t_odd_even.sid) where 1=1 " + 
      buffer.toString() + 
      " order by animal";

    System.out.println(sql);

    List returnList = new ArrayList();

    Connection conn = DbUtil.getCon();
    PreparedStatement pst = null;
    Object columns = new ArrayList();
    try {
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        String code = rs.getString("code");
        String animal = rs.getString("animal");
        String color = rs.getString("color");
        String odd_even = rs.getString("odd_even");

        String home_wild = rs.getString("home_wild");
        String boy_girl = rs.getString("boy_girl");
        String sky_earth = rs.getString("sky_earth");
        String five_attri = rs.getString("five_attri");
        String end_number = rs.getString("end_number");

        Map map = new HashMap();
        map.put("code", code);
        map.put("animal", animal);
        map.put("code", code);
        map.put("color", color);
        map.put("odd_even", odd_even);
        map.put("home_wild", home_wild);
        map.put("boy_girl", boy_girl);
        map.put("sky_earth", sky_earth);
        map.put("five_attri", five_attri);
        map.put("end_number", end_number);
        returnList.add(map);
      }

      Object dataMap = new HashMap();
      ((Map)dataMap).put("list", returnList);

      Configuration freemarkerConfig = new Configuration();

      freemarkerConfig.setDefaultEncoding("UTF-8");

      String url = session.getServletContext().getRealPath("/") + "WEB-INF/classes/template/lvyou";
      File source = new File(url);
      System.out.println("模板位置：" + source.getAbsolutePath());
      freemarkerConfig.setDirectoryForTemplateLoading(source);
      Template mapTemplate = freemarkerConfig.getTemplate("ma_result.ftl", "UTF-8");

      mapTemplate.setEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain; charset=utf-8");
      mapTemplate.process(dataMap, response.getWriter());
      System.out.println(((List)columns).size());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return (String)(String)(String)(String)null;
  }*/

  public void initRoot(HttpServletRequest request)
  {
    ServletContext sc = Constants.getCtx();

    String strFileType = request.getParameter("fileType");
    String isFileToDb = request.getParameter("isFileToDb");
    String webSiteId = request.getParameter("webSiteId");
    Map mapParam = request.getParameterMap();
    Iterator paramsIter = mapParam.entrySet().iterator();
    while (paramsIter.hasNext()) {
      Map.Entry entry = (Map.Entry)paramsIter.next();
      try {
        String name = (String)entry.getKey();
        String value = entry.getValue().toString();

        log.info("测试name：" + name);
        log.info("测试value：" + value);

        log.info("测试value2：" + entry.getValue());
        System.out.println("key=" + entry.getKey() + " and value= " + request.getParameter(entry.getKey().toString()));
      }
      catch (Exception e) {
        e.printStackTrace();
      }

    }

    uploadPath = sc.getRealPath("/");
    if (!uploadPath.endsWith(FILE_SEPARATOR)) {
      uploadPath += FILE_SEPARATOR;
    }
    uploadPath = uploadPath + "uploadfile" + FILE_SEPARATOR;

    relativePath = FILE_SEPARATOR + "uploadfile" + FILE_SEPARATOR;
    relativePath = FilePathUtil.getHttpURLPath(relativePath);

    log.debug("relativePath:" + relativePath);

    File f = new File(uploadPath);

    if (!f.exists())
      f.mkdirs();
  }

  @RequestMapping({"/upload/multiUpload"})
  @ResponseBody
  public String multiUpload(@RequestParam("fileType") String strFileType, @RequestParam("webSiteId") String webSiteId, @RequestParam("userName") String userName, @RequestParam("isFileToDb") String isFileToDb, @RequestParam("file") MultipartFile[] multipartfiles, HttpServletRequest request)
    throws Exception
  {
    log.debug("进入 multiUpload 方法 Post ...");
    try
    {
      initRoot(request);
    } catch (Exception e) {
      log.error(e.getMessage());
      e.printStackTrace();
    }
    System.out.println(multipartfiles.length);

    if ((multipartfiles != null) && (multipartfiles.length > 0))
    {
      for (MultipartFile file : multipartfiles) {
        System.out.println("处理上传文件...");
        int fileType = -1;
        if ((strFileType != null) && (strFileType.trim().length() > 0)) {
          fileType = Integer.parseInt(strFileType);
        }

        String fileName = file.getOriginalFilename().toLowerCase();
        if (log.isDebugEnabled()) {
          log.debug("upload fileName:" + fileName);
        }

        if (fileName.indexOf("\\") > -1) {
          int index = fileName.lastIndexOf("\\");
          fileName = fileName.substring(index + 1);
        } else if (fileName.indexOf("/") > -1) {
          int index = fileName.lastIndexOf("/");
          fileName = fileName.substring(index + 1);
        }

        if (fileName.indexOf(",") >= 0) {
          throw new Exception("文件名内不能含有\",\"！");
        }
        if (fileType == -1) {
          fileType = parseFileType(fileName).intValue();
        }
        long fileSize = file.getSize();
        String errorMsg = checkFileSize(Integer.valueOf(fileType), Long.valueOf(fileSize));
        if (errorMsg != null)
        {
          System.out.println(errorMsg);
          log.error(errorMsg);
          throw new Exception(errorMsg);
        }

        SysUploadfile uploadFile = new SysUploadfile();
        if (userName != null) {
          uploadFile.setUserId(userName);
        }
        uploadFile.setFileName(fileName);
        uploadFile.setFileSize(Long.valueOf(fileSize));
        uploadFile.setFileType(Integer.valueOf(fileType));

        createSysUploadfile(request, file, uploadFile, webSiteId, isFileToDb);
      }
    }
    RetInfo retinfo = new RetInfo("0", "上传成功！");
    return new ObjectMapper().writeValueAsString(retinfo);
  }

  @RequestMapping(value={"/upload/uploadAlbumPics"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json; charset=utf-8"})
  @ResponseBody
  public String uploadAlbumPics(@RequestParam("albumSid") String albumSid, @RequestParam("imageName") String imageName, @RequestParam("imagenote") String imagenote, @RequestParam("userName") String userName, @RequestParam("isFileToDb") String isFileToDb, @RequestParam("webSiteId") String webSiteId, @RequestParam("fileType") String strFileType, @RequestParam("file") MultipartFile[] multipartfiles, HttpServletRequest request)
    throws Exception
  {
    log.debug("进入 uploadAlbumPics 方法 Post ...");
    initRoot(request);
    if ((multipartfiles != null) && (multipartfiles.length > 0))
    {
      for (MultipartFile file : multipartfiles) {
        log.debug("处理上传文件...");
        StringBuffer fileUrls = new StringBuffer();
        int fileType = -1;
        if ((strFileType != null) && (strFileType.trim().length() > 0)) {
          fileType = Integer.parseInt(strFileType);
        }

        String fileName = file.getOriginalFilename().toLowerCase();
        if (fileName.indexOf("\\") > -1) {
          int index = fileName.lastIndexOf("\\");
          fileName = fileName.substring(index + 1);
        } else if (fileName.indexOf("/") > -1) {
          int index = fileName.lastIndexOf("/");
          fileName = fileName.substring(index + 1);
        }

        if (fileName.indexOf(",") >= 0) {
          throw new Exception("文件名内不能含有\",\"！");
        }
        if (fileType == -1) {
          fileType = parseFileType(fileName).intValue();
        }
        long fileSize = file.getSize();
        String errorMsg = checkFileSize(Integer.valueOf(fileType), Long.valueOf(fileSize));
        if (errorMsg != null)
        {
          System.out.println(errorMsg);
          log.error(errorMsg);
          throw new Exception(errorMsg);
        }

        SysUploadfile uploadFile = new SysUploadfile();
        if (userName != null) {
          uploadFile.setUserId(userName);
        }
        uploadFile.setFileName(fileName);
        uploadFile.setFileSize(Long.valueOf(fileSize));
        uploadFile.setFileType(Integer.valueOf(fileType));
        createSysUploadfile(request, file, uploadFile, webSiteId, isFileToDb);
        fileUrls.append(uploadFile.getFileUrl());
        LyAlbumInfo lyAlbumInfo = new LyAlbumInfo();
        lyAlbumInfo.setAlbumSid(Integer.valueOf(Integer.parseInt(albumSid)));
        LyAlbum lyAlbum = this.lyAlbumService.queryLyAlbum(Integer.valueOf(Integer.parseInt(albumSid)));
        if ((lyAlbum.getCoverUrl() != null) && (!lyAlbum.equals(""))) {
          lyAlbum.setCoverUrl(uploadFile.getFileUrl());
        }

        lyAlbumInfo.setImageName(imageName);
        lyAlbumInfo.setImagenote(imagenote);
        lyAlbumInfo.setCTime(new Timestamp(new Date().getTime()));
        lyAlbumInfo.setImageUrl(uploadFile.getFileUrl());
        this.lyAlbumInfoService.createLyAlbumInfo(lyAlbumInfo);
        this.lyAlbumService.updateLyAlbum(lyAlbum);
      }
    }
    RetInfo retinfo = new RetInfo("0", "上传成功！");
    return new ObjectMapper().writeValueAsString(retinfo);
  }

  @RequestMapping(value={"/upload/uploadPhotowallPics"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json; charset=utf-8"})
  @ResponseBody
  public String uploadPhotowallPics(@RequestParam("imageName") String imageName, @RequestParam("albumnote") String albumnote, @RequestParam("userName") String userName, @RequestParam("isFileToDb") String isFileToDb, @RequestParam("webSiteId") String webSiteId, @RequestParam("fileType") String strFileType, @RequestParam("file") MultipartFile[] multipartfiles, HttpServletRequest request)
    throws Exception
  {
    log.debug("进入 uploadAlbumPics 方法 Post ...");
    initRoot(request);
    if ((multipartfiles != null) && (multipartfiles.length > 0))
    {
      for (MultipartFile file : multipartfiles) {
        log.debug("处理上传文件...");
        StringBuffer fileUrls = new StringBuffer();
        int fileType = -1;
        if ((strFileType != null) && (strFileType.trim().length() > 0)) {
          fileType = Integer.parseInt(strFileType);
        }

        String fileName = file.getOriginalFilename().toLowerCase();
        if (fileName.indexOf("\\") > -1) {
          int index = fileName.lastIndexOf("\\");
          fileName = fileName.substring(index + 1);
        } else if (fileName.indexOf("/") > -1) {
          int index = fileName.lastIndexOf("/");
          fileName = fileName.substring(index + 1);
        }

        if (fileName.indexOf(",") >= 0) {
          throw new Exception("文件名内不能含有\",\"！");
        }
        if (fileType == -1) {
          fileType = parseFileType(fileName).intValue();
        }
        long fileSize = file.getSize();
        String errorMsg = checkFileSize(Integer.valueOf(fileType), Long.valueOf(fileSize));
        if (errorMsg != null)
        {
          System.out.println(errorMsg);
          log.error(errorMsg);
          throw new Exception(errorMsg);
        }

        SysUploadfile uploadFile = new SysUploadfile();
        if (userName != null) {
          uploadFile.setUserId(userName);
        }
        uploadFile.setFileName(fileName);
        uploadFile.setFileSize(Long.valueOf(fileSize));
        uploadFile.setFileType(Integer.valueOf(fileType));
        createSysUploadfile(request, file, uploadFile, webSiteId, isFileToDb);
        fileUrls.append(uploadFile.getFileUrl());
        LyPhotoWall lyPhotoWall = new LyPhotoWall();
        lyPhotoWall.setImagename(imageName);
        lyPhotoWall.setCTime(new Timestamp(new Date().getTime()));
        lyPhotoWall.setImageurl(fileUrls.toString());
        this.lyPhotoWallService.createLyPhotoWall(lyPhotoWall);
      }
    }
    RetInfo retinfo = new RetInfo("0", "上传成功！");
    return new ObjectMapper().writeValueAsString(retinfo);
  }

  @RequestMapping(value={"/upload/publicDynamicinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json; charset=utf-8"}, consumes={"multipart/*"})
  @ResponseBody
  public String publicDynamicinfo(@RequestParam("fileType") String strFileType, @RequestParam("webSiteId") String webSiteId, @RequestParam("isFileToDb") String isFileToDb, @RequestParam("userName") String userName, @RequestParam("commentnote") String commentnote, @RequestParam("commentaddress") String commentaddress, @RequestParam("oper") String oper, @RequestParam("file") MultipartFile[] multipartfiles, HttpServletRequest request)
    throws Exception
  {
    log.debug("进入 publicDynamicinfo 方法 Post ...");
    initRoot(request);
    System.out.println(multipartfiles.length);
    LyDynamicinfo lyDynamicinfo = new LyDynamicinfo();
    lyDynamicinfo.setUsername(URLDecoder.decode(userName, "utf-8"));
    log.info(" URLDecoder.decode ..." + URLDecoder.decode(commentnote, "utf-8"));

    lyDynamicinfo.setCommentnote(URLDecoder.decode(commentnote, "utf-8"));
    lyDynamicinfo.setCommentaddress(URLDecoder.decode(commentaddress, "utf-8"));
    this.lyDynamicinfoService.createLyDynamicinfo(lyDynamicinfo);

    if ((multipartfiles != null) && (multipartfiles.length > 0))
    {
      for (MultipartFile file : multipartfiles) {
        System.out.println("处理上传文件...");
        StringBuffer fileUrls = new StringBuffer();
        int fileType = -1;
        if ((strFileType != null) && (strFileType.trim().length() > 0)) {
          fileType = Integer.parseInt(strFileType);
        }

        String fileName = file.getOriginalFilename().toLowerCase();
        if (log.isDebugEnabled()) {
          log.debug("upload fileName:" + fileName);
        }

        if (fileName.indexOf("\\") > -1) {
          int index = fileName.lastIndexOf("\\");
          fileName = fileName.substring(index + 1);
        } else if (fileName.indexOf("/") > -1) {
          int index = fileName.lastIndexOf("/");
          fileName = fileName.substring(index + 1);
        }

        if (fileName.indexOf(",") >= 0) {
          throw new Exception("文件名内不能含有\",\"！");
        }
        if (fileType == -1) {
          fileType = parseFileType(fileName).intValue();
        }
        long fileSize = file.getSize();
        String errorMsg = checkFileSize(Integer.valueOf(fileType), Long.valueOf(fileSize));
        if (errorMsg != null)
        {
          System.out.println(errorMsg);
          log.error(errorMsg);
          throw new Exception(errorMsg);
        }

        SysUploadfile uploadFile = new SysUploadfile();
        if (userName != null) {
          uploadFile.setUserId(userName);
        }
        uploadFile.setFileName(fileName);
        uploadFile.setFileSize(Long.valueOf(fileSize));
        uploadFile.setFileType(Integer.valueOf(fileType));
        createSysUploadfile(request, file, uploadFile, webSiteId, isFileToDb);
        fileUrls.append(uploadFile.getFileUrl());
        LyAlbumDetailImage lyAlbumDetailImage = new LyAlbumDetailImage();
        lyAlbumDetailImage.setImageName(uploadFile.getFileName());
        lyAlbumDetailImage.setImageUrl(fileUrls.toString());
        lyAlbumDetailImage.setDynamicid(lyDynamicinfo.getSid());
        this.lyAlbumDetailImageService.createLyAlbumDetailImage(lyAlbumDetailImage);
      }
    }
    RetInfo retinfo = new RetInfo("0", "上传成功！");
    return new ObjectMapper().writeValueAsString(retinfo); } 
  @RequestMapping(value={"/upload/userHeadImg"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json; charset=utf-8"})
  @ResponseBody
  public String uploadFile(@RequestParam("fileType") String strFileType, @RequestParam("userName") String userName, @RequestParam("isDefault") String isDefault, @RequestParam("webSiteId") String webSiteId, @RequestParam("isFileToDb") String isFileToDb, @RequestParam("userSid") String userSid, @RequestParam("userNickName") String userNickName, @RequestParam("sex") String sex, @RequestParam("citySid") String citySid, @RequestParam("birthday") String birthday, @RequestParam("signName") String signName, @RequestParam("profess") String profess, HttpServletRequest request) throws Exception { request.setCharacterEncoding("utf-8");
    log.debug("进入upload 方法 Post");
    initRoot(request);
    Map map = new HashMap();
    RetInfo retinfo;
    try { MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
      StringBuffer fileUrls = new StringBuffer();
      int fileType = -1;
      if ((strFileType != null) && (strFileType.trim().length() > 0)) {
        fileType = Integer.parseInt(strFileType);
      }
      this.file = multipartRequest.getFile("file");

      String fileName = this.file.getOriginalFilename().toLowerCase();

      if (fileName.indexOf("\\") > -1) {
        int index = fileName.lastIndexOf("\\");
        fileName = fileName.substring(index + 1);
      } else if (fileName.indexOf("/") > -1) {
        int index = fileName.lastIndexOf("/");
        fileName = fileName.substring(index + 1);
      }

      if (fileName.indexOf(",") >= 0) {
        throw new Exception("文件名内不能含有\",\"！");
      }
      if (fileType == -1) {
        fileType = parseFileType(fileName).intValue();
      }
      long fileSize = this.file.getSize();
      String errorMsg = checkFileSize(Integer.valueOf(fileType), Long.valueOf(fileSize));
      if (errorMsg != null)
      {
        System.out.println(errorMsg);
        log.error(errorMsg);
        throw new Exception(errorMsg);
      }

      SysUploadfile uploadFile = new SysUploadfile();
      if (userName != null) {
        uploadFile.setUserId(userName);
      }
      uploadFile.setFileName(fileName);
      uploadFile.setFileSize(Long.valueOf(fileSize));
      uploadFile.setFileType(Integer.valueOf(fileType));

      createSysUploadfile(request, this.file, uploadFile, webSiteId, isFileToDb);
      fileUrls.append(uploadFile.getFileUrl());
      if (userName != null) {
        uploadFile.setUserId(userName);

        Collection user = this.lyUserInfoService.queryLyUserInfoByField(StringUtil.underscoreName("UserName"), userName);
        if (user.iterator().hasNext()) {
          LyUserInfo lyUserInfo = (LyUserInfo)user.iterator().next();
          lyUserInfo.setHeadImg(fileUrls.toString());
          this.lyUserInfoService.updateLyUserInfo(lyUserInfo);

          RongCloud rongCloud = RongCloud.getInstance(Constants.appkey, Constants.appSecret);

          CodeSuccessReslut localCodeSuccessReslut = rongCloud.user.refresh(String.valueOf(lyUserInfo.getSid()), 
            lyUserInfo.getUserName(), lyUserInfo.getHeadImg() != null ? lyUserInfo.getHeadImg() : "http://www.rongcloud.cn/images/logo.png");
        }

        LyUserImage lyUserImage = new LyUserImage();
        lyUserImage.setImageUrl(fileUrls.toString());
        lyUserImage.setImageSize(new Integer(String.valueOf(fileSize)));
        lyUserImage.setCTime(new Timestamp(new Date().getTime()));
        if (isDefault != null) {
          lyUserImage.setIsDefault(Integer.valueOf(Integer.parseInt(isDefault)));
        }
        lyUserImage.setUserName(userName);
        this.lyUserImageService.createLyUserImage(lyUserImage);
      }
       retinfo = new RetInfo("0", "上传成功！");
      return new ObjectMapper().writeValueAsString(retinfo);
    } catch (Exception ex) {
      ex.printStackTrace();
      retinfo = new RetInfo("9999990", "上传失败！");
    }return new ObjectMapper().writeValueAsString(retinfo);
  }

  private void createSysUploadfile(HttpServletRequest request, MultipartFile fileItem, SysUploadfile uploadFile, String webSiteId, String isFileToDb)
    throws Exception
  {
    if (uploadFile.getUserId() == null)
      uploadFile.setUserId("0");
    else {
      uploadFile.setUserId(uploadFile.getUserId().toString());
    }

    String fileUrl = createNewFile(fileItem, uploadFile, webSiteId, request);
    uploadFile.setFileUrl(fileUrl);

    if ((webSiteId != null) && (webSiteId.trim().length() > 0)) {
      uploadFile.setWebSiteId(Integer.valueOf(Integer.parseInt(webSiteId)));
    }
    this.sysUploadfileService.createSysUploadfile(uploadFile);
  }

  public String createNewFile(MultipartFile fileItem, SysUploadfile uploadFile, String webSiteId, HttpServletRequest request)
    throws Exception
  {
    StringBuffer fileUrl_relativePath = new StringBuffer(64);
    StringBuffer relativeFileUrl = new StringBuffer(64);
    File file = null;
    if ((webSiteId != null) && (webSiteId.trim().length() > 0)) {
      fileUrl_relativePath.append("webSite_").append(webSiteId);
      relativeFileUrl.append("webSite_").append(webSiteId);
    } else if (5 == uploadFile.getFileType().intValue()) {
      fileUrl_relativePath.append("private");
      relativeFileUrl.append("private");
    } else {
      fileUrl_relativePath.append("publicFile");
      relativeFileUrl.append("publicFile");
    }
    file = new File(uploadPath + fileUrl_relativePath.toString());
    if (!file.exists()) {
      file.mkdir();
    }
    fileUrl_relativePath.append(FILE_SEPARATOR);
    relativeFileUrl.append(FILE_SEPARATOR);

    switch (uploadFile.getFileType().intValue()) {
    case 0:
      fileUrl_relativePath.append("image");
      relativeFileUrl.append("image");
      break;
    case 1:
      fileUrl_relativePath.append("viedo");
      relativeFileUrl.append("viedo");
      break;
    case 2:
      fileUrl_relativePath.append("att");
      relativeFileUrl.append("att");
      break;
    case 3:
      fileUrl_relativePath.append("normalFile");
      relativeFileUrl.append("normalFile");
      break;
    case 4:
      fileUrl_relativePath.append("contentImage");
      relativeFileUrl.append("contentImage");
      break;
    case 5:
      if (uploadFile.getUserId() != null) {
        fileUrl_relativePath.append(uploadFile.getUserId());
        relativeFileUrl.append(uploadFile.getUserId());
      } else {
        fileUrl_relativePath.append("0");
        relativeFileUrl.append("0");
      }
      break;
    case 6:
      fileUrl_relativePath.append("flash");
      relativeFileUrl.append("flash");
      break;
    case 7:
      fileUrl_relativePath.append("template");
      relativeFileUrl.append("template");
      break;
    case 8:
      fileUrl_relativePath.append("excel");
      relativeFileUrl.append("excel");
      break;
    case 9:
      fileUrl_relativePath.append("temp");
      relativeFileUrl.append("temp");
    }

    file = new File(uploadPath + fileUrl_relativePath.toString());
    if (!file.exists()) {
      file.mkdir();
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");

    String stamp = simpleDateFormat.format(new Date(System.currentTimeMillis()));
    fileUrl_relativePath.append(FILE_SEPARATOR).append(stamp);
    relativeFileUrl.append(FILE_SEPARATOR).append(stamp);

    file = new File(uploadPath + fileUrl_relativePath.toString());
    if (!file.exists()) {
      file.mkdir();
    }
    fileUrl_relativePath.append(FILE_SEPARATOR);
    relativeFileUrl.append(FILE_SEPARATOR);

    Random r = new Random();

    String random = String.valueOf(r.nextInt(1000));
    String stamp1 = String.valueOf(System.currentTimeMillis());

    fileUrl_relativePath.append(random).append(stamp1);
    relativeFileUrl.append(random).append(stamp1);

    String fileName = uploadFile.getFileName();
    fileUrl_relativePath.append(fileName.subSequence(fileName.lastIndexOf("."), fileName.length()));
    relativeFileUrl.append(fileName.subSequence(fileName.lastIndexOf("."), fileName.length()));
    file = new File(uploadPath + fileUrl_relativePath.toString());
    file.createNewFile();
    if (uploadFile.getFileType().intValue() == 0) {
      ImgCompress imgCom = new ImgCompress(fileItem.getInputStream(), file);

      imgCom.resizeFix(700, 800);
      System.out.println("结束：" + new Date().toLocaleString());
    } else {
      fileItem.transferTo(file);
    }
    return FilePathUtil.getHttpURLPath(relativePath + relativeFileUrl.toString());
  }

  private String getUploadCurrentTime()
  {
    return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
  }

  private Integer parseFileType(String fileName)
  {
   // Integer fileType;
    Integer fileType;
    if ((fileName.endsWith(".jpg")) || (fileName.endsWith(".gif")) || (fileName.endsWith(".bmp")) || 
      (fileName.endsWith(".png")) || (fileName.endsWith(".tif")) || (fileName.endsWith(".wmf"))) {
      fileType = Integer.valueOf(0);
    }
    else
    {
    //  Integer fileType;
      if ((fileName.endsWith(".rar")) || (fileName.endsWith(".zip")) || (fileName.endsWith(".jar")) || 
        (fileName.endsWith(".war")) || (fileName.endsWith(".ear"))) {
        fileType = Integer.valueOf(2);
      }
      else
      {
     //   Integer fileType;
        if ((fileName.endsWith(".asf")) || (fileName.endsWith(".wma")) || (fileName.endsWith(".mp3")) || 
          (fileName.endsWith(".mov")) || (fileName.endsWith(".avi")) || (fileName.endsWith(".midi")) || 
          (fileName.endsWith(".mp4")) || (fileName.endsWith(".wav")) || (fileName.endsWith(".au")) || 
          (fileName.endsWith(".vod")))
          fileType = Integer.valueOf(1);
        else
          fileType = Integer.valueOf(3); 
      }
    }
    return fileType;
  }

  private String checkFileSize(Integer fileType, Long fileSize)
  {
    String errorMsg = null;

    if ((5 == fileType.intValue()) && 
      (fileSize.longValue() > PRIVATEFILE_SIZE_LIMIT)) {
      errorMsg = "上传的附件不能超过" + PRIVATEFILE_SIZE_LIMIT_ALERT + ",请处理后再试!";
    }

    return errorMsg;
  }
}