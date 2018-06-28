public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i ++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(3, 100);
        System.out.println(arr);

        arr.addFirst(10001);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeElement(100);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }


}
