import java.io.*;

public class ValidarMilMasUsadas implements ValidadorPasswords{
    String nombreArchivo = "/10k-most-common.txt";
    @Override
    public boolean validarPassword(String password){
        return !passwordEnArchivo(password,this.nombreArchivo);
    }
    private boolean passwordEnArchivo(String unaPassword, String unNombreArchivo){
        String strLine;
        InputStream inputStream = getClass().getResourceAsStream(unNombreArchivo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((strLine = reader.readLine()) != null) {
                if (unaPassword.equals(strLine)) {
                    reader.close();
                    inputStream.close();
                    return true;
                }
            }
            reader.close();
            inputStream.close();
            return false;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return true;
    }
}
