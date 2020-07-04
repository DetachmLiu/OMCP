//package api;
//
//
//import okhttp3.internal.http.HttpMethod;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//
//
//import java.io.IOException;
//
//import java.util.Map;
//
//
///**
// * @author Hesenbai
// */
//public class httpClientApi {
//    String run(String url) {
////        String content = "";
////        //请求结果
////        CloseableHttpResponse response = null;
////        //实例化httpclient
////        CloseableHttpClient httpclient = HttpClients.createDefault();
////        try{
////            StringBuilder urlName = new StringBuilder(url);
////            if(params!=null && params.size()>0) {
////                url.append("?");
////                for(Map.Entry<String, Object> entry : params.entrySet()) {
////                    url.append(entry.getKey()+"="+entry.getValue()+"&");
////                }
////                url.substring(0, url.length()-1);
////            }
////            //实例化get方法
////            HttpGet httpget = new HttpGet(url.toString());
////            //执行get请求
////            response = httpclient.execute(httpget);
////            if(response.getStatusLine().getStatusCode()==200) {
////                content = EntityUtils.toString(response.getEntity(),"utf-8");
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return content;
//
//
//        HttpClient client = new HttpClient();
//        // 设置代理服务器地址和端口
//        //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
//        // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
//        HttpMethod method=new GetMethod(url);
//        //使用POST方法
//        //HttpMethod method = new PostMethod("http://java.sun.com");
//        client.executeMethod(method);
//
//        //打印服务器返回的状态
//        System.out.println(method.getStatusLine());
//        //打印返回的信息
//        System.out.println(method.getResponseBodyAsString());
//        //释放连接
//        method.releaseConnection();
//    }
//
//
//
//    }
//}
