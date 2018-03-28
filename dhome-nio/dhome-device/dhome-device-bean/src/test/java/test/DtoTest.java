package test;

import org.junit.Test;

/**
 * 
 * @author daijun
 *
 */
/*

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration( locations = { "classpath:spring/applicationContext.xml",
        "classpath:spring/applicationContext-extend.xml" })*/

/**
 * 
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年4月27日 - 下午6:56:11
 * @history 
 * 		 2017年4月27日 - 下午6:56:11 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DtoTest {

    /**
     * autoTest
     */
    @Test
    public void autoTest() {
        try {
            String pkgName = "com.cmcc.dhome.app.device.bean.common";
            String pkgName1 = "com.cmcc.dhome.app.device.bean.device";
            String pkgName2 = "com.cmcc.dhome.app.device.bean.enums";
            String pkgName3 = "com.cmcc.dhome.app.device.bean.framework";
            String pkgName4 = "com.cmcc.dhome.app.device.bean.medal";
            String pkgName5 = "com.cmcc.dhome.app.device.bean.plan";
            String pkgName6 = "com.cmcc.dhome.app.device.bean.plugin";
            String pkgName7 = "com.cmcc.dhome.app.device.bean.plugins";
            String pkgName8 = "com.cmcc.dhome.app.device.bean.speed";
            String pkgName9 = "com.cmcc.dhome.app.device.bean.user";

            TestUtil.execPackage(pkgName);
            TestUtil.execPackage(pkgName1);
            TestUtil.execPackage(pkgName2);
            TestUtil.execPackage(pkgName3);
            TestUtil.execPackage(pkgName4);
            TestUtil.execPackage(pkgName5);
            TestUtil.execPackage(pkgName6);
            TestUtil.execPackage(pkgName7);
            TestUtil.execPackage(pkgName8);
            TestUtil.execPackage(pkgName9);
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    // @Test
    // public void test_userInfo_query(HttpServletRequest request){
    // UserInfoController userInfoController = new UserInfoController();
    // //Session session = SecurityUtils.getSubject().getSession(false);
    // HttpSession session = request.getSession();
    // session.setAttribute("orgId", "100078");
    // UserQueryDto userQueryDto = new UserQueryDto();
    // userQueryDto.setQueryKey("");
    // userInfoController.findTheLevelUsers(userQueryDto);
    // }

}
