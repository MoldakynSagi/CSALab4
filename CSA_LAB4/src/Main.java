import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      int N;
      int M;
      int K;
      Scanner scan = new Scanner(System.in);
      MainMemory mainMemory = new MainMemory();

      System.out.println("Enter N: ");
      N = scan.nextInt();
      System.out.println("Enter M: ");
      M = scan.nextInt();
      System.out.println("K should be power of 2");
      System.out.println("Enter K: ");
      K = scan.nextInt();

      mainMemory.create(N, M, K);

      if (N % 2 == 0 || M % 2 == 0 || K % 2 == 0) {
          while(true){
              System.out.println("Algorithm 1 - 1");
              System.out.println("Algorithm 2 - 2");
              System.out.println("Algorithm 3 - 3");
              System.out.println("EXIT - 0");
              int number = scan.nextInt();
              if(number == 1){
                  mainMemory.firstAlgorithm(N, M, K);
                  break;
              }else if(number == 2){
                  mainMemory.secondAlgorithm(N, M, K);
                  break;
              }else if(number == 3){
                  break;
              }else if(number == 0){
                  System.exit(0);
              }else{
                  System.out.println("ERROR!!! incorrect number!!!");
              }
          }
          mainMemory.result();
      }else {
          System.out.println("ERROR!!! incorrect number");
      }
    }
}