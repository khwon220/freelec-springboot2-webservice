package com.jojolud.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    /**
     * Posts로 데이터베이스를 접근하게 해 줄 JpaRepository 생성
     * JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성
     * @Repository를 추가할 필요도 없지만 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다는 점
     *      - 둘은 아주 밀접한 관계이고 Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없기 때문
     *      - 도메인별로 프로젝트를 분리해야 한다면 Entity와 Repository는 함께 도메인 패키지에서 관리
     */

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    /**
     * SpringDataJpa에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 되는 것을 보여주기 위해 @Query 사용
     * 실제로는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결 가능
     * 가독성은 @Query가 훨씬 좋으니 선택해서 사용
     *
     * 조회 : querydsl, jooq, MyBatis 등의 프레임워크 중 하나를 통해 진행 (querydsl 추천)
     *      규모가 있는 프로젝트에서의 데이터 조회는 FK 조인 등 복잡한 조건으로 인해 Entity 클래스만으로 처리하기 어려움
     * 등록/수정/삭제 등 : SpringDataJpa를 통해 진행
     */
}
