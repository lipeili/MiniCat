package server.core;

import server.HttpServlet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Date 2020-03-01 14:00
 * @Created by videopls
 */
public class Context {

    private String path;

    private Host host;

//    private Wrapper[] wrappers;
    Map<String, Wrapper> wrappers;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Map<String, Wrapper> getWrappers() {
        if (null == wrappers) {
            wrappers = new ConcurrentHashMap<>();
        }
        return wrappers;
    }

    public void setWrappers(Map<String, Wrapper> wrappers) {
        this.wrappers = wrappers;
    }
}
