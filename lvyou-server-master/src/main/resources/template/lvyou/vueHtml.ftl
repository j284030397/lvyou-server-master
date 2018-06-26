<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <title>��ӭ��¼΢����Ӫ����ƽ̨</title>
    <link rel="stylesheet" type="text/css" href="../ui/1.5.4.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../ui/1.5.4.2/themes/icon.css">
    <link rel='stylesheet' type='text/css' href='../ui/js/bootstrap/css/bootstrap.min.css'>
    <link rel='stylesheet' type='text/css' href='../ui/js/jqGrid/css/ui.jqgrid-bootstrap.css'>
    <link rel='stylesheet' type='text/css' href='../ui/css/list.css'>
    <link rel='stylesheet' type='text/css' href='../ui/css/public.css'>
    <script type="text/javascript" src="../ui/1.5.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="../ui/1.5.4.2/jquery.easyui.min.js"></script>
    <script type='text/javascript' src='../ui/1.5.4.2/locale/easyui-lang-zh_CN.js'></script>
    <script type="text/javascript" src="../ui/js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../ui/js/jqGrid/js/jquery.jqGrid.min.js"></script>
    <script type='text/javascript' src='../ui/js/public.js'></script>
    <style type="text/css">
    body {
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 14px;
        line-height: 1.42857143;
        color: #333;
        background-color: #fff;
    }

    .row {
        margin-right: 0px;
        margin-left: 0px;
    }

    .form-horizontal .form-group {
        margin-right: 0px;
        margin-left: 0px;
    }

    .fm-select {
        padding-left: 12px;
        line-height: 35px;
        height: 35px;
        width: 93px;
        border-radius: 5px;
        color: #333;
        border: 1px solid #dddddd;
        appearance: none;
        -moz-appearance: none;
        -webkit-appearance: none;
        background: url(../ui/images/arrow_down.png) no-repeat;
        background-position: right 17px top 16px;
        background-size: 7px 4px;
        width: 100%;
    }

    .fm-spaces {
        margin-right: 20px;
    }

    .fm-label {
        padding-top: 7px;
        margin-bottom: 0;
        text-align: right;
    }

    .ellipsis {
        display: block;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    </style>
</head>

<body style="padding:10px;">
    <form enctype="multipart/form-data" class="form-horizontal" method="post" role="form" id="reqForm">
        <caption></caption>
        <div class="alert alert-info" role="alert">
            ������Ϣ(��
            <font color="red">*</font>Ϊ�������ȷ����д����Ϣ��ʵ׼ȷ�ԣ������޷�ͨ����� )
        </div>
        <div class="row martp10">




		<#list list as columnbean>
				<div class="form-group" title="ѧԱ����">
				    <div class="col-xs-3 control-label fm-label ellipsis">
					<font color="red">*</font>ѧԱ����:</div>
				    <div class="col-xs-9">
					<input type="text" class="form-control" v-model="${columnbean.colTbName}.${columnbean.colName}" placeholder="ѧԱ����">
				    </div>
				</div>
		</#list>


          
               
         
          
        </div>
        <div class="form-group">
        </div>
        <div>
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="col-xs-3 control-label fm-label ellipsis"></div>
                    <div class="col-xs-9">
                        <button type="button" @click="back" class="btn btn-warning fm-spaces">ȷ��</button>
                        <button type="button" @click="saveOrUpdate" class="btn btn-secondary">����</button>
                    </div>
                </div>
            </div>
            <div class="col-xs-6">
            </div>
        </div>
    </form>
</body>

</html>

