package ra.studentservicecaching.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ra.studentservicecaching.dto.MenuItem;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantService {

    @Cacheable(value = "restaurantMenu", key = "#id")
    public List<MenuItem> getMenuByRestaurantId(Long id) {
        System.out.println(">>> Đang truy vấn Database cho restaurantId = " + id);

        try {
            Thread.sleep(3000); // giả lập độ trễ database 3 giây
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (id == 101L) {
            return Arrays.asList(
                    new MenuItem(1L, 101L, "Phở Bò", 55000.0),
                    new MenuItem(2L, 101L, "Bún Chả", 60000.0)
            );
        }

        return List.of();
    }
}