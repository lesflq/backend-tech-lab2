package uk.sevastianov.lab2.Entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class User {
    Long id;
    String name;

}
