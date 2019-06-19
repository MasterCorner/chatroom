<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>在线聊天室</title>
        <link rel="stylesheet" href="CSS/style_index.css" type="text/css">
        <link rel="icon" href="imgs/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="imgs/favicon.ico" type="image/x-icon">
    </head>
<body>

        <header>
            <nav class="b_clear">
                <div class="nav_logo l_float">
                    <img src="imgs/logo.svg" alt="">
                </div>
                <div class="nav_link r_float">
                    <ul>
                        <li><a href="register.jsp">注册</a></li>
                        <!-- <li><a href="#">关于我们</a></li>
                        <li><a href="#">联系我们</a></li>
 -->
                    </ul>
                </div>
            </nav>
        </header>
        <div class="container">
            <div class="login_body l_clear">
                <div class="login_form l_float">
                    <div class="login_top">
                        <img src="imgs/logo_z.svg" alt="" class="">
                        
                        <div class="login_tags b_clear">
                            <span class="top_tag l_float active" onClick="PwdLogin()">密码登录</span>
                            <span class="top_tag r_float" onClick="QrcodeLogin()">扫码登录</span>
                        </div>
                    </div>
                    <div class="login_con">
                        <form action="${pageContext.request.contextPath }/user" method="post"  onSubmit="return check()">
                        		<input type="hidden" name="method" value="login">
                            <div>
                                <label for="username">用户名</label>
                                <input type="text" name="username" id="username" placeholder="名字一定超好听耶(￣▽￣)~*"">
                                <img src="imgs/icons/user.svg">
                                <p class="tips hidden">请检查您的账号</p>
                            </div>
                            <div>
                                <label for="password">密码</label>
                                <input type="password" name="password" id="password" placeholder="你猜我能不能记住φ(>ω<*)">
                                <img src="imgs/icons/lock.svg">
                                <p class="tips hidden">请检查您的密码</p>
                            </div>
                            
                            <div  class="b_clear">
                                <label for="auth_code" class="b_clear">验证码</label>
                                <input type="text" name="auth_code" id="auth_code" style="font-size:16px" placeholder="区分大小写" >
                                
                                
                                <img src="imgs/icons/auth_code.svg">
                                <img style="width:100px;height:30px;margin-left:130px" alt="" src="<%= request.getContextPath() %>/ValidateColorServlet">

                                <!--  <p class="tips hidden">验证码错误</p> -->
                
                                
                            </div >

                            
                            <div class="b_clear submit">
                                
                                <button type="submit" value="Submit">登&nbsp;&nbsp;录</button>
                                <!--  <a href="#" class="r_float">忘记密码？</a> -->
                                <p class="tips hidden">登录失败，请检查您的账户与密码</p>
                            </div>
                            <div class="b_clear">
                                <font color="red">
                                	<%= session.getAttribute("message") == null ? "" : session.getAttribute("message") %>
                                	<% session.removeAttribute("message"); %>
                                </font>
                                <!-- <p>测试账号user="tom",password="1234"</p>  -->
                            </div>
                        </form>   
                    </div>
                    <div class="login_con hidden">
                        <div class="qr_code">
                                <img src="imgs/qr.jpg" alt="">
                                <p>请使用微信扫码登录<br>仅支持已绑定微信的账户进行快速登录</p>
                        </div>
                        
                    </div>
                    <div class="login_otherAccount">
                        <span>第三方登录</span>
                        <a href="https://wx.qq.com/"><img src="imgs/icons/wechat.svg" alt="微信登录"></a>
                        <a href="https://weibo.com/"><img src="imgs/icons/weibo.svg" alt="微博登录"></a>
                        <a href="https://im.qq.com/"><img src="imgs/icons/qq.svg" alt="QQ登录"></a>
                    </div>
                    
                </div>
                <div class="login_ad l_float" id="AdImg">
                    <a href="">查看详情</a>
                </div>
            </div>

        </div>

        <script src="js/login.js"></script>  

</body>
</html>