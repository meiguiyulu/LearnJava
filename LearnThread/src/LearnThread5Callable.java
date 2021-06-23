import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author LYJ
 * @create 2021-04-28 21:17
 * 线程创建方式3 实现Callable接口
 */

public class LearnThread5Callable implements Callable<Boolean> {

    private String url;
    private String name;

    public LearnThread5Callable(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call()  {

        WebDownloader2 web = new WebDownloader2();
        web.DownLoader(url, name);
        System.out.println("下载了文件名为 " + name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String url = "https://meiguiyulu.github.io/assets/img/sample/avatar.jpg";
        String name = "2.jpg";
        LearnThread5Callable web = new LearnThread5Callable(url, name);

        ExecutorService ser = Executors.newFixedThreadPool(1); //创建执行服务
        Future<Boolean> r1 = ser.submit(web);//提交执行
        boolean rs1 = r1.get();// 获取结果
        ser.shutdownNow();//关闭服务
    }
}

// 下载器
class WebDownloader2{
    public void DownLoader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常， DownLoader方法出现异常!");
        }
    }
}

