public interface Queue<E> {

    int getSize(); // O(1)

    boolean isEmpty(); // O(1)

    void enqueue(E e); // O(1) 均摊

    E dequeue(); // O(n) -> 由于动态数组 removeFirst，之后的所有元素都要向前移动，所以是 O(n)

    E getFront(); // O(1)

}
