import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class ConferenceClient {
    private ConferenceRegistration conferenceRegistration;

    public ConferenceClient() {
        try {
            conferenceRegistration = (ConferenceRegistration) Naming.lookup("//localhost/ConferenceRegistration");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public void register(String name, String email) {
        try {
            Participant participant = new Participant(name, email);
            conferenceRegistration.registerParticipant(participant);
            System.out.println("Registered: " + name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void exportToXML(String filePath) {
        try {
            conferenceRegistration.exportToXML(filePath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void importFromXML(String filePath) {
        try {
            conferenceRegistration.importFromXML(filePath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}