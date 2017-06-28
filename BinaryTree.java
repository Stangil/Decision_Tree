import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Stan Gilstrap on 2/23/2017.
 */
public class BinaryTree {
    Node root;
    //int count = 0;

    public void addNode(int key, String name) {

        Node newNode = new Node(key, name);
        if (root == null)//tests to see if this is the root element
        {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;//where focusNode is root
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

 public void breadthOrderTraverseTree(Node focusNode) {
     int breadthOrdercount = 0;
     double ran;
     int key = 0;
     Queue<Node> queue = new LinkedList<>();
     queue.add(focusNode);
     Node tempNode;
     while (!queue.isEmpty()) {
         breadthOrdercount++;
         tempNode = queue.poll();
         if (tempNode.rightChild == null && tempNode.leftChild == null) {
             ran = Math.round(Math.random());
            // System.out.println("Random: "+ ran);
             //System.out.println("Key modulus: " + tempNode.key%2);
             if(((double)tempNode.key%2) == ran)
             {
                 System.out.println(tempNode +"\nBreadth First Search number of steps: " + breadthOrdercount);
                 key = tempNode.key;
                 break;
             }
         }
         if (tempNode.leftChild != null)
             queue.add(tempNode.leftChild);
         if (tempNode.rightChild != null)
             queue.add(tempNode.rightChild);
     }
     preOrderTraverseTree(focusNode, key);
 }
 public void preOrderTraverseTree(Node focusNode, int key)//depth first
    {
        int preOrdercount = 0;
        if (focusNode != null) {
            preOrdercount++;
            if (focusNode.key == key) {//have reached a leaf
                System.out.println("Depth First Search number of steps: " + preOrdercount);
                //preOrdercount = 0;
            }
            preOrderTraverseTree(focusNode.leftChild, key);
            preOrderTraverseTree(focusNode.rightChild, key);
        }
    }

public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null)
                return null;
        }
        return focusNode;
    }
}
class Node {
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return "Response: " + name;
    }
}

