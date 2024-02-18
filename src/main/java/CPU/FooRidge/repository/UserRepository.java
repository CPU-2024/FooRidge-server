package CPU.FooRidge.repository;

import CPU.FooRidge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserEmail(String userEmail);
}
