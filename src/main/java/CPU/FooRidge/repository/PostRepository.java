package CPU.FooRidge.repository;

import CPU.FooRidge.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
