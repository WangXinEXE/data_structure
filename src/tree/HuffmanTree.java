package tree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);
    }

    //前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.preNodeList();
        } else {
            System.out.println("这树是空的");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        //遍历数组将每个元素打包成node放入arrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //从小到大排序,因为实现了Compareable接口,这块必须要排序
        Collections.sort(nodes);
        //System.out.println(nodes);

        while (nodes.size() > 1) {  //因为一直删除添加到最后arrayList肯定就剩下一个node了
            //取出前两个权值最小的节点(二叉树)
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);//构造权值父节点
            parent.left = leftNode;
            parent.right = rightNode;//这两个节点挂在树上
            nodes.remove(leftNode);//删除已经处理过的节点
            nodes.remove(rightNode);
            nodes.add(parent);//加入父节点
            Collections.sort(nodes);//这也是,必须要排序
            //System.out.println("diyici" + nodes);
        }
        return nodes.get(0);  // 返回Huffman权值根节点

    }

}

class Node implements Comparable<Node> {
    int value;//节点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preNodeList() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preNodeList();
        }
        if (this.right != null) {
            this.right.preNodeList();
        }
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
