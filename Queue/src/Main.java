import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        LoopQueue<Integer> queue = new LoopQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            // 每入队两个元素，就出队一个元素
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//
//        }

        int opCount = 100000;

        // 测试 ArrayQueue 和 LoopQueue 的性能
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayTime = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: " + arrayTime + " s"); // 3.677620174 s

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time: " + loopTime + " s"); // 0.013825136 s

    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long start = System.nanoTime();

        // 进行 opCount 次的入队和出队操作
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }


}
