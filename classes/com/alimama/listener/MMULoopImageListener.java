package com.alimama.listener;

import com.alimama.config.MMUAdInfo;
import java.util.List;

public abstract interface MMULoopImageListener
{
  public abstract void onClicked(String paramString);
  
  public abstract void onRequestAdFail(String paramString, int paramInt);
  
  public abstract void onRequestAdSuccess(String paramString, List<MMUAdInfo> paramList);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\listener\MMULoopImageListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */