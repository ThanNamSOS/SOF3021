package SOF3021.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="products")
@Data
@NamedQueries(value = {
@NamedQuery(name = "Product.SearchProduct", 
			query = "SELECT pro From Product pro where pro.name = :name or pro.category = :category"),
})
public class Product {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@Column(name="price")
	private double price;
	
	@Column(name="created_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="available")
	private int available;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

}