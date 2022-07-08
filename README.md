# Project: angularShop

## End-point: Find Products
### Method: GET
>```
>localhost:8081/api/v1/products
>```
### Response: undefined
```json
[
    {
        "id": 25,
        "title": "Nike Sneaker",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum vel mauris quis rhoncus. Nulla elementum porta neque vehicula varius.",
        "size": "40",
        "price": 150.2,
        "category": "Nike",
        "imagePath": "/assets/products/nike.jpeg"
    }
]
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Find Products By ID
### Method: GET
>```
>localhost:8081/api/v1/products/25
>```
### Response: undefined
```json
{
    "id": 25,
    "title": "Nike Sneaker",
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum vel mauris quis rhoncus. Nulla elementum porta neque vehicula varius.",
    "size": "40",
    "price": 150.2,
    "category": "Nike",
    "imagePath": "/assets/products/nike.jpeg"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Add Product
### Method: POST
>```
>localhost:8081/api/v1/products
>```
### Body (**raw**)

```json
{
  "title": "myTestProdudut",
  "description": "myTestDescription",
  "size": "myTestSize",
  "price": 150,
  "category": "myTestCategory",
  "imagePath": "myTestImagePath"
}
```

### Response: undefined
```json
{
    "id": 29,
    "title": "myTestProdudut",
    "description": "myTestDescription",
    "size": "myTestSize",
    "price": 150,
    "category": "myTestCategory",
    "imagePath": "myTestImagePath"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Edit Product
### Method: PUT
>```
>localhost:8081/api/v1/products/28
>```
### Body (**raw**)

```json
{
  "title": "myTestProduct2",
  "description": "myTestDescription2",
  "size": "myTestSize2",
  "price": 151,
  "category": "myTestCategory2",
  "imagePath": "myTestImagePath2"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: DeleteProduct
### Method: DELETE
>```
>localhost:8081/api/v1/products/28
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Documentation: [More examples](https://documenter.getpostman.com/view/17690251/UzJMsG3w)

Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
