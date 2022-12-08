import java.util.ArrayList;

public class CommandTree {
    CommandTree parent;
    String name;
    int size;
    ArrayList<CommandTree> children;

    public CommandTree(CommandTree parent, String name, int size) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.children = new ArrayList<CommandTree>();
    }

    public void addChild(CommandTree child) {
        children.add(child);
    }

}
