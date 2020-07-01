package edu.uog;

import java.util.Scanner;

import edu.uog.campus.roomData;
import edu.uog.course.Course;
import edu.uog.course.courseOptions;

public class Option 
{
	courseOptions courseoptions = new courseOptions();
	roomData roomdata = new roomData();
	Course course = new Course();
	Scanner scan = new Scanner(System.in);
	public char op;

	public void optionSelect() {
		System.out.println("===========================================");
		System.out.println("           Enter Your Choice               ");
		System.out.println("===========================================");
		System.out.println("1. For Accessing Courses Data.");
		System.out.println("2. For Accessing Rooms Data.");
		System.out.println("3. For Accessing Students Data.");
		System.out.println("4. For Accessing Teachers Data.");
		System.out.println("5. For Accessing TimeTable.");
		System.out.println("6. For Exiting the system.");
		System.out.println("===========================================");
		do {
			System.out.println("Choice: ");
			op = scan.next().charAt(0);
			switch(op) {
			case '1':
				courseoptions.coursesDataOptions();
				break;
			case '2':
				roomdata.roomsDataOptions();
				break;
			case '3':
				studentsData();
				break;
			case '4':
				teachersData();
				break;
			case '5':
				timeTableData();
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
		public void coursesData() {
			System.out.println("accesed course data");
		}
		
		public void studentsData() {
			System.out.println("accesed students data");
		}
		public void teachersData() {
			System.out.println("accesed teachers data");
		}
		public void timeTableData() {
			System.out.println("accesed timetable data");
		}
}

