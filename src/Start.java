import demo.DemoService;
import demo.DemoServiceImpl;

public class Start {
    public static void main(String[] args) {
        DemoService demoService = new DemoServiceImpl();
        demoService.start();
    }
}
