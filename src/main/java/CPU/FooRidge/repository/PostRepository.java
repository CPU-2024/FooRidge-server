package CPU.FooRidge.repository;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);
}
