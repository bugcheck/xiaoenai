package cn.sharesdk.framework;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import com.mob.tools.b.g;
import dalvik.system.DexFile;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class l
{
  private static boolean a = true;
  private Context b;
  private String c;
  
  public l(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
  }
  
  private ArrayList<Platform> a(PackageInfo paramPackageInfo)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = new DexFile(paramPackageInfo.applicationInfo.sourceDir);
      paramPackageInfo = ((DexFile)localObject).entries();
      try
      {
        ((DexFile)localObject).close();
        while ((paramPackageInfo != null) && (paramPackageInfo.hasMoreElements()))
        {
          localObject = (String)paramPackageInfo.nextElement();
          if ((((String)localObject).startsWith("cn.sharesdk")) && (!((String)localObject).contains("$"))) {
            try
            {
              localObject = Class.forName((String)localObject);
              if ((localObject != null) && (Platform.class.isAssignableFrom((Class)localObject)) && (!CustomPlatform.class.isAssignableFrom((Class)localObject)))
              {
                localObject = ((Class)localObject).getConstructor(new Class[] { Context.class });
                ((Constructor)localObject).setAccessible(true);
                localArrayList.add((Platform)((Constructor)localObject).newInstance(new Object[] { this.b }));
              }
            }
            catch (Throwable localThrowable1)
            {
              cn.sharesdk.framework.utils.d.a().w(localThrowable1);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.d.a().w(localThrowable2);
        }
      }
      return localArrayList;
    }
    catch (Throwable paramPackageInfo)
    {
      cn.sharesdk.framework.utils.d.a().w(paramPackageInfo);
      return null;
    }
  }
  
  private PackageInfo e()
  {
    try
    {
      Object localObject = this.b.getPackageManager();
      String str = this.b.getPackageName();
      localObject = ((PackageManager)localObject).getInstalledPackages(8192).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        boolean bool = str.equals(localPackageInfo.packageName);
        if (bool) {
          return localPackageInfo;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      return null;
    }
    return null;
  }
  
  private ArrayList<Platform> f()
  {
    String[] arrayOfString = new String[37];
    arrayOfString[0] = "cn.sharesdk.douban.Douban";
    arrayOfString[1] = "cn.sharesdk.evernote.Evernote";
    arrayOfString[2] = "cn.sharesdk.facebook.Facebook";
    arrayOfString[3] = "cn.sharesdk.renren.Renren";
    arrayOfString[4] = "cn.sharesdk.sina.weibo.SinaWeibo";
    arrayOfString[5] = "cn.sharesdk.kaixin.KaiXin";
    arrayOfString[6] = "cn.sharesdk.linkedin.LinkedIn";
    arrayOfString[7] = "cn.sharesdk.system.email.Email";
    arrayOfString[8] = "cn.sharesdk.system.text.ShortMessage";
    arrayOfString[9] = "cn.sharesdk.tencent.qq.QQ";
    arrayOfString[10] = "cn.sharesdk.tencent.qzone.QZone";
    arrayOfString[11] = "cn.sharesdk.tencent.weibo.TencentWeibo";
    arrayOfString[12] = "cn.sharesdk.twitter.Twitter";
    arrayOfString[13] = "cn.sharesdk.wechat.friends.Wechat";
    arrayOfString[14] = "cn.sharesdk.wechat.moments.WechatMoments";
    arrayOfString[15] = "cn.sharesdk.wechat.favorite.WechatFavorite";
    arrayOfString[16] = "cn.sharesdk.youdao.YouDao";
    arrayOfString[17] = "cn.sharesdk.google.GooglePlus";
    arrayOfString[18] = "cn.sharesdk.foursquare.FourSquare";
    arrayOfString[19] = "cn.sharesdk.pinterest.Pinterest";
    arrayOfString[20] = "cn.sharesdk.flickr.Flickr";
    arrayOfString[21] = "cn.sharesdk.tumblr.Tumblr";
    arrayOfString[22] = "cn.sharesdk.dropbox.Dropbox";
    arrayOfString[23] = "cn.sharesdk.vkontakte.VKontakte";
    arrayOfString[24] = "cn.sharesdk.instagram.Instagram";
    arrayOfString[25] = "cn.sharesdk.yixin.friends.Yixin";
    arrayOfString[26] = "cn.sharesdk.yixin.moments.YixinMoments";
    arrayOfString[27] = "cn.sharesdk.mingdao.Mingdao";
    arrayOfString[28] = "cn.sharesdk.line.Line";
    arrayOfString[29] = "cn.sharesdk.kakao.story.KakaoStory";
    arrayOfString[30] = "cn.sharesdk.kakao.talk.KakaoTalk";
    arrayOfString[31] = "cn.sharesdk.system.bluetooth.Bluetooth";
    arrayOfString[32] = "cn.sharesdk.whatsapp.WhatsApp";
    arrayOfString[33] = "cn.sharesdk.pocket.Pocket";
    arrayOfString[34] = "cn.sharesdk.instapaper.Instapaper";
    arrayOfString[35] = "cn.sharesdk.facebookmessenger.FacebookMessenger";
    arrayOfString[36] = "cn.sharesdk.alipay.share.Alipay";
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = arrayOfString[i];
        try
        {
          localObject = Class.forName((String)localObject).getConstructor(new Class[] { Context.class });
          ((Constructor)localObject).setAccessible(true);
          localArrayList.add((Platform)((Constructor)localObject).newInstance(new Object[] { this.b }));
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cn.sharesdk.framework.utils.d.a().d(localThrowable);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String a(int paramInt, String paramString, HashMap<Integer, HashMap<String, Object>> paramHashMap)
  {
    paramHashMap = (HashMap)paramHashMap.get(Integer.valueOf(paramInt));
    if (paramHashMap == null) {
      return null;
    }
    paramString = paramHashMap.get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = String.valueOf(paramString)) {
      return paramString;
    }
  }
  
  public String a(Bitmap paramBitmap)
  {
    return cn.sharesdk.framework.statistics.a.a(this.b, this.c).a(paramBitmap);
  }
  
  public String a(String paramString)
  {
    return cn.sharesdk.framework.statistics.a.a(this.b, this.c).a(paramString);
  }
  
  public String a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    return cn.sharesdk.framework.statistics.a.a(this.b, this.c).a(paramString1, paramInt, paramBoolean, paramString2);
  }
  
  public ArrayList<Platform> a()
  {
    if (a) {}
    for (Object localObject = f();; localObject = a((PackageInfo)localObject))
    {
      a((ArrayList)localObject);
      return (ArrayList<Platform>)localObject;
      localObject = e();
      if (localObject == null) {
        return null;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, HashMap<Integer, HashMap<String, Object>> paramHashMap)
  {
    paramHashMap.put(Integer.valueOf(paramInt2), (HashMap)paramHashMap.get(Integer.valueOf(paramInt1)));
  }
  
  public void a(int paramInt, Platform paramPlatform)
  {
    cn.sharesdk.framework.statistics.b.d locald = new cn.sharesdk.framework.statistics.b.d();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramPlatform != null) {
        locald.b = paramPlatform.getPlatformId();
      }
      paramPlatform = cn.sharesdk.framework.statistics.d.a(this.b, this.c);
      if (paramPlatform != null) {
        paramPlatform.a(locald);
      }
      return;
      locald.a = "SHARESDK_ENTER_SHAREMENU";
      continue;
      locald.a = "SHARESDK_CANCEL_SHAREMENU";
      continue;
      locald.a = "SHARESDK_EDIT_SHARE";
      continue;
      locald.a = "SHARESDK_FAILED_SHARE";
      continue;
      locald.a = "SHARESDK_CANCEL_SHARE";
    }
  }
  
  public void a(Handler paramHandler, boolean paramBoolean, int paramInt)
  {
    cn.sharesdk.framework.statistics.d locald = cn.sharesdk.framework.statistics.d.a(this.b, this.c);
    if (locald != null)
    {
      locald.a(paramHandler);
      locald.a(paramBoolean);
      locald.a(paramInt);
      locald.startThread();
    }
  }
  
  public void a(n paramn) {}
  
  public void a(String paramString, int paramInt)
  {
    cn.sharesdk.framework.statistics.d locald = cn.sharesdk.framework.statistics.d.a(this.b, this.c);
    if (locald == null) {
      return;
    }
    cn.sharesdk.framework.statistics.b.a locala = new cn.sharesdk.framework.statistics.b.a();
    locala.b = paramString;
    locala.a = paramInt;
    locald.a(locala);
  }
  
  public void a(ArrayList<Platform> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Collections.sort(paramArrayList, new m(this));
  }
  
  public boolean a(HashMap<String, Object> paramHashMap, HashMap<Integer, HashMap<String, Object>> paramHashMap1)
  {
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      return false;
    }
    paramHashMap = (ArrayList)paramHashMap.get("fakelist");
    if (paramHashMap == null) {
      return false;
    }
    paramHashMap = paramHashMap.iterator();
    for (;;)
    {
      if (paramHashMap.hasNext())
      {
        HashMap localHashMap = (HashMap)paramHashMap.next();
        if (localHashMap == null) {
          continue;
        }
        String str = String.valueOf(localHashMap.get("snsplat"));
        try
        {
          i = g.d(str);
          if (i != -1) {
            paramHashMap1.put(Integer.valueOf(i), localHashMap);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cn.sharesdk.framework.utils.d.a().w(localThrowable);
            int i = -1;
          }
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    cn.sharesdk.framework.statistics.d locald = cn.sharesdk.framework.statistics.d.a(this.b, this.c);
    if (locald != null) {
      locald.stopThread();
    }
  }
  
  public String c()
  {
    return "2.7.0";
  }
  
  public int d()
  {
    return 58;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */