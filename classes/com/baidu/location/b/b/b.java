package com.baidu.location.b.b;

public final class b
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    int i = paramArrayOfByte.length * 4 / 3;
    byte[] arrayOfByte = new byte[i + (i / 76 + 3)];
    int n = paramArrayOfByte.length - paramArrayOfByte.length % 3;
    int k = 0;
    int j = 0;
    i = 0;
    if (j < n)
    {
      int m = i + 1;
      arrayOfByte[i] = a[((paramArrayOfByte[j] & 0xFF) >> 2)];
      i = m + 1;
      arrayOfByte[m] = a[((paramArrayOfByte[j] & 0x3) << 4 | (paramArrayOfByte[(j + 1)] & 0xFF) >> 4)];
      m = i + 1;
      arrayOfByte[i] = a[((paramArrayOfByte[(j + 1)] & 0xF) << 2 | (paramArrayOfByte[(j + 2)] & 0xFF) >> 6)];
      i = m + 1;
      arrayOfByte[m] = a[(paramArrayOfByte[(j + 2)] & 0x3F)];
      if (((i - k) % 76 != 0) || (i == 0)) {
        break label396;
      }
      m = i + 1;
      arrayOfByte[i] = 10;
      k += 1;
      i = m;
    }
    label396:
    for (;;)
    {
      j += 3;
      break;
      switch (paramArrayOfByte.length % 3)
      {
      }
      for (;;)
      {
        return new String(arrayOfByte, 0, i, paramString);
        j = i + 1;
        arrayOfByte[i] = a[((paramArrayOfByte[n] & 0xFF) >> 2)];
        i = j + 1;
        arrayOfByte[j] = a[((paramArrayOfByte[n] & 0x3) << 4)];
        j = i + 1;
        arrayOfByte[i] = 61;
        i = j + 1;
        arrayOfByte[j] = 61;
        continue;
        j = i + 1;
        arrayOfByte[i] = a[((paramArrayOfByte[n] & 0xFF) >> 2)];
        i = j + 1;
        arrayOfByte[j] = a[((paramArrayOfByte[n] & 0x3) << 4 | (paramArrayOfByte[(n + 1)] & 0xFF) >> 4)];
        j = i + 1;
        arrayOfByte[i] = a[((paramArrayOfByte[(n + 1)] & 0xF) << 2)];
        i = j + 1;
        arrayOfByte[j] = 61;
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt / 4 * 3;
    if (i == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[i];
    int m = 0;
    int n = paramInt;
    i = paramArrayOfByte[(n - 1)];
    paramInt = m;
    if (i != 10)
    {
      paramInt = m;
      if (i != 13)
      {
        paramInt = m;
        if (i != 32) {
          if (i != 9) {
            break label79;
          }
        }
      }
    }
    for (paramInt = m;; paramInt = m + 1)
    {
      n -= 1;
      m = paramInt;
      break;
      label79:
      if (i != 61) {
        break label93;
      }
    }
    label93:
    int i1 = 0;
    int k = 0;
    int j = 0;
    paramInt = 0;
    if (i1 < n)
    {
      i = paramArrayOfByte[i1];
      if ((i == 10) || (i == 13) || (i == 32)) {
        break label409;
      }
      if (i == 9)
      {
        i = j;
        j = paramInt;
        paramInt = k;
      }
    }
    for (;;)
    {
      i1 += 1;
      k = paramInt;
      paramInt = j;
      j = i;
      break;
      if ((i >= 65) && (i <= 90))
      {
        i -= 65;
        label184:
        i = k << 6 | (byte)i;
        if (j % 4 != 3) {
          break label406;
        }
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)((0xFF0000 & i) >> 16));
        int i2 = k + 1;
        arrayOfByte[k] = ((byte)((0xFF00 & i) >> 8));
        paramInt = i2 + 1;
        arrayOfByte[i2] = ((byte)(i & 0xFF));
      }
      label403:
      label406:
      for (;;)
      {
        k = j + 1;
        j = paramInt;
        paramInt = i;
        i = k;
        break;
        if ((i >= 97) && (i <= 122))
        {
          i -= 71;
          break label184;
        }
        if ((i >= 48) && (i <= 57))
        {
          i += 4;
          break label184;
        }
        if (i == 43)
        {
          i = 62;
          break label184;
        }
        if (i == 47)
        {
          i = 63;
          break label184;
        }
        return null;
        i = paramInt;
        if (m > 0)
        {
          j = k << m * 6;
          i = paramInt + 1;
          arrayOfByte[paramInt] = ((byte)((0xFF0000 & j) >> 16));
          if (m != 1) {
            break label403;
          }
          paramInt = i + 1;
          arrayOfByte[i] = ((byte)((0xFF00 & j) >> 8));
          i = paramInt;
        }
        for (;;)
        {
          paramArrayOfByte = new byte[i];
          System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i);
          return paramArrayOfByte;
        }
      }
      label409:
      i = k;
      k = paramInt;
      paramInt = i;
      i = j;
      j = k;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */