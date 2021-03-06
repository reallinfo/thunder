package com.sanction.thunder;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.sanction.thunder.authentication.Key;
import com.sanction.thunder.dao.dynamodb.DynamoDbConfiguration;
import com.sanction.thunder.email.EmailConfiguration;
import com.sanction.thunder.validation.PropertyValidationRule;

import io.dropwizard.Configuration;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Provides configuration options that are defined at the top level of the
 * configuration file.
 *
 * @see ThunderModule
 */
class ThunderConfiguration extends Configuration {

  @NotNull
  @Valid
  @JsonProperty("dynamo")
  private final DynamoDbConfiguration dynamoConfiguration = null;

  DynamoDbConfiguration getDynamoConfiguration() {
    return dynamoConfiguration;
  }

  @NotNull
  @Valid
  @JsonProperty("ses")
  private final EmailConfiguration emailConfiguration = null;

  EmailConfiguration getEmailConfiguration() {
    return emailConfiguration;
  }

  @NotNull
  @Valid
  @JsonProperty("approvedKeys")
  private final List<Key> approvedKeys = null;

  List<Key> getApprovedKeys() {
    return approvedKeys;
  }

  /* Optional configuration options */

  @Valid
  @JsonProperty("properties")
  private final List<PropertyValidationRule> validationRules = null;

  List<PropertyValidationRule> getValidationRules() {
    return validationRules;
  }
}
