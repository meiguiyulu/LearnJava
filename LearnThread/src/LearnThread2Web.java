import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author LYJ
 * @create 2021-04-28 20:30
 * //练习Thread，实现多线程同步下载图片
 */
public class LearnThread2Web extends Thread{

    private String url; //网络图片地址
    private String name; //保存的文件名

    public LearnThread2Web(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader  webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载的文件名称："+ name);
    }

    public static void main(String[] args) {
        String url = "https://meiguiyulu.github.io/assets/img/sample/avatar.jpg";
        String name = "2.jpg";
        LearnThread2Web web = new LearnThread2Web(url, name);
        web.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try{
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常；downloader方法出现问题!");
        }
    }
}
