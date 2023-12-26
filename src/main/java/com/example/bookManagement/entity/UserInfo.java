package com.example.bookManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user_info")
@Data
public class UserInfo {
  @Id
  @Column(name="user_id")
  private String userId;
  private String password;

  /**
   * デフォルトコンストラクタ
   */
  public UserInfo() {
  }
}