package server;

import java.io.*;

/**
 * 上级委托机制的类加载
 * @Description TODO
 * @Date 2020-02-27 15:50
 * @Created by videopls
 */
public class WebAppsClassLoader extends ClassLoader {

    private String path;

    public WebAppsClassLoader(String path){
        super();
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class log = null;
        // 获取该class文件字节码数组
        byte[] classData = getData();

        if (classData != null) {
            // 将class的字节码数组转换成Class类的实例
            log = defineClass(name, classData, 0, classData.length);
        }
        return log;
    }

    private byte[] getData() {

        File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String path = WebAppsClassLoader.class.getResource("/webapps/demo1/LagouServlet.class").getPath();

        WebAppsClassLoader loader = new WebAppsClassLoader(path);
        Object servlet = loader.loadClass("demo1.LagouServlet");
//        WebAppsClassLoader loader = new WebAppsClassLoader("/Users/videopls/self/Java_L2_2019.12.23/02_讲义/第二阶段/Tomcat&Nginx资料/代码/Minicat/src/main/java/Servlet.class");
//        Object servlet = loader.loadClass("Servlet");


    }


}
