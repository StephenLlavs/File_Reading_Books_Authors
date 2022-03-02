import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookInfoSys {

	static String userFileName;
	static Book[] booksArr = new Book[100];
	static int numOfBooks = 0;

	public static void main(String[] args) {

		// Displaying Title
		System.out.println("Welcome to Book Info.System.");


		while (true) {
			System.out.println("");
			System.out.println("Please select an option:\r\n" + "(R)ead books from file\r\n" + "(S)how all books\r\n"
					+ "(F)ind books by title\r\n" + "(E)xit\r\n" + "");
		
		// Asking users for Options
			Scanner board = new Scanner(System.in);
			System.out.print("Enter your option >> ");
			String userOption = board.nextLine();
		
			switch (userOption) {

			case "R":
				readFromFile();
				break;
			case "S":
				showAllBooks();
				break;
			case "F":
				findBooks();
				break;
			case "E":
				System.out.println("Thank You for Using!");
				System.exit(0);

				break;
			default:
				System.out.println("Input is Invalid");

			}
		}

	}

	// Finding Books for a certain keyword
	private static void findBooks() {
		Scanner board3 = new Scanner(System.in);
		System.out.print("Enter a key >> ");
		String userKeyword = board3.nextLine();
		int j = 0;
		
		try {
			for (int i = 0; i < numOfBooks; i++) {

				if(booksArr[i].getTitle().toLowerCase().contains(userKeyword.toLowerCase())) {
					System.out.println("Book # " + (i + 1) + ": ");
					System.out.println("Title: " + booksArr[i].getTitle());
					System.out.println("Authors: " + booksArr[i].getAuthors());
					System.out.println("Pages: " + booksArr[i].getPages());
					j++;
				}
				
			}
			System.out.println(j + " record(s) found.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Showing books within the the text files
	private static void showAllBooks() {
		try {
			for (int i = 0; i < numOfBooks; i++) {
				System.out.println("Book # " + (i + 1) + ": ");
				System.out.println("Title: " + booksArr[i].getTitle());
				System.out.println("Authors: " + booksArr[i].getAuthors());
				System.out.println("Pages: " + booksArr[i].getPages());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// Reading the texts within the files
	private static void readFromFile() {

		Scanner board1 = new Scanner(System.in);
		System.out.print("Enter the Filename >> ");
		userFileName = board1.nextLine();

		try {
			File myObj = new File(userFileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] bookData = data.split(",");
				String bookName = bookData[0];
				String bookAuthor = bookData[1];
				String bookPages = bookData[2];

				Book book1 = new Book(bookName, bookAuthor, bookPages);
				booksArr[numOfBooks] = book1;
				numOfBooks++;

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
