package encryptdecrypt;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

class CryptMachine {

    protected CryptMethod cryptMethod;
    protected Output outputMethod;
    protected Input inputMethod;
    private String typeOfCrypt;

    public void startMachine() {
        cryptData();
        outputData();
    }

    protected void cryptData() {
        if (typeOfCrypt.equals("enc")) {
            cryptMethod.encrypt(inputMethod.getData());
        } else {
            cryptMethod.decrypt(inputMethod.getData());
        }
    }

    protected void outputData() {
        outputMethod.setCryptString(cryptMethod.getData());
        outputMethod.output();
    }

    public void setCryptMethod(CryptMethod cryptMethod) {
        this.cryptMethod = cryptMethod;
    }

    public void setOutputMethod(Output outputMethod) {
        this.outputMethod = outputMethod;
    }

    public void setInputMethod(Input inputMethod) {
        this.inputMethod = inputMethod;
    }

    public void setTypeOfCrypt(String typeOfCrypt) {
        this.typeOfCrypt = typeOfCrypt;
    }
}

interface CryptMethod {

    void encrypt(String data);

    void decrypt(String data);

    String getData();
}

class ShiftingMethod implements CryptMethod {

    private final int key;
    private String data;

    public ShiftingMethod(int key) {
        this.key = key;
    }


    @Override
    public void encrypt(@NotNull String data) {
        char[] arrOfUnCrypt = data.toCharArray();
        int index = 0;
        for (Character eachChar : arrOfUnCrypt) {
            if (eachChar >= 97 && eachChar <= 122) {
                arrOfUnCrypt[index] = (char) (((eachChar - 'a' + key) % 26) + 'a');
            } else if (eachChar >= 65 && eachChar <= 90) {
                arrOfUnCrypt[index] = (char) (((eachChar - 'A' + key) % 26) + 'A');
            }
            index++;
        }
        this.data = new String(arrOfUnCrypt);
    }

    @Override
    public void decrypt(String data) {
        char[] arrOfUnCrypt = data.toCharArray();
        int index = 0;
        for (Character eachChar : arrOfUnCrypt) {
            if (eachChar >= 97 && eachChar <= 122) {
                int temporary = (eachChar - 'a' - key) ;
                arrOfUnCrypt[index] = (char) (temporary >= 0 ? temporary + 'a' : temporary + 'z' + 1 );
            } else if (eachChar >= 65 && eachChar <= 90) {
                int temporary = (eachChar - 'A' - key) ;
                arrOfUnCrypt[index] = (char) (temporary >= 0 ? temporary + 'A' : temporary + 'Z' + 1 );
            }
            index++;
        }
        this.data = new String(arrOfUnCrypt);
    }

    public String getData() {
        return data;
    }
}

class UnicodeMethod implements CryptMethod {

    private final int key;
    private String data;

    public UnicodeMethod(int key) {
        this.key = key;
    }

    @Override
    public void encrypt(String data) {
        char[] arrOfUnCrypt = data.toCharArray();
        int index = 0;
        for (Character eachChar : arrOfUnCrypt) {
            arrOfUnCrypt[index] = (char) (eachChar + key);
            index++;
        }
        this.data = new String(arrOfUnCrypt);
    }

    @Override
    public void decrypt(String data) {
        char[] arrOfUnCrypt = data.toCharArray();
        int index = 0;
        for (Character eachChar : arrOfUnCrypt) {
            arrOfUnCrypt[index] = (char) (eachChar - key);
            index++;
        }
        this.data = new String(arrOfUnCrypt);
    }

    @Override
    public String getData() {
        return data;
    }
}


interface Output {

    void output();

    void setCryptString(String result);
}

class StandardOutput implements Output {

    private String resultOfCrypt;

    @Override
    public void output() {
        System.out.println(resultOfCrypt);
    }

    @Override
    public void setCryptString(String resultOfCrypt) {
        this.resultOfCrypt = resultOfCrypt;
    }
}

class FileOutput implements Output {

    private final String path;

    private String resultOfCrypt;

    public  FileOutput(String path) {
        this.path = path;
    }


    @Override
    public void output() {
        try (PrintWriter printWriter = new PrintWriter(new File(path))) {
            printWriter.write(resultOfCrypt);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void setCryptString(String resultOfCrypt) {
        this.resultOfCrypt = resultOfCrypt;
    }
}

interface Input {
    String getData();

    void setData(String dataOrPath);
}


class StandardInput implements Input {

    protected String data;

    public String getData() {
        return data;
    }

    @Override
    public void setData(String dataOrPath) {
        this.data = dataOrPath;
    }
}

class FileInput implements Input {
    protected String path;

    @Override
    public String getData() {
        return path;
    }

    @Override
    public void setData(String dataOrPath) {
        try {
            this.path = ReadingFile.readFileAsString(dataOrPath);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}