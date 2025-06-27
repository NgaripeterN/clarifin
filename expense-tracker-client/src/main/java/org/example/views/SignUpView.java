package org.example.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image; // Added import
import javafx.scene.image.ImageView; // Added import
import javafx.scene.layout.HBox; // Added import for the main split
import javafx.scene.layout.Priority; // Added import for HGrow
import javafx.scene.layout.VBox;
import org.example.controllers.SignUpController;
import org.example.utils.Utilitie;
import org.example.utils.ViewNavigator;

public class SignUpView {
    private Label expenseTrackerLabel = new Label("ClariFin"); // Changed label text to ClariFin for consistency
    private TextField nameField = new TextField();
    private TextField usernameField = new TextField(); // This will be for email
    private PasswordField passwordField = new PasswordField();
    private PasswordField rePasswordField = new PasswordField();
    private Button registerButton = new Button("Register");
    private Label loginLabel = new Label("Already have an account? Login here");

    public void show(){
        Scene scene = createScene();
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        new SignUpController(this);
        ViewNavigator.switchViews(scene);

        // Request focus for the root container after the scene is displayed.
        // This prevents any TextField from getting default initial focus,
        // allowing the prompt text to remain visible.
        scene.getRoot().requestFocus();
    }

    private Scene createScene(){
        HBox rootContainer = new HBox(); // Use HBox as the root for splitting the view
        rootContainer.getStyleClass().add("root-split-container"); // Reuse CSS class for the overall container

        // Left side of the signup page (dark blue shade) - Reusing LoginView's left side structure
        VBox leftSide = new VBox(20); // Add spacing between elements
        leftSide.getStyleClass().addAll("left-side-blue"); // Reuse CSS class for dark blue background
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setPadding(new Insets(20));

        // Add Logo (reusing ic_logo.png)
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/ic_logo.png")));
        logo.setFitWidth(220); // Consistent size with LoginView
        logo.setFitHeight(220);

        // Add Welcome Message (reusing welcome-message style)
        Label welcomeMessage = new Label("Your journey to \n Financial Clarity\n starts here ");
        welcomeMessage.getStyleClass().addAll("welcome-message", "text-white");

        // The main app title is already styled as a header

        leftSide.getChildren().addAll(logo, welcomeMessage, expenseTrackerLabel);
        HBox.setHgrow(leftSide, Priority.ALWAYS); // Make left side grow

        // Right side of the signup page (dull white shade)
        VBox rightSide = new VBox(25); // Spacing for elements on right side
        rightSide.getStyleClass().addAll("right-side-white"); // Reuse CSS class for dull white background
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setPadding(new Insets(20));

        // Add the new message to the right side for signup
        Label rightSideMessage = new Label("Join ClariFin today.\nStart your journey to financial freedom!");
        rightSideMessage.getStyleClass().addAll("right-side-intro-message"); // Reuse stylish message class
        rightSideMessage.setWrapText(true);
        rightSideMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        VBox signUpFormContainer = createSignUpForm(); // Get the signup form
        rightSide.getChildren().addAll(rightSideMessage, signUpFormContainer); // Add message before the form
        HBox.setHgrow(rightSide, Priority.ALWAYS); // Make right side grow

        rootContainer.getChildren().addAll(leftSide, rightSide);
        return new Scene(rootContainer, Utilitie.APP_WIDTH, Utilitie.APP_HEIGHT);
    }

    private VBox createSignUpForm(){
        VBox signUpForm = new VBox(30); // Spacing between fields
        signUpForm.setAlignment(Pos.CENTER);
        signUpForm.setMaxWidth(473); // Apply max width to the form container itself

        // --- Name Field with Icon (ic_user.png) ---
        ImageView userIcon = new ImageView(new Image(getClass().getResourceAsStream("/ic_user.png")));
        userIcon.getStyleClass().add("icon-field");
        userIcon.setFitWidth(24);
        userIcon.setFitHeight(24);
        nameField.setPromptText("Enter Name");
        nameField.getStyleClass().addAll("text-light-gray", "text-size-lg", "transparent-background");
        HBox nameFieldWithIcon = new HBox(10);
        nameFieldWithIcon.setAlignment(Pos.CENTER_LEFT);
        nameFieldWithIcon.getStyleClass().addAll("field-background", "rounded-border", "field-with-icon");
        nameFieldWithIcon.getChildren().addAll(userIcon, nameField);
        HBox.setHgrow(nameField, Priority.ALWAYS);

        // --- Username (Email) Field with Icon (ic_email.png) ---
        ImageView emailIcon = new ImageView(new Image(getClass().getResourceAsStream("/ic_email.png")));
        emailIcon.getStyleClass().add("icon-field");
        emailIcon.setFitWidth(24);
        emailIcon.setFitHeight(24);
        usernameField.setPromptText("Enter Email");
        usernameField.getStyleClass().addAll("text-light-gray", "text-size-lg", "transparent-background");
        HBox usernameFieldWithIcon = new HBox(10);
        usernameFieldWithIcon.setAlignment(Pos.CENTER_LEFT);
        usernameFieldWithIcon.getStyleClass().addAll("field-background", "rounded-border", "field-with-icon");
        usernameFieldWithIcon.getChildren().addAll(emailIcon, usernameField);
        HBox.setHgrow(usernameField, Priority.ALWAYS);

        // --- Password Field with Icon (ic_pwd.png) ---
        ImageView passwordIcon = new ImageView(new Image(getClass().getResourceAsStream("/ic_pwd.png")));
        passwordIcon.getStyleClass().add("icon-field");
        passwordIcon.setFitWidth(24);
        passwordIcon.setFitHeight(24);
        passwordField.setPromptText("Enter Password");
        passwordField.getStyleClass().addAll("text-light-gray", "text-size-lg", "transparent-background");
        HBox passwordFieldWithIcon = new HBox(10);
        passwordFieldWithIcon.setAlignment(Pos.CENTER_LEFT);
        passwordFieldWithIcon.getStyleClass().addAll("field-background", "rounded-border", "field-with-icon");
        passwordFieldWithIcon.getChildren().addAll(passwordIcon, passwordField);
        HBox.setHgrow(passwordField, Priority.ALWAYS);

        // --- Re-Enter Password Field with Icon (ic_pwd.png) ---
        ImageView rePasswordIcon = new ImageView(new Image(getClass().getResourceAsStream("/ic_pwd.png")));
        rePasswordIcon.getStyleClass().add("icon-field");
        rePasswordIcon.setFitWidth(24);
        rePasswordIcon.setFitHeight(24);
        rePasswordField.setPromptText("Re-Enter Password");
        rePasswordField.getStyleClass().addAll("text-light-gray", "text-size-lg", "transparent-background");
        HBox rePasswordFieldWithIcon = new HBox(10);
        rePasswordFieldWithIcon.setAlignment(Pos.CENTER_LEFT);
        rePasswordFieldWithIcon.getStyleClass().addAll("field-background", "rounded-border", "field-with-icon");
        rePasswordFieldWithIcon.getChildren().addAll(rePasswordIcon, rePasswordField);
        HBox.setHgrow(rePasswordField, Priority.ALWAYS);

        registerButton.getStyleClass().addAll("text-size-lg", "bg-light-blue", "text-white", "text-weight-700", "rounded-border");
        registerButton.setMaxWidth(473); // Max width for button

        loginLabel.getStyleClass().addAll("text-size-md", "text-light-gray", "text-underline", "link-text");


        signUpForm.getChildren().addAll(
                nameFieldWithIcon,
                usernameFieldWithIcon,
                passwordFieldWithIcon,
                rePasswordFieldWithIcon,
                registerButton,
                loginLabel
        );
        return signUpForm;
    }

    public Label getExpenseTrackerLabel() {
        return expenseTrackerLabel;
    }

    public void setExpenseTrackerLabel(Label expenseTrackerLabel) {
        this.expenseTrackerLabel = expenseTrackerLabel;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public PasswordField getRePasswordField() {
        return rePasswordField;
    }

    public void setRePasswordField(PasswordField rePasswordField) {
        this.rePasswordField = rePasswordField;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    public Label getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(Label loginLabel) {
        this.loginLabel = loginLabel;
    }
}
