package com.projectToLearn.springProject.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
  private Long id;
  private String datePlaced;

  @OneToOne
  @JoinColumn(name="user_id")
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
  private CartDetail cartDetail;
}
