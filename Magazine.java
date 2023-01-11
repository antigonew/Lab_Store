public class Magazine extends ReadingItem {
    public Magazine(String name, String locaiton, int price, String description, int wordCount, String datePublished,
            String author) {
        super(name, locaiton, price, description, wordCount, datePublished, author);
    }

    private String coverStoryTitle;
    private String printDate;

    public String getCoverStoryTitle() {
        return coverStoryTitle;
    }

    public void setCoverStoryTitle(String coverStoryTitle) {
        this.coverStoryTitle = coverStoryTitle;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }
}
