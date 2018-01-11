package fr.aston.guide.models;

/**
 * Created by kevin on 11/01/2018.
 */

public class Restaurant {
    private String name;
    private String category;
    private String email;
    private String phone;
    private String url;
    private String image;

    public Restaurant(String name, String category, String email, String phone, String url, String image) {
        this.setName(name);
        this.setCategory(category);
        this.setEmail(email);
        this.setPhone(phone);
        this.setUrl(url);
        this.setImage(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
