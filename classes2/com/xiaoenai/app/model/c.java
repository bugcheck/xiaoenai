package com.xiaoenai.app.model;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

final class c
  extends m
{
  c(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    UserConfig.setLong("key_config_changed_last_req_time", ak.a());
    if (paramJSONObject.optJSONObject("data").optBoolean("changed")) {
      ConfigCenter.getConfig(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */