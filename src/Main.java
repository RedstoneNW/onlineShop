public class Main {
    public static void main(String[] args) {
        ShopServer server = new ShopServer(218);
        ShopClient client = new ShopClient("localhost",218);

        System.out.println(client.isConnected());
        client.send("HOSE:L:Schwarz");
        client.send("TSHIRT:XL:Schwarz");
        client.send("BESTAETIGUNG:ja");
        client.logout();
    }
}
