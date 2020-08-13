# javax validation custom
*Custom DateTime Validator for java with javax validations*


This validator is a variation of @FutureOrPresent validator, it supports a gap error time that may be present in your application. For example, when a request is made to the server there may be some network delays and other issues that can invalidate the date by some seconds.

## Usage
In the following example, a gap of 60 seconds is used, which means if we receive a request at time T, this will be valid if T > NOW - 60 seconds
```
@FutureOrPresentWithMargin(margin=60)
DateTime myfield;
```
