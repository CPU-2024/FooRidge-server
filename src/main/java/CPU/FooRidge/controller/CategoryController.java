package CPU.FooRidge.controller;

import CPU.FooRidge.domain.Category;
import CPU.FooRidge.domain.User;
import CPU.FooRidge.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category createCategory=categoryService.addCategory(category);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId,@RequestBody Category updateCategory){
        categoryService.updateCategory(categoryId,updateCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
