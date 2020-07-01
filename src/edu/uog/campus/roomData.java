package edu.uog.campus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class roomData {
	Scanner scan = new Scanner(System.in);
	public char op;

	public void roomsDataOptions() {
		System.out.println("-------------------------------------------");
		System.out.println("       ------Accessed Room Data------      ");
		System.out.println("===========================================");
		System.out.println("       ------Enter Your Choice------       ");
		System.out.println("===========================================");
		System.out.println("1. For Viewing All The Records .");
		System.out.println("2. For Finding a Record.");
		System.out.println("3. For Searching A Record.");
		System.out.println("4. For Adding a New Record.");
		System.out.println("5. For Deleting a Record.");
		System.out.println("6. For Returning to Main Menu.");
		System.out.println("===========================================");
		do {
			System.out.println("Choice: ");
			op = scan.next().charAt(0);
			switch(op) {
			case '1':
				findAll();
				break;
			case '2':
				findOne(op);
				break;
			case '3':
				search(null);
				break;
			case '4':
				Save(null);
				break;
			case '5':
				//deleting();
				break;
			case '6':
				System.out.println("System Exiting....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input!!!!\nEnter Again!!!");
				break;
			}
			
		}while(!(op=='1'||op=='2'||op=='3'||op=='4'||op=='5'||op=='6'));
	}
	@SuppressWarnings("resource")
	public List<Room> findAll()  {
		List<Room> rooms = new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Room.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				room.setROOM_ID(Integer.parseInt(roomRow[0]));
				room.setROOM_NAME(roomRow[1]);
				room.setROOM_FLOUR(Integer.parseInt(roomRow[2]));
				room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
				room.setROOM_TYPE(roomRow[4]);
				
				rooms.add(room);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rooms;
	}

	@SuppressWarnings("resource")
	public Room findOne(int room_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Room.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				if (Integer.parseInt(roomRow[0]) == room_ID) {
					room.setROOM_ID(Integer.parseInt(roomRow[0]));
					room.setROOM_NAME(roomRow[1]);
					room.setROOM_FLOUR(Integer.parseInt(roomRow[2]));
					room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
					room.setROOM_TYPE(roomRow[4]);
					
					return room;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public List<Room> search(String search)  {
		List<Room> rooms = new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Room.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				if (roomRow[1].contains(search) == true) {
					room.setROOM_ID(Integer.parseInt(roomRow[0]));
					room.setROOM_NAME(roomRow[1]);
					room.setROOM_FLOUR(Integer.parseInt(roomRow[2]));
					room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
					room.setROOM_TYPE(roomRow[4]);
					
					rooms.add(room);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rooms;
	}

	public Room Save(Room room) {
		FileWriter filewriter;

		List<Room> rooms = this.findAll();

		try {
			filewriter = new FileWriter(Room.csvFile);

			for (int i=0; i<rooms.size(); i++) {
				filewriter.append(rooms.get(i).toString());
				filewriter.append("\n");
			}
			if (rooms.size()>0)
				room.setROOM_ID(rooms.get(rooms.size()-1).getROOM_ID()+1);
			else
				room.setROOM_ID(1);
			filewriter.append(room.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return room;
	}
}
