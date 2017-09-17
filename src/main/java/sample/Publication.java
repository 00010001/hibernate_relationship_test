package sample;

import javax.persistence.*;

@Entity(name = "sample.Publication")
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue
    private Long id;

    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "isbn",
            referencedColumnName = "isbn"
    )
    private Book book;

    @Column(
            name = "price_in_cents",
            nullable = false
    )
    private Integer priceCents;

    private String currency;

    public Publication() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getPriceCents() {
        return priceCents;
    }

    public void setPriceCents(Integer priceCents) {
        this.priceCents = priceCents;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}