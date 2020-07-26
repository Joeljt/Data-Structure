import java.util.Arrays;

/**
 * 实现一个数组数据结构，以泛型方式兼容多种数据类型，并支持动态扩展
 */
public class Array<E> {

    // 内部真正实现
    private E[] data;
    // 数组实际的大小，与 capacity（容量） 的概念不同
    private int size;

    /**
     * 以 new Object[] 的形式间接实现泛型数组
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public Array() {
        this(10);
    }

    // ================================== 增 ===================================
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal.");
        }

        // 当数组容量不够时，动态为数组进行扩容
//        if (index == data.length) resize(data.length * 2);
        if (size == data.length) resize(data.length * 2);

        // me
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        // bobo
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }

        data[index] = e;
        size++;
    }

    // ================================== 删 ===================================
    public E remove(int index) {
        E ret = data[index];

        // me，index out of range
//        for (int i = index; i < size; i++) {
//            data[i] = data[i + 1];
//        }
//        data[size] = null;
//        size --;

        // bobo, correct
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering != memory leak

        // 动态缩容 & 解决复杂度震荡问题
//        if (size == data.length / 4 && data.length / 2 != 0) {
//            resize(data.length / 2);
//        }

//        if (size == data.length / 2) {
//            resize(data.length / 2);
//        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // ================================== 改 ===================================
    public void update(int index, E e) {
        data[index] = e;
    }


    // ================================== 查 ===================================
    public boolean contains(E e) {
        return find(e) != -1;
    }

    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }


    // ================================== helper ===================================
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Array size = ").append(getSize()).append(", capacity = ").append(getCapacity());
        b.append("\n[");
        for (int i = 0; i < size; i++) {
            b.append(data[i].toString());
            if (i == size - 1)
                return b.append(']').toString();
            b.append(", ");
        }
        return "[]";
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
