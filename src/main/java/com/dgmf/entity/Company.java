package com.dgmf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "tbl_companies")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
    //private List<Job> jobs = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
    // Hibernate will automatically take the
    // current Timestamp of the JVM
    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime creationDate;
    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    @JsonIgnore
    private boolean isActive = true;
}
