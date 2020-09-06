package encryptdecrypt;

import java.util.HashMap;
import java.util.Optional;

public class LoaderData {

    private final String[] args;
    private static final HashMap<String, String> fastSearchData = new HashMap<>();

    private String inputPath;
    private String typeOfOutput;
    private String choiceOfMethod;
    private String typeOfCrypt;
    private int key;
    boolean inputWithPath = false;

    public LoaderData(String[] args) {
        this.args = args;
    }

    public void loadData() {
        loadDataToMap();
        assignValues();
    }

    // Loading data to HashMap to fast search
    private void loadDataToMap() {
        for (int i = 0; i < args.length; i += 2) {
            fastSearchData.put(args[i], args[i + 1]);
        }
    }

    private void assignValues() {
        typeOfCrypt = Optional.ofNullable(fastSearchData.get("-mode")).orElse("enc");
        key = Integer.parseInt(Optional.ofNullable(fastSearchData.get("-key")).orElse("0"));
        choiceOfMethod = Optional.ofNullable(fastSearchData.get("-alg")).orElse("shift");
        if (fastSearchData.get("-data") == null) {
            if (fastSearchData.get("-in") == null) {
                inputPath = "";
            } else {
                inputPath = fastSearchData.get("-in");
                inputWithPath = true;
            }
        } else {
            inputPath = fastSearchData.get("-data");
        }
        typeOfOutput = Optional.ofNullable(fastSearchData.get("-out")).orElse("standard");
    }

    public String getChoiceOfMethod() {
        return choiceOfMethod;
    }

    public String getTypeOfOutput() {
        return typeOfOutput;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getTypeOfCrypt() {
        return typeOfCrypt;
    }

    public int getKey() {
        return key;
    }

    public boolean isInputWithPath() {
        return inputWithPath;
    }


}

