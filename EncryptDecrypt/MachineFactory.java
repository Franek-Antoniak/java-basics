package encryptdecrypt;

import java.util.Stack;

public class MachineFactory {

    private final LoaderData loaderData;

    public MachineFactory(LoaderData loaderData) {
        this.loaderData = loaderData;
    }

    public CryptMachine createMachine() {
        CryptMachine cryptMachine = new CryptMachine();
        // Standard or File Input
        if (loaderData.isInputWithPath()) {
            FileInput fileInput = new FileInput();
            fileInput.setData(loaderData.getInputPath());
            cryptMachine.setInputMethod(fileInput);
        } else {
            StandardInput standardInput = new StandardInput();
            standardInput.setData(loaderData.getInputPath());
            cryptMachine.setInputMethod(standardInput);
        }
        // Method to crypt
        if (loaderData.getChoiceOfMethod().equals("shift")) {
            cryptMachine.setCryptMethod(new ShiftingMethod(loaderData.getKey()));
        } else {
            cryptMachine.setCryptMethod(new UnicodeMethod(loaderData.getKey()));
        }
        //
        if (loaderData.getTypeOfOutput().equals("standard")) {
            cryptMachine.setOutputMethod(new StandardOutput());
        } else {
            cryptMachine.setOutputMethod(new FileOutput(loaderData.getTypeOfOutput()));
        }
        cryptMachine.setTypeOfCrypt(loaderData.getTypeOfCrypt());
        return cryptMachine;
    }
}
