package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;

class i
  implements Runnable
{
  i(f paramf, a parama) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("feeds", "_id=?", new String[] { String.valueOf(this.a.a()) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */