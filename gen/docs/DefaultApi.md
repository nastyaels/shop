# DefaultApi

All URIs are relative to *http://http*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cakeGet**](DefaultApi.md#cakeGet) | **GET** /cake | 


<a name="cakeGet"></a>
# **cakeGet**
> OneOfcakes cakeGet()



Return list of all avaliable cakes

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      OneOfcakes result = apiInstance.cakeGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#cakeGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OneOfcakes**](OneOfcakes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | ok |  -  |

