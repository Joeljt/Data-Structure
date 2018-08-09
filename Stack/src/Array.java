public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void add(int index, E e){

        if (index > size || index < 0){
            throw new IllegalArgumentException("index is wrong");
        }

        // 如果超出容量限制，则对数组进行动态扩容
        if (size == getCapacity()){
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i --){
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;

    }

    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Wrong index");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 利用现有的 get 方法，而不是直接使用 data
     * 可以更好的规避一些错误
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Wrong index");
        }

        data[index] = e;
    }

    /**
     * 查询数组中是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查询某个元素在数组中对应的位置
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Wrong index");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }

        size --;
        data[size] = null; // loitering objects != memory leak

        // 删除元素后，如果空余元素过多，同样进行动态缩减
        // 数组长度为 1 时，不再进行缩减
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;

    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除特定的元素
     * @param e
     * @return
     */
    public boolean removeElement(E e){
        int index = find(e);
        if (index == -1){
            throw new IllegalArgumentException(String.format("No Such element like %d ", e));
        }
        remove(index);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n", size, getCapacity()));
        builder.append("[");
        for (int i = 0; i < size; i ++){
            builder.append(data[i]);
            if (i != size - 1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++){
            newData[i] = data[i];
        }

        data = newData;

    }

}
