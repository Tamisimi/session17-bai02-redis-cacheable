# Session 17 - Bài 02: Triển khai Lazy Loading với @Cacheable

## Yêu cầu
- Redis chạy trên Docker (port 6379)
- Spring Boot + Redis Cache (JSON Serializer)
- API: `GET /restaurants/{restaurantId}/menu`

## Cách chạy

1. Khởi động Redis:
```bash
docker run -d --name redis-cache -p 6379:6379 redis:latest
```

2. Chạy ứng dụng Spring Boot

3. Test bằng Postman / curl:
```
GET http://localhost:8085/restaurants/101/menu
```

- Lần 1: ~3 giây (Cache Miss)
- Lần 2: < 20ms (Cache Hit)

## Cấu trúc
- `CacheConfig.java`: Cấu hình RedisCacheManager + JSON Serializer
- `RestaurantService.java`: @Cacheable(value = "restaurantMenu", key = "#id")
- `RestaurantController.java`: Endpoint API