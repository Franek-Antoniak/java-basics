package encryptdecrypt;


public class Main {

    public static void main(String[] args) {
        LoaderData loaderData = new LoaderData(args);
        loaderData.loadData();
        MachineFactory machineFactory = new MachineFactory(loaderData);
        CryptMachine cryptMachine = machineFactory.createMachine();
        cryptMachine.startMachine();
    }
}
