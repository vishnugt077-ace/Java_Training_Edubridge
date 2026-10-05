import java.util.*;

abstract class LibraryItem {
    private String id, title;
    private boolean available = true;
    private Queue<Member> waitlist = new LinkedList<>();

    LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Queue<Member> getWaitlist() {
        return waitlist;
    }

    abstract String getType();

    abstract int getLoanDays();

    public double calculateFine(int days) {
        if (days > getLoanDays())
            return (days - getLoanDays()) * 2;
        return 0;
    }

    abstract String getDetails();
}

class Book extends LibraryItem {
    private String author;

    Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    String getType() {
        return "Book";
    }

    @Override
    int getLoanDays() {
        return 14;
    }

    @Override
    String getDetails() {
        return "Author: " + author;
    }
}

class Magazine extends LibraryItem {
    private int issueNo;

    Magazine(String id, String title, int issueNo) {
        super(id, title);
        this.issueNo = issueNo;
    }

    @Override
    String getType() {
        return "Magazine";
    }

    @Override
    int getLoanDays() {
        return 7;
    }

    @Override
    String getDetails() {
        return "Issue No: " + issueNo;
    }
}

class Member {
    private int id;
    private String name;
    private ArrayList<LibraryItem> borrowed = new ArrayList<>();

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<LibraryItem> getBorrowed() {
        return borrowed;
    }

    public boolean canBorrow() {
        return borrowed.size() < 3;
    }

    public boolean hasItem(LibraryItem item) {
        return borrowed.contains(item);
    }

    public void borrow(LibraryItem item) {
        borrowed.add(item);
    }

    public void giveBack(LibraryItem item) {
        borrowed.remove(item);
    }
}

public class LibraryManagementSystem {

    private HashMap<String, LibraryItem> items = new HashMap<>();
    private HashMap<Integer, Member> members = new HashMap<>();
    private int nextMemberId = 1;
    private Scanner sc = new Scanner(System.in);

    // Add Book
    void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();

        if (items.containsKey(id)) {
            System.out.println("ID already exists.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        items.put(id, new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    // Add Magazine
    void addMagazine() {
        System.out.print("Enter Magazine ID: ");
        String id = sc.nextLine();

        if (items.containsKey(id)) {
            System.out.println("ID already exists.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Issue Number: ");
        int issue = sc.nextInt();
        sc.nextLine();

        items.put(id, new Magazine(id, title, issue));
        System.out.println("Magazine added successfully.");
    }

    // Display all items
    void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        System.out.println("\nID\tType\tTitle\t\tStatus");

        for (LibraryItem item : items.values()) {
            String status = item.isAvailable()
                    ? "Available"
                    : "Issued";

            System.out.println(
                    item.getId() + "\t" +
                    item.getType() + "\t" +
                    item.getTitle() + "\t\t" +
                    status
            );
        }
    }

    // Register member
    void registerMember() {
        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        Member member = new Member(nextMemberId, name);
        members.put(nextMemberId, member);

        System.out.println(
                "Member registered. ID: " + nextMemberId
        );

        nextMemberId++;
    }

    // Issue item
    void issueItem() {
        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item ID: ");
        String itemId = sc.nextLine();

        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);

        if (member == null) {
            System.out.println("Unknown member ID.");
            return;
        }

        if (item == null) {
            System.out.println("Unknown item ID.");
            return;
        }

        if (member.hasItem(item)) {
            System.out.println("Member already has this item.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Member already holds 3 items.");
            return;
        }

        if (!item.isAvailable()) {

            if (item.getWaitlist().contains(member)) {
                System.out.println("Already in waitlist.");
                return;
            }

            item.getWaitlist().offer(member);

            System.out.println(
                    member.getName() +
                    " added to waitlist. Position: " +
                    item.getWaitlist().size()
            );

            return;
        }

        item.setAvailable(false);
        member.borrow(item);

        System.out.println(
                "\"" + item.getTitle() +
                "\" issued to " +
                member.getName()
        );

        System.out.println(
                "Due in " + item.getLoanDays() + " days."
        );
    }

    // Return item
    void returnItem() {
        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item ID: ");
        String itemId = sc.nextLine();

        System.out.print("Enter Days Kept: ");
        int days = sc.nextInt();
        sc.nextLine();

        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);

        if (member == null) {
            System.out.println("Unknown member ID.");
            return;
        }

        if (item == null) {
            System.out.println("Unknown item ID.");
            return;
        }

        if (!member.hasItem(item)) {
            System.out.println("Member does not have this item.");
            return;
        }

        member.giveBack(item);

        double fine = item.calculateFine(days);

        System.out.println(
                "Returned by " + member.getName()
        );

        if (fine > 0)
            System.out.println("Fine: Rs. " + fine);
        else
            System.out.println("No fine.");

        // Auto issue
        if (!item.getWaitlist().isEmpty()) {

            Member next = item.getWaitlist().poll();

            if (next.canBorrow()) {
                item.setAvailable(false);
                next.borrow(item);

                System.out.println(
                        "\"" + item.getTitle() +
                        "\" auto-issued to " +
                        next.getName()
                );

                System.out.println(
                        "Due in " + item.getLoanDays() + " days."
                );
            }
            else {
                item.setAvailable(true);
            }

        } else {
            item.setAvailable(true);

            System.out.println(
                    "\"" + item.getTitle() +
                    "\" is now available."
            );
        }
    }

    // Search
    void search() {
        System.out.print("Enter title or author: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;

        for (LibraryItem item : items.values()) {

            boolean match = item.getTitle()
                    .toLowerCase()
                    .contains(key);

            if (item instanceof Book) {
                Book book = (Book) item;

                if (book.getAuthor()
                        .toLowerCase()
                        .contains(key)) {
                    match = true;
                }
            }

            if (match) {
                String status = item.isAvailable()
                        ? "Available"
                        : "Issued";

                System.out.println(
                        item.getId() + " | " +
                        item.getType() + " | " +
                        item.getTitle() + " | " +
                        status
                );

                found = true;
            }
        }

        if (!found)
            System.out.println("No item found.");
    }

    // View member
    void viewMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Member member = members.get(id);

        if (member == null) {
            System.out.println("Unknown member ID.");
            return;
        }

        System.out.println("\nMember ID: " + member.getId());
        System.out.println("Name: " + member.getName());

        if (member.getBorrowed().isEmpty()) {
            System.out.println("No borrowed items.");
            return;
        }

        System.out.println("Borrowed Items:");

        for (LibraryItem item : member.getBorrowed()) {
            System.out.println(
                    item.getId() + " - " +
                    item.getTitle()
            );
        }
    }

    // Report
    void report() {
        int total = items.size();
        int issued = 0;

        for (LibraryItem item : items.values()) {
            if (!item.isAvailable())
                issued++;
        }

        int available = total - issued;

        System.out.println("\n===== LIBRARY REPORT =====");
        System.out.println("Total Items     : " + total);
        System.out.println("Issued Items    : " + issued);
        System.out.println("Available Items : " + available);
        System.out.println("Members         : " + members.size());
    }

    // Menu
    void menu() {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. View All Items");
            System.out.println("4. Register Member");
            System.out.println("5. Issue Item");
            System.out.println("6. Return Item");
            System.out.println("7. Search");
            System.out.println("8. View Member");
            System.out.println("9. Reports");
            System.out.println("10. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    addMagazine();
                    break;

                case 3:
                    viewItems();
                    break;

                case 4:
                    registerMember();
                    break;

                case 5:
                    issueItem();
                    break;

                case 6:
                    returnItem();
                    break;

                case 7:
                    search();
                    break;

                case 8:
                    viewMember();
                    break;

                case 9:
                    report();
                    break;

                case 10:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {

        LibraryManagementSystem library =
                new LibraryManagementSystem();

        library.menu();
    }
}
