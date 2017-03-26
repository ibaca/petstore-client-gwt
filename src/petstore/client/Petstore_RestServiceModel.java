package petstore.client;

import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;

import com.intendia.gwt.autorest.client.ResourceVisitor;
import com.intendia.gwt.autorest.client.RestServiceModel;
import java.lang.Number;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import rx.Observable;
import rx.Single;

public class Petstore_RestServiceModel extends RestServiceModel implements Petstore {
  @Inject
  public Petstore_RestServiceModel(final ResourceVisitor.Supplier parent) {
    super(new ResourceVisitor.Supplier() { public ResourceVisitor get() { return parent.get().path("/v2"); } });
  }

  @Override
  @Path("/pet")
  @POST
  public Observable<Void> post_pet(Petstore.Pet body) {
    return method(POST).path("pet").data(body).as(Observable.class, Void.class);
  }

  @Override
  @Path("/pet")
  @PUT
  public Observable<Void> put_pet(Petstore.Pet body) {
    return method(PUT).path("pet").data(body).as(Observable.class, Void.class);
  }

  @Override
  @Path("/pet/findByStatus")
  @GET
  public Observable<Petstore.Pet> get_pet_findByStatus(@QueryParam("status") List<String> status) {
    return method(GET).path("pet", "findByStatus").param("status", status).as(Observable.class, Petstore.Pet.class);
  }

  @Override
  @Path("/pet/findByTags")
  @GET
  public Observable<Petstore.Pet> get_pet_findByTags(@QueryParam("tags") List<String> tags) {
    return method(GET).path("pet", "findByTags").param("tags", tags).as(Observable.class, Petstore.Pet.class);
  }

  @Override
  @Path("/pet/{petId}")
  @DELETE
  public Observable<Void> delete_pet(@HeaderParam("api_key") @Nullable String api_key, @PathParam("petId") Number petId) {
    return method(DELETE).path("pet", petId).header("api_key", api_key).as(Observable.class, Void.class);
  }

  @Override
  @Path("/pet/{petId}")
  @POST
  public Observable<Void> post_pet(@PathParam("petId") Number petId, @Nullable String name, @Nullable String status) {
    return method(POST).path("pet", petId).data(name).as(Observable.class, Void.class);
  }

  @Override
  @Path("/pet/{petId}")
  @GET
  public Single<Petstore.Pet> get_pet(@PathParam("petId") Number petId) {
    return method(GET).path("pet", petId).as(Single.class, Petstore.Pet.class);
  }

  @Override
  @Path("/pet/{petId}/uploadImage")
  @POST
  public Single<Petstore.ApiResponse> post_pet_uploadImage(@PathParam("petId") Number petId, @Nullable String additionalMetadata, @Nullable Object file) {
    return method(POST).path("pet", petId, "uploadImage").data(additionalMetadata).as(Single.class, Petstore.ApiResponse.class);
  }

  @Override
  @Path("/store/inventory")
  @GET
  public Single<Object> get_store_inventory() {
    return method(GET).path("store", "inventory").as(Single.class, Object.class);
  }

  @Override
  @Path("/store/order")
  @POST
  public Single<Petstore.Order> post_store_order(Petstore.Order body) {
    return method(POST).path("store", "order").data(body).as(Single.class, Petstore.Order.class);
  }

  @Override
  @Path("/store/order/{orderId}")
  @DELETE
  public Observable<Void> delete_store_order(@PathParam("orderId") Number orderId) {
    return method(DELETE).path("store", "order", orderId).as(Observable.class, Void.class);
  }

  @Override
  @Path("/store/order/{orderId}")
  @GET
  public Single<Petstore.Order> get_store_order(@PathParam("orderId") Number orderId) {
    return method(GET).path("store", "order", orderId).as(Single.class, Petstore.Order.class);
  }

  @Override
  @Path("/user")
  @POST
  public Observable<Void> post_user(Petstore.User body) {
    return method(POST).path("user").data(body).as(Observable.class, Void.class);
  }

  @Override
  @Path("/user/createWithArray")
  @POST
  public Observable<Void> post_user_createWithArray(List<Petstore.User> body) {
    return method(POST).path("user", "createWithArray").data(body).as(Observable.class, Void.class);
  }

  @Override
  @Path("/user/createWithList")
  @POST
  public Observable<Void> post_user_createWithList(List<Petstore.User> body) {
    return method(POST).path("user", "createWithList").data(body).as(Observable.class, Void.class);
  }

  @Override
  @Path("/user/login")
  @GET
  public Single<String> get_user_login(@QueryParam("username") String username, @QueryParam("password") String password) {
    return method(GET).path("user", "login").param("username", username).param("password", password).as(Single.class, String.class);
  }

  @Override
  @Path("/user/logout")
  @GET
  public Observable<Void> get_user_logout() {
    return method(GET).path("user", "logout").as(Observable.class, Void.class);
  }

  @Override
  @Path("/user/{username}")
  @DELETE
  public Observable<Void> delete_user(@PathParam("username") String username) {
    return method(DELETE).path("user", username).as(Observable.class, Void.class);
  }

  @Override
  @Path("/user/{username}")
  @GET
  public Single<Petstore.User> get_user(@PathParam("username") String username) {
    return method(GET).path("user", username).as(Single.class, Petstore.User.class);
  }

  @Override
  @Path("/user/{username}")
  @PUT
  public Observable<Void> put_user(@PathParam("username") String username, Petstore.User body) {
    return method(PUT).path("user", username).data(body).as(Observable.class, Void.class);
  }
}
