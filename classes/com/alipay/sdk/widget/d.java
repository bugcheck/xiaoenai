package com.alipay.sdk.widget;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class d
{
  private static boolean a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private static AlertDialog.Builder a(Context paramContext, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    if (a)
    {
      if ((!TextUtils.isEmpty(paramString2)) && (paramOnClickListener2 != null)) {
        paramContext.setPositiveButton(paramString2, paramOnClickListener2);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (paramOnClickListener1 != null)) {
        paramContext.setNegativeButton(paramString1, paramOnClickListener1);
      }
    }
    do
    {
      return paramContext;
      if ((!TextUtils.isEmpty(paramString1)) && (paramOnClickListener1 != null)) {
        paramContext.setPositiveButton(paramString1, paramOnClickListener1);
      }
    } while ((TextUtils.isEmpty(paramString2)) || (paramOnClickListener2 == null));
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    if (a)
    {
      if ((!TextUtils.isEmpty(paramString4)) && (paramOnClickListener2 != null)) {
        paramContext.setPositiveButton(paramString4, paramOnClickListener2);
      }
      if ((!TextUtils.isEmpty(paramString3)) && (paramOnClickListener1 != null)) {
        paramContext.setNegativeButton(paramString3, paramOnClickListener1);
      }
    }
    for (;;)
    {
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext = paramContext.create();
      paramContext.setCanceledOnTouchOutside(false);
      paramContext.setOnKeyListener(new e());
      try
      {
        paramContext.show();
        return paramContext;
      }
      catch (Throwable paramString1) {}
      if ((!TextUtils.isEmpty(paramString3)) && (paramOnClickListener1 != null)) {
        paramContext.setPositiveButton(paramString3, paramOnClickListener1);
      }
      if ((!TextUtils.isEmpty(paramString4)) && (paramOnClickListener2 != null)) {
        paramContext.setNegativeButton(paramString4, paramOnClickListener2);
      }
    }
    return paramContext;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */