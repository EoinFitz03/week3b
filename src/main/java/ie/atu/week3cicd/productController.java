package ie.atu.week3cicd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api/products")

public class productController {

    private List<Product> productList = new ArrayList<>();

    public productController() {
        productList.add(new Product("1", "TV", "Electronics", 600.0));
        productList.add(new Product("2", "Phone", "Electronics", 500.0));
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productList;
    }

   @PostMapping
    public Product addProduct(@RequestBody Product newProduct){
        productList.add(newProduct);
        return newProduct;
   }

    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable String id ,  @RequestBody Product uProduct){
        for(Product p : productList){
            if(p.getId().equals(id)){
                productList.remove(p);
            }
        }

        productList.add(uProduct);
        return ResponseEntity.ok(productList);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List>  deleteProduct(@PathVariable String id){
        for(Product p : productList){
            if(p.getId().equals(id)){
                productList.remove(p);
            }
        }
        return ResponseEntity.ok(productList);

    }


}
