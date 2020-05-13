public class ValidarCaracteresConsecutivos implements ValidadorPasswords {
    /*
    Me resulta raro tener que instanciar una clase que no tiene estado.
    Lo que necesito son los métodos.
    Investigar que hace static.
     */
    @Override
    public boolean validarPassword(String passwordPlana) {
       return !allCharactersSame(passwordPlana);
    }
    private boolean allCharactersSame(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0))
                return false;
        return true;
    }
}
