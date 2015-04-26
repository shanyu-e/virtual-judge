package judge.remote.provider.saikr;//package judge.remote.provider.csu;

import judge.httpclient.DedicatedHttpClient;
import judge.httpclient.HttpBodyValidator;
import judge.httpclient.SimpleNameValueEntityFactory;
import judge.remote.RemoteOjInfo;
import judge.remote.account.RemoteAccount;
import judge.remote.loginer.RetentiveLoginer;

import org.apache.http.HttpEntity;
import org.springframework.stereotype.Component;

@Component
public class SaikrLoginer extends RetentiveLoginer { //CSULoginer

    @Override
    public RemoteOjInfo getOjInfo() {
        return SaikrInfo.INFO;//CSUInfo.INFO
    }

    @Override
    protected void loginEnforce(RemoteAccount account, DedicatedHttpClient client) {
        if (client.get("/include/profile.php").getBody().contains("Logout")) { //"OnlineJudge/include/profile.php"
            return;
        }

        HttpEntity entity = SimpleNameValueEntityFactory.create( //
                "user_id", account.getAccountId(), //
                "password", account.getPassword());
        client.post("/login.php", entity, new HttpBodyValidator("history.go(-2)"));//"/OnlineJudge/login.php"
    }

}
