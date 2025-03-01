package Helpers.Entities;

import lombok.Builder;

@Builder
public class Address {
    public String Country;
    public String City;
    public String Street;
    public String PostalCode;
    public String PhoneNumber;
}
