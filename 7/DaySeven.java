import java.io.FileReader;
import java.io.BufferedReader;

public class DaySeven {
    
    final static String INPUT = "day-seven-input.txt";
    static CommandTree treeStructure = new CommandTree(null, "/", 0);
    static int dirTotal = 0;
    
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(INPUT);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;

            while((currentLine = br.readLine()) != null) {
                buildTree(currentLine);
            }

            root();
            printTree(treeStructure, "");
            int test = sumDirs(treeStructure);
            System.out.println(String.valueOf(dirTotal));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buildTree(String line) {
        String[] l = line.split(" ");

        if (l[0].equals("$")) { //user command
            if (l.length == 3) { //change directory
                if (l[2].equals("/")) { //to root
                    root();
                } else if (l[2].equals("..")) { //to parent
                    treeStructure = treeStructure.parent;
                } else { //to child
                    for (int i = 0; i < treeStructure.children.size(); i++) {
                        if (treeStructure.children.get(i).name.equals(l[2])) {
                            treeStructure = treeStructure.children.get(i);
                            break;
                        }
                    }
                }
            }
        } else { //ls output
        	CommandTree newTree;
            if (l[0].equals("dir")) { //directory size = 0
            	newTree = new CommandTree(treeStructure, l[1], 0);
                treeStructure.addChild(newTree);
            } else { //file size = l[0]
            	newTree = new CommandTree(treeStructure, l[1], Integer.parseInt(l[0]));
                treeStructure.addChild(newTree);
            }
        }
    }

    public static void root() {
        while (treeStructure.parent != null) {
            treeStructure = treeStructure.parent;
        }
    }

    public static void printTree(CommandTree tree, String indent) {
    	String type = "(dir)";
    	if (tree.size != 0) {
    		type = "(file, size=" + String.valueOf(tree.size) + ")";
    	}
    	System.out.println(indent + "- " + tree.name + " " + type);
    	for (int i = 0; i < tree.children.size(); i++) {
    		printTree(tree.children.get(i), indent+" ");
        }
    }
    
    public static int sumDirs(CommandTree t) {
    	int childTotal = 0;
    	
    	if (t.size != 0) { //File
    		return t.size;
    	}
    	
    	//Dir
	    for (int i = 0; i < t.children.size(); i++) {
	    	childTotal += sumDirs(t.children.get(i));
	    }
	    	
	    if (childTotal <= 100000) {
	    	dirTotal += childTotal;
	    }
    	
    	return childTotal;
    }
    
}