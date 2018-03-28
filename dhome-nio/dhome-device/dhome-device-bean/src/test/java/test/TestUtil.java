package test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试dto对象
 * 
 * @author lilu@chinamobile.com
 * @date 2017年3月21日 - 上午8:54:45
 * @history
 *          2017年3月21日 - 上午8:54:45 lilu@chinamobile.com create.
 */
public class TestUtil {

    /**
     *
     * @param pkgName
     */
    public static void execPackage(String pkgName) {
        // 获取包File对象，如果不存在则返回空
        File pkgFile = getPackageFile(pkgName);
        // 迭代执行包下所有.Class文件
        iteratorClass(pkgFile);
    }

    /**
     *
     * @param pkgName
     * @return
     */
    private static File getPackageFile(String pkgName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        pkgName = pkgName.replace(".", "/");
        URL url = loader.getResource(pkgName);
        if (url != null) {
            if ("file".equals(url.getProtocol())) {
                File file = new File(url.getPath());
                return file;
            }
        }
        return null;
    }

    /**
     *
     * @param file
     */
    private static void iteratorClass(File file) {
        if (!file.isDirectory()) {
            String path = file.getPath();
            if (path.lastIndexOf(".class") > 0) {
                String fullClassName = path.substring(path.lastIndexOf(File.separator + "com") + 1, path.lastIndexOf(".")).replace(File.separator, ".");
                try {
                    execMehtods(Class.forName(fullClassName).newInstance());
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                }
            }
            return;
        }
        File[] files = file.listFiles();
        for (File f : files) {
            iteratorClass(f);
        }
    }

    /**
     *
     * @param obj
     */
    private static void execMehtods(Object obj) {
        Method[] ms = obj.getClass().getDeclaredMethods();
        Object[] objs;
        for (Method m : ms) {
            Class<?>[] pras = m.getParameterTypes();
            objs = new Object[pras.length];
            for (int i = 0; i < objs.length; i++) {
                if (pras[i].equals(String.class)) {
                    objs[i] = "1";
                    continue;
                }
                if (int.class.equals(pras[i])) {
                    objs[i] = 1;
                    continue;
                }
                if (boolean.class.equals(pras[i])) {
                    objs[i] = true;
                    continue;
                }
                if (pras[i].equals(Long.class)) {
                    objs[i] = Long.valueOf(1);
                    continue;
                }
                if (pras[i].equals(Integer.class)) {
                    objs[i] = Integer.valueOf(1);
                    continue;
                }
                if (pras[i].equals(Double.class)) {
                    objs[i] = Double.valueOf(1.0);
                    continue;
                }
                if (pras[i].equals(Date.class)) {
                    objs[i] = new Date(1);
                    continue;
                }
                if (pras[i].equals(Map.class)) {
                    // objs[i] = new HashMap<>();
                    continue;
                }
                if (pras[i].equals(List.class)) {
                    // objs[i] = new ArrayList<>();
                    continue;
                }
                if (double.class.equals(pras[i])) {
                    objs[i] = 1.0;
                    continue;
                }
                if (long.class.equals(pras[i])) {
                    objs[i] = 1L;
                    continue;
                }
                try {
                    objs[i] = pras[i].newInstance();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                }
            }
            try {
                m.invoke(obj, objs);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                continue;
            }
        }
    }

    // /**
    // * testConstructer
    // */
    // public static void testConstructer() {
    // CmdAsynBackResp cabr = new CmdAsynBackResp();
    // GwDp gwdp = new GwDp();
    // GwBody gwBody = new GwBody();
    // gwBody.setPlugin(new ArrayList<PluginInstallProgress>());
    // gwdp.setBody(gwBody);
    // cabr.setGwdp(gwdp);
    // ClientCmdReqParam ccrp = new ClientCmdReqParam();
    // ccrp.setReqType(1);
    // PluginDetailDto pdo = new PluginDetailDto();
    // pdo.setPluginSizeGw("123");
    // pdo.setPluginTypeGw("1");
    // pdo.setPluginUrlGw("http://www.baidu.com");
    //
    // AsynRespToClient astc = new AsynRespToClient(new SyncCmdToClient(cabr,
    // new SyncCmdToClientParam(new CmdAsynBackResp(), new SyncCmdToEqpt(ccrp,
    // "www.baidu.com", new SyncCmdToEqptParam(ccrp, pdo)))));
    // }

    // /**
    // * testCmdToEqptReqParam
    // */
    // public static void testCmdToEqptReqParam() {
    // ClientCmdReqParam ccrp = new ClientCmdReqParam();
    // ccrp.setDid("1230");
    // ccrp.setSeqId("123123");
    // ccrp.setReqType(1);
    // CmdToEqptReqParam cerp = new CmdToEqptReqParam(ccrp, new
    // PluginDetailDto(),
    // "http://www.baidu.com");
    // PluginDetailDto pdo = new PluginDetailDto();
    // pdo.setPluginSizeGw("123");
    // pdo.setPluginTypeGw("1");
    // pdo.setPluginUrlGw("http://www.baidu.com");
    // SyncCmdToEqptParam sctep = new SyncCmdToEqptParam(ccrp, pdo);
    // sctep.setEnable("0");
    // SyncCmdToEqpt scte = new SyncCmdToEqpt();
    // scte.setParameter(sctep);
    // scte.setCmdType(CmdTypeStatus.PLUGIN_INSTALL.value());
    // cerp = new CmdToEqptReqParam(scte);
    // }

    // /**
    // * testDisriToEqptMsg
    // */
    // public static void testDisriToEqptMsg() {
    // PluginDistribution distri = new PluginDistribution();
    // distri.setDistributedType(1);
    // PluginDetailDto pdo = new PluginDetailDto();
    // pdo.setPluginSizeGw("123");
    // pdo.setPluginTypeGw("1");
    // pdo.setPluginUrlGw("http://www.baidu.com");
    // pdo.setDeviceType("1");
    // pdo.setVersion("1.1.1");
    // DisriToEqptMsg dtem = new DisriToEqptMsg(distri, pdo);
    // com.cmcc.dto.ws.eqpt.GwHeader gwHeader = new
    // com.cmcc.dto.ws.eqpt.GwHeader();
    // gwHeader.setCmdType("123");
    // gwHeader.setID(123);
    // gwHeader.setRPCMethod("123");
    // gwHeader.setSequenceId("123");
    // gwHeader.getCmdType();
    // gwHeader.getID();
    // gwHeader.getRPCMethod();
    // gwHeader.getSequenceId();
    //
    // }

    // /**
    // * testCheck
    // */
    // public static void testCheck() {
    // PluginParamUtil paramUtil = new PluginParamUtil();
    // PluginUpdateDto updateDto = new PluginUpdateDto();
    // paramUtil.checkUpshelves(4, updateDto);
    // paramUtil.checkDownshelves(8, updateDto);
    // paramUtil.checkPlDelReview(8, updateDto);
    // paramUtil.checkrdy2ReviewPl(2, updateDto);
    // InfoVerStatus ivStatus = new InfoVerStatus();
    // ivStatus.setPluginStatus(8);
    // ivStatus.setVersionStatus(2);
    // paramUtil.checkrdy2ReviewVer(ivStatus, updateDto);
    // paramUtil.judgePluginStatus(8);
    // }

}
