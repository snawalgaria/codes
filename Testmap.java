import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Testmap {

	static class Node implements Comparator<Node> {
		private Node left;
		private Node right;
		int count;
		String word;
		Node(int value, Node left, Node right, String word){
			this.count=value;
			this.left=left;
			this.right=right;
			this.word=word;
		}
		
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if(o1.count<o2.count)
				return -1;
			else
				return 1;
		}
	}
	static void preOrder(Node root) {
		if(root == null)
			return;
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.count+",");
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Integer> m = readfromFile();
		Node t2 =new Node(0,null,null,null);
		PriorityQueue <Node> trees = new PriorityQueue<Node>(t2);
		Set<String> allWords=m.keySet();
		String setElement;
		 Iterator<String> iterator = allWords.iterator();
		    while(iterator.hasNext()) {
		        setElement = iterator.next();
		        Node t = new Node(m.get(setElement),null,null,setElement);
		        trees.add(t);
		    }
		Node n1,n2,result = null;
		if(trees.isEmpty()) {
			System.out.print("Blank File");
		}
		else 
		{
		while(!trees.isEmpty()) {
			
			n1=trees.poll();
			n2 = trees.poll();
			if(n2 == null) {
				
				result = n1;
				break;
			}
			result= new Node(n1.count+n2.count,n1,n2,null);
			trees.offer(result);
		}
			preOrder(result);
		}
		
	}
	private static Map<String, Integer> readfromFile() throws FileNotFoundException, IOException {
		Map<String,Integer> m = new HashMap<String,Integer>();
		FileReader fr=new FileReader("C:/users/snawalga/file1.txt");
		BufferedReader br=new BufferedReader(fr);
		String Line;
		String words[];
		while(true)
		{
			Line=br.readLine();
			if(Line == null)
				break;
			words=Line.split(" ");
			for(String w:words)
			{
				if(m.get(w)!=null)
					m.put(w, m.get(w)+1);
				else
					m.put(w,1);
			}
		}
		br.close();
		return m;
	}

}
