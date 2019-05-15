import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node leftLeaf;
    public Node rightLeaf;
    public Integer frequency;
    public List<Integer> letters = new ArrayList<>();

    public Node(Node lL, Node rL) {
        leftLeaf = lL;
        rightLeaf = rL;
        frequency = lL.frequency + rL.frequency;
        letters.addAll(lL.letters);
        letters.addAll(rL.letters);
    }

    public Node(int letter, int frequency) {
        letters.add(letter);
        this.frequency = frequency;
    }

    public boolean isLeaf() {
        return (leftLeaf == null & rightLeaf == null);
    }
}
