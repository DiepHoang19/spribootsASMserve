package spingboot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spingboot.example.entity.District;
import spingboot.example.repository.DistrictRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository productRepository;

    @Autowired
    public DistrictService(DistrictRepository productRespository) {
        this.productRepository = productRespository;
    }

    public List<District> findAll() {
        return productRepository.findAll();
    }

    public Optional<District> findById(Long id) {
        return productRepository.findById(id);
    }

    public District save(District stock) {
        return productRepository.save(stock);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
