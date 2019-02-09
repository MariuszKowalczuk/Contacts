package pl.ContactsManager;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Contact implements Serializable {
    private String name;
    private String adress;
    private String telephoneNumber;
    private String email;


    @Override
    public String toString() {
        return name + "," + adress + "," + telephoneNumber + "," + email;
    }
}
