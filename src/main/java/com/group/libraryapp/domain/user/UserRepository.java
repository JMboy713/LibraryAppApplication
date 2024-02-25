package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepo를 상속받으면 알아서 spring bean에 등록된다.
public interface UserRepository extends JpaRepository<User,Long> {// <entity, id>
    User findByName(String name); // 함수 이름을 작성하면 알아서 쿼리를 만들어준다.

    /*
    DataJPA
    find : 1건을 가져온다. 반환 타입은 Optional될수도 있고, 객체가 될 수 도 있다.
    findAll : 쿼리의 결과물이 N개인 경우 사용. List<> 반환
    exists: 존재 여부를 확인한다. boolean 반환
    count : SQL의 count(*)와 같다. long 반환 결과 개수 반환.

    */
}
