package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.api.WeiboMessage;

public class SendMessageToWeiboRequest
  extends BaseRequest
{
  public WeiboMessage message;
  
  public SendMessageToWeiboRequest() {}
  
  public SendMessageToWeiboRequest(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  final boolean check(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, VersionCheckHandler paramVersionCheckHandler)
  {
    if ((this.message == null) || (paramWeiboInfo == null) || (!paramWeiboInfo.isLegal())) {}
    while ((paramVersionCheckHandler != null) && (!paramVersionCheckHandler.checkRequest(paramContext, paramWeiboInfo, this.message))) {
      return false;
    }
    return this.message.checkArgs();
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.message = new WeiboMessage(paramBundle);
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(this.message.toBundle(paramBundle));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\share\SendMessageToWeiboRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */