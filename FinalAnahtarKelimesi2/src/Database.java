
public final class Database { // 1 ve 2 de class tanımında final yazılmamıştır

    /*Eğer class final tanımlarsak  başka yerden extends edilmez */
    
    //3-)
    public void baglantiKur(String username, String password) {

        System.out.println(username);
        System.out.println(password);
    }
    /* // 2-)  
    public final void baglantiKur(String username,String password) {

        System.out.println(username);
        System.out.println(password);
    }*/

 /* // 1-)
    public void baglantiKur(final String username, final String password) {

        System.out.println(username);
        System.out.println(password);
    }*/
}
