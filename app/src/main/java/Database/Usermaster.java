package Database;

import android.provider.BaseColumns;

public final class Usermaster {
    public Usermaster() {
    }

    public static class Users implements BaseColumns{
        public static final String Table = "users";
        public static final String Col1 = "username";
    }
}
