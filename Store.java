import java.util.ArrayList;

public class Store {
    public ArrayList<CISItem> items = new ArrayList<>();

    public ArrayList<CISItem> getItems() {
        return items;
    }

    public void addBook(Book b) {
        items.add(b);
    }

    public void addPhone(Phone p) {
        items.add(p);
    }

    public void addItems(CISItem i) {
        items.add(i);
    }

    public void updatePhonesLocation(String location) {
        Phone p = new Phone(null, null, 0, null, 0, null, null, null, null, 0);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getClass().getSimpleName().equals(p.getClass().getSimpleName())) {
                items.get(i).setLocaiton(location);
            }
        }
    }

    public ArrayList<Phone> getAllPhones() {
        ArrayList<Phone> phones = new ArrayList<>();
        Phone p = new Phone(null, null, 0, null, 0, null, null, null, null, 0);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getClass().getSimpleName().equals(p.getClass().getSimpleName())) {
                phones.add(((Phone) items.get(i)));
            }
        }
        return phones;
    }

    public ArrayList<CISItem> getItems(String itemType) {
        ArrayList<CISItem> itemTypeArrayList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getClass().getSimpleName().equalsIgnoreCase(itemType)) {
                itemTypeArrayList.add(items.get(i));
            }
        }
        return itemTypeArrayList;
    }

    public void updateItems(String itemType, String property, String value) {
        ArrayList<CISItem> itemTypeArrayList = getItems(itemType);
        for (int i = 0; i < itemTypeArrayList.size(); i++) {
            switch (property) {
                case "name":
                    itemTypeArrayList.get(i).setName(value);
                    break;
                case "price":
                    itemTypeArrayList.get(i).setPrice(Integer.valueOf(value));
                    break;
                case "location":
                    itemTypeArrayList.get(i).setLocaiton(value);
                    break;
                case "description":
                    itemTypeArrayList.get(i).setDescription(value);
                    break;
                default:
                    break;
            }
        }
        if (itemType.equalsIgnoreCase("book")) {
            for (int i = 0; i < itemTypeArrayList.size(); i++) {
                Book b = (Book) itemTypeArrayList.get(i);
                switch (property) {
                    case "isbn":
                        b.setIsbn(value);
                        itemTypeArrayList.set(i, b);
                        break;
                    case "edition":
                        b.setEdition(value);
                        itemTypeArrayList.set(i, b);
                        break;
                    case "title":
                        b.setTitle(value);
                        itemTypeArrayList.set(i, b);
                        break;
                    default:
                        break;
                }
            }
        } else if (itemType.equalsIgnoreCase("magazine")) {
            for (int i = 0; i < itemTypeArrayList.size(); i++) {
                Magazine m = (Magazine) itemTypeArrayList.get(i);
                switch (property) {
                    case "coverStoryTitle":
                        m.setCoverStoryTitle(value);
                        itemTypeArrayList.set(i, m);
                        break;
                    case "printDate":
                        m.setPrintDate(value);
                        itemTypeArrayList.set(i, m);
                        break;
                    default:
                        break;
                }
            }
        } else if (itemType.equalsIgnoreCase("phone")) {
            for (int i = 0; i < itemTypeArrayList.size(); i++) {
                Phone p = (Phone) itemTypeArrayList.get(i);
                switch (property) {
                    case "networkType":
                        p.setNetworkType(value);
                        itemTypeArrayList.set(i, p);
                        break;
                    case "screenSize":
                        p.setScreenSize( Integer.valueOf(value));
                        itemTypeArrayList.set(i, p);
                        break;
                    default:
                        break;
                }
            }
        } else if (itemType.equalsIgnoreCase("arduino")) {
            for (int i = 0; i < itemTypeArrayList.size(); i++) {
                Arduino a = (Arduino) itemTypeArrayList.get(i);
                a.setVersion(value);
                itemTypeArrayList.set(i, a);
            }
        }
    }

    public void showAllInfo() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).toString());
        }
    }
}
