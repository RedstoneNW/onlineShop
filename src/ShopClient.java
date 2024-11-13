public class ShopClient extends Client{

    public ShopClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }

    public void chooseProduct(String pProduct, String pSize, String pColor) {
        this.send(pProduct+":"+pSize+":"+pColor);
    }

    public void confirm(String pAnswer) {
        this.send(pAnswer);
    }

    public void logout() {
        this.send("ABMELDEN");
    }

}
