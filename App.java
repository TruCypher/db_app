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
            	System.out.println("table doesn't exist return to the main application");
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
    		
    		String sql = "INSERT INTO EMPLOYEE (e_fName, e_lName, e_rank) VALUES " 
    				+ "('"+fName+"','"+lName+"','"+rank+"')";
    		
    		System.out.println();
    		try {
    			stmt.executeUpdate(sql);
    			System.out.println("insert to employee successfully returning to the main app");
    		} catch (SQLException e)
    		{
    			System.out.println("insertion failed returning to the main app");
    		}
    		
    	} 
    	else if (table.equals("PURCHASE")) 
    	{
    		System.out.print("please enter client id: ");
    		int c_id = kb.nextInt();
    		System.out.print("please enter shoe id: ");
    		int s_id = kb.nextInt();
    		System.out.print("please enter day client purchased: ");
    		String p_dayPurchase = kb.next();
    		System.out.print("please enter wheter or not the client return format: (true|false): ");
    		String returned = kb.next();
    		
    		String sql = "INSERT INTO PURCHASE (c_id, s_id, p_dayPurchase, p_return) VALUES "+
    		"("+c_id+","+s_id+",'"+p_dayPurchase+"','"+returned+"')";
    		
    		try {
    			stmt.executeUpdate(sql);
    			System.out.println("insert to purchase successfully returning to the main app");
    		}	catch (SQLException e)
    		{
    			System.out.println("insertion failed returning to the main app");
    		}
    		
    		
    	} else //SHOES
    	{
    		
    		System.out.print("please enter the quantity of shoes: ");
    		int quan = kb.nextInt();
    		System.out.print("please enter the internet rating format(1-10): ");
    		int rate = kb.nextInt();
    		System.out.print("please enter the shoe's brand name: ");
    		String brand = kb.next();
    		System.out.print("please enter the price of the shoe: ");
    		double price = kb.nextDouble();
    		
    		String sql = "INSERT INTO SHOES (s_quantity, s_rate, s_brandName, s_price) " + 
    				"VALUES ("+quan+","+rate+",'"+brand+"',"+price+")";
    		
    		System.out.println();
    		try {
    			stmt.executeUpdate(sql);
    			System.out.println("insert to shoes successfully returning to the main app");
    		}	catch (SQLException e)
    		{
    			System.out.println("insertion failed returning to the main app");
    		}
    			
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
    		String sql = "SELECT * FROM CLIENT";
    		try {
				ResultSet rs = stmt.executeQuery(sql);
				
				System.out.println("---------------------------------------------------------------------------------------------------");
			    System.out.printf("%10s %10s %10s %10s %10s %10s %10s", "c_id", "c_fName", "c_lName", "# Shoes", "day_joined","c_loyal" ,"e_id");
			    System.out.println();
			    System.out.println("---------------------------------------------------------------------------------------------------");
				while(rs.next()) 
				{
					
					System.out.format("%10s %10s %10s %10s %10s %10s %10s",
							rs.getObject(1).toString(),rs.getObject(2).toString(),rs.getObject(3).toString(),
							rs.getObject(4).toString(),rs.getObject(5).toString(),rs.getObject(6).toString(),
							rs.getObject(7).toString());
					
					System.out.println();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    	} 
    	else if (table.equals("EMPLOYEE")) 
    	{
    		String sql = "SELECT * FROM EMPLOYEE";
    		try {
				ResultSet rs = stmt.executeQuery(sql);
				
				System.out.println("---------------------------------------------------------------------------------------------------");
			    System.out.printf("%20s %20s %20s %20s", "e_id", "e_fName", "e_lName", "e_rank");
			    System.out.println();
			    System.out.println("---------------------------------------------------------------------------------------------------");
				while(rs.next()) 
				{
					
					System.out.format("%20s %20s %20s %20s",
							rs.getObject(1).toString(),rs.getObject(2).toString(),rs.getObject(3).toString(),
							rs.getObject(4).toString());
					
					System.out.println();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
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
