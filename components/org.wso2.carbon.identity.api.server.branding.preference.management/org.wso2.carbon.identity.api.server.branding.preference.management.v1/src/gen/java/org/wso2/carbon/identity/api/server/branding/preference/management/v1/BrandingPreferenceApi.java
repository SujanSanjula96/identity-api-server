/*
 * Copyright (c) 2021-2023, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.api.server.branding.preference.management.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import java.io.InputStream;
import java.util.List;

import org.wso2.carbon.identity.api.server.branding.preference.management.v1.model.BrandingPreferenceModel;
import org.wso2.carbon.identity.api.server.branding.preference.management.v1.model.CustomTextModel;
import org.wso2.carbon.identity.api.server.branding.preference.management.v1.model.Error;
import org.wso2.carbon.identity.api.server.branding.preference.management.v1.BrandingPreferenceApiService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import io.swagger.annotations.*;

import javax.validation.constraints.*;

@Path("/branding-preference")
@Api(description = "The branding-preference API")

public class BrandingPreferenceApi  {

    @Autowired
    private BrandingPreferenceApiService delegate;

    @Valid
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Add branding preferences for a tenant.", notes = "This API provides the capability to add a custom branding preference for a tenant/application.<br> Currently this API provides the capability to only configure tenant wise branding preference for 'en-US' locale.<br>   <b>Permission required:</b> <br>     * /permission/admin/manage/identity/applicationmgt/update <br>   <b>Scope required:</b> <br>     * internal_application_mgt_update ", response = BrandingPreferenceModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Branding Preference", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successfully created.", response = BrandingPreferenceModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class),
        @ApiResponse(code = 501, message = "Not Implemented.", response = Error.class)
    })
    public Response addBrandingPreference(@ApiParam(value = "This represents the branding preferences to be added." ,required=true) @Valid BrandingPreferenceModel brandingPreferenceModel) {

        return delegate.addBrandingPreference(brandingPreferenceModel );
    }

    @Valid
    @POST
    @Path("/text")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Add custom text for a tenant.", notes = "This API provides the capability to add custom texts for the specified screen & locale.<br>   <b>Permission required:</b> <br>     * /permission/admin/manage/identity/applicationmgt/update <br>   <b>Scope required:</b> <br>     * internal_application_mgt_update ", response = CustomTextModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Custom Text", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successfully created.", response = CustomTextModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class),
        @ApiResponse(code = 501, message = "Not Implemented.", response = Error.class)
    })
    public Response addCustomText(@ApiParam(value = "This represents the custom text to be added." ,required=true) @Valid CustomTextModel customTextModel) {

        return delegate.addCustomText(customTextModel );
    }

    @Valid
    @DELETE
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Deletes branding preferences of a tenant.", notes = "This API provides the capability to delete the branding preferences of a tenant/application.<br>   <b>Permission required:</b> <br>     * /permission/admin/manage/identity/applicationmgt/update <br>   <b>Scope required:</b> <br>     * internal_application_mgt_update ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Branding Preference", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successfully deleted.", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response deleteBrandingPreference(    @Valid@ApiParam(value = "Type to filter the retrieval of customizations.", allowableValues="ORG, APP, CUSTOM", defaultValue="ORG") @DefaultValue("ORG")  @QueryParam("type") String type,     @Valid@ApiParam(value = "Tenant/Application name to filter the retrieval of customizations.")  @QueryParam("name") String name,     @Valid@ApiParam(value = "Locale to filter the retrieval of customizations.", defaultValue="en-US") @DefaultValue("en-US")  @QueryParam("locale") String locale) {

        return delegate.deleteBrandingPreference(type,  name,  locale );
    }

    @Valid
    @DELETE
    @Path("/text")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Deletes custom text.", notes = "This API provides the capability to delete the custom texts for the specified screen & locale of a tenant.<br>   <b>Permission required:</b> <br>     * /permission/admin/manage/identity/applicationmgt/update <br>   <b>Scope required:</b> <br>     * internal_application_mgt_update ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Custom Text", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successfully deleted.", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response deleteCustomText(    @Valid@ApiParam(value = "Type to filter the retrieval of customizations.", allowableValues="ORG, APP, CUSTOM", defaultValue="ORG") @DefaultValue("ORG")  @QueryParam("type") String type,     @Valid@ApiParam(value = "Tenant/Application name to filter the retrieval of customizations.")  @QueryParam("name") String name,     @Valid@ApiParam(value = "Locale to filter the retrieval of customizations.", defaultValue="en-US") @DefaultValue("en-US")  @QueryParam("locale") String locale,     @Valid@ApiParam(value = "Screen to filter the retrieval of customizations.")  @QueryParam("screen") String screen) {

        return delegate.deleteCustomText(type,  name,  locale,  screen );
    }

    @Valid
    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get branding preference of a tenant.", notes = "This API provides the capability to retrieve the branding preference of a tenant/specific application.<br> If there is no branding preference available for the requested locale, API will check for the default locale('en-US') and return it.<br> If there is no branding preference available for the requested application, API will check for the tenant's branding preference and return it.<br>   <b>Permission required:</b> <br>     * None <br>   <b>Scope required:</b> <br>     * None ", response = BrandingPreferenceModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Branding Preference", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BrandingPreferenceModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response getBrandingPreference(    @Valid@ApiParam(value = "Type to filter the retrieval of customizations.", allowableValues="ORG, APP, CUSTOM", defaultValue="ORG") @DefaultValue("ORG")  @QueryParam("type") String type,     @Valid@ApiParam(value = "Tenant/Application name to filter the retrieval of customizations.")  @QueryParam("name") String name,     @Valid@ApiParam(value = "Locale to filter the retrieval of customizations.", defaultValue="en-US") @DefaultValue("en-US")  @QueryParam("locale") String locale) {

        return delegate.getBrandingPreference(type,  name,  locale );
    }

    @Valid
    @GET
    @Path("/text")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get Custom text of a tenant.", notes = "This API provides the capability to retrieve the existing custom text configurations of a tenant for the specified screen and locale.<br> If there is no custom texts available for the requested locale, API will check for the default locale('en-US') and return it.<br>   <b>Permission required:</b> <br>     * None <br>   <b>Scope required:</b> <br>     * None ", response = CustomTextModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Custom Text", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CustomTextModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response getCustomText(    @Valid@ApiParam(value = "Type to filter the retrieval of customizations.", allowableValues="ORG, APP, CUSTOM", defaultValue="ORG") @DefaultValue("ORG")  @QueryParam("type") String type,     @Valid@ApiParam(value = "Tenant/Application name to filter the retrieval of customizations.")  @QueryParam("name") String name,     @Valid@ApiParam(value = "Locale to filter the retrieval of customizations.", defaultValue="en-US") @DefaultValue("en-US")  @QueryParam("locale") String locale,     @Valid@ApiParam(value = "Screen to filter the retrieval of customizations.")  @QueryParam("screen") String screen) {

        return delegate.getCustomText(type,  name,  locale,  screen );
    }

    @Valid
    @GET
    @Path("/resolve")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Resolve branding preference of an organization.", notes = "This API provides the capability to retrieve the branding preference of an organization/specific application.<br> If there is no branding preference available for the requested locale, API will check for the default locale('en-US') and return it.<br> If there is no branding preference available for the requested application, API will check for the organization's branding preference and return it.<br>   <b>Permission required:</b> <br>     * None <br>   <b>Scope required:</b> <br>     * None ", response = BrandingPreferenceModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Branding Preference", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BrandingPreferenceModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response resolveBrandingPreference(    @Valid@ApiParam(value = "Type to filter the retrieval of customizations.", allowableValues="ORG, APP, CUSTOM", defaultValue="ORG") @DefaultValue("ORG")  @QueryParam("type") String type,     @Valid@ApiParam(value = "Tenant/Application name to filter the retrieval of customizations.")  @QueryParam("name") String name,     @Valid@ApiParam(value = "Locale to filter the retrieval of customizations.", defaultValue="en-US") @DefaultValue("en-US")  @QueryParam("locale") String locale) {

        return delegate.resolveBrandingPreference(type,  name,  locale );
    }

    @Valid
    @GET
    @Path("/text/resolve")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Resolve custom text of an organization.", notes = "This API provides the capability to retrieve the custom text configurations of an organization/specific application.<br> If there is no custom text available for the requested locale, API will check for the default locale('en-US') and return it.<br> If there is no custom text available for the requested organization, API will check for the parent organization's custom text configurations and return it.<br>   <b>Permission required:</b> <br>     * None <br>   <b>Scope required:</b> <br>     * None ", response = CustomTextModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Custom Text", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CustomTextModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response resolveCustomText(    @Valid@ApiParam(value = "Type to filter the retrieval of customizations.", allowableValues="ORG, APP, CUSTOM", defaultValue="ORG") @DefaultValue("ORG")  @QueryParam("type") String type,     @Valid@ApiParam(value = "Tenant/Application name to filter the retrieval of customizations.")  @QueryParam("name") String name,     @Valid@ApiParam(value = "Locale to filter the retrieval of customizations.", defaultValue="en-US") @DefaultValue("en-US")  @QueryParam("locale") String locale,     @Valid@ApiParam(value = "Screen to filter the retrieval of customizations.")  @QueryParam("screen") String screen) {

        return delegate.resolveCustomText(type,  name,  locale,  screen );
    }

    @Valid
    @PUT
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Update branding preferences of a tenant.", notes = "This API provides the capability to update the branding preference of a tenant/application.<br>   <b>Permission required:</b> <br>     * /permission/admin/manage/identity/applicationmgt/update <br>   <b>Scope required:</b> <br>     * internal_application_mgt_update ", response = BrandingPreferenceModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Branding Preference", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully updated", response = BrandingPreferenceModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response updateBrandingPreference(@ApiParam(value = "This represents the branding preferences to be updated." ,required=true) @Valid BrandingPreferenceModel brandingPreferenceModel) {

        return delegate.updateBrandingPreference(brandingPreferenceModel );
    }

    @Valid
    @PUT
    @Path("/text")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Update custom text of a tenant.", notes = "This API provides the capability to update the custom texts for the specified screen & locale.<br>   <b>Permission required:</b> <br>     * /permission/admin/manage/identity/applicationmgt/update <br>   <b>Scope required:</b> <br>     * internal_application_mgt_update ", response = CustomTextModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "Custom Text" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully updated", response = CustomTextModel.class),
        @ApiResponse(code = 400, message = "Invalid input in the request.", response = Error.class),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid.", response = Void.class),
        @ApiResponse(code = 403, message = "Access forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Requested resource is not found.", response = Error.class),
        @ApiResponse(code = 500, message = "Internal server error.", response = Error.class)
    })
    public Response updateCustomText(@ApiParam(value = "This represents the custom text content to be updated for the specified screen & locale." ,required=true) @Valid CustomTextModel customTextModel) {

        return delegate.updateCustomText(customTextModel );
    }

}
