public class ShopServer extends Server{
    public ShopServer(int pPort) {
        super(pPort);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        this.send(pClientIP, pClientPort, "Waehlen sie ihr Produkt");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] messageParts = pMessage.split(":");
        if (messageParts[0].equals("TSHIRT")) {
            this.send(pClientIP,pClientPort,"Moechten Sie ein TSHIRT in der Groesse " + messageParts[1] + " und der Farbe " + messageParts[2] + " fuer 19,99€ bestellen?" );
        } else if (messageParts[0].equals("HOSE")) {
            this.send(pClientIP,pClientPort,"Moechten Sie eine Hose in der Groesse " + messageParts[1] + " und der Farbe " + messageParts[2] + " fuer 29,99€ bestellen?" );
        } else if (messageParts[0].equals("BESTAETIGUNG")) {
            if (messageParts[1].equals("ja")) {
                this.send(pClientIP,pClientPort,"Bestellung eingegangen");
                closeConnection(pClientIP,pClientPort);
            } else if (messageParts[1].equals("nein")) {
                closeConnection(pClientIP,pClientPort);
            } else {
                this.send(pClientIP,pClientPort,"Bitte ja oder nein");
            }
        } else if (messageParts[0].equals("ABMELDEN")) {
            closeConnection(pClientIP,pClientPort);
        } else {
            this.send(pClientIP,pClientPort,"ERROR. Eingabe fehlerhaft");
        }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        this.send(pClientIP,pClientPort,"Connection terminated");
    }
}
