package projects.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projects.northwind.business.abstracts.ProductService;
import projects.northwind.core.utilities.results.DataResult;
import projects.northwind.core.utilities.results.Result;
import projects.northwind.entities.concretes.Product;

@RestController
@RequestMapping("api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productSerivice) {
		this.productService = productSerivice;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByproductName")
	public DataResult<Product> getByProductName(@RequestParam String productName)
	{
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId)
	{
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName)
	{
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPageSize")
	public DataResult<List<Product>> getAllByPageSize(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize)
	{
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted() 
	{
		return this.productService.getAllSorted();
	}
}
