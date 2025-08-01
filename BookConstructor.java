public class BookConstructor {
    String title;
    String Author;
    int year;

    public BookConstructor(String bookTitle, String authorName, int yearOfPublication ){
        this.title = bookTitle;
        this.Author = authorName;
        this.year = yearOfPublication;
    }
    public void displayDetails(){
        System.out.println("Book Title: " + title);
        System.out.println("Author name: " + Author);
        System.out.println("Year of publication: " + year);
    }

    public static void main(String[] args) {
        BookConstructor B1 = new BookConstructor("Romeo & Juliet", "Mark Williams", 2008 );
        BookConstructor B2 = new BookConstructor("Far away", "Audrey Miles", 2015);

        B1.displayDetails();
        System.out.println();
        B2.displayDetails();

    }
}
