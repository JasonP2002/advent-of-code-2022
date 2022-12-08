import java.io.FileReader;
import java.io.BufferedReader;

public class DaySeven {
    
    final static String INPUT = "day-seven-input.txt";
    static CommandTree treeStructure = new CommandTree(null, "/", 0);
    static int dirTotal = 0;
    
    static final int TOTAL_SPACE = 70000000;
    static final int SPACE_REQUIRED = 30000000;
    static int freeSpace = 0;
    static int spaceToFree = 0;
    static int minDirSpace = TOTAL_SPACE;
    
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(INPUT);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;

            //Build Tree
            while((currentLine = br.readLine()) != null) {
                buildTree(currentLine);
            }
            root();
            printTree(treeStructure, "");
            
            //Part One
            int test = sumDirs(treeStructure);
            System.out.println("Part One: " + String.valueOf(dirTotal));
            
            //Part Two
            int spaceTaken = sumAllDirs(treeStructure);
            freeSpace = TOTAL_SPACE - spaceTaken;
            spaceToFree = SPACE_REQUIRED - freeSpace;
            int testtwo = findMinDirSpace(treeStructure);
            System.out.println("Part Two: " + String.valueOf(minDirSpace));
            
            br.close();
            fr.close();
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
    	String output = indent + "- " + tree.name + " (dir)";
    	if (tree.size != 0) {
    		output = indent + "- " + tree.name + " (file, size=" + String.valueOf(tree.size) + ")";
    	}
    	System.out.println(output);
    	for (int i = 0; i < tree.children.size(); i++) {
    		printTree(tree.children.get(i), indent+" ");
        }
    }
    
    //Part One
    public static int sumDirs(CommandTree t) {
    	if (t.size != 0) { //File
    		return t.size;
    	}
    	
    	//Dir
    	int childTotal = 0;
	    for (int i = 0; i < t.children.size(); i++) {
	    	childTotal += sumDirs(t.children.get(i));
	    }
	    if (childTotal <= 100000) {
	    	dirTotal += childTotal;
	    }
    	return childTotal;
    }
    
    //Part Two
    public static int sumAllDirs(CommandTree t) {
    	int total = 0;
    	for (int i = 0; i < t.children.size(); i++) {
    		total += sumAllDirs(t.children.get(i));
    	}
    	return t.size + total;
    }
    public static int findMinDirSpace(CommandTree t) {
    	if (t.size != 0) { //File
    		return t.size;
    	}
    	
    	//Dir
    	int childTotal = 0;
	    for (int i = 0; i < t.children.size(); i++) {
	    	childTotal += findMinDirSpace(t.children.get(i));
	    }
	    if (childTotal >= spaceToFree && childTotal < minDirSpace) {
	    	minDirSpace = childTotal;
	    }
    	return childTotal;
    }
    
}