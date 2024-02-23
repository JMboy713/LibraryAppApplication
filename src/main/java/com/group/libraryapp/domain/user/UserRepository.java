package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepo를 상속받으면 알아서 spring bean에 등록된다.
public interface UserRepository extends JpaRepository<User,Long> {// <entity, id>

}
