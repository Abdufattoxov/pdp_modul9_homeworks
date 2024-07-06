package uz.pdp.modul9.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String originalName;
    private String generatedName;
    private long size;
    private String mimeType;
    private String uploadedPath;
}

