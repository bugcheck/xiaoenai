package android.support.v7.widget;

import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class bo
  implements View.OnKeyListener
{
  bo(SearchView paramSearchView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (SearchView.access$1400(this.a) == null) {}
    do
    {
      return false;
      if ((SearchView.access$1200(this.a).isPopupShowing()) && (SearchView.access$1200(this.a).getListSelection() != -1)) {
        return SearchView.access$1500(this.a, paramView, paramInt, paramKeyEvent);
      }
    } while ((SearchView.SearchAutoComplete.access$1600(SearchView.access$1200(this.a))) || (!KeyEventCompat.hasNoModifiers(paramKeyEvent)) || (paramKeyEvent.getAction() != 1) || (paramInt != 66));
    paramView.cancelLongPress();
    SearchView.access$1700(this.a, 0, null, SearchView.access$1200(this.a).getText().toString());
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */