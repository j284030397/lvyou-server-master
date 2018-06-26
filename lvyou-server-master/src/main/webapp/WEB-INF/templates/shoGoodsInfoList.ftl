<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <title>时代地产</title>
    <link href="/css/public.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
     <script type="text/javascript" src="/js/public.js"></script>
</head>

<body type="1">
    <div class="head clearfix">
        <div class="logo">时代地产定价系统</div>
        <div class="userMenu">
            <img src="/images/head.png" /> <span class="hName"> Lily Yang</span>
            <a class="dBtn"></a>
            <a class="backBtn"></a>
        </div>
    </div>
    <div class="main">
        <div class="menu clearfix">
            <a class="on"><img src="/images/hours.png" /><span>房屋定价</span></a>
            <a><img src="/images/pen.png" /><span>定价模板设置</span></a>
        </div>
        <div class="cont">
            <div class="mangerDiv">
                <div class="funDiv"><a class="addCase"><span>新增定价方案</span></a></div>
                <div class="optionDiv clearfix">
                    <div class="leftPan">
                        <input type="text" class="caseInput fl mrt15" placeholder="请输入方案名" />
                       

 					  <div class="select_def fl selLoud" id="hxDiv">
                        <a>请选择楼栋</a>
                        <div class="marks"></div>
                        <input name="" type="hidden" value="" id="inputselect3" />
                        <ul>
                            <li><a href="javascript:void(0);" selValue="1">30%</a></li>
                            <li><a href="javascript:void(0);" selValue="2">50%</a></li>
                            <li><a href="javascript:void(0);" selValue="3">70%</a></li>
                        </ul>
                      </div>
                        <a class="searchBtn fl"><span>查询</span></a>
                    </div>
                    <div class="rightPan"><a class="on">全部方案</a><a>最近三个月 </a><a class="last">最新修改</a></div>
                </div>
                <div class="tableBox">
                	
                	<table class="tblist">
	                    <thead>
	                        <tr>
	                            <th style="width:44px;"></th>
	                            <th>方案名</th>
	                            <th>项目</th>
	                            <th>区域</th>
	                            <th>楼栋 </th>
	                            <th> 修改时间 </th>
	                            <th>操作</th>
	                        </tr>
	                    </thead>
	                    <tbody>

							<#list shoGoodsList as item>

								<#if item_index%2 != 0>  
								 	<tr class="odd">
			                            <td>
			                                <input type="checkbox" value="${item.id?if_exists }" />
			                            </td>
			                            <td>${item.name?if_exists } </td>
			                            <td>${item.type?if_exists } </td>
			                            <td>${item.intro?if_exists }</td>
			                            <td> ${item.detail?if_exists } </td>
			                            <td>${item.remark?if_exists }</td>
			                            <td><a class="updatBtn">查看/修改</a></td>
			                        </tr>
							
								<#else>  
	 								<tr class="edd">
			                              <td>
			                                <input type="checkbox" value="${item.id?if_exists }" />
			                            </td>
			                            <td>${item.name?if_exists } </td>
			                            <td>${item.type?if_exists } </td>
			                            <td>${item.intro?if_exists }</td>
			                            <td> ${item.detail?if_exists } </td>
			                            <td>${item.remark?if_exists }</td>
			                            <td><a class="updatBtn">查看/修改</a></td>
		                       		 </tr>
								</#if> 

                            </#list>

	                       
	                    </tbody>
	                </table>
	                <div class="paging clearfix mtp12">
	                    <div class="pagediv"> <a class="first">上一页</a><a>1</a><a class="on">2</a><a>3</a><span>...</span><a>35</a><a class="last">下一页</a></div>
	                </div>
                </div>
                
            </div>
        </div>
    </div>
</body>

</html>
