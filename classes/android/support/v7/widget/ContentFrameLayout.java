package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout
  extends FrameLayout
{
  private OnAttachListener mAttachListener;
  private final Rect mDecorPadding = new Rect();
  private TypedValue mFixedHeightMajor;
  private TypedValue mFixedHeightMinor;
  private TypedValue mFixedWidthMajor;
  private TypedValue mFixedWidthMinor;
  private TypedValue mMinWidthMajor;
  private TypedValue mMinWidthMinor;
  
  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void dispatchFitSystemWindows(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (this.mFixedHeightMajor == null) {
      this.mFixedHeightMajor = new TypedValue();
    }
    return this.mFixedHeightMajor;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.mFixedHeightMinor == null) {
      this.mFixedHeightMinor = new TypedValue();
    }
    return this.mFixedHeightMinor;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.mFixedWidthMajor == null) {
      this.mFixedWidthMajor = new TypedValue();
    }
    return this.mFixedWidthMajor;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.mFixedWidthMinor == null) {
      this.mFixedWidthMinor = new TypedValue();
    }
    return this.mFixedWidthMinor;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.mMinWidthMajor == null) {
      this.mMinWidthMajor = new TypedValue();
    }
    return this.mMinWidthMajor;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.mMinWidthMinor == null) {
      this.mMinWidthMinor = new TypedValue();
    }
    return this.mMinWidthMinor;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mAttachListener != null) {
      this.mAttachListener.onAttachedFromWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mAttachListener != null) {
      this.mAttachListener.onDetachedFromWindow();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = 0;
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int j;
    int i1;
    int i2;
    TypedValue localTypedValue;
    label60:
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      j = 1;
      i1 = View.MeasureSpec.getMode(paramInt1);
      i2 = View.MeasureSpec.getMode(paramInt2);
      if (i1 != Integer.MIN_VALUE) {
        break label482;
      }
      if (j == 0) {
        break label348;
      }
      localTypedValue = this.mFixedWidthMinor;
      if ((localTypedValue == null) || (localTypedValue.type == 0)) {
        break label482;
      }
      if (localTypedValue.type != 5) {
        break label356;
      }
      i = (int)localTypedValue.getDimension(localDisplayMetrics);
    }
    for (;;)
    {
      label88:
      int m;
      int k;
      if (i > 0)
      {
        m = View.MeasureSpec.makeMeasureSpec(Math.min(i - (this.mDecorPadding.left + this.mDecorPadding.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
        k = 1;
      }
      for (;;)
      {
        i = paramInt2;
        if (i2 == Integer.MIN_VALUE)
        {
          if (j == 0) {
            break label387;
          }
          localTypedValue = this.mFixedHeightMajor;
          label148:
          i = paramInt2;
          if (localTypedValue != null)
          {
            i = paramInt2;
            if (localTypedValue.type != 0)
            {
              if (localTypedValue.type != 5) {
                break label395;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
        }
        for (;;)
        {
          label181:
          i = paramInt2;
          if (paramInt1 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
          super.onMeasure(m, i);
          i2 = getMeasuredWidth();
          m = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
          if ((k == 0) && (i1 == Integer.MIN_VALUE)) {
            if (j != 0)
            {
              localTypedValue = this.mMinWidthMinor;
              label264:
              if ((localTypedValue == null) || (localTypedValue.type == 0)) {
                break label463;
              }
              if (localTypedValue.type != 5) {
                break label433;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
          for (;;)
          {
            label291:
            paramInt2 = paramInt1;
            if (paramInt1 > 0) {
              paramInt2 = paramInt1 - (this.mDecorPadding.left + this.mDecorPadding.right);
            }
            if (i2 < paramInt2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            for (paramInt2 = 1;; paramInt2 = n)
            {
              if (paramInt2 != 0) {
                super.onMeasure(paramInt1, i);
              }
              return;
              j = 0;
              break;
              label348:
              localTypedValue = this.mFixedWidthMajor;
              break label60;
              label356:
              if (localTypedValue.type != 6) {
                break label491;
              }
              i = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label88;
              label387:
              localTypedValue = this.mFixedHeightMinor;
              break label148;
              label395:
              if (localTypedValue.type != 6) {
                break label477;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              break label181;
              localTypedValue = this.mMinWidthMajor;
              break label264;
              label433:
              if (localTypedValue.type != 6) {
                break label472;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label291;
              label463:
              paramInt1 = m;
            }
            label472:
            paramInt1 = 0;
          }
          label477:
          paramInt1 = 0;
        }
        label482:
        k = 0;
        m = paramInt1;
      }
      label491:
      i = 0;
    }
  }
  
  public void setAttachListener(OnAttachListener paramOnAttachListener)
  {
    this.mAttachListener = paramOnAttachListener;
  }
  
  public void setDecorPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDecorPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ViewCompat.isLaidOut(this)) {
      requestLayout();
    }
  }
  
  public static abstract interface OnAttachListener
  {
    public abstract void onAttachedFromWindow();
    
    public abstract void onDetachedFromWindow();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ContentFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */