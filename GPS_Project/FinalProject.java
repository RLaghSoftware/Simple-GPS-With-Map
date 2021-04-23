package package5;

import java.util.Scanner;
import java.util.Stack;

public class FinalProject 
{
	public static void DisplayMap () // uses print statements to display map and instructions
	{
		 System.out.println(" Using the following map, enter the number label of your destination");
		 System.out.println(" and starting location, and the shortest path will be displayed: ");
		 
		 System.out.println("			");
		 System.out.println("			");
		 
		 System.out.println("			MAP:");
	        System.out.println(" ");
	        System.out.println(" ");
	        System.out.println(" ");

	        System.out.println(" ");
	        System.out.println("		23	24     1      25 		");
	        System.out.println("		 O------O------O------O	    ");
	        System.out.println(" 		 |     /|     /|     /|		");
	        System.out.println("		 |    / |    / |    / |	    ");
	        System.out.println("		 |   /  |   /  |   /  |	    ");
	        System.out.println("		 |  /   |  /   |  /   |	    ");
	        System.out.println("	         | /    | /    | /    |	    ");
	        System.out.println("	       21|/    2|/    3|/   22|	    ");
	        System.out.println("	         O------O------O------O	    ");
	        System.out.println("                 |     /|     /|\\     |	");
	        System.out.println("                 |    / |    / | \\    |	");
	        System.out.println("                 |   /  |   /  |  \\   |	");
	        System.out.println("                 |  /   |  /   |   \\  |	");
	        System.out.println("                 | /    | /    |    \\ |	");
	        System.out.println("                4|/   20|/    6|     \\|5	");
	        System.out.println("                 O------O------O------O	");
	        System.out.println("                 |     /|     /      /| ");
	        System.out.println("                 |    / |    /      / | ");
	        System.out.println("                 |   /  |   /      /  | ");
	        System.out.println("                 |  /   |  /      /   | ");
	        System.out.println("                 | /    | /      /    | ");
	        System.out.println("                7|/   10|/    9 /    8| ");
	        System.out.println("                 O------O------O------O	");
	        System.out.println("                 |      |      |      | ");
	        System.out.println("                 |      |      |      | ");
	        System.out.println("                 |      |      |      | ");
	        System.out.println("                 |      |      |      | ");
	        System.out.println("                 |      |      |      | ");
	        System.out.println("               11|    14|    13|    12| ");
	        System.out.println("                 O------O------O------O	");
	        System.out.println("                /      /|      |      |	");
	        System.out.println("               /      / |      |      |   ");
	        System.out.println("              /      /  |      |      |   ");
	        System.out.println("             /      /   |      |      | ");
	        System.out.println("            /      /    |      |      |");
	        System.out.println("         15/    18/   19|    17|    16|");
	        System.out.println("          O------O------O------O------O	");
	        System.out.println("			");
	        System.out.println("			");
	}
	
	public static void main (String [] args)
	{
		
		Scanner keyboard89 =new	Scanner(System.in);
		int DestinationLabel = 0;

		DisplayMap();
		System.out.println("Enter destination label");
		while (DestinationLabel<1 || DestinationLabel > 25) // validates label
		{
			DestinationLabel = keyboard89.nextInt();
			if (DestinationLabel<1 || DestinationLabel > 25)
			{
				System.out.println("Error: the label you entered is invalid, please try again:");
			}
		}
		
		Scanner keyboard90 =new	Scanner(System.in);
		int StartLabel = 0;
		System.out.println("Enter starting location label");
		while (StartLabel<1 || StartLabel > 25) // validates label
		{
			StartLabel = keyboard89.nextInt();
			if (StartLabel<1 || StartLabel > 25)
			{
				System.out.println("Error: the label you entered is invalid, please try again:");
			}
		}
		
	CaveSystem<Object> n = new CaveSystem<Object>();

	
	Cave<Object> a = new Cave(1); // adds caves and tunnels
	Cave<Object> b = new Cave(2);
	Cave<Object> c = new Cave(3);
	Cave<Object> d = new Cave(4);
	Cave<Object> e = new Cave(5);
	Cave<Object> f = new Cave(6);
	Cave<Object> g = new Cave(7);
	Cave<Object> h = new Cave(8);
	Cave<Object> i = new Cave(9);
	Cave<Object> j = new Cave(10);
	Cave<Object> k = new Cave(11);
	Cave<Object> l = new Cave(12);
	Cave<Object> m = new Cave(13);
	Cave<Object> nn = new Cave(14);
	Cave<Object> o = new Cave(15);
	Cave<Object> p = new Cave(16);
	Cave<Object> q = new Cave(17);
	Cave<Object> r = new Cave(18);
	Cave<Object> s = new Cave(19);
	Cave<Object> t = new Cave(20);
	Cave<Object> u = new Cave(21);
	Cave<Object> v = new Cave(22);
	Cave<Object> w = new Cave(23);
	Cave<Object> yyy = new Cave(24);
	Cave<Object> z = new Cave(25);
	
	n.addCave(a);
	n.addCave(b);
	n.addCave(c);
	n.addCave(d);
	n.addCave(e);
	n.addCave(f);
	n.addCave(g);
	n.addCave(h);
	n.addCave(i);
	n.addCave(j);
	n.addCave(k);
	n.addCave(l);
	n.addCave(m);
	n.addCave(nn);
	n.addCave(o);
	n.addCave(p);
	n.addCave(q);
	n.addCave(r);
	n.addCave(s);
	n.addCave(t);
	n.addCave(u);
	n.addCave(v);
	n.addCave(w);
	n.addCave(yyy);
	n.addCave(z);
	
	n.addTunnel(a.getLabel(), b.getLabel());
	n.addTunnel(a.getLabel(), c.getLabel());
	
	n.addTunnel(b.getLabel(), d.getLabel());
	n.addTunnel(b.getLabel(), c.getLabel());
	
	n.addTunnel(c.getLabel(), e.getLabel());
	n.addTunnel(c.getLabel(), f.getLabel());
	
	n.addTunnel(d.getLabel(), g.getLabel());
	
	
	n.addTunnel(e.getLabel(), h.getLabel());
	n.addTunnel(e.getLabel(), i.getLabel());
	
	n.addTunnel(f.getLabel(), j.getLabel());
	n.addTunnel(f.getLabel(), e.getLabel());
	
	n.addTunnel(g.getLabel(), k.getLabel());
	n.addTunnel(g.getLabel(), j.getLabel());
	
	n.addTunnel(h.getLabel(), l.getLabel());
	
	n.addTunnel(i.getLabel(), m.getLabel());
	n.addTunnel(i.getLabel(), h.getLabel());
	
	n.addTunnel(j.getLabel(), nn.getLabel());
	n.addTunnel(j.getLabel(), i.getLabel());
	
	n.addTunnel(k.getLabel(), o.getLabel());
	n.addTunnel(k.getLabel(), nn.getLabel());
	
	n.addTunnel(l.getLabel(), p.getLabel());
	
	n.addTunnel(m.getLabel(), q.getLabel());
	n.addTunnel(m.getLabel(), l.getLabel());
	
	n.addTunnel(nn.getLabel(), r.getLabel());
	n.addTunnel(nn.getLabel(), s.getLabel());
	n.addTunnel(nn.getLabel(), m.getLabel());
	
	n.addTunnel(o.getLabel(), r.getLabel());
	
	n.addTunnel(r.getLabel(), s.getLabel());
	
	n.addTunnel(s.getLabel(), q.getLabel());
	
	n.addTunnel(q.getLabel(), p.getLabel());
	
	n.addTunnel(t.getLabel(), b.getLabel());
	n.addTunnel(t.getLabel(), c.getLabel());
	n.addTunnel(t.getLabel(), d.getLabel());
	n.addTunnel(t.getLabel(), f.getLabel());
	n.addTunnel(t.getLabel(), g.getLabel());
	n.addTunnel(t.getLabel(), j.getLabel());
	
	n.addTunnel(u.getLabel(), b.getLabel());
	n.addTunnel(u.getLabel(), d.getLabel());
	
	n.addTunnel(v.getLabel(), c.getLabel());
	n.addTunnel(v.getLabel(), e.getLabel());
	
	n.addTunnel(w.getLabel(), u.getLabel());

	n.addTunnel(yyy.getLabel(), w.getLabel());
	n.addTunnel(yyy.getLabel(), a.getLabel());
	n.addTunnel(yyy.getLabel(), u.getLabel());
	n.addTunnel(yyy.getLabel(), b.getLabel());
	
	n.addTunnel(z.getLabel(), a.getLabel());
	n.addTunnel(z.getLabel(), c.getLabel());
	n.addTunnel(z.getLabel(), v.getLabel());
	
	
	
	
	Cave<Object> Destination;
	Cave<Object> StartingLocation;
	
	Stack<Cave<Object>> AllCaves = new Stack<Cave<Object>>(); // list of all caves
	
	AllCaves.add(a);
	AllCaves.add(b);
	AllCaves.add(c);
	AllCaves.add(d);
	AllCaves.add(e);
	AllCaves.add(f);
	AllCaves.add(g);
	AllCaves.add(h);
	AllCaves.add(i);
	AllCaves.add(j);
	AllCaves.add(k);
	AllCaves.add(l);
	AllCaves.add(m);
	AllCaves.add(nn);
	AllCaves.add(o);
	AllCaves.add(p);
	AllCaves.add(q);
	AllCaves.add(r);
	AllCaves.add(s);
	AllCaves.add(t);
	AllCaves.add(u);
	AllCaves.add(v);
	AllCaves.add(w);
	AllCaves.add(yyy);
	AllCaves.add(z);
	
	
	int LabelTrackerToFindDestinationLabel;
	
	Destination= AllCaves.pop(); 
	
	LabelTrackerToFindDestinationLabel= (int) Destination.getLabel();
	
	
	
	while (!AllCaves.isEmpty() && DestinationLabel!= LabelTrackerToFindDestinationLabel ) // searches until destination cave given is found
	{
		Destination= AllCaves.pop();
		LabelTrackerToFindDestinationLabel= (int) Destination.getLabel();
	}
	
	 AllCaves = new Stack<Cave<Object>>(); //creates new stack containing all caves
	
	AllCaves.add(a);
	AllCaves.add(b);
	AllCaves.add(c);
	AllCaves.add(d);
	AllCaves.add(e);
	AllCaves.add(f);
	AllCaves.add(g);
	AllCaves.add(h);
	AllCaves.add(i);
	AllCaves.add(j);
	AllCaves.add(k);
	AllCaves.add(l);
	AllCaves.add(m);
	AllCaves.add(nn);
	AllCaves.add(o);
	AllCaves.add(p);
	AllCaves.add(q);
	AllCaves.add(r);
	AllCaves.add(s);
	AllCaves.add(t);
	AllCaves.add(u);
	AllCaves.add(v);
	AllCaves.add(w);
	AllCaves.add(yyy);
	AllCaves.add(z);
	
	int LabelTrackerToFindStartingLabel;
	
	
	StartingLocation= AllCaves.pop();
	
	LabelTrackerToFindStartingLabel= (int) StartingLocation.getLabel();
	
	
	
	while (!AllCaves.isEmpty() && StartLabel!=LabelTrackerToFindStartingLabel ) // searches until destination cave given is found
	{
		StartingLocation= AllCaves.pop();
		LabelTrackerToFindStartingLabel= (int) StartingLocation.getLabel();
	}
	
	keyboard89.close();
	keyboard90.close();

	Destination.setExit();
	
	
	if (LabelTrackerToFindDestinationLabel ==(int) StartingLocation.getLabel())
	{
		System.out.println("You are at your destination already!");
	}
	 
	
	
	
	else
	{
		
		Cave<Object> exit = n.FindExit(StartingLocation);
	Stack<Cave<Object>> Pathway = new Stack<Cave<Object>>(); // contains all caves in path to exit

	
	System.out.println("To arrive at your destination, take the following path");
	
	Cave<Object> Path = exit;
	
	while (!Path.getPredecessor().equals(StartingLocation))
	{
		Path = Path.getPredecessor();
		Pathway.add(Path);
	}

	int count = 0;
	
	System.out.print(StartingLocation.getLabel()+ " ---> ");
	while (!Pathway.isEmpty())
	{
		
		count ++;
		System.out.print(Pathway.pop().getLabel()+ " ---> ");
		if (count % 8 == 0)
		{
			System.out.println(" ");
		}
	}

	System.out.println(exit.getLabel());
	
	}
	
	
		
	}
}

