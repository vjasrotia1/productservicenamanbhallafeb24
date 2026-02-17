package com.scaler.productservicenamanbhallafeb24.services;

import com.scaler.productservicenamanbhallafeb24.exceptions.ProductNotFoundException;
import com.scaler.productservicenamanbhallafeb24.models.Category;
import com.scaler.productservicenamanbhallafeb24.models.Product;
import com.scaler.productservicenamanbhallafeb24.repositories.CategoryRepository;
import com.scaler.productservicenamanbhallafeb24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
private ProductRepository productRepository;
private CategoryRepository categoryRepository;

//constructor injection
    public SelfProductService(ProductRepository productRepository,  CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();

    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product updateProduct(Long productId,
                                 String title,
                                 String description,
                                 Double price,
                                 String image,
                                 String categoryTitle) throws ProductNotFoundException {
        Product product= productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not present in DB"));
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category prodcategory = categoryRepository.findByTitle(categoryTitle);
        if (prodcategory == null) {
            prodcategory = new Category();
            prodcategory.setTitle(categoryTitle);
        }
        product.setCategory(prodcategory);
        return productRepository.save(product);
    }

    @Override
    public Product patchProduct(Long productId,
                                String title,
                                String description,
                                Double price,
                                String image,
                                String categoryTitle) throws ProductNotFoundException {

        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not present in DB"));
            if(title!=null){product.setTitle(title);}
            if(description!=null){product.setDescription(description);}
            if(price!=null){product.setPrice(price);}
            if(image!=null){product.setImageUrl(image);}
            if(categoryTitle!=null){
                Category prodcategory=categoryRepository.findByTitle(categoryTitle);
            if(prodcategory==null){
                prodcategory=new Category();
                prodcategory.setTitle(categoryTitle);
            }
                product.setCategory(prodcategory);
            }
            return  productRepository.save(product) ;
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findAllByCategory_titleIgnoreCase(categoryName);
    }

    @Override
    public void deleteProduct(Long productId) {
    productRepository.deleteById(productId);
    }

    @Override
    public Product createProduct(String title, String image, String description, String category, Double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setImageUrl(image);
        product.setDescription(description);
        product.setPrice(price);
        /*
        problems with category :
        1. category may not be saved unless cascade persist is configured
        2. duplicate categories
        with this logic : new Category(), it means :
        every product creates a new category
        even if say "electronics" category already exists
        ur database will end up like this :
        category_id, category_title
        1, electronics
        2,electronics
        3, electronics
        etc.
        so what is recommended ??
       Step 1: Look up the for  category, first in database
        Step 2: Assign it to product
        Step 3 : save the product

        you must either explicitly save the category or fetch an existing one to avoid errors and duplicate data.
         */
        Category prodcategory = categoryRepository.findByTitle(category);
        /*
        what this above line means ??
        “Ask the CategoryRepository to look in the database for a Category object
        whose title matches the value in String category, or we can say that CategoryRepository
        will check whether there is any id existing for this "title" or "categoryname" category
        and store that result in prodcategory
         */

        if (prodcategory == null) {
            //it means category not exists yet in DB, create new category object/table in database
            //first u create the object and then u make a call to database to save that category
            prodcategory = new Category();
            prodcategory.setTitle(category);
            //categoryRepository.save(prodcategory);
            /*
            if we are using cascade = cascade.PERSIST
            then we dont . have to save new Category in CategoryRepository
            i.e. categoryRepository.save(prodcategory);
            as cascade.PERSIST will do this job of saving the new Category in DB
            before saving the product.
            so this reduces the amount of code i hv to right
             */
        }
        product.setCategory(prodcategory);
        return productRepository.save(product);
    }
}
