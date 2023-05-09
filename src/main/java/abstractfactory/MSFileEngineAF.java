package abstractfactory;

import documents.*;
import documents.apple.AppleDoc;
import documents.google.GoogleDoc;
import documents.ibm.IBMDoc;
import documents.ms.*;
import documents.oracle.OracleDoc;
import utils.Randomiser;

public class MSFileEngineAF implements IFileEngineAF {
    @Override
    public IDoc createDoc() {
        return new MSDoc();
    }

    @Override
    public ITable createTable() {
        switch (Randomiser.getRandomTableType()) {
            case 0 -> {
                return new MSTableComplex();
            }
            case 1 -> {
                return new MSTableHierarchical();
            }
            default -> {
                return new MSTableSimple();
            }
        }
    }

    @Override
    public IEmail createEmail() {
        return new MSEmail();
    }

    @Override
    public IMsg createMsg() {
        return new MSMsg();
    }

    @Override
    public IAVMsg createAVMsg() {
        return new MSAVMsg();
    }
}
