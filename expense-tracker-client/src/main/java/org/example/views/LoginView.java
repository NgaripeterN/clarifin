package org.example.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.example.controllers.LoginController;
import org.example.utils.Utilitie;
import org.example.utils.ViewNavigator;

public class LoginView {
    private Label expenseTrackerLabel = new Label("ClariFin");
    private TextField usernameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Label signupLabel = new Label("Don't have an account? Click Here");

    public void show(){
        Scene scene = createScene();
        // Ensure the style.css path is correct, assuming it's in the root of resources folder
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        new LoginController(this);
        ViewNavigator.switchViews(scene);

        // Request focus for the root container after the scene is displayed.
        // This prevents any TextField from getting default initial focus,
        // allowing the prompt text to remain visible.
        scene.getRoot().requestFocus();
    }

    private Scene createScene(){
        HBox rootContainer = new HBox(); // Use HBox as the root for splitting the view
        rootContainer.getStyleClass().add("root-split-container"); // New CSS class for the overall container

        // Left side of the login page (blue shade)
        VBox leftSide = new VBox(20); // Add spacing between elements in leftSide
        leftSide.getStyleClass().addAll("left-side-blue"); // New CSS class for blue background
        leftSide.setAlignment(Pos.CENTER); // Center content vertically and horizontally
        leftSide.setPadding(new Insets(20)); // Add some padding

        // Add Logo
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/ic_logo.png"))); // Assuming ic_logo.png exists
        logo.setFitWidth(210); // Set appropriate size for your logo
        logo.setFitHeight(210);

        // Add Welcome Message
        Label welcomeMessage = new Label("Your journey to \n Financial Clarity\n starts here ");
        welcomeMessage.getStyleClass().addAll("welcome-message", "text-white"); // New CSS class for styling


        leftSide.getChildren().addAll(logo, welcomeMessage, expenseTrackerLabel); // Add logo and welcome message
        HBox.setHgrow(leftSide, Priority.ALWAYS); // Make left side grow to fill available space

        // Right side of the login page (dull white shade)
        VBox rightSide = new VBox(25); // Added spacing for elements on right side
        rightSide.getStyleClass().addAll("right-side-white"); // New CSS class for dull white background
        rightSide.setAlignment(Pos.CENTER); // Center the login form
        rightSide.setPadding(new Insets(20)); // Add some padding

        // Add the new message to the right side
        Label rightSideMessage = new Label("Welcome Back!\n Sign in to continue.");
        rightSideMessage.getStyleClass().addAll("right-side-intro-message"); // New CSS class for styling
        rightSideMessage.setWrapText(true); // Allow text to wrap if it's too long
        rightSideMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER); // Center align multi-line text

        VBox loginFormBox = createLoginFormBox(); // Get the existing login form
        rightSide.getChildren().addAll(rightSideMessage, loginFormBox); // Add the message before the login form box
        HBox.setHgrow(rightSide, Priority.ALWAYS); // Make right side grow to fill available space

        rootContainer.getChildren().addAll(leftSide, rightSide);
        return new Scene(rootContainer, Utilitie.APP_WIDTH, Utilitie.APP_HEIGHT);
    }

    private VBox createLoginFormBox(){
        VBox loginFormVBox = new VBox(51);
        loginFormVBox.setAlignment(Pos.CENTER);

        // --- Username (Email) Field with Icon ---
        ImageView emailIcon = new ImageView(new Image(getClass().getResourceAsStream("/ic_email.png")));
        emailIcon.getStyleClass().add("icon-field"); // Apply icon styling
        emailIcon.setFitWidth(24); // Set icon size
        emailIcon.setFitHeight(24);

        usernameField.setPromptText("Enter email");
        usernameField.getStyleClass().addAll("text-light-gray", "text-size-lg", "transparent-background"); // Applied new class

        HBox usernameFieldWithIcon = new HBox(10); // Spacing between icon and text field
        usernameFieldWithIcon.setAlignment(Pos.CENTER_LEFT);
        usernameFieldWithIcon.getStyleClass().addAll("field-background", "rounded-border", "field-with-icon"); // Applied styles to HBox
        usernameFieldWithIcon.setMaxWidth(473); // Apply max width to the container
        usernameFieldWithIcon.getChildren().addAll(emailIcon, usernameField);
        HBox.setHgrow(usernameField, javafx.scene.layout.Priority.ALWAYS); // Allow text field to grow

        // --- Password Field with Icon ---
        ImageView passwordIcon = new ImageView(new Image(getClass().getResourceAsStream("/ic_pwd.png")));
        passwordIcon.getStyleClass().add("icon-field"); // Apply icon styling
        passwordIcon.setFitWidth(24); // Set icon size
        passwordIcon.setFitHeight(24);

        passwordField.setPromptText("Enter Password");
        passwordField.getStyleClass().addAll("text-light-gray", "text-size-lg", "transparent-background"); // Applied new class

        HBox passwordFieldWithIcon = new HBox(10); // Spacing between icon and text field
        passwordFieldWithIcon.setAlignment(Pos.CENTER_LEFT);
        passwordFieldWithIcon.getStyleClass().addAll("field-background", "rounded-border", "field-with-icon"); // Applied styles to HBox
        passwordFieldWithIcon.setMaxWidth(473); // Apply max width to the container
        passwordFieldWithIcon.getChildren().addAll(passwordIcon, passwordField);
        HBox.setHgrow(passwordField, javafx.scene.layout.Priority.ALWAYS); // Allow password field to grow


        loginButton.getStyleClass().addAll("text-size-lg", "bg-light-blue", "text-white", "text-weight-700", "rounded-border");
        loginButton.setMaxWidth(473);

        signupLabel.getStyleClass().addAll("text-size-md", "text-light-gray", "text-underline", "link-text");

        // Add the HBox containers instead of the raw fields
        loginFormVBox.getChildren().addAll(usernameFieldWithIcon, passwordFieldWithIcon, loginButton, signupLabel);
        return loginFormVBox;
    }

    public Label getExpenseTrackerLabel() {
        return expenseTrackerLabel;
    }

    public void setExpenseTrackerLabel(Label expenseTrackerLabel) {
        this.expenseTrackerLabel = expenseTrackerLabel;
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

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public Label getSignupLabel() {
        return signupLabel;
    }

    public void setSignupLabel(Label signupLabel) {
        this.signupLabel = signupLabel;
    }
}
