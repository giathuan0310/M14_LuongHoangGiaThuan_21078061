package fit.iuh.se.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code")
	@NotEmpty(message = " must not be empty")
	private String code;
	
	
	@Column(name="name")
	@NotEmpty(message = "Full Name must not be empty")
	private String name;
	
	@Column(name="description")
	@NotEmpty(message = "Full Name must not be empty")
	private String description;
	
	@Column(name="register_date")
	@Past(message = "Date of birth must be before today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;
	
	 @Column(name = "is_active")
	 @NotEmpty(message = "isActive must be selected")
	  private String isActive;
	 
	 @ManyToOne 
	 @JoinColumn(name = "category_id")  // Khóa ngoại tham chiếu đến bảng category
	    private Category category;

	 
	 


	public Product() {
		super();
	}


	public Product(int id, @NotEmpty(message = " must not be empty") String code,
			@NotEmpty(message = "Full Name must not be empty") String name,
			@NotEmpty(message = "Full Name must not be empty") String description,
			@Past(message = "Date of birth must be before today") Date registerDate,
			@NotEmpty(message = "isActive must be selected") String isActive, Category category) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.registerDate = registerDate;
		this.isActive = isActive;
		this.category = category;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", registerDate=" + registerDate + ", isActive=" + isActive + ", category=" + category + "]";
	}


	


	
	

	
}
