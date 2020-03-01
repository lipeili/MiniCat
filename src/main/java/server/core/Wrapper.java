package server.core;

import server.Servlet;

/**
 * @Description TODO
 * @Date 2020-03-01 14:17
 * @Created by videopls
 */
public class Wrapper {

    private Servlet servlet;

    private String mapping;

    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }
}
