package judge.remote.provider.saikr;//原先 package judge.remote.provider.csu;

import judge.remote.RemoteOj;
import judge.remote.RemoteOjInfo;

import org.apache.http.HttpHost;

public class SaikrInfo { //CSUInfo

    public static final RemoteOjInfo INFO = new RemoteOjInfo( //
            RemoteOj.Saikr, //RemoteOj.CSU
            "Saikr", //"CSU"
            new HttpHost("121.40.149.142") //new HttpHost("acm.csu.edu.cn")
//            new HttpHost("acm.csu.edu.cn")
    );
    
    static {
        INFO.faviconUrl = "images/remote_oj/Saikr_favicon.ico";//"images/remote_oj/CSU_favicon.ico"
        INFO._64IntIoFormat = "%lld & %llu";
    }
}
