# CakeControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCake**](CakeControllerApi.md#addCake) | **POST** /addCake | 
[**getCakeById**](CakeControllerApi.md#getCakeById) | **GET** /cake/{id} | 
[**getListOfCakes**](CakeControllerApi.md#getListOfCakes) | **GET** /cakes | 


<a name="addCake"></a>
# **addCake**
> Cake addCake(infoAboutCake)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CakeControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CakeControllerApi apiInstance = new CakeControllerApi(defaultClient);
    InfoAboutCake infoAboutCake = new InfoAboutCake(); // InfoAboutCake | 
    try {
      Cake result = apiInstance.addCake(infoAboutCake);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CakeControllerApi#addCake");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **infoAboutCake** | [**InfoAboutCake**](InfoAboutCake.md)|  |

### Return type

[**Cake**](Cake.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | OK |  -  |

<a name="getCakeById"></a>
# **getCakeById**
> InfoAboutCake getCakeById(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CakeControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CakeControllerApi apiInstance = new CakeControllerApi(defaultClient);
    Long id = 56L; // Long | 
    try {
      InfoAboutCake result = apiInstance.getCakeById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CakeControllerApi#getCakeById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**InfoAboutCake**](InfoAboutCake.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | OK |  -  |

<a name="getListOfCakes"></a>
# **getListOfCakes**
> Cakes getListOfCakes()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CakeControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CakeControllerApi apiInstance = new CakeControllerApi(defaultClient);
    try {
      Cakes result = apiInstance.getListOfCakes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CakeControllerApi#getListOfCakes");
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

[**Cakes**](Cakes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | OK |  -  |

