package CPU.FooRidge.repository;

import CPU.FooRidge.domain.postImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PostImageRepository extends JpaRepository<postImage,Long> {

}
