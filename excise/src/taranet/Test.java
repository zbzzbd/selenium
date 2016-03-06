package taranet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class TCA001LoginUser {
 String test;
 public static String apiIp = null;
 public static String auths = null;
 Properties testdataconfig = LibDataConfig.getInstance().getProperties();
 private static final LibLogger logger = LibLogger
   .getLogger(TCA001LoginUser.class);

 @BeforeClass
 public void setUp() throws Exception {
  logger.log(" Auto Test Data Init ! ");

  Connection conn = null;
  Statement statement = null;
  ResultSet rs = null;
  int rs_del = 0;
  try {
   conn = LibJDBC.getConnection();
   statement = conn.createStatement();
   String sql1 = "UPDATE  users set  phone_number=15811297594 ,password='fcbdf647ea2ae6bff9c859e0403cd219648349d27e11d9fc0304c0d681538eb4' WHERE  user_id='3618'";
   rs_del = statement.executeUpdate(sql1);   
  } catch (Exception e1) {
   e1.printStackTrace();
  } finally {
   LibJDBC.release(rs, statement, conn);
  }
 }
 public String gettest() {
  return test;
 }

 public String getLoginResultInfo(String userName, String passwd) {

  if (apiIp == null) {
   apiIp = testdataconfig.getProperty("testMURL.apiIp");
  }
  String actualResults;
  String callUrls = "loginUserSystem.do";
  String auths = "info={'username':'"
    + userName
    + "','loginPwd':'"
    + passwd
    + "'}&auth="
    + "{'source':'7','vendor':'100000','appver':'1','version':'20'}";
  StringBuffer sbs = new StringBuffer();
  sbs.append(apiIp).append(callUrls).append("?");
  String results2 = HttpUtils.doPostBody(sbs.toString(), auths, null,
    "utf-8", false);
  actualResults = results2.replace('\"', '\'');
  return actualResults;
 }
 // 为其它接口需要获取UserSession使用
 public String getUserSession(String userName, String passwd) {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  String actualResults = LoginUser.getLoginResultInfo(userName, passwd);
  logger.log("Login actualResults is:" + actualResults);
  JSONObject dataJson = JSONObject.fromObject(actualResults);
  String resultInfo = dataJson.getString("result");

  JSONObject resultInfoBody = JSONObject.fromObject(resultInfo);
  String userSession = resultInfoBody.getString("userSession");
  // logger.log("resultInfo is :" +resultInfo );
  if( userSession.equals("null")){
  logger.log("userSession is :" + userSession);
  return null;
  }
  return userSession;
 }


 public String getUserId(String userName, String passwd) {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  String actualResults = LoginUser.getLoginResultInfo(userName, passwd);
  JSONObject dataJson = JSONObject.fromObject(actualResults);
  String resultInfo = dataJson.getString("result");
  JSONObject resultInfoBody = JSONObject.fromObject(resultInfo);
  String userId = resultInfoBody.getString("userId");
  return userId;
 }


 public boolean loginUser(String userName, String passwd) {
  if (apiIp == null) {
   apiIp = testdataconfig.getProperty("testMURL.apiIp");
   logger.log(" apiIp is : " + apiIp);
  }
  String actualResults;
  String callUrls = "loginUserSystem.do";
  String auths = "info={'username':'"
    + userName
    + "','loginPwd':'"
    + passwd
    + "'}&auth="
    + "{'source':'7','vendor':'100000','appver':'1','version':'20'}";
  StringBuffer sbs = new StringBuffer();
  sbs.append(apiIp).append(callUrls).append("?");
  logger.log("sbs.toString() :"+sbs.toString());
  String results2 = HttpUtils.doPostBody(sbs.toString(), auths, null,
    "utf-8", false);
  actualResults = results2.replace('\"', '\'');
  logger.log("LoginUser Results is " + actualResults);
  boolean contains = actualResults.indexOf("登录成功") != -1;
  logger.log(" LoginResult is " + contains);
  return contains;
 }
 public boolean loginUserAll(String userName, String passwd) {
  if (apiIp == null) {
   apiIp = testdataconfig.getProperty("testMURL.apiIp");
   logger.log(" apiIp is : " + apiIp);
  }
  // String apiIp="http://115.28.36.45:85/";
  String actualResults;
  String callUrls = "loginUserSystem.do";
  String auths = "info={'username':'"
    + userName
    + "','loginPwd':'"
    + passwd
    + "'}&auth="
    + "{'source':'7','vendor':'100000','osver':'1','appver':'1','version':'20'}";
  StringBuffer sbs = new StringBuffer();
  sbs.append(apiIp).append(callUrls).append("?");
  String results2 = HttpUtils.doPostBody(sbs.toString(), auths, null,
    "utf-8", false);
  actualResults = results2.replace('\"', '\'');
  JSONObject dataJson = JSONObject.fromObject(actualResults);
  String resultInfo = dataJson.getString("result");
  JSONObject resultInfoBody = JSONObject.fromObject(resultInfo);
  String userId = resultInfoBody.getString("userId");
  String username = resultInfoBody.getString("username");
  String phone = resultInfoBody.getString("phone");
  String email = resultInfoBody.getString("email");
  String userLevel = resultInfoBody.getString("userLevel");
  String realName = resultInfoBody.getString("realName");
  String totalInvest = resultInfoBody.getString("totalInvest");

  Connection conn = null;
  Statement statement = null;
  ResultSet rs = null;
  String userIddb = null;
  String usernamedb = null;
  String phonedb = null;
  String emaildb = null;
  String userLeveldb = null;
  String realNamedb = null;
  String accountStatusdb = null;
  String totalInvestdb = null;

  try {
   conn = LibJDBC.getConnection();
   statement = conn.createStatement();
   String sqluserId = "select user_id,phone_number from users where phone_number='"
     + userName + "'";
   logger.log("sqluserId is:" + sqluserId);
   rs = statement.executeQuery(sqluserId);
   if (rs.next()) {
    userIddb = rs.getString("user_id");
    logger.log("userIddb is:" + userIddb);
   }
   if (userIddb != null) {
    String sqluserinfo = "select username,phone_number,email,user_level,realName from users where user_id='"
      + userIddb + "'";
    logger.log("sqlusername is:" + sqluserinfo);
    rs = statement.executeQuery(sqluserinfo);
    if (rs.next()) {
     usernamedb = rs.getString("username");
     phonedb = rs.getString("phone_number");
     emaildb = rs.getString("email");
     userLeveldb = rs.getString("user_level");
     realNamedb = rs.getString("realName");
    }
    String sqltotalInvest = "SELECT sum(amountOfInvest) as amountOfInvest  from investment WHERE userId='"
      + userIddb + "'";
    logger.log("sqltotalInvest is:" + sqltotalInvest);
    rs = statement.executeQuery(sqltotalInvest);
    if (rs.next()) {
     totalInvestdb = rs.getString("amountOfInvest");
     logger.log("totalInvestdb is:" + totalInvestdb);
    }

   }
  } catch (Exception e1) {
   e1.printStackTrace();
  } finally {
   LibJDBC.release(rs, statement, conn);
  }
  if (LibKeepTwoDecimal.KeepTwoDecimalAction(
    Double.parseDouble(totalInvest), 2) == LibKeepTwoDecimal
    .KeepTwoDecimalAction(Double.parseDouble(totalInvestdb), 2)) {
   logger.log("Json totalInvest , DB totalInvestdb 一致");
   if (userId.equals(userIddb) && (username.equals(usernamedb))
     && (phone.equals(phonedb)) && (email.equals(emaildb))
     && (userLevel.equals(userLeveldb))
     && (realName.equals(realNamedb))) {
    return true;
   }
  } else {
   logger.log("Json ， DB  不一致");
   return false;
  }
  return false;
 }
  //多种情况的登录
 @Test
 public void loginUserSuccess() {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  boolean LoginUserResult = LoginUser.loginUser("15811297594", "111111");
  if (!LoginUserResult) {
   logger.log("LoginUserResult is Success !");
  }
  Assert.assertEquals(LoginUserResult, true, " LoginUserResult is Fail ！");
 }
 @Test
 public void loginUserSuccessALL() {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  boolean LoginUserResult = LoginUser.loginUserAll("15811297594",
    "111111");
  if (!LoginUserResult) {
   logger.log("LoginUserResult is Success !");
  }
  Assert.assertEquals(LoginUserResult, true, " LoginUserResult is Fail ！");

 }

 @Test
 public void loginUserFail_passwd() {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  boolean LoginUserResult = LoginUser.loginUser("15811297594", "111111");
  if (!LoginUserResult) {
   logger.log("LoginUserResult Fail_passwd is ok !");
  }
  Assert.assertEquals(LoginUserResult, true,
    " LoginUserFail_passwd is Fail ！");

 }
 @Test
 public void loginUserAgain() {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  boolean LoginUserResult = LoginUser.loginUser("15811297594", "111111");
  if (LoginUserResult) {
   logger.log("LoginUserResult is Success !");
  }
  Assert.assertEquals(LoginUserResult, true,
    " LoginUserSuccessAgain is Fail ！");

 }

 @Test
 public void loginUserFailPasswdIsNull() {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  boolean LoginUserResult = LoginUser.loginUser("15811297594", "");
  if (LoginUserResult) {
   logger.log("LoginUserFailPasswdIsNull is ok  !");
  }
  Assert.assertEquals(!LoginUserResult, true,
    " LoginUserFailPasswdIsNull is Fail ！");
 }
 @Test
 public void loginUserFailNamePasswdIsNull() {
  TCA001LoginUser LoginUser = new TCA001LoginUser();
  boolean LoginUserResult = LoginUser.loginUser("", "");
  if (LoginUserResult) {
   logger.log("LoginUserFailNamePasswdIsNull is ok  !");
  }
  Assert.assertEquals(!LoginUserResult, true,
    " LoginUserFailNamePasswdIsNull is Fail ！");

 }
 
}
 不多说啦。登录接口的测试
