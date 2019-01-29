/*This problem was asked by Google.


        Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

        For example, given the following Node class

class Node:
        def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        The following test should pass:

        node = Node('root', Node('left', Node('left.left')), Node('right'))
        assert deserialize(serialize(node)).left.left.val == 'left.left'


*/

public class Problem3 {

    public static void main(String[] args) {
        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));

        System.out.println(serialize(node));
        //        System.out.println(deserialize(serialize(node)).getLeft().getLeft().getValue());
    }

    public static String serialize(Node node) {
        String s = node.getValue();
        if (node.getLeft() != null || node.getRight() != null) {
            s = s + "(";
            if (node.getLeft() != null) {
                s = s + serialize(node.getLeft());
            }
            if (node.getRight() != null) {
                s = s + "," + serialize(node.getRight());
            }
            s = s + ")";
        }
        return s;
    }

    public static Node deserialize(String s) {
        String value = "";
        for (int i = 0; i < s.length(); i++) {
            char c = value.charAt(i);
            if (c == '(' || c == ')') {
                Node node = new Node(value);
                node.setLeft(deserialize(s));
            }
            else if (c == ','){

            }
            else {
                value += c;

            }
        }
    }

}

class Node {

    private Node left;
    private Node right;
    private String value;

    public Node(String value) {
        this.value = value;
    }

    public Node(String value, Node left) {
        this.left = left;
        this.value = value;
    }

    public Node(String value, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    public void setLeft(Node node) {
        this.left = node;
    }
}