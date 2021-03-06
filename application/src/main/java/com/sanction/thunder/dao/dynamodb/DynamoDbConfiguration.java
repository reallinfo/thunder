package com.sanction.thunder.dao.dynamodb;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Provides configuration options for DynamoDB.
 *
 * @see DynamoDbModule
 */
public class DynamoDbConfiguration {

  @NotEmpty
  @JsonProperty("endpoint")
  private final String endpoint = null;

  public String getEndpoint() {
    return endpoint;
  }

  @NotEmpty
  @JsonProperty("region")
  private final String region = null;

  public String getRegion() {
    return region;
  }

  @NotEmpty
  @JsonProperty("tableName")
  private final String tableName = null;

  public String getTableName() {
    return tableName;
  }
}
