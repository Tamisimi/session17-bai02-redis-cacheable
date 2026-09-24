package ra.studentservicecaching.controller;

import org.springframework.web.bind.annotation.*;
import ra.studentservicecaching.dto.MenuItem;
import ra.studentservicecaching.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{restaurantId}/menu")
    public List<MenuItem> getMenu(@PathVariable Long restaurantId) {
        return restaurantService.getMenuByRestaurantId(restaurantId);
    }
}