
public class Book {

	private String authors;
	private String title;
	private String pages;

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public Book(String title, String authors,  String pages) {
		super();
		this.authors = authors;
		this.title = title;
		this.pages = pages;
	}
}
