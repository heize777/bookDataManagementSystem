package com.example.model;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String publisher;
    private Double price;

//    public Book(Integer id, String title, String author, String isbn, Integer publicationYear, String publisher, Double price) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//        this.publicationYear = publicationYear;
//        this.publisher = publisher;
//        this.price = price;
//    }
//
//    public Book(String title, String author, String isbn, Integer publicationYear, String publisher, Double price) {
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//        this.publicationYear = publicationYear;
//        this.publisher = publisher;
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
