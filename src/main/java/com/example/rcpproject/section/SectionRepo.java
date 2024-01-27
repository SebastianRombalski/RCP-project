package com.example.rcpproject.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SectionRepo extends JpaRepository<Section,Long> {

}
