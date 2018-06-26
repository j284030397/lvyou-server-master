<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <title>时代地产</title>
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <link href="/css/public.css" type="text/css" rel="stylesheet" />
</head>

<body type="1" style="background:#fff;" >
    <div class="head clearfix">
        <div class="logo">时代地产定价系统</div>
        <div class="userMenu">
            <img src="/images/head.png" /> <span class="hName"> Lily Yang</span>
            <a class="dBtn"></a>
            <a class="backBtn"></a>
        </div>
    </div>
    <div class="main" style="background:#fff;">
        <div class="main_bg">
             <div class="cBox">
                <ul>
                    <li><a><img src="/images/tux1.png"/></a><span>${shoGoods1.name}</span></li>
                    <li><a><img src="/images/tux2.png"/></a><span>房屋调价</span></li>
                    <li><a><img src="/images/tux3.png"/></a><span>定价模板设置</span></li>
                </ul>
            </div> 
        </div>
    </div>
    <script type="text/javascript">
        //$('.main_bg').css('padding',document.body.clientHeight-57-548-30)/2+'px'+' 0px';
       // $(window).resize(function(){
            // $('.main_bg').css('padding',document.body.clientHeight-57-548-30)/2+'px'+' 0px';  
        //});
        

        //

  
    if( $('.cBox').outerWidth(true)<$('.cBox').width()){
                 $('.head').css({
                    width:$('.cBox').width()+'px'
                })
            }else{
                 $('.head').css({
                    width:'auto'
                })
            }
    $(window).resize(function(){

            if( $('.cBox').outerWidth(true)<$('.cBox').width()){
                 $('.head').css({
                    width:$('.cBox').width()+'px'
                })
            }else{
                 $('.head').css({
                    width:'auto'
                })
            }

           
    });
        
    </script>
</body>

</html>
