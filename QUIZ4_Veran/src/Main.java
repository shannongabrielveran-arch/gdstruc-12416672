public class Main {

    public static void main(String[] args) {

        Player Blair = new Player(1236, 450, "BlairFluffy");
        Player Yukio = new Player(2233, 745, "HSYukio");
        Player ZXen0on = new Player(3367, 360, "ZXen0on");
        Player James = new Player(4321, 980, "James631Playz");

        SimpleHashTable hashtable = new SimpleHashTable();
        hashtable.put(Blair.getUserName(), Blair);
        hashtable.put(Yukio.getUserName(), Yukio);
        hashtable.put(ZXen0on.getUserName(), ZXen0on);
        hashtable.put(James.getUserName(), James);

        //hashtable.printHastable();
        System.out.println(hashtable.get("HSYukio"));
    }
}
