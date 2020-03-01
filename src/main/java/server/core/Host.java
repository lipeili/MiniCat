package server.core;

/**
 * @Description TODO
 * @Date 2020-03-01 12:32
 * @Created by videopls
 */
public class Host {

    private String name = "localhost";

    private String appBase;

    private Context[] contexts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppBase() {
        return appBase;
    }

    public void setAppBase(String appBase) {
        this.appBase = appBase;
    }

    public Context[] getContexts() {
        return contexts;
    }

    public void setContexts(Context[] contexts) {
        this.contexts = contexts;
    }
}
