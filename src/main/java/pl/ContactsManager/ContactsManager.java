package pl.ContactsManager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ContactsManager extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Kontakty");
        primaryStage.show();


        Button addContact = new Button("Dodaj kontakt");
        Button printContacts = new Button("Eksportuj listę kontaktów");
        Button showContacts = new Button("Pokaż listę kontaktów");

        HBox startPanel = new HBox(addContact, printContacts, showContacts);
        primaryStage.setScene(new Scene(startPanel));
        ObservableList<Contact> contacts = FXCollections.observableArrayList();


        addContact.setOnAction(event -> {

            Label name = new Label("Imię");
            Label adress = new Label("Adres");
            Label telehoneNumber = new Label("Numer telefonu");
            Label eMail = new Label("Adres e-mail");
            TextField nameInput = new TextField();
            TextField adressInput = new TextField();
            TextField telephoneNumberInput = new TextField();
            TextField eMailInput = new TextField();
            Button submitContact = new Button("Dodaj");

            GridPane form = new GridPane();
            form.add(name, 0, 0);
            form.add(nameInput, 1, 0);
            form.add(adress, 0, 1);
            form.add(adressInput, 1, 1);
            form.add(telehoneNumber, 0, 2);
            form.add(telephoneNumberInput, 1, 2);
            form.add(eMail, 0, 3);
            form.add(eMailInput, 1, 3);
            form.add(submitContact, 2, 4);
            Stage formStage = new Stage();
            formStage.setScene(new Scene(form));
            formStage.show();
            formStage.setTitle("Dodawanie kontaktu");

            submitContact.setOnAction(event1 -> contacts.add(
                    new Contact(nameInput.getText(), adressInput.getText(), telephoneNumberInput.getText(), eMailInput.getText()))
            );
        });

        File file = new File("C:\\Users\\lordm\\Development\\Contacts\\contacts.csv");
        printContacts.setOnAction(event -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Contact contact : contacts) {
                    writer.write(contact.toString());
                    writer.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}













