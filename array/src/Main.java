package array.src;

public class Main {
  
  public static void main(String[] args) {
    
    Array array = new Array(20);
    for (int i = 0; i < 10; i++) {
      array.addLast(i);
    }

    array.add(1, 100);
    System.out.println(array); 

    array.addFirst(-1);
    System.out.println(array); 


    array.remove(2);
    System.out.println(array); 

    array.removeElement(4);
    System.out.println(array); 

    array.removeFirst();
    System.out.println(array); 


  }

}