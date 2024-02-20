package CPU.FooRidge.service;

import CPU.FooRidge.domain.Category;
import CPU.FooRidge.domain.User;
import CPU.FooRidge.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(Long categoryId, Category updatedCategory){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setCategoryImage(updatedCategory.getCategoryName());
            category.setCategoryImage(updatedCategory.getCategoryImage());
            return categoryRepository.save(category);
        }
        return null;
    }
}
