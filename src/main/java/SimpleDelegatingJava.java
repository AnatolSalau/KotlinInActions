
interface RunnerJava {
      void run();
}

class RunnerImplJava implements RunnerJava {
      private final Integer speed;

      public RunnerImplJava() {
            speed = 10;
      }

      public RunnerImplJava(Integer speed) {
            this.speed = speed;
      }

      @Override
      public void run() {

            System.out.println("Run function from RunnerImpl with speed " + speed);
      }
}

class ParentWhoCanRunJava implements RunnerJava {
      private final RunnerJava runner;

      ParentWhoCanRunJava(RunnerJava runner) {
            this.runner = runner;
      }

      @Override
      public void run() {
            runner.run();
      }
}

class SimpleDelegatingJava {
      public static void main(String[] args) {
            RunnerJava runner = new RunnerImplJava(20);
            RunnerJava parent = new ParentWhoCanRunJava(runner);
            parent.run();
      }
}



