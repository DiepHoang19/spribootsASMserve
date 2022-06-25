package spingboot.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spingboot.example.entity.District;
import spingboot.example.service.DistrictService;
import spingboot.example.validation.ProductIDExisting;
import spingboot.example.dto.ResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/district")
@Validated
@CrossOrigin("*")
public class DistrictApi {
    @Autowired
    DistrictService districtService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(districtService.findAll()).build();

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable @ProductIDExisting Long id) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(districtService.findById(id)).build();

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody District district) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.CREATED.toString())
                .body(districtService.save(district)).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody @Valid District district) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.ACCEPTED.toString())
                .body(districtService.save(district)).build();

        return ResponseEntity.accepted().body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable @ProductIDExisting Long id) {
        districtService.deleteById(id);

        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.ACCEPTED.toString()).build();

        return ResponseEntity.accepted().body(responseDTO);
    }
}