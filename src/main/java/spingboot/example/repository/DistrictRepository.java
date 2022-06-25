package spingboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spingboot.example.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
}
