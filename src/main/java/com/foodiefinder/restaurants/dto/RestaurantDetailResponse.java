package com.foodiefinder.restaurants.dto;

import com.foodiefinder.datapipeline.writer.entity.Restaurant;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class RestaurantDetailResponse {
    private long id;
    private String sigunName;
    private String businessPlaceName;
    private String businessStateName;
    private String sanitationBusinessCondition;
    private String roadAddress;
    private String lotNumberAddress;
    private double zipCode;
    private double latitude;
    private double longitude;
    private double averageRating;
    private List<RatingDto> ratings;

    public RestaurantDetailResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.sigunName = restaurant.getSigunName();
        this.businessPlaceName = restaurant.getBusinessPlaceName();
        this.businessStateName = restaurant.getBusinessStateName();
        this.sanitationBusinessCondition = restaurant.getSanitationBusinessCondition();
        this.roadAddress = restaurant.getRoadAddress();
        this.lotNumberAddress = restaurant.getLotNumberAddress();
        this.zipCode = restaurant.getZipCode();
        this.latitude = restaurant.getLatitude();
        this.longitude = restaurant.getLongitude();
        this.averageRating = restaurant.getAverageRating();
        this.ratings = restaurant.getRatings().stream()
                .map(rating -> new RatingDto(rating.getUser().getId(), rating.getValue(), rating.getComment()))
                .collect(Collectors.toList());
    }
    public static RestaurantDetailResponse from(Restaurant restaurant) {
        return new RestaurantDetailResponse(restaurant);
    }

}
