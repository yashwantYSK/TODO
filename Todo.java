import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Todo
{
	public static void main(String[] args) throws IOException 
	{
		
		if(args.length!=0)
		{
			switch(args[0])
			{
				case "add" :
					if(args.length!=2)
					{
						System.out.println("Error: Missing todo string. Nothing added!");
					}
					else
					{
						add(args[1]);
					}
					break;
				case "ls" :
					File file=new File("todo.txt");
					file.createNewFile();
					ls();
					break;
				case "del" :
					if(args.length!=2)
					{
						System.out.println("Error: Missing NUMBER for deleting todo.");
					}
					else
					{
						int a2=Integer.parseInt(args[1]);
						del(a2);
					}
					break;
				case "done" :
					if(args.length !=2)
					{
						System.out.println("Error: Missing NUMBER for marking todo as done.");
					}
					else
					{
						int a3=Integer.parseInt(args[1]);
						done(a3);
					}
					break;
				case "help" :
					Usage();
					break;
				case "report" :
					report();
					break;
				default:
					Usage();
					break;
			}
		}
		else
		{
			Usage();
		}
	}

	private static void report() throws IOException 
	{
		int panding=0,complete=0;
		BufferedReader readder = new BufferedReader(new FileReader("todo.txt"));
		String line=readder.readLine();
		while(line!=null)
		{
			panding++;
			line=readder.readLine();
		}
		BufferedReader readder1 = new BufferedReader(new FileReader("done.txt"));
		String line1=readder1.readLine();
		while(line1!=null)
		{
			complete++;
			line1=readder1.readLine();
		}

		System.out.println(java.time.LocalDate.now()+" Pending : "+panding+" Completed : "+complete);
	}

	private static void done(int a3) throws IOException 
	{
		FileWriter fw = new FileWriter("temp.txt", true); 
		BufferedWriter bw = new BufferedWriter(fw); 
		PrintWriter pw = new PrintWriter(bw);
		BufferedReader readder = new BufferedReader(new FileReader("todo.txt"));
		String line=readder.readLine();
		int j=1;
		while(line!=null)
		{
			if(j!=a3)
				pw.println(line);
			else
			{
				FileWriter fw1 = new FileWriter("done.txt", true); 
				BufferedWriter bw1 = new BufferedWriter(fw1); 
				PrintWriter pw1 = new PrintWriter(bw1);
				pw1.println("X "+java.time.LocalDate.now()+" "+line);
				pw1.flush();
				bw1.close();
			}
			j++;
			line=readder.readLine();
			pw.flush();
		}
		bw.close();
		readder.close();
		File f1=new File("todo.txt");
		f1.delete();
		File f2=new File("temp.txt");
		f2.renameTo(f1);
		if(j-1<a3 || a3 == 0)
		{
			System.out.println("Error: todo #"+a3+" does not exist.");
		}
		else
		{
			System.out.println("Marked todo #"+a3+" as done.");
		}
	}

	private static void del(int a2) throws IOException 
	{
		FileWriter fw = new FileWriter("temp.txt", true); 
		BufferedWriter bw = new BufferedWriter(fw); 
		PrintWriter pw = new PrintWriter(bw);
		BufferedReader readder = new BufferedReader(new FileReader("todo.txt"));
		String line=readder.readLine();
		int j=1,i=0;
		while(line!=null)
		{
			if(j!=a2)
				pw.println(line);
			j++;
			
			line=readder.readLine();
			pw.flush();
		}
		bw.close();
		readder.close();
		File f1=new File("todo.txt");
		f1.delete();
		File f2=new File("temp.txt");
		f2.renameTo(f1);
		if(j-1 < a2 || a2==0)
		{
			System.out.println("Error: todo #"+a2+" does not exist. Nothing deleted.");
		}
		else
		{
			System.out.println("Deleted todo #"+a2);
		}
	}
	
	private static void ls() throws IOException 
	{
		ArrayList<String> item = new ArrayList<String>(); 
		BufferedReader readder = new BufferedReader(new FileReader("todo.txt"));
		String line=readder.readLine();
		while(line!=null)
		{
			item.add(line);
			line=readder.readLine();
		}
		readder.close();
		if(item.size()==0)
		{
			System.out.println("There are no pending todos!");
		}
		else
		{
			for(int i=item.size()-1;i>=0;i--)
			{
				int j=i+1;
				String s=item.get(i);
				System.out.print("["+j+"] "+ s+"\n");
			}
		}
	}

	private static void add(String arg) throws IOException
	{
		FileWriter fw = new FileWriter("todo.txt", true); 
		BufferedWriter bw = new BufferedWriter(fw); 
		PrintWriter pw = new PrintWriter(bw);
		pw.println(arg);
		pw.flush();
		System.out.println("Added todo: \""+arg+"\"");
		bw.close();
	}

	private static void Usage() 
	{
		System.out.print("Usage :-\n");
		System.out.print("$ ./todo add \"todo item\"  # Add a new todo\n$ ./todo ls               # Show remaining todos\n$ ./todo del NUMBER       # Delete a todo\n$ ./todo done NUMBER      # Complete a todo\n$ ./todo help             # Show usage\n$ ./todo report           # Statistics");
		
		
	}

}

