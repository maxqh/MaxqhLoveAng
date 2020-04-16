package com.maxqh.testarea.leetcode.Heap;

import java.util.Comparator;

/**
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2020-04-03 09:47
 */
public class HeapPriority<E> {
    private Object[] heapArray;
    private Comparator<? super E> comparatorInit;
    private int size = 0;

    public HeapPriority(Integer capacity) {
        heapArray = new Object[capacity];
    }

    public HeapPriority(Integer capacity, Comparator<? super E> comparator) {
        heapArray = new Object[capacity];
        this.comparatorInit = comparator;
    }

    public Boolean add(E param) throws Exception {
        if (size >= heapArray.length) {
            throw new Exception("超过初始长度");
        }

        if (size == 0) {
            heapArray[size++] = param;
            return Boolean.TRUE;
        }

        siftUp(size++, param);

        return Boolean.TRUE;

    }

    private void siftUp(int index, E param) {
        Comparable<? super E> comparable = (Comparable<? super E>) param;

        while (index > 0) {
            int parent = (index - 1) >>> 1;
            E temp = (E) heapArray[parent];
            if (comparable.compareTo(temp) >= 0) {
                break;
            }

            heapArray[index] = temp;
            index = parent;
        }

        heapArray[index] = param;
    }

    public static void main(String[] args) throws Exception {
        HeapPriority<Integer> param = new HeapPriority<>(5, null);
        param.add(100000);
        param.add(0);
        param.add(10);
        param.add(-12123);
        System.out.println(param.remove(0));
        System.out.println(param.remove(0));
        System.out.println(param.remove(0));
        System.out.println(param.remove(0));


        param.add(321);
        param.add(6812);
        param.add(10);
        param.add(-12123);

        System.out.println(param.remove(0));
        System.out.println(param.remove(0));
        System.out.println(param.remove(0));

        param.add(1000000);
        System.out.println(param.remove(0));

        System.out.println(param);
    }

    public E remove(int i) throws Exception {
        if ((i + 1) > size) {
            throw new Exception("不存在的数据");
        }

        if (i < 0) {
            throw new Exception("错误的位置");
        }

        size--;
        if (i == size) {
            E result = (E) heapArray[i];
            heapArray[i] = null;
            return result;
        } else {
            E remove = (E) heapArray[size];
            E old = (E) heapArray[i];
            heapArray[size] = null;
            siftDown(i, remove);
            return old;
        }


    }

    private E siftDown(int i, E param) {
        Comparable<? super E> comparable = (Comparable<? super E>) param;

        int half = size >>> 1;
        while (i < half) {
            int left = (i << 1) + 1;
            int right = left + 1;
            int min = left;
            E leftChild = (E) heapArray[left];
            E minChild = leftChild;
            if (right < size && (((Comparable<? super E>) leftChild).compareTo((E) heapArray[right]) > 0)) {
                min = right;
                minChild = (E) heapArray[right];
            }
            if (comparable.compareTo(leftChild) <= 0) {
                break;
            }

            heapArray[i] = minChild;
            i = min;
        }

        heapArray[i] = param;
        return (E) heapArray[i];
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) heapArray[0];
    }
}
