public class Card {

    private String code;
    private String image;
    private Images images;
    private String value;
    private String suit;

    public void setCode(String string) {
        this.code = string;
    }

    public void setImage(String string) {
        this.image = string;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public void setValue(String string) {
        this.value = string;

    }

    public void setSuit(String string) {
        this.suit = string;
    }

    public Object getCode() {
        return code;
    }

    public Object getImage() {
        return image;
    }

    public Images getImages() {
        return images;
    }

    public Object getValue() {
        return value;
    }

    public Object getSuit() {
        return suit;
    }

}
