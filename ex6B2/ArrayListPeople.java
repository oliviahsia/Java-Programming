package com.ait.ex6B2;

import java.util.ArrayList;
import java.util.Scanner;


public class ArrayListPeople {

	public static void main(String[] args) {
		
		ArrayList<Person> personList =new ArrayList<>() ; // Create a ArrayList to save a person object
		userChoice(personList);
	}
	
	public static void userChoice(ArrayList<Person> personList) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What do you want to do?");
		System.out.println("1. Add");
		System.out.println("2. Update");
		System.out.println("3. Delete a person");
		System.out.println("4. Delete everyone");
		System.out.println("5. Find a person");
		System.out.println("6. Display");
		System.out.println("7. Exit");
		
		int choice = in.nextInt();
		
		switch (choice) {
		case 1:
			add(personList);
			break;
		case 2:
			update(personList);
			break;
		case 3:
			deletePerson(personList);
			break;	
		case 4:
			deleteEveryone(personList);
			break;			
		case 5:
			findPersonByName(personList);
			break;		
		case 6:
			display(personList);
			break;
		case 7:
			System.exit(0);
			break;
		default:
			break;
		}
		
	}
	
	public static void add(ArrayList<Person> personList) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the persons name --> ");
		String name = in.next();
		
		int check = personThereAlready(name,personList);
		
		if (check == -1) {
			System.out.println("Enter the persons age --> ");
			int age = in.nextInt();
			
			Person person = new Person(name,age);
			personList.add(person);
			
		}else{
			System.out.println(name +" is already in the list...");
		}
		
		
		userChoice(personList);
		
		
	}
	
	public static int personThereAlready(String name,ArrayList<Person> personList) {
		
		for (int i = 0 ; i < personList.size();i++ ) {
			Person person = personList.get(i);
			
			 if (person.getName().equals(name)) {
		            return i; 
		        }
		    } 
		return -1;
			
		}
	
	public static void display(ArrayList<Person> personList) {
		for (int i = 0 ; i < personList.size();i++ ) {
			Person person = personList.get(i);
			System.out.println(person);
			
		}
		
		userChoice(personList);
	}
	
	public static void update(ArrayList<Person> personList) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the persons name you wish to change -->");
		String checkname = in.next();
		int check = personThereAlready(checkname,personList);
		
		if (check != -1) {
			System.out.println("Enter the new name --> ");
			String newName = in.next();
			
			System.out.println("Enter the new age --> ");
			int newAge = in.nextInt();
			
			Person person = new Person(newName,newAge);
			personList.set(check,person);
			System.out.println("The updated person's list : " + "["+ person + "]");
			
		}else{
			System.out.println(checkname +" is not in the list...");
		}
		userChoice(personList);
	}
	
	public static void deletePerson(ArrayList<Person> personList) {
		Scanner in = new Scanner(System.in);
		System.out.println("The person list before : " + "[" + personList.toString() +"]");
		
		System.out.println("Enter the persons name you wish to delete -->");
		String deleteName = in.next();
		int check = personThereAlready(deleteName,personList);
		
		if (check != -1) {
			personList.remove(check);
			System.out.println("The person list after : " + "["+ personList.toString() + "]");
			
		}else{
			System.out.println("Could not find that person!");
		}
		userChoice(personList);
	}

	
	public static void deleteEveryone(ArrayList<Person> personList) {
		personList.clear();
		userChoice(personList);
	}
	
	public static void findPersonByName(ArrayList<Person> personList) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the persons name  -->");
		String findName = in.next();
		
		int check = personThereAlready(findName,personList);
			
		if (check == -1) {
			System.out.println("Did NOT find person!");
			
		}else{
			System.out.println("Found person...");
		}	
		userChoice(personList);
	}
	
		
	}
	
	

