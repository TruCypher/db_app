package db_app.db_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
	static Statement stmt;
	static ResultSet rs;
	static Scanner kb;
	static Connection conn = null;
	static ArrayList<String> tableName;
	
	
    public static void main( String[] args )
    {
        
        while(true)
        {
        	try 
            {
               kb = new Scanner(System.in);
               conn = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/s19315_trunguyen?"+"user=s19315_trunguyen&password=641059");   
               stmt = conn.createStatement(); 
               String sql = "SELECT table_name FROM information_schema.tables where table_schema='s19315_trunguyen'";
               rs = stmt.executeQuery(sql);  
               tableName = new ArrayList<String>();
               
               System.out.println("here is the full list of table name: \n");
               
               int i = 1;
               while(rs.next())
               {
            	  tableName.add(rs.getString(1));
                  System.out.println(i + ". " + rs.getString(1));
                  i++;
               }
               
               rs.close();
               
               System.out.println();
               System.out.print("which table you wanted to select? or press -1 to exits ");
               
               int chooseTable = kb.nextInt();
               
               if(chooseTable == -1) {
            	   return;
               }
               System.out.println();
               System.out.println("Table "+tableName.get(chooseTable-1).toString()+" choosen");
               System.out.println("what do you want to do with it?");
               System.out.println("1. Insert");
    		   System.out.println("2. Update");
    		   System.out.println("3. Delete");
    		   System.out.println("4. Display all data");
    		   System.out.println("5. Search");
    		   System.out.println("6. Skip This Step");
    		   
    		   int option = kb.nextInt();
               switch(option)
               {
               		case 1:
               			insert(tableName.get(chooseTable-1));
               			break;
               		case 2:
               			update(tableName.get(chooseTable-1));
               			break;
               		case 3:
               			delete(tableName.get(chooseTable-1));
               			break;
               		case 4:
               			showAll(tableName.get(chooseTable-1));
               			break;
               		case 5:
               			search(tableName.get(chooseTable-1));
               			break;
               		default:
               			break;
               }
               
               
            } catch (SQLException ex) {
               System.out.println("SQLException: " + ex.getMessage());    
               System.out.println("SQLState: " + ex.getSQLState());    
               System.out.println("VendorError: " + ex.getErrorCode());
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
    }
    
    public static void insert(String table)
    {
    	System.out.println();
    	if(table.equals("CLIENT"))
    	{
    		System.out.print("please enter first name of client: ");
    		String fName = kb.next();
    		System.out.print("please enter last name of client: ");
    		String lName = kb.next();
    		System.out.print("please enter # of shoe(s) of client: ");
    		int shoes = kb.nextInt();
    		System.out.print("please enter the date client joined (format MM-DD-YYYY): ");
    		String day = kb.next();
    		System.out.print("please enter loyalty rating 1-10: ");
    		int loyal = kb.nextInt();
    		System.out.print("please enter employee id who in charge of this person");
    		int e_id = kb.nextInt();
    		
    		
    		
    		String sql = "INSERT INTO CLIENT (c_fName, c_lName, c_numShoes, c_dayJoined, c_loyal, e_id) VALUES "+
    		"('"+fName.toString()+"','"+lName.toString()+"',"+shoes+",'"+day+"',"+loyal+","+e_id+")";
    		
    		System.out.println();
    		try {
				stmt.executeUpdate(sql);
				System.out.println("insert successfully returning to the main application");
				
			} catch (SQLException e) {
				
				System.out.println("insert fail unable to insert the given data to the database");
//				e.printStackTrace();
			}
    	} 
    	else if (table.equals("EMPLOYEE")) 
    	{
    		System.out.print("please enter first name of employee: ");
    		String fName = kb.next();
    		System.out.print("please enter last name of employee: ");
    		String lName = kb.next();
    		System.out.print("please enter rank of employee: ");
    		String rank = kb.next();
    		
    		//+String sql
    		
    	} 
    	else if (table.equals("PURCHASE")) 
    	{
    		
    	} else //SHOES
    	{
    		
    	}
    }
    
    public static void update(String table)
    {
    	if(table.equals("CLIENT"))
    	{
    		
    	} 
    	else if (table.equals("EMPLOYEE")) 
    	{
    		
    	} 
    	else if (table.equals("PURCHASE")) 
    	{
    		
    	} else //SHOES
    	{
    		
    	}
    }
    
    public static void delete(String table)
    {
    	if(table.equals("CLIENT"))
    	{
    		
    	} 
    	else if (table.equals("EMPLOYEE")) 
    	{
    		
    	} 
    	else if (table.equals("PURCHASE")) 
    	{
    		
    	} else //SHOES
    	{
    		
    	}
    }
    
    public static void showAll(String table)
    {
    	if(table.equals("CLIENT"))
    	{
    		
    	} 
    	else if (table.equals("EMPLOYEE")) 
    	{
    		
    	} 
    	else if (table.equals("PURCHASE")) 
    	{
    		
    	} else //SHOES
    	{
    		
    	}
    }
    
    public static void search(String table)
    {
    	if(table.equals("CLIENT"))
    	{
    		
    	} 
    	else if (table.equals("EMPLOYEE")) 
    	{
    		
    	} 
    	else if (table.equals("PURCHASE")) 
    	{
    		
    	} else //SHOES
    	{
    		
    	}
    }
}
