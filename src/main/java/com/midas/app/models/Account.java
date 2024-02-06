
package com.midas.app.models;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @Column(name = "id")
  @GeneratedValue
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "created_at")
  @CreationTimestamp
  private OffsetDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private OffsetDateTime updatedAt;

  @Column(name = "provider_type")
  private String providerType;

  @Column(name = "provider_id")
  private String providerId;

public String getEmail() {
	// TODO Auto-generated method stub
	return email;
}

public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public OffsetDateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(OffsetDateTime createdAt) {
	this.createdAt = createdAt;
}

public OffsetDateTime getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(OffsetDateTime updatedAt) {
	this.updatedAt = updatedAt;
}

public String getProviderType() {
	return providerType;
}

public void setProviderType(String providerType) {
	this.providerType = providerType;
}

public String getProviderId() {
	return providerId;
}

public void setProviderId(String providerId) {
	this.providerId = providerId;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", providerType=" + providerType
			+ ", providerId=" + providerId + "]";
}

public static Object builder() {
	// TODO Auto-generated method stub
	return builder();
}


}
