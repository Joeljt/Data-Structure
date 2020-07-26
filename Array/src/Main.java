public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());

        array.addLast( 100);
        System.out.println(array.toString());
//
        array.removeLast();
        System.out.println(array.toString());

        array.removeLast();
        System.out.println(array.toString());


    }

}
