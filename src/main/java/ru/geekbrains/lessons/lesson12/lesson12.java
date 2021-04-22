package ru.geekbrains.lessons.lesson12;

import javax.naming.SizeLimitExceededException;
import java.util.Arrays;

public class lesson12 {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;


    public static void main (String[] args) {
        float[] data1 = createArr(SIZE);
        timeDelta(() -> countThisArr(data1, 0));

        float[] data2 = createArr(SIZE);
        timeDelta(() -> multiTread(data2));

        System.out.println(Arrays.equals(data1, data2));


    }



    private static void timeDelta(Runnable action) {
        long a = System.currentTimeMillis();
        action.run();
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void countThisArr (float [] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i+ offset) / 5) * Math.cos(0.4f + (i+offset) / 2));
        }

    }

    private static float [] createArr(int size) {
        float [] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1f;
        }
        return arr;
    }

    private static void multiTread (float [] arr) {

        float[] part1 = new float[HALF];
        System.arraycopy(arr, 0, part1, 0, HALF);
        float[] part2 = new float[HALF];
        System.arraycopy(arr, HALF, part2  , 0, HALF);

        Thread thread1 = new Thread(() -> countThisArr(part1, 0));
        Thread thread2 = new Thread(() -> countThisArr(part2, HALF));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(part1, 0, arr, 0, HALF);
        System.arraycopy(part2, 0, arr, HALF, HALF);



    }


}
