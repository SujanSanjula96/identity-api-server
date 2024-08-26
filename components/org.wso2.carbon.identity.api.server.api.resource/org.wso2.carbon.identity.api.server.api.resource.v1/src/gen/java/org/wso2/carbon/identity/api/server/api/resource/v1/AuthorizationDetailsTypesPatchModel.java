/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.api.server.api.resource.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class AuthorizationDetailsTypesPatchModel  {
  
    private String name;
    private String description;
    private Map<String, Object> schema = new HashMap<String, Object>();


    /**
    * display name of the authorization details type
    **/
    public AuthorizationDetailsTypesPatchModel name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "Payment Initiation", required = true, value = "display name of the authorization details type")
    @JsonProperty("name")
    @Valid
    @NotNull(message = "Property name cannot be null.")
 @Size(min=3,max=255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * description of the authorization details type
    **/
    public AuthorizationDetailsTypesPatchModel description(String description) {

        this.description = description;
        return this;
    }
    
    @ApiModelProperty(example = "Payment initiation authorization details type", required = true, value = "description of the authorization details type")
    @JsonProperty("description")
    @Valid
    @NotNull(message = "Property description cannot be null.")

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    * Accepts the [JSON Schema document](https://json-schema.org/draft/2020-12/json-schema-core#name-json-schema-documents) of the authorization details type
    **/
    public AuthorizationDetailsTypesPatchModel schema(Map<String, Object> schema) {

        this.schema = schema;
        return this;
    }
    
    @ApiModelProperty(example = "{\"type\":\"object\",\"required\":[\"type\",\"actions\",\"locations\",\"instructedAmount\"],\"properties\":{\"type\":{\"type\":\"string\",\"enum\":[\"payment_initiation\"]},\"actions\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"enum\":[\"initiate\",\"cancel\"]}},\"locations\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"format\":\"uri\"}},\"instructedAmount\":{\"type\":\"object\",\"properties\":{\"currency\":{\"type\":\"string\",\"minLength\":3},\"amount\":{\"type\":\"string\"}}},\"creditorName\":\"string\",\"creditorAccount\":{\"type\":\"object\"}}}", required = true, value = "Accepts the [JSON Schema document](https://json-schema.org/draft/2020-12/json-schema-core#name-json-schema-documents) of the authorization details type")
    @JsonProperty("schema")
    @Valid
    @NotNull(message = "Property schema cannot be null.")

    public Map<String, Object> getSchema() {
        return schema;
    }
    public void setSchema(Map<String, Object> schema) {
        this.schema = schema;
    }


    public AuthorizationDetailsTypesPatchModel putSchemaItem(String key, Object schemaItem) {
        this.schema.put(key, schemaItem);
        return this;
    }

    

    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthorizationDetailsTypesPatchModel authorizationDetailsTypesPatchModel = (AuthorizationDetailsTypesPatchModel) o;
        return Objects.equals(this.name, authorizationDetailsTypesPatchModel.name) &&
            Objects.equals(this.description, authorizationDetailsTypesPatchModel.description) &&
            Objects.equals(this.schema, authorizationDetailsTypesPatchModel.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, schema);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class AuthorizationDetailsTypesPatchModel {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

