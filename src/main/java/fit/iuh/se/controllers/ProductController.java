package fit.iuh.se.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fit.iuh.se.entities.Category;

import fit.iuh.se.entities.Product;
import fit.iuh.se.services.CategoryService;
import fit.iuh.se.services.ProductService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
   ProductService productService;

    @Autowired
    CategoryService categoryService;
    
    
    @GetMapping
    public String getList(Model model) {
        List<Product> pds = productService.findAll();
        model.addAttribute("pds", pds);
        return "product-list";
    }
    
    //Hiển thị form thêm
    @GetMapping("/add-product")
    public String add(Model model){
        Product add =new Product();
        List<Category> categories=categoryService.findAll();
    	model.addAttribute("categories", categories);
        model.addAttribute("addNewProduct", add);
        return "AddProduct";
    }

 // thêm mơi
    @PostMapping("/save")
    public String save(@ModelAttribute("addNewProduct") Product product) {
        
        productService.save(product);
        
        return "redirect:/products";
    }
    
 // Delete  by ID
    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id) {
    	productService.delete(id);
        return "redirect:/products";
    }
    
 // Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit-product/{id}")
    public String edit(Model model,@PathVariable("id") Integer id) {
        Product product = productService.findById(id); // Lấy sản phẩm theo ID
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
       // This corresponds to the EditProduct.html view
        model.addAttribute("updateProduct", product); // Pass the product object to the form
        return "Edit";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("updateProduct") Product product, @PathVariable("id") Integer id) {
    	 if (product.getId() != id) {
    	        throw new IllegalArgumentException("Product ID mismatch");
    	    }
    	productService.updateCategory(product);
        
        return "redirect:/products";
    }
    
    
    
 // Search products by keyword
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Product> products = productService.search(keyword); // Giả sử bạn có phương thức tìm kiếm trong service
        model.addAttribute("pds", products);  // Thêm vào model với tên "products"
        return "product-list";  // Trả về view product-list
    }

    
}
