package com.adhoc;

import java.util.Comparator;

final class dz
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return 0;
    }
    if (paramString1 == null) {
      return -1;
    }
    if (paramString2 == null) {
      return 1;
    }
    return String.CASE_INSENSITIVE_ORDER.compare(paramString1, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */