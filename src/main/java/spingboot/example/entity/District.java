package spingboot.example.entity;

import lombok.*;
import spingboot.example.validation.ProductIDExisting;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ProductIDExisting
    private Long id;

    @NotNull(message = "{NotNull.name}")
    private String name;
    private String district;
    private LocalDateTime founding;

    @Size(max = 100)
    private String description;



}