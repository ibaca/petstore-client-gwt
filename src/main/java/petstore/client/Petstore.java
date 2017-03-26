package petstore.client;

import com.intendia.gwt.autorest.client.AutoRestGwt;
import java.lang.Number;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.List;
import javax.annotation.Nullable;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import rx.Observable;
import rx.Single;

@AutoRestGwt
@Path("/v2")
@SuppressWarnings("unused")
public interface Petstore {
  /**
   *
   *
   * <pre>Operation{tags=[pet], summary=Add a new pet to the store, operationId=addPet, consumes=[application/json, application/xml], produces=[application/xml, application/json], parameters=[Parameter{name=body, in=body, required=true, schema=Schema{$ref=#/definitions/Pet}}], responses={405=Response{}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet")
  @POST
  Observable<Void> post_pet(Pet body);

  /**
   *
   *
   * <pre>Operation{tags=[pet], summary=Update an existing pet, operationId=updatePet, consumes=[application/json, application/xml], produces=[application/xml, application/json], parameters=[Parameter{name=body, in=body, required=true, schema=Schema{$ref=#/definitions/Pet}}], responses={400=Response{}, 404=Response{}, 405=Response{}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet")
  @PUT
  Observable<Void> put_pet(Pet body);

  /**
   * Multiple status values can be provided with comma separated strings
   *
   * <pre>Operation{tags=[pet], summary=Finds Pets by status, operationId=findPetsByStatus, produces=[application/xml, application/json], parameters=[Parameter{name=status, in=query, required=true, type=array, items=Schema{type=string}, collectionFormat=multi}], responses={200=Response{schema=Schema{type=array, items=Schema{$ref=#/definitions/Pet}}}, 400=Response{}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet/findByStatus")
  @GET
  Observable<Pet> get_pet_findByStatus(@QueryParam("status") List<String> status);

  /**
   * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
   *
   * <pre>Operation{tags=[pet], summary=Finds Pets by tags, operationId=findPetsByTags, produces=[application/xml, application/json], parameters=[Parameter{name=tags, in=query, required=true, type=array, items=Schema{type=string}, collectionFormat=multi}], responses={200=Response{schema=Schema{type=array, items=Schema{$ref=#/definitions/Pet}}}, 400=Response{}}, deprecated=true, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet/findByTags")
  @GET
  Observable<Pet> get_pet_findByTags(@QueryParam("tags") List<String> tags);

  /**
   *
   *
   * <pre>Operation{tags=[pet], summary=Deletes a pet, operationId=deletePet, produces=[application/xml, application/json], parameters=[Parameter{name=api_key, in=header, required=false, type=string}, Parameter{name=petId, in=path, required=true, type=integer, format=int64}], responses={400=Response{}, 404=Response{}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet/{petId}")
  @DELETE
  Observable<Void> delete_pet(@HeaderParam("api_key") @Nullable String api_key, @PathParam("petId") Number petId);

  /**
   *
   *
   * <pre>Operation{tags=[pet], summary=Updates a pet in the store with form data, operationId=updatePetWithForm, consumes=[application/x-www-form-urlencoded], produces=[application/xml, application/json], parameters=[Parameter{name=petId, in=path, required=true, type=integer, format=int64}, Parameter{name=name, in=formData, required=false, type=string}, Parameter{name=status, in=formData, required=false, type=string}], responses={405=Response{}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet/{petId}")
  @POST
  Observable<Void> post_pet(@PathParam("petId") Number petId, @Nullable String name, @Nullable String status);

  /**
   * Returns a single pet
   *
   * <pre>Operation{tags=[pet], summary=Find pet by ID, operationId=getPetById, produces=[application/xml, application/json], parameters=[Parameter{name=petId, in=path, required=true, type=integer, format=int64}], responses={200=Response{schema=Schema{$ref=#/definitions/Pet}}, 400=Response{}, 404=Response{}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet/{petId}")
  @GET
  Single<Pet> get_pet(@PathParam("petId") Number petId);

  /**
   *
   *
   * <pre>Operation{tags=[pet], summary=uploads an image, operationId=uploadFile, consumes=[multipart/form-data], produces=[application/json], parameters=[Parameter{name=petId, in=path, required=true, type=integer, format=int64}, Parameter{name=additionalMetadata, in=formData, required=false, type=string}, Parameter{name=file, in=formData, required=false, type=file}], responses={200=Response{schema=Schema{$ref=#/definitions/ApiResponse}}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/pet/{petId}/uploadImage")
  @POST
  Single<ApiResponse> post_pet_uploadImage(@PathParam("petId") Number petId, @Nullable String additionalMetadata, @Nullable Object file);

  /**
   * Returns a map of status codes to quantities
   *
   * <pre>Operation{tags=[store], summary=Returns pet inventories by status, operationId=getInventory, produces=[application/json], parameters=[], responses={200=Response{schema=Schema{type=object}}}, security=[SecurityRequirement{}]}</pre>
   */
  @Path("/store/inventory")
  @GET
  Single<Object> get_store_inventory();

  /**
   *
   *
   * <pre>Operation{tags=[store], summary=Place an order for a pet, operationId=placeOrder, produces=[application/xml, application/json], parameters=[Parameter{name=body, in=body, required=true, schema=Schema{$ref=#/definitions/Order}}], responses={200=Response{schema=Schema{$ref=#/definitions/Order}}, 400=Response{}}}</pre>
   */
  @Path("/store/order")
  @POST
  Single<Order> post_store_order(Order body);

  /**
   * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
   *
   * <pre>Operation{tags=[store], summary=Delete purchase order by ID, operationId=deleteOrder, produces=[application/xml, application/json], parameters=[Parameter{name=orderId, in=path, required=true, type=integer, format=int64}], responses={400=Response{}, 404=Response{}}}</pre>
   */
  @Path("/store/order/{orderId}")
  @DELETE
  Observable<Void> delete_store_order(@PathParam("orderId") Number orderId);

  /**
   * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions
   *
   * <pre>Operation{tags=[store], summary=Find purchase order by ID, operationId=getOrderById, produces=[application/xml, application/json], parameters=[Parameter{name=orderId, in=path, required=true, type=integer, format=int64}], responses={200=Response{schema=Schema{$ref=#/definitions/Order}}, 400=Response{}, 404=Response{}}}</pre>
   */
  @Path("/store/order/{orderId}")
  @GET
  Single<Order> get_store_order(@PathParam("orderId") Number orderId);

  /**
   * This can only be done by the logged in user.
   *
   * <pre>Operation{tags=[user], summary=Create user, operationId=createUser, produces=[application/xml, application/json], parameters=[Parameter{name=body, in=body, required=true, schema=Schema{$ref=#/definitions/User}}], responses={default=Response{}}}</pre>
   */
  @Path("/user")
  @POST
  Observable<Void> post_user(User body);

  /**
   *
   *
   * <pre>Operation{tags=[user], summary=Creates list of users with given input array, operationId=createUsersWithArrayInput, produces=[application/xml, application/json], parameters=[Parameter{name=body, in=body, required=true, schema=Schema{type=array, items=Schema{$ref=#/definitions/User}}}], responses={default=Response{}}}</pre>
   */
  @Path("/user/createWithArray")
  @POST
  Observable<Void> post_user_createWithArray(List<User> body);

  /**
   *
   *
   * <pre>Operation{tags=[user], summary=Creates list of users with given input array, operationId=createUsersWithListInput, produces=[application/xml, application/json], parameters=[Parameter{name=body, in=body, required=true, schema=Schema{type=array, items=Schema{$ref=#/definitions/User}}}], responses={default=Response{}}}</pre>
   */
  @Path("/user/createWithList")
  @POST
  Observable<Void> post_user_createWithList(List<User> body);

  /**
   *
   *
   * <pre>Operation{tags=[user], summary=Logs user into the system, operationId=loginUser, produces=[application/xml, application/json], parameters=[Parameter{name=username, in=query, required=true, type=string}, Parameter{name=password, in=query, required=true, type=string}], responses={200=Response{schema=Schema{type=string}, headers={X-Rate-Limit=com.intendia.openapi.OpenApi$Header@19dfb72a, X-Expires-After=com.intendia.openapi.OpenApi$Header@17c68925}}, 400=Response{}}}</pre>
   */
  @Path("/user/login")
  @GET
  Single<String> get_user_login(@QueryParam("username") String username, @QueryParam("password") String password);

  /**
   *
   *
   * <pre>Operation{tags=[user], summary=Logs out current logged in user session, operationId=logoutUser, produces=[application/xml, application/json], parameters=[], responses={default=Response{}}}</pre>
   */
  @Path("/user/logout")
  @GET
  Observable<Void> get_user_logout();

  /**
   * This can only be done by the logged in user.
   *
   * <pre>Operation{tags=[user], summary=Delete user, operationId=deleteUser, produces=[application/xml, application/json], parameters=[Parameter{name=username, in=path, required=true, type=string}], responses={400=Response{}, 404=Response{}}}</pre>
   */
  @Path("/user/{username}")
  @DELETE
  Observable<Void> delete_user(@PathParam("username") String username);

  /**
   *
   *
   * <pre>Operation{tags=[user], summary=Get user by user name, operationId=getUserByName, produces=[application/xml, application/json], parameters=[Parameter{name=username, in=path, required=true, type=string}], responses={200=Response{schema=Schema{$ref=#/definitions/User}}, 400=Response{}, 404=Response{}}}</pre>
   */
  @Path("/user/{username}")
  @GET
  Single<User> get_user(@PathParam("username") String username);

  /**
   * This can only be done by the logged in user.
   *
   * <pre>Operation{tags=[user], summary=Updated user, operationId=updateUser, produces=[application/xml, application/json], parameters=[Parameter{name=username, in=path, required=true, type=string}, Parameter{name=body, in=body, required=true, schema=Schema{$ref=#/definitions/User}}], responses={400=Response{}, 404=Response{}}}</pre>
   */
  @Path("/user/{username}")
  @PUT
  Observable<Void> put_user(@PathParam("username") String username, User body);

  /**
   * api.Api.ApiResponse
   *
   * <pre>Schema{type=object, properties={code=Schema{type=integer, format=int32}, type=Schema{type=string}, message=Schema{type=string}}}</pre>
   */
  @JsType(
          isNative = true,
          namespace = JsPackage.GLOBAL,
          name = "Object"
  )
  class ApiResponse {
    /**
     * code
     *
     * <pre>Schema{type=integer, format=int32}</pre>
     */
    public Number code;

    /**
     * type
     *
     * <pre>Schema{type=string}</pre>
     */
    public String type;

    /**
     * message
     *
     * <pre>Schema{type=string}</pre>
     */
    public String message;
  }

  /**
   * api.Api.Category
   *
   * <pre>Schema{type=object, properties={id=Schema{type=integer, format=int64}, name=Schema{type=string}}}</pre>
   */
  @JsType(
          isNative = true,
          namespace = JsPackage.GLOBAL,
          name = "Object"
  )
  class Category {
    /**
     * id
     *
     * <pre>Schema{type=integer, format=int64}</pre>
     */
    public Number id;

    /**
     * name
     *
     * <pre>Schema{type=string}</pre>
     */
    public String name;
  }

  /**
   * api.Api.Order
   *
   * <pre>Schema{type=object, properties={id=Schema{type=integer, format=int64}, petId=Schema{type=integer, format=int64}, quantity=Schema{type=integer, format=int32}, shipDate=Schema{type=string, format=date-time}, status=Schema{type=string}, complete=Schema{type=boolean}}}</pre>
   */
  @JsType(
          isNative = true,
          namespace = JsPackage.GLOBAL,
          name = "Object"
  )
  class Order {
    /**
     * id
     *
     * <pre>Schema{type=integer, format=int64}</pre>
     */
    public Number id;

    /**
     * petId
     *
     * <pre>Schema{type=integer, format=int64}</pre>
     */
    public Number petId;

    /**
     * quantity
     *
     * <pre>Schema{type=integer, format=int32}</pre>
     */
    public Number quantity;

    /**
     * shipDate
     *
     * <pre>Schema{type=string, format=date-time}</pre>
     */
    public String shipDate;

    /**
     * Order Status
     *
     * <pre>Schema{type=string}</pre>
     */
    public String status;

    /**
     * complete
     *
     * <pre>Schema{type=boolean}</pre>
     */
    public Object complete;
  }

  /**
   * api.Api.Pet
   *
   * <pre>Schema{type=object, required=[name, photoUrls], properties={id=Schema{type=integer, format=int64}, category=Schema{$ref=#/definitions/Category}, name=Schema{type=string}, photoUrls=Schema{type=array, items=Schema{type=string}}, tags=Schema{type=array, items=Schema{$ref=#/definitions/Tag}}, status=Schema{type=string}}}</pre>
   */
  @JsType(
          isNative = true,
          namespace = JsPackage.GLOBAL,
          name = "Object"
  )
  class Pet {
    /**
     * id
     *
     * <pre>Schema{type=integer, format=int64}</pre>
     */
    public Number id;

    /**
     * category
     *
     * <pre>Schema{$ref=#/definitions/Category}</pre>
     */
    public Category category;

    /**
     * name
     *
     * <pre>Schema{type=string}</pre>
     */
    public String name;

    /**
     * photoUrls
     *
     * <pre>Schema{type=array, items=Schema{type=string}}</pre>
     */
    public String[] photoUrls;

    /**
     * tags
     *
     * <pre>Schema{type=array, items=Schema{$ref=#/definitions/Tag}}</pre>
     */
    public Tag[] tags;

    /**
     * pet status in the store
     *
     * <pre>Schema{type=string}</pre>
     */
    public String status;
  }

  /**
   * api.Api.Tag
   *
   * <pre>Schema{type=object, properties={id=Schema{type=integer, format=int64}, name=Schema{type=string}}}</pre>
   */
  @JsType(
          isNative = true,
          namespace = JsPackage.GLOBAL,
          name = "Object"
  )
  class Tag {
    /**
     * id
     *
     * <pre>Schema{type=integer, format=int64}</pre>
     */
    public Number id;

    /**
     * name
     *
     * <pre>Schema{type=string}</pre>
     */
    public String name;
  }

  /**
   * api.Api.User
   *
   * <pre>Schema{type=object, properties={id=Schema{type=integer, format=int64}, username=Schema{type=string}, firstName=Schema{type=string}, lastName=Schema{type=string}, email=Schema{type=string}, password=Schema{type=string}, phone=Schema{type=string}, userStatus=Schema{type=integer, format=int32}}}</pre>
   */
  @JsType(
          isNative = true,
          namespace = JsPackage.GLOBAL,
          name = "Object"
  )
  class User {
    /**
     * id
     *
     * <pre>Schema{type=integer, format=int64}</pre>
     */
    public Number id;

    /**
     * username
     *
     * <pre>Schema{type=string}</pre>
     */
    public String username;

    /**
     * firstName
     *
     * <pre>Schema{type=string}</pre>
     */
    public String firstName;

    /**
     * lastName
     *
     * <pre>Schema{type=string}</pre>
     */
    public String lastName;

    /**
     * email
     *
     * <pre>Schema{type=string}</pre>
     */
    public String email;

    /**
     * password
     *
     * <pre>Schema{type=string}</pre>
     */
    public String password;

    /**
     * phone
     *
     * <pre>Schema{type=string}</pre>
     */
    public String phone;

    /**
     * User Status
     *
     * <pre>Schema{type=integer, format=int32}</pre>
     */
    public Number userStatus;
  }
}
