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

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "tbl_jobs")
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Long minSalary;
    @Column(nullable = false)
    private Long maxSalary;
    @Column(nullable = false)
    private String location;
    @ManyToOne
    private Company company;
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
