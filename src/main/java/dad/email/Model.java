package dad.email;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	private StringProperty nomServer = new SimpleStringProperty();
	private IntegerProperty numPuerto = new SimpleIntegerProperty();
	private StringProperty remitenteEmail = new SimpleStringProperty();
	private StringProperty passEmail = new SimpleStringProperty();
	private StringProperty destinatarioEmail = new SimpleStringProperty();
	private StringProperty asuntoEmail = new SimpleStringProperty();
	private StringProperty areaMensaje = new SimpleStringProperty();
	private BooleanProperty sslOption = new SimpleBooleanProperty();
	

	
	public final StringProperty nomServerProperty() {
		return this.nomServer;
	}
	

	public final String getNomServer() {
		return this.nomServerProperty().get();
	}
	

	public final void setNomServer(final String nomServer) {
		this.nomServerProperty().set(nomServer);
	}


	public final IntegerProperty numPuertoProperty() {
		return this.numPuerto;
	}
	


	public final int getNumPuerto() {
		return this.numPuertoProperty().get();
	}
	


	public final void setNumPuerto(final int numPuerto) {
		this.numPuertoProperty().set(numPuerto);
	}
	


	public final StringProperty remitenteEmailProperty() {
		return this.remitenteEmail;
	}
	


	public final String getRemitenteEmail() {
		return this.remitenteEmailProperty().get();
	}
	


	public final void setRemitenteEmail(final String remitenteEmail) {
		this.remitenteEmailProperty().set(remitenteEmail);
	}
	


	public final StringProperty passEmailProperty() {
		return this.passEmail;
	}
	


	public final String getPassEmail() {
		return this.passEmailProperty().get();
	}
	


	public final void setPassEmail(final String passEmail) {
		this.passEmailProperty().set(passEmail);
	}
	


	public final StringProperty destinatarioEmailProperty() {
		return this.destinatarioEmail;
	}
	


	public final String getDestinatarioEmail() {
		return this.destinatarioEmailProperty().get();
	}
	


	public final void setDestinatarioEmail(final String destinatarioEmail) {
		this.destinatarioEmailProperty().set(destinatarioEmail);
	}
	


	public final StringProperty asuntoEmailProperty() {
		return this.asuntoEmail;
	}
	


	public final String getAsuntoEmail() {
		return this.asuntoEmailProperty().get();
	}
	


	public final void setAsuntoEmail(final String asuntoEmail) {
		this.asuntoEmailProperty().set(asuntoEmail);
	}


	public final StringProperty areaMensajeProperty() {
		return this.areaMensaje;
	}
	


	public final String getAreaMensaje() {
		return this.areaMensajeProperty().get();
	}
	


	public final void setAreaMensaje(final String areaMensaje) {
		this.areaMensajeProperty().set(areaMensaje);
	}


	public final BooleanProperty sslOptionProperty() {
		return this.sslOption;
	}
	


	public final boolean isSslOption() {
		return this.sslOptionProperty().get();
	}
	


	public final void setSslOption(final boolean sslOption) {
		this.sslOptionProperty().set(sslOption);
	}
	
	
	
	
	
}
