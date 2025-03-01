package Helpers.Entities;

import lombok.Builder;

@Builder
public class User {
    public String FirstName;
    public String LastName;
    public String Email;
    public String Password;
}
