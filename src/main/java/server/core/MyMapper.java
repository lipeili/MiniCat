package server.core;

/**
 * @Description TODO
 * @Date 2020-03-01 14:54
 * @Created by videopls
 */
public class MyMapper {

    private Host[] mapperHosts;

    public Host[] getMapperHosts() {
        return mapperHosts;
    }

    public void setMapperHosts(Host[] mapperHosts) {
        this.mapperHosts = mapperHosts;
    }

    public Host getMappedHost (String mappedName) {
        for (Host host : mapperHosts) {
            if (host.getName().equalsIgnoreCase(mappedName)) {
                return host;
            }
        }
        return null;
    }

    public Context getMappedContext (Host host,String contextUrl) {

        for (Context context : host.getContexts()) {
            if (context.getPath().equals(contextUrl)) {
                return context;
            }
        }
        return null;
    }

    public Wrapper getMappedWrapper (Context context,String mappingUrl) {

        return context.getWrappers().get(mappingUrl);
    }
}
