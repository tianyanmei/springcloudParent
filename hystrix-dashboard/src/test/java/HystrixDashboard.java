import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HystrixDashboard {

    @Test
    public  void  testHystrixDashboard(){
       while (true){
           ThreadUtil.sleep(1000);
           try {
               new Thread() {
                   public void run() {
                       String html = HttpUtil.get("http://localhost:8012/product");
                       System.out.println("html length:" + html.length());
                   }
               }.start();//开启线程


             String html = HttpUtil.get("http://localhost:8012/product");
             System.out.println("html length:" + html.length());

           }catch (Exception e){
               System.err.println(e.getMessage());
           }
       }
    }
}
