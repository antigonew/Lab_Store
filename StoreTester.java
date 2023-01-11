import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
public class StoreTester {

    @Test
    public void addBookTest() {
        Store store = new Store();
        Book book = new Book("Harry Potter", "Library", 90, "The first one", 10000, "2000", "JK Rowling", "9784883793341", "1", "Harry Potter & Sorceror's stone");
        store.addBook(book);
        assertTrue("FAIL", store.getItems().size() == 1);
    }

    @Test
    public void addBookPhoneTest() {
        Store store = new Store();
        Book book = new Book("Harry Potter", "Library", 90, "The first one", 10000, "2000", "JK Rowling", "9784883793341", "1", "Harry Potter & Sorceror's stone");
        store.addBook(book);
        Phone phone = new Phone("IPhone", "School",10000, "The latest version", 10, "2", "Apple", "One", "any", 10);
        store.addPhone(phone);
        assertTrue("FAIL", store.getItems().size() == 2);
    }

    @Test
    public void phonesLocationTest() {
        Store store = new Store();
        Phone phone1 = new Phone("IPhone", "School",10000, "The first version", 10, "1", "Apple", "One", "any", 10);
        Phone phone2 = new Phone("IPhone", "School",10000, "The second version", 10, "2", "Apple", "Two", "any", 10);
        Phone phone3 = new Phone("IPhone", "School",10000, "The third version", 10, "3", "Apple", "Three", "any", 10);
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.updatePhonesLocation("Room 514");
        ArrayList<Phone> phones = new ArrayList<>();
        phones = store.getAllPhones();
        for (int i = 0; i < phones.size(); i++) {
            assertEquals(phones.get(i).getLocation(), "Room 514");
        }
    }

    @Test
    public void getItemsTest() {
        Store store = new Store();
        Phone phone1 = new Phone("IPhone", "School1",10000, "The first version", 10, "1", "Apple", "One", "any", 10);
        Phone phone2 = new Phone("IPhone", "School2",10000, "The second version", 10, "2", "Apple", "Two", "any", 10);
        Phone phone3 = new Phone("IPhone", "School3",10000, "The third version", 10, "3", "Apple", "Three", "any", 10);
        Book book1 = new Book("Harry Potter", "Library", 90, "The first one", 10000, "2000", "JK Rowling", "9784883793341", "1", "Harry Potter & Sorceror's stone");
        Book book2 = new Book("Harry Potter", "Library", 90, "The second one", 10000, "2000", "JK Rowling", "9784883793341", "2", "Harry Potter & The chamber of Secrets");
        Book book3 = new Book("Harry Potter", "Library", 90, "The second one", 10000, "2000", "JK Rowling", "9784883793341", "3", "Harry Potter & The Prisoner of Azkaban");
        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        ArrayList<CISItem> allBooks = store.getItems("book");
        for (int i = 0; i < allBooks.size(); i++) {
            assertEquals(allBooks.get(i).getClass(), book1.getClass());
        }
        ArrayList<CISItem> allPhones = store.getItems("phone");
        for (int i = 0; i < allPhones.size(); i++) {
            assertEquals(allPhones.get(i).getClass(), phone1.getClass());
        }
    }

    @Test
    public void updateItemsTest() {
        Store store = new Store();
        Phone phone1 = new Phone("IPhone", "School1",10000, "The first version", 10, "1", "Apple", "One", "any", 10);
        Phone phone2 = new Phone("IPhone", "School2",10000, "The second version", 10, "2", "Apple", "Two", "any", 10);
        Phone phone3 = new Phone("IPhone", "School3",10000, "The third version", 10, "3", "Apple", "Three", "any", 10);
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.updateItems("phone", "networkType", "wifi");
        ArrayList<CISItem> storItems = store.getItems("phone");
        ArrayList<Phone> allPhones = new ArrayList<>();
        for (int i = 0; i < storItems.size(); i++) {
            allPhones.add((Phone)storItems.get(i));
        }
        for (int i = 0; i < allPhones.size(); i++) {
            assertEquals(allPhones.get(i).getNetworkType(), "wifi");
        }
    }

    @Test
    public void showAllInfo() {
        Store store = new Store();
        Phone phone1 = new Phone("IPhone", "School1",10000, "The first version", 10, "1", "Apple", "One", "any", 10);
        Phone phone2 = new Phone("IPhone", "School2",10000, "The second version", 10, "2", "Apple", "Two", "any", 10);
        Phone phone3 = new Phone("IPhone", "School3",10000, "The third version", 10, "3", "Apple", "Three", "any", 10);
        Book book1 = new Book("Harry Potter", "Library", 90, "The first one", 10000, "2000", "JK Rowling", "9784883793341", "1", "Harry Potter & Sorceror's stone");
        Book book2 = new Book("Harry Potter", "Library", 90, "The second one", 10000, "2000", "JK Rowling", "9784883793341", "2", "Harry Potter & The chamber of Secrets");
        Book book3 = new Book("Harry Potter", "Library", 90, "The third one", 10000, "2000", "JK Rowling", "9784883793341", "3", "Harry Potter & The Prisoner of Azkaban");
        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.showAllInfo();
    }
}
