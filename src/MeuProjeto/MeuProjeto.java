package MeuProjeto;
import java.util.Scanner;
public class MeuProjeto
{
	
	public static Scanner input = new Scanner (System.in);
	public static String addressbook [][] = new String [10][3];
	
	public static void cleanmatriz(String mm[][])
	{
		for (int line = 0; line < 10; line++)
		{
			for (int column = 0; column < 3; column++)
			{
				mm[line][column] = "";
			}
		}
	}
	
	public static void newcontact(String mm[][], int line)
	{
		System.out.println("--------------- FILL IN THE NEW CONTACT");
		System.out.println("Name: ");
		mm[line][0] = input.next();
		System.out.println("Cell phone: ");
		mm[line][1] = input.next();
		System.out.println("E-mail: ");
		mm[line][2] = input.next();
	}
	
	public static void editcontact(String mm[][], int line)
	{
		System.out.println("-----------EDIT CONTACT");
		System.out.println("Nome: " + mm[line][0]);
		
		System.out.println("Cell phone: ");
		mm[line][1] = input.next();
		System.out.println("E-mail: ");
		mm[line][2] = input.next();
	}
	
	public static int nextlinecontact(String mm[][])
	{
		for(int line = 0; line < 10; line++)
			if(mm[line][0].equals(""))
			{
				return line;
			}
		return -1;
	}
	
	public static void displaycontact(String mm[][], int line)
	{
		System.out.println("Name: " + mm[line][0]);
		System.out.println("Cell phone: " + mm[line][1]);
		System.out.println("E-mail: " + mm[line][2]);
	}
	
	public static void listaddressbook (String mm[][])
	{
		System.out.println("-------------ADDRESS BOOK CONTACTS");
		for(int line = 0; line < 10; line++)
		{
			if (mm[line][0] != "")
			{
				displaycontact (mm, line);
				System.out.println("---------------------------");
			}
		}
		System.out.println("-----------END ADDRESS BOOK");
	}
	
	public static int searchcontact(String mm [][], String name)
	{
		for (int line = 0; line < 10; line++)
			if (mm [line][0].equals(name))
			{
				return line;
			}
		return -1;
	}
	
	public static void deleteline (String mm[][], int line)
	{
		mm[line][0] = "";
		mm[line][1] = "";
		mm[line][2] = "";
		System.out.println("Deleted contact");
	}
	
	public static void deletecontact(String mm[][], String name)
	{
		boolean searched = false;
		int line = searchcontact (mm, name);
		String option;
		if (line != -1)
		{
			displaycontact(mm,line);
			System.out.println("\nConfirm the delete in the contact?");
			System.out.println("[Y}es or [N]o?");
			option = input.next();
			if (option.equals("Y") || option.equals("y"))
			{
				deleteline(mm, line);
			}
			else
			{
				System.out.println("Deletion canceled");
			}
		}
		else
		{
			System.out.println("Contact not found");
		}
		
	}
	
	public static void displaymenu()
	{
		System.out.println("--------MENU---------");
		System.out.println("1 - Add new contact");
		System.out.println("2 - Edit contact");
		System.out.println("3 - Search contact");
		System.out.println("4 - Address book ");
		System.out.println("5 - Delete a contact");
		System.out.println("6 - Left");
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner (System.in);
		int option, line;
		String name;
		
		cleanmatriz(addressbook);
		do
		{
			displaymenu();
			System.out.println("Choose an option: ");
			option = input.nextInt();
			System.out.println();
			
			switch(option)
			{
			case 1:
				newcontact (addressbook, nextlinecontact (addressbook));
				break;
				
			case 2:
				System.out.println("----------EDITING (search for contact): ");
				System.out.println("Enter the name: ");
				name = input.next();
				line = searchcontact(addressbook, name);
				if (line == -1)
				{
					System.out.println("Unregistered contact");
				}
				else
				{
					displaycontact(addressbook, line);
					editcontact(addressbook, line);
				}
				break;
				
			case 3:
				System.out.println("----------SEARCH FOR CONTACT");
				System.out.println("Enter the name: ");
				name = input.next();
				line = searchcontact(addressbook, name);
				if (line == -1)
				{
					System.out.println("Unregistered contact!");
				}
				else
				{
					displaycontact(addressbook, line);
				}
				break;
			case 4:
				listaddressbook(addressbook);
				break;
			case 5:
				System.out.println("DELETING (search the contact): ");
				name = input.next();
				name = input.next();
				deletecontact(addressbook, name);
				break;
				
			case 6:
				System.out.println("Thank you for using our address book!");
			}
			System.out.println("");
		}while(option != 6);
	}	            	
}
