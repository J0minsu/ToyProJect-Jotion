package msjo.jotion.zzodeng.Repository;

import msjo.jotion.zzodeng.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
