package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.f.a;

class y
  implements View.OnClickListener
{
  y(StreetPayBottomView paramStreetPayBottomView) {}
  
  public void onClick(View paramView)
  {
    a.c("mClickListener = {}", new Object[] { StreetPayBottomView.b(this.a) });
    if (StreetPayBottomView.b(this.a) != null) {
      StreetPayBottomView.b(this.a).b(StreetPayBottomView.c(this.a));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */