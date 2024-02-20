package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int categoryId;

    @Column(name = "name",nullable = false)
    private String categoryName;

    @Column(name = "image",nullable = false)
    private String categoryImage;

    public Category(){
    }

    public Category(String categoryName,String categoryImage){
        this.categoryName=categoryName;
        this.categoryImage=categoryImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
