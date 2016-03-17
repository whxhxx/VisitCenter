package WAP;

import java.util.ArrayList;
import java.util.Scanner;

import 测试.Car;

class Node
{
	 ArrayList<Integer> eds = new ArrayList<Integer>();
}

public class Main 
{

	static Node[] nodes  = new Node[100];

	static int[] dis   = new int[100];
	 
	public static void main(String[] args) 
	{	 
		// init dis[]
		for(int distanceFromIToEventCity : dis)
		{
			distanceFromIToEventCity = -1;
		}
		
		System.out.println(dis[1]);
		System.out.println(dis[2]);
		System.out.println(dis[3]);
		

		
		
		// firsr row
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		line.trim();
//		int m = Integer.parseInt(line.substring(0, line.indexOf(" ")));
//		int n = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1,line.length()));
		String []lineArr  = line.split("(\\s){1,5}") ;
//		System.out.println(s1[0]+  " " + s1[1]);
  
		
		int n = Integer.parseInt(lineArr[0]);
		int m = Integer.parseInt(lineArr[1]);
	
 		// part2 rows
		for(int i =1; i < n; ++i)
		{
			String line2 = scanner.nextLine();
//			int a = Integer.parseInt(line2.substring(0, line2.indexOf(" ")));
//			int b = Integer.parseInt(line2.substring(line2.lastIndexOf(" ")+1,line2.length()));
			String []line2Arr  = line2.split("(\\s){1,5}") ;
 	  
			
			int ai = Integer.parseInt(line2Arr[0]);
			int bi = Integer.parseInt(line2Arr[1]);
			
			// city a has b 
			Node node1 = new Node();
			node1.eds.add(bi);
			nodes[ai] = node1;
			
			//city b has a
			Node node2 = new Node();
			node2.eds.add(ai);
			nodes[bi] = node2;
		
			
			System.out.println(nodes[ai].eds);
 			System.out.println(nodes[bi].eds);
		}
		
		dis[1] = 0;
		
		dfs(1,0);
		
		
		// part3 rows
		for(int i = 0; i < m ; ++i)
		{
			String line3 = scanner.nextLine();
//			int c = Integer.parseInt(line3.substring(0, line3.indexOf(" ")));
//			int p = Integer.parseInt(line3.substring(line3.lastIndexOf(" ")+1,line3.length()));
			String []line3Arr  = line3.split("(\\s){1,5}") ;
 	  
			
			int ci = Integer.parseInt(line3Arr[0]);
			int pi = Integer.parseInt(line3Arr[1]);
			
			if(ci ==1)
			{
				dis[pi] = 0;
				dfs(pi, 0);
				System.out.println(dis[pi]);
			}
			else 
			{
				{
					System.out.println(dis[pi]);
				}
			}
			
		}
		
	}


	private static void dfs(int x, int p) 
	{
		ArrayList<Integer> vecs = nodes[x].eds;
		
		for(int i = 0; i< vecs.size(); ++i)
		{
			if( vecs.get(i) == p)
			{
				continue;
			}
			
			if(dis[vecs.get(i)] == -1 || dis[vecs.get(i)] > dis[x] + 1)
			{
				dis[vecs.get(i)] = dis[x] + 1;
				System.out.println(dis[vecs.get(i)]);
				dfs(vecs.get(i), x);
			}
		}
	}

}
