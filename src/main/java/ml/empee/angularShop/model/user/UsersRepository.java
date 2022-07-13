package ml.empee.angularShop.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface UsersRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username); //TODO param validation

}
