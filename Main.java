import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Stan Gilstrap on 2/20/2017.
 */

public class Main {
    public static Reader reader;

    public static void main(String[] args) {
        int nodeKey;
        String input = "";
        Scanner scanner = new Scanner(System.in);
        try {
            reader = new Reader("Decision_Tree");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        while (!"quit".equals(input)) {//select Event
            System.out.println("\nPossible events are:\n" +
                    "Incoming Projectile\n" +
                    "Combat\n" +
                    "Idle");
            System.out.println("Select Event (type 'quit' to exit:)");
            input = scanner.nextLine();
            if ("Incoming Projectile".equals(input)) {
                nodeKey = 31;
            } else if ("Combat".equals(input)) {
                nodeKey = 25;
            } else if ("Idle".equals(input)) {
                nodeKey = 75;
            } else
                nodeKey = 50;
            reader.theTree.breadthOrderTraverseTree(reader.theTree.findNode(nodeKey));
            //TODO make leaf selection random and count each step for each traversal
        }

     /*   System.out.println("-------------------------------------");
        System.out.println("preOrderTraverseTree");
        reader.theTree.preOrderTraverseTree(reader.theTree.root);
        System.out.println("-------------------------------------");

        System.out.println("breadthOrderTraverseTree");
        reader.theTree.breadthOrderTraverseTree(reader.theTree.root);*/
        //System.out.println("Root Node: "+ reader.theTree.findNode(10)); //finding a node
    }

}
