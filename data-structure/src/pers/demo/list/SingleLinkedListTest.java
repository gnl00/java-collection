package pers.demo.list;

import java.util.LinkedList;

/**
 * SingleLinkedListTest 单链表
 *
 * @author gnl
 */

public class SingleLinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        a.add(1);
        a.add(12);
        a.add(90);

        b.add(2);
        b.add(6);
        b.add(8);
        b.add(10);

        LinkedList<Integer> resList = merge(a, b);
        System.out.println(resList);


    }

    /**
     * 将两个递增链表合并为新的递增链表
     * @author gnl
     */
    public static LinkedList<Integer> merge(LinkedList<Integer> a, LinkedList<Integer> b) {

        LinkedList<Integer> c = new LinkedList<>();
        int index = 0;

        while (index < a.size() && index < b.size()) {

            // 将值较小的元素使用尾插法插入新链表
            if (a.get(index) <= b.get(index)) {
                c.addLast(a.get(index));
                c.addLast(b.get(index));
            } else {
                c.addLast(b.get(index));
                c.addLast(a.get(index));
            }
            index++;
        }

        if (index < a.size()) {
            // 将从index开始一直到finalListSize位置的元素，加入c
            for (int i = index; i < a.size(); i++) {
                c.add(a.get(i));
            }
        } else if (index < b.size()){
            // 将从index开始一直到finalListSize位置的元素，加入c
            for (int i = index; i < b.size(); i++) {
                c.add(b.get(i));
            }
        }

        return bubbleSort(c);
    }

    /**
     * 冒泡排序
     * @param list
     * @return java.util.LinkedList<java.lang.Integer>
     * @author gnl
     */
    public static LinkedList<Integer> bubbleSort(LinkedList<Integer> list) {

        int temp;

        // 记录本次扫描有无交换，若有，继续下一轮排序，若无，则排序结束
        boolean flag = false;

        for (int i = 1, j = i - 1; i < list.size(); i++, j++) {

            if (list.get(j) > list.get(i)) {
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                flag = true;
            }
        }

        // 如果有交换，继续下一次排序
        while (flag) {
            bubbleSort(list);
            break;
        }
        return list;

    }
}

