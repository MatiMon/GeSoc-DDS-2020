import java.io.*;

public class ValidarMilMasUsadas implements ValidadorPasswords{
    String nombreArchivo = "/10k-most-common.txt";
    @Override
    public boolean validarPassword(String password){
        String strLine;
        InputStream inputStream = getClass().getResourceAsStream(nombreArchivo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((strLine = reader.readLine()) != null) {
                if (password.equals(strLine)) {
                    reader.close();
                    inputStream.close();
                    return false;
                }
            }
            reader.close();
            inputStream.close();
            return true;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return false;
    }
}
