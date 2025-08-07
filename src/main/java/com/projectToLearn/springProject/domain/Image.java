package com.projectToLearn.springProject.domain;

import java.sql.Blob;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="file_name")
  private String fileName;

  @Column(name="file_type")
  private String fileType;

  @Lob
  @Column(name="image")
  private Blob image;

  @Column(name="download_url")
  private String downloadUrl;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="product_id")
  private Product product;
  
}
