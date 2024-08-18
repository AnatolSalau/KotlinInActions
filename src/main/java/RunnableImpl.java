public class RunnableImpl implements Runnable{
      private final int speed = Runnable.MAX_SPEED;

      void printSpeed() {
            System.out.println(speed);
      }

      public static void main(String[] args) {
            RunnableImpl runnable = new RunnableImpl();
            runnable.printSpeed();
      }
}
