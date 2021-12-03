package collectionGenerics.task1;

/*
1) Написать метод, который создаст список, положит в него 10
элементов, затем удалит первые два и последний, а затем выведет
результат на экран.
 */

import java.util.ArrayList;

 public class Main {
    public static ArrayList<Integer> doList(int[] a) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            integers.add(a[i]);
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        int sz = integers.size();
        integers.remove(sz - 1);
        integers.subList(0, 2).clear();

        System.out.println();
        return integers;
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> d = doList(w);
        System.out.println("after cutting");
        for (int i = 0; i < d.size(); i++) {

            System.out.print(d.get(i) + " ");
        }
    }
}
