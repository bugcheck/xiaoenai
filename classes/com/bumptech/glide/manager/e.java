package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class e
  implements c
{
  private final Context a;
  private final c.a b;
  private boolean c;
  private boolean d;
  private final BroadcastReceiver e = new f(this);
  
  public e(Context paramContext, c.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = parama;
  }
  
  private void a()
  {
    if (this.d) {
      return;
    }
    this.c = a(this.a);
    this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.d = true;
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private void b()
  {
    if (!this.d) {
      return;
    }
    this.a.unregisterReceiver(this.e);
    this.d = false;
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    b();
  }
  
  public void f() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\manager\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */