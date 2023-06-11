package online_examination;

import java.util.HashMap;

public class password {
    HashMap<String, String> logininfo=new HashMap<>();
    password(){
        logininfo.put("Naman", "123");
        logininfo.put("Thor", "hammer");
        logininfo.put("Tony", "mac42");

    }
    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
