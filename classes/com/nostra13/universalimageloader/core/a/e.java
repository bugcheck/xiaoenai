package com.nostra13.universalimageloader.core.a;

public class e
{
  private final int a;
  private final int b;
  
  public e(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % 180 == 0)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      return;
    }
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public e a(float paramFloat)
  {
    return new e((int)(this.a * paramFloat), (int)(this.b * paramFloat));
  }
  
  public e a(int paramInt)
  {
    return new e(this.a / paramInt, this.b / paramInt);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return 9 + this.a + "x" + this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */