package helper;

import java.util.ArrayList;

public class ExpectedWordList {

    public ArrayList<String> getWordArrayList(String value) {
        ArrayList<String> result = new ArrayList<>();
        switch(value) {
            case "eeeeddoonnnsssrv":
                result.add("rose");
                result.add("oven");
                result.add("send");
                result.add("ends");
                break;
            case "aaccdeeeemmnnnoo":
                result.add("moan");
                result.add("once");
                result.add("acme");
                result.add("need");
                break;
            case "aabbeeeeeeeehmosrrrruttvv":
                result.add("heart");
                result.add("ember");
                result.add("above");
                result.add("revue");
                result.add("trees");
                break;
            case "aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy":
                result.add("bravado");
                result.add("renamed");
                result.add("analogy");
                result.add("valuers");
                result.add("amoebas");
                result.add("degrade");
                result.add("odyssey");
        }

        return result;
    }
}
