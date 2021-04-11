import java.util.*;
import java.io.*;


class TicTacToe
{
	static HashSet<Integer> ur_set= new HashSet<Integer>();
	static HashSet<Integer> comp_set= new HashSet<Integer>();
	public static void main(String []args)
	{
	  char[][] g_boards ={
		{' ','|',' ','|',' '},
		{'-','|','-','|','-'},
		{' ','|',' ','|',' '},
		{'-','|','-','|','-'},
		{' ','|',' ','|',' '}
	  };
	  
	  print_board(g_boards);
	  
	 Scanner Sc =new Scanner(System.in);
	 while(true)
	 {
		 System.out.print("Enter Values from 1 to 9");
		 int user_pos=Sc.nextInt();
		 while(ur_set.contains(user_pos)||comp_set.contains(user_pos))
		 {
			 System.out.println();
			 System.out.print("Retry ,Enter values 1 to 9");
			 user_pos=Sc.nextInt();
		 }
		 print_holder(g_boards,user_pos,"You");
		 
		 String res = check_winner();
		 if(res.length()>0)
		 {
			 System.out.println(res);
			 break;
		 }
		 
		 
		 int cpu_pos=gen_random();
		 while(comp_set.contains(cpu_pos)||comp_set.contains(cpu_pos))
		 {
			 
			 cpu_pos= gen_random();
		 }
		 print_holder(g_boards,cpu_pos,"Computer");
		 res = check_winner();
		 if(res.length()>0)
		 {
			 System.out.println(res);
			 break;
		 }
	 }
	}
	
	static String check_winner()
	{
		HashSet<Integer> r1=new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer> r2=new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer> r3=new HashSet<Integer>();
		r3.add(7); r3.add(8);r3.add(9);
		HashSet<Integer> c1=new HashSet<Integer>();
		c1.add(1);c1.add(4);c1.add(7);
		HashSet<Integer> c2=new HashSet<Integer>();
		c2.add(2);c2.add(5);c2.add(8);
		HashSet<Integer> c3=new HashSet<Integer>();
		c3.add(3);c3.add(6);c3.add(9);
		HashSet<Integer> d1=new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		HashSet<Integer> d2=new HashSet<Integer>();
		d2.add(3); d2.add(5);d2.add(7);
		HashSet<HashSet> check = new 
		
		
	HashSet<HashSet>();
		check.add(r1);check.add(r2);check.add(r3);
		check.add(c1);check.add(c2);check.add(c3);
	    check.add(d1);check.add(d2);
		for(HashSet c : check) {
		if(ur_set.containsAll(c))
		return "YOU WON";
		else if (comp_set.containsAll(c))
		return "YOU LOSE";
		}
		if (ur_set.size()+comp_set.size()==9)
		return "ITS A DRAW";
		return "";
	}
	
	static int gen_random()
	{
		int max = 9;
		int min = 1;
		
		
		int range = max-min+1;
		int res = (int)(Math.random()*range)+min;
		return res;
	}
	static void print_board(char [][]g_boards)
	{
		for(int r=0;r<g_boards.length;r++)
		{
		   for(int c=0;c<g_boards[0].length;c++)
		   {
		      System.out.print(g_boards[r][c]);
		   }
		   System.out.println();
		}
	
	}
	
	static void print_holder(char [][]g_boards,int pos ,String user)
	{
		char symbol ='X';
		if(user.equals("You"))
		{
			symbol ='X';
			ur_set.add(pos);
		}
		else if(user.equals("Computer"))
		{
			symbol ='O';
			comp_set.add(pos);
		}
		
		switch(pos)
		{
			case 1:
			g_boards[0][0]=symbol;
			break;
			case 2:
			g_boards[0][2]=symbol;
			break;
			case 3:
			g_boards[0][4]=symbol;
			break;
			case 4:
			g_boards[2][0]=symbol;
			break;
			case 5:
			g_boards[2][2]=symbol;
			break;
			case 6:
			g_boards[2][4]=symbol;
			break;
			case 7:
			g_boards[4][0]=symbol;
			break;
			case 8:
			g_boards[4][2]=symbol;
			break;
			case 9:
			g_boards[4][4]=symbol;
			break;
			default:
			System.out.println("Enter Valid Input");
			
		}
		print_board(g_boards);
		
	}















}