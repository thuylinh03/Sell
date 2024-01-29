package sell.project.demo.enity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import java.util.ArrayList;
// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.CascadeType;

@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cateID")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "sort")
    private int sort;
    @Column(name = "metaKeywords")
    private String metaKeywords;
    @Column(name = "metaDescriptions")
    private String metaDescriptions;
    @Column(name = "createdBy")
    private int createdBy;
    @Column(name = "createdDate")
    private String createdDate;
    @Column(name = "updateBy")
    private int updateBy;
    @Column(name = "updateDate")
    private String updateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products = new ArrayList<>();

    public Categories() {
        super();
    }

    public Categories(int id, String name, String status, int sort, String metaKeywords, String metaDescriptions,

            int createdBy, String createdDate, int updateBy, String updateDate, List<Products> products) {

        this.id = id;
        this.name = name;
        this.status = status;
        this.sort = sort;
        this.metaKeywords = metaKeywords;
        this.metaDescriptions = metaDescriptions;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescriptions() {
        return metaDescriptions;
    }

    public void setMetaDescriptions(String metaDescriptions) {
        this.metaDescriptions = metaDescriptions;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
