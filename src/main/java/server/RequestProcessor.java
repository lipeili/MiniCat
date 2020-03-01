package server;

import server.core.Context;
import server.core.Host;
import server.core.MyMapper;
import server.core.Wrapper;

import java.io.InputStream;
import java.net.Socket;

public class RequestProcessor extends Thread {

    private Socket socket;
    private MyMapper myMapper;

    public RequestProcessor(Socket socket, MyMapper myMapper) {
        this.socket = socket;
        this.myMapper = myMapper;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();

            // 封装Request对象和Response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());

            // 静态资源处理
            try {
                Host host = myMapper.getMappedHost("localhost");// 偷懒写法
                Context context = myMapper.getMappedContext(host,request.getUrl().split("/")[1]);
                Wrapper wrapper = context.getWrappers().get(request.getUrl());
                if(wrapper == null) {
                    response.outputHtml(request.getUrl());
                }else{
                    // 动态资源servlet请求
                    wrapper.getServlet().service(request, response);
                }
            } catch (NullPointerException e) {
                response.output("404");
            }

            socket.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
