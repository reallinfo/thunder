package com.sanction.thunder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.sanction.thunder.authentication.Key;

import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.validation.Validators;

import java.io.File;
import java.util.Arrays;
import javax.validation.Validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThunderConfigurationTest {
  private final ObjectMapper mapper = Jackson.newObjectMapper();
  private final Validator validator = Validators.newValidator();
  private final YamlConfigurationFactory<ThunderConfiguration> factory
      = new YamlConfigurationFactory<>(ThunderConfiguration.class, validator, mapper, "dw");

  @Test
  public void testFromYaml() throws Exception {
    ThunderConfiguration configuration = factory.build(
        new File(Resources.getResource("fixtures/config.yaml").toURI()));

    assertEquals("test.dynamodb.com", configuration.getDynamoConfiguration().getEndpoint());
    assertEquals("test-region-1", configuration.getDynamoConfiguration().getRegion());
    assertEquals("test-table", configuration.getDynamoConfiguration().getTableName());

    assertEquals("test.email.com", configuration.getEmailConfiguration().getEndpoint());
    assertEquals("test-region-2", configuration.getEmailConfiguration().getRegion());
    assertEquals("test@sanctionco.com", configuration.getEmailConfiguration().getFromAddress());

    assertEquals(
        Arrays.asList(new Key("test-app", "test-secret")),
        configuration.getApprovedKeys());
  }
}