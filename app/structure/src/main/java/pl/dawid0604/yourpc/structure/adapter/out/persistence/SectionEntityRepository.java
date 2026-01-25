/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface SectionEntityRepository extends JpaRepository<SectionEntity, Long> {

    @EntityGraph("SectionEntity.withParent")
    @Query("SELECT s FROM #{#entityName} s LEFT JOIN s.parent p WHERE p.slug = :slug")
    List<SectionEntity> findAllByParentSlug(@Param("slug") String parentSlug);

    @Query("SELECT s FROM #{#entityName} s WHERE s.parent IS NULL")
    List<SectionEntity> findAllWithNullableParent();
}
