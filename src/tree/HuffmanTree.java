package tree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 6, 7, 7, 12, 1};
        createHuffmanTree(arr);
    }

    public static void createHuffmanTree(int[] arr) {
        //遍历数组将每个元素打包成node放入arrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //从小到大排序,因为实现了Compareable接口
        Collections.sort(nodes);
        System.out.println(nodes);
    }

}

class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大进行排序
        return this.value - o.value;
    }
}
