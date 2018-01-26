package config.java.api;

import java.io.Serializable;
import java.util.Hashtable;

public class AppConfig implements Serializable {

    private static final long         serialVersionUID = 657830227960163705L;

    public volatile static AppConfig  Instance         = new AppConfig();

    private Hashtable<String, String> params           = new Hashtable<>();

    private AppConfig() {
    }

    public void setValue(String key, String value) {
        if (params.containsKey(key))
            params.remove(key);

        params.put(key, value);
    }

    public String getValue(String key) {
        if (params.containsKey(key))
            return params.get(key);

        return null;
    }

    @Override
    public String toString() {
        return "AppConfig values=" + params;
    }
}
