package top.karlo.springbeandemo.bean;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/29 11:08
 */
public class TestThread{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("ssss");
                return "ttt";
            }
        };

        FutureTask<String> task = new FutureTask(call);
        new Thread(task).start();
        String s = task.get();
        System.out.println(s);

    }

}
