package org.example.wl2.model;

public class WishlistModel {

    private int id;
    private int userId;
    private String name;
    private String description;
    private double price;
    private String link;

    public WishlistModel(int id, int userId, String name, String description,double price,String link){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
    }

    public WishlistModel(String name, String description, double price, String link){
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;

    }
    public WishlistModel(){

    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

   /* public String toString(){
        return "name, " + name + " descriptions: " + description + " price: " + price + " Link = " + link;
    }

    */
}
