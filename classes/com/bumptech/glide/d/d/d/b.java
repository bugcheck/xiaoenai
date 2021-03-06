package com.bumptech.glide.d.d.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.d.g;

public class b
  extends com.bumptech.glide.d.d.b.b
  implements f.b
{
  private final Paint a;
  private final Rect b = new Rect();
  private final a c;
  private final a d;
  private final f e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private int j;
  private int k = -1;
  private boolean l;
  
  public b(Context paramContext, a.a parama, com.bumptech.glide.d.b.a.c paramc, g<Bitmap> paramg, int paramInt1, int paramInt2, com.bumptech.glide.b.c paramc1, byte[] paramArrayOfByte, Bitmap paramBitmap)
  {
    this(new a(paramc1, paramArrayOfByte, paramContext, paramg, paramInt1, paramInt2, parama, paramc, paramBitmap));
  }
  
  b(a parama)
  {
    if (parama == null) {
      throw new NullPointerException("GifState must not be null");
    }
    this.c = parama;
    this.d = new a(parama.g);
    this.a = new Paint();
    this.d.a(parama.a, parama.b);
    this.e = new f(parama.c, this, this.d, parama.e, parama.f);
  }
  
  private void g()
  {
    this.j = 0;
  }
  
  private void h()
  {
    this.e.c();
    invalidateSelf();
  }
  
  private void i()
  {
    if (this.d.c() == 1) {
      invalidateSelf();
    }
    while (this.f) {
      return;
    }
    this.f = true;
    this.e.a();
    invalidateSelf();
  }
  
  private void j()
  {
    this.f = false;
    this.e.b();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt <= 0) && (paramInt != -1) && (paramInt != 0)) {
      throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
    }
    if (paramInt == 0)
    {
      this.k = this.d.e();
      return;
    }
    this.k = paramInt;
  }
  
  public void a(g<Bitmap> paramg, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new NullPointerException("The first frame of the GIF must not be null");
    }
    if (paramg == null) {
      throw new NullPointerException("The frame transformation must not be null");
    }
    this.c.d = paramg;
    this.c.i = paramBitmap;
    this.e.a(paramg);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public Bitmap b()
  {
    return this.c.i;
  }
  
  @TargetApi(11)
  public void b(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (getCallback() == null))
    {
      stop();
      h();
    }
    do
    {
      return;
      invalidateSelf();
      if (paramInt == this.d.c() - 1) {
        this.j += 1;
      }
    } while ((this.k == -1) || (this.j < this.k));
    stop();
  }
  
  public g<Bitmap> c()
  {
    return this.c.d;
  }
  
  public byte[] d()
  {
    return this.c.b;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.h) {
      return;
    }
    if (this.l)
    {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.b);
      this.l = false;
    }
    Bitmap localBitmap = this.e.d();
    if (localBitmap != null) {}
    for (;;)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.b, this.a);
      return;
      localBitmap = this.c.i;
    }
  }
  
  public int e()
  {
    return this.d.c();
  }
  
  public void f()
  {
    this.h = true;
    this.c.h.a(this.c.i);
    this.e.c();
    this.e.b();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.c;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c.i.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.c.i.getWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.f;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.l = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.i = paramBoolean1;
    if (!paramBoolean1) {
      j();
    }
    for (;;)
    {
      return super.setVisible(paramBoolean1, paramBoolean2);
      if (this.g) {
        i();
      }
    }
  }
  
  public void start()
  {
    this.g = true;
    g();
    if (this.i) {
      i();
    }
  }
  
  public void stop()
  {
    this.g = false;
    j();
    if (Build.VERSION.SDK_INT < 11) {
      h();
    }
  }
  
  static class a
    extends Drawable.ConstantState
  {
    com.bumptech.glide.b.c a;
    byte[] b;
    Context c;
    g<Bitmap> d;
    int e;
    int f;
    a.a g;
    com.bumptech.glide.d.b.a.c h;
    Bitmap i;
    
    public a(com.bumptech.glide.b.c paramc, byte[] paramArrayOfByte, Context paramContext, g<Bitmap> paramg, int paramInt1, int paramInt2, a.a parama, com.bumptech.glide.d.b.a.c paramc1, Bitmap paramBitmap)
    {
      if (paramBitmap == null) {
        throw new NullPointerException("The first frame of the GIF must not be null");
      }
      this.a = paramc;
      this.b = paramArrayOfByte;
      this.h = paramc1;
      this.i = paramBitmap;
      this.c = paramContext.getApplicationContext();
      this.d = paramg;
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = parama;
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return new b(this);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return newDrawable();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */