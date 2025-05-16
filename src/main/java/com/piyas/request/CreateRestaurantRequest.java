package com.piyas.request;

import com.piyas.model.Address;
import com.piyas.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private String description;
    private String cuisinetype;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<String> images;
}
