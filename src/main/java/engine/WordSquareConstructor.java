package engine;

import model.Node;

public class WordSquareConstructor {

    private static int count;

    public char[][] getWordSquare(Node rootTrie, int[] charFreq, int count) {
        this.count = count;
        Node[][] nodeArray = new Node[count][count+1];
        for (int i = 0; i < nodeArray.length; i++)
            nodeArray[i][0] = rootTrie;

        if (populateWordBankOneCharAtTime(0, 1, nodeArray, charFreq)) {
            char[][] result = new char[count][count];
            for (int j = 0; j < count; j++)
                for (int k = 0; k < count; k++) {
                    result[j][k] = (char) (nodeArray[j][k + 1].val + 'a');
                }
            return result;
        } else {
            return null;
        }
    }

    private static boolean populateWordBankOneCharAtTime(int r, int c, Node[][] nodeArray, int[] charBank)  {
        int incrAmt = r==c-1 ? 1 : 2; // need 1 for a diagonal, 2 otherwise (since it's mirrored)

        for (int l = 0; l < 26; l++) {
            Node node = nodeArray[r][c-1].children[l];
            Node nodeMirrorSide = nodeArray[c-1][r].children[l];
            if (node != null && nodeMirrorSide != null && charBank[l] >= incrAmt) {

                nodeArray[r][c] = node;
                nodeArray[c - 1][r + 1] = nodeMirrorSide;
                charBank[l] -= incrAmt;

                if (c == count) {
                    if (r == count - 1 || populateWordBankOneCharAtTime(r + 1, r + 2, nodeArray, charBank)) { // move to next row
                        return true;
                    }
                } else if (populateWordBankOneCharAtTime(r, c + 1, nodeArray, charBank)) { // move to next column
                    return true;
                }

                charBank[l] += incrAmt;
            }
        }
        return false;
    }
}
