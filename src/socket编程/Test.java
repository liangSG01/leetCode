package socket编程;

import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
    }
}
public class Test {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        solution(root);
        }

   public static void solution(Node root){
       Stack<Node> stack = new Stack<>();
       Node cur = root;
       while(cur != null || !stack.isEmpty()) {
           //左子树全部入栈
           while( cur != null){
               stack.push(cur);
               cur = cur.left;
           }
           cur = stack.pop();
           //访问节点
           System.out.print(cur.data);
           cur = cur.right;
       }
   }
}

