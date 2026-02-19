package com.scaler.productservicenamanbhallafeb24.repositories.projections;

//this is a superset, it has same or more attributes than what is returned by query
/*
product projection comes into picture when we need multiple attributes(but not all) in the returned object
returning the whole object may not be necessary or required all th time and it leads performance degradation

 */
/*
what HQL solves for??
HQL is solving :
1. more visibility for query
2. allowing only those attributes(in the returned object) that we need
3.Spring is still validating our queries
 */
public interface ProductProjection {
    Long getId();
    String getTitle();
    String getDescription();
}
