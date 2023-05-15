package compare;

import algorithms.tree.Tree;

import java.util.Scanner;

public class L3 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        long start;
        int key;
        int run = 100;
        int size = 64000;
        Scanner in = new Scanner(System.in);
        System.out.println("\nKey: ");
        key = in.nextInt();

        tree.randomize(tree, size, 100);
        switch (key) {
            case 0: {
                System.out.println("\nPreOrderRec");
                start = System.currentTimeMillis();
                for (int i = 0; i < run; i++) {
                    tree.preOrderRec(tree.getRoot());
                }
                time(start, run);
                break;
            }
            case 1: {
                System.out.println("\nInOrderRec");
                start = System.currentTimeMillis();
                for (int i = 0; i < run; i++) {
                    tree.inOrderRec(tree.getRoot());
                }
                time(start, run);
                break;
            }
            case 2: {
                System.out.println("\nPostOrderRec");
                start = System.currentTimeMillis();
                for (int i = 0; i < run; i++) {
                    tree.postOrderRec(tree.getRoot());
                }
                time(start, run);
                break;
            }
            case 3: {
                System.out.println("\nPreOrderIteration");
                start = System.currentTimeMillis();
                for (int i = 0; i < run; i++) {
                    tree.preOrderIt(tree.getRoot());
                }
                time(start, run);
                break;
            }
            case 4: {
                System.out.println("\nInOrderIteration");
                start = System.currentTimeMillis();
                for (int i = 0; i < run; i++) {
                    tree.inOrderIt(tree.getRoot());
                }
                time(start, run);
                break;
            }
            default: {
                break;
            }
        }
    }

    private static void time(long start, int run) {
        long end;
        double allTime, avgTime;
        System.out.println("\nTime: ");
        end = System.currentTimeMillis();
        allTime = (double) (end - start) / 1000;
        avgTime = allTime / run;
        System.out.print(avgTime + "\n");
    }
}
