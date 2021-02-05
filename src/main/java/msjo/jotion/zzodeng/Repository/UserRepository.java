package msjo.jotion.zzodeng.Repository;

import msjo.jotion.zzodeng.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, String> {

}
