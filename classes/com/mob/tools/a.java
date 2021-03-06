package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.mob.tools.b.g;
import com.mob.tools.b.j;
import java.lang.reflect.Method;
import java.util.HashMap;

public class a
{
  private static Class<? extends Activity> shellClass;
  protected Activity activity;
  private View contentView;
  private HashMap<String, Object> result;
  private a resultReceiver;
  
  public static void registerExecutor(String paramString, Object paramObject)
  {
    if (shellClass != null) {
      try
      {
        Method localMethod = shellClass.getMethod("registerExecutor", new Class[] { String.class, Object.class });
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { paramString, paramObject });
        return;
      }
      catch (Throwable paramString)
      {
        e.a().w(paramString);
        return;
      }
    }
    MobUIShell.a(paramString, paramObject);
  }
  
  public static void setShell(Class<? extends Activity> paramClass)
  {
    shellClass = paramClass;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    if (this.activity == null) {
      return null;
    }
    return this.activity.findViewById(paramInt);
  }
  
  public <T extends View> T findViewByResName(View paramView, String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = g.d(this.activity, paramString);
    } while (i <= 0);
    return paramView.findViewById(i);
  }
  
  public <T extends View> T findViewByResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = g.d(this.activity, paramString);
    } while (i <= 0);
    return findViewById(i);
  }
  
  public final void finish()
  {
    if (this.activity != null) {
      this.activity.finish();
    }
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public Context getContext()
  {
    return this.activity;
  }
  
  public int getOrientation()
  {
    return this.activity.getResources().getConfiguration().orientation;
  }
  
  public a getParent()
  {
    return this.resultReceiver;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onDestroy() {}
  
  public boolean onFinish()
  {
    return false;
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onRestart() {}
  
  public void onResult(HashMap<String, Object> paramHashMap) {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void requestFullScreen(boolean paramBoolean)
  {
    if (this.activity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.activity.getWindow().addFlags(1024);
      this.activity.getWindow().clearFlags(2048);
    }
    for (;;)
    {
      this.activity.getWindow().getDecorView().requestLayout();
      return;
      this.activity.getWindow().addFlags(2048);
      this.activity.getWindow().clearFlags(1024);
    }
  }
  
  public void requestLandscapeOrientation()
  {
    setRequestedOrientation(0);
  }
  
  public void requestPortraitOrientation()
  {
    setRequestedOrientation(1);
  }
  
  public void runOnUIThread(Runnable paramRunnable)
  {
    j.a(0, new c(this, paramRunnable));
  }
  
  public void runOnUIThread(Runnable paramRunnable, long paramLong)
  {
    j.a(0, paramLong, new d(this, paramRunnable));
  }
  
  public void sendResult()
  {
    if (this.resultReceiver != null) {
      this.resultReceiver.onResult(this.result);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setContentViewLayoutResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return;
      i = g.c(this.activity, paramString);
    } while (i <= 0);
    this.activity.setContentView(i);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.setRequestedOrientation(paramInt);
  }
  
  public final void setResult(HashMap<String, Object> paramHashMap)
  {
    this.result = paramHashMap;
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    showForResult(paramContext, paramIntent, null);
  }
  
  public void showForResult(Context paramContext, Intent paramIntent, a parama)
  {
    this.resultReceiver = parama;
    Message localMessage = new Message();
    if (shellClass != null) {}
    for (parama = new Intent(paramContext, shellClass);; parama = MobUIShell.a(this))
    {
      try
      {
        localObject1 = shellClass.getMethod("registerExecutor", new Class[] { Object.class });
        ((Method)localObject1).setAccessible(true);
        str = (String)((Method)localObject1).invoke(null, new Object[] { this });
        localObject1 = parama;
        parama = str;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          e.a().w(localThrowable);
          String str = null;
          localObject2 = parama;
          parama = str;
        }
      }
      ((Intent)localObject1).putExtra("launch_time", parama);
      ((Intent)localObject1).putExtra("executor_name", getClass().getName());
      if (paramIntent != null) {
        ((Intent)localObject1).putExtras(paramIntent);
      }
      localMessage.obj = new Object[] { paramContext, localObject1 };
      j.a(localMessage, new b(this));
      return;
      Object localObject2 = new Intent(paramContext, MobUIShell.class);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, -1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */