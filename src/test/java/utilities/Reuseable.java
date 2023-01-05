package utilities;

public class Reuseable {
    public  static   void bekle(int value){
        try {
            Thread.sleep(value*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
