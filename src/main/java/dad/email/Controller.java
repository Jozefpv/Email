package dad.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Controller implements Initializable {

	Model model = new Model();
	@FXML
	private GridPane view;

	@FXML
	private TextField nomServer, numPuerto, remitenteEmail, passEmail, destinatarioEmail, asuntoEmail;

	@FXML
	private TextArea areaMensaje;

	@FXML
	private CheckBox sslOption;

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// Bindings
		model.nomServerProperty().bindBidirectional((nomServer.textProperty()));
		numPuerto.textProperty().bindBidirectional(model.numPuertoProperty(), new NumberStringConverter());
		model.remitenteEmailProperty().bindBidirectional((remitenteEmail.textProperty()));
		model.passEmailProperty().bindBidirectional((passEmail.textProperty()));
		;
		model.destinatarioEmailProperty().bindBidirectional((destinatarioEmail.textProperty()));
		model.asuntoEmailProperty().bindBidirectional((asuntoEmail.textProperty()));
		model.areaMensajeProperty().bindBidirectional((areaMensaje.textProperty()));
		model.sslOptionProperty().bind(sslOption.selectedProperty());
		//sslOption.selectedProperty().bind(model.sslOptionProperty());
		
	}

	public GridPane getView() {
		return view;
	}

	@FXML
	private void onVaciarAction(ActionEvent e) {
		model.setNomServer("");
		model.setNumPuerto(0);
		model.setRemitenteEmail("");
		model.setPassEmail("");
		model.setDestinatarioEmail("");
		model.setAsuntoEmail("");
		model.setAreaMensaje("");
		sslOption.setSelected(false);
		;
		e.consume();
	}

	@FXML
	private void onCerrarAction(ActionEvent e) {
		EmailApp.PrimaryStage.close();

	}

	@FXML
	private void onEnviarAction(ActionEvent e) {
		Email email = new SimpleEmail();
		try {
			email.setHostName(model.getNomServer());
			email.setSmtpPort(model.getNumPuerto());
			email.setAuthenticator(new DefaultAuthenticator(model.getRemitenteEmail(), model.getPassEmail()));
			//email.setSSLOnConnect(sslOption.isSelected());
			email.setSSLOnConnect(model.isSslOption());
			email.setFrom(model.getRemitenteEmail());
			email.setSubject(model.getAsuntoEmail());
			email.setMsg(model.getAreaMensaje());
			email.addTo(model.getDestinatarioEmail());
			email.send();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mensaje eviado");
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("/images/email-send-icon-32x32.png"));
			alert.setHeaderText("Mensaje enviado con exito a " + model.getDestinatarioEmail());
			alert.showAndWait();
			
			model.setDestinatarioEmail("");
			model.setAsuntoEmail("");
			model.setAreaMensaje("");

			
		} catch (EmailException e1) {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("/images/email-send-icon-32x32.png"));
			alert.setHeaderText("No se pudo enviar el email");
			alert.setContentText(e1 + "");

			alert.showAndWait();
			
			e1.printStackTrace();
		}

	}

}
