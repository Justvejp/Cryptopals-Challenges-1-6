package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    List<String> resultList = new ArrayList<>();


    public Main() {
        //exerciseOne();
        //exerciseTwo();
        //exerciseThree();
        //exerciseFour();
        //exerciseFive();
        exerciseSix();
    }

    public void exerciseSix() {

        File file = new File("C:\\Users\\Gurra\\DokumentsGitub\\KrypteringTest\\src\\com\\company\\text1.txt");

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                resultList.add(sc.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List <String> eWords = new ArrayList<>();
        eWords.add("the");
        eWords.add("and");
        eWords.add("that");
        eWords.add("for");
        eWords.add("have");
        eWords.add("you");
        eWords.add("with");
        eWords.add("but");
        eWords.add("from");
        eWords.add("his");
        eWords.add("they");
        eWords.add("this");
        eWords.add("say");
        eWords.add("not");
        eWords.add("n't");
        eWords.add("she");
        eWords.add("make");
        eWords.add("her");
        eWords.add("would");
        eWords.add("get");
        eWords.add("can");
        eWords.add("who");
        eWords.add("about");
        eWords.add("know");
        eWords.add("will");
        eWords.add("one");
        eWords.add("time");
        eWords.add("there");
        eWords.add("year");
        eWords.add("when");
        eWords.add("wich");
        eWords.add("them");
        eWords.add("some");
        eWords.add("people");
        eWords.add("out");
        eWords.add("into");
        eWords.add("just");
        eWords.add("see");
        eWords.add("him");
        eWords.add("your");
        eWords.add("come");
        eWords.add("now");
        eWords.add("could");
        eWords.add("than");
        eWords.add("like");
        eWords.add("other");
        eWords.add("all");

        String encryptedString = "";
        StringBuilder sb = new StringBuilder(encryptedString);

        for (String s : resultList) {
            sb.append(s);
        }

        String s = ""+sb;

            int clearLetter = 0;
            String resultString = "";
            //deBase64 the file.
            byte[] decodedBytes = Base64.getDecoder().decode(s);
            String decodedString = new String(decodedBytes);


            String xorTestString = "";

            //for (int i = 0; i < 255; i++) {
                //char t = (char) i;
                //xorTestString = generateXoringASCIITestString(decodedString, t);
            xorTestString = "Terminator X: Bring the noise"; //kom fram till denna nyckel.


            //xorTestString = "the the the the the the the the the the the the the the the the the the ";


                byte[] x = xorTestString.getBytes();
                byte[] y = decodedString.getBytes();

                //for (int j = 0; j < y.length; j++) {
                  //  byte letter = y[j];
                    //byte key = x[j];
                    //int cipher = letter ^ key;

                    //clearLetter = letter ^ key;
                    //System.out.print((char) clearLetter);
                    //resultString += (char) clearLetter;

                //}

                int ii = 0;
               StringBuilder resultSB1 = new StringBuilder();
               for(byte u: y) {
                    resultSB1.append((char) (u ^ xorTestString.charAt(ii++)));
                    if (ii == 29) {
                       ii = 0;
                   }
               }

                //System.out.println(xorTestString);
            //System.out.println(resultString);

            //for (String k : eWords) {
                //if (resultString.contains(k)) {
                    System.out.println(resultSB1);
                //}
           // }



                //System.out.println(xorTestString);
            //}


        //}



        String resultASCIIOne = "";
        String resultASCIITwo = "";

        String one = "this is a test";
        String two = "wokka wokka!!!";

        byte[] l = one.getBytes();
        byte[] k = two.getBytes();

        for (int i = 0; i < l.length; i++) { //ASCII //kasta till char för att få vanliga strängen.
            resultASCIIOne += l[i];
        }
        for (int i = 0; i < k.length; i++) {
            resultASCIITwo += k[i];
        }
        //System.out.println(resultASCIIOne);
        //System.out.println(resultASCIITwo);
        System.out.println(convertToStringToBinary(l)); //Skickar in en byte Array av en string
        System.out.println(convertToStringToBinary(k));
        //String hexedOne = bytesToHex(l);
        //String hexedTwo = bytesToHex(k);

        System.out.println(hammingDistanceBetweenTwoStrings(convertToStringToBinary(l), convertToStringToBinary(k)));

    }

    public int generateValueForResultString(String resultString) {
        int score = 0;
        for (int i = 0; i < resultString.length(); i++) {
            if (resultString.charAt(i) > 97 && resultString.charAt(i) <  122 || resultString.charAt(i) == 32) {
                score++;
            }
        }
        return score;
    }

    public String generateXoringASCIITestString(String s, char t) {
        String ACSIIString = "";
        StringBuilder sb = new StringBuilder(ACSIIString);

            for (int j = 0; j < s.length(); j++) {
                sb.append(t);
            }
        return sb+"";
    }

    public String convertToStringToBinary(byte[] l) {
        StringBuilder binary = new StringBuilder();
        for (byte b : l)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        return ""+binary;
    }
    public int hammingDistanceBetweenTwoStrings(String one, String two) {

        int i = 0, count = 0;
        while (i < one.length())
        {
            if (one.charAt(i) != two.charAt(i))
                count++;
            i++;
        }
        return count;
    }


    public void exerciseFive() {
        //finns i excercise 3

    }

    public void exerciseFourMod(String feedString) {

            String resultFeedString = "";
            String xorStringTest = "";


                byte[] deHexedFeedString = hexStringToByteArray(feedString);
                for (int i = 0; i < deHexedFeedString.length; i++) {
                    resultFeedString += (char) deHexedFeedString[i];
                }

                //System.out.println(resultFeedString);
                byte[] d = resultFeedString.getBytes();

                for (char t = 'a'; t < 'z'; t++) { //Loopar igenom alfabetet och kollar vilken char vi kan Xor:a mot för att få en träff.

                    //xorStringTest = generateTestCharacterToXoRAgainstSecond(t);
                    xorStringTest = "555555555555555555555555555555555555555555555555555555";

                    //System.out.println(xorStringTest);

                    byte[] l = xorStringTest.getBytes();

                    int clearLetter;
                    String resultString = "";

                    for (int i = 0; i < d.length; i++) {
                        byte letter = d[i];
                        byte key = l[i];
                        //int cipher = letter ^ key;

                        clearLetter = letter ^ key;
                        //System.out.print((char) clearLetter);
                        resultString += (char) clearLetter;

                    }

                    //System.out.println(resultString);

                    addResultToList(resultString);



                }

    }

    public void addResultToList(String resultString) {
        resultList.add(resultString);
    }

    public void exerciseFour() {

        List<String> list = new ArrayList<>();

        File file = new File("C:\\Users\\Gurra\\DokumentsGitub\\KrypteringTest\\src\\text.txt");

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                list.add(sc.next());
            }

            for (String b : list) {
                exerciseFourMod(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String s : resultList) {
            if (s.contains("party")) {
                System.out.println(s);
            }
        }
    }

    public String generateTestCharacterToXoRAgainstSecond(char t) {
        String s = "";
        StringBuilder x = new StringBuilder(s);
        for (int i = 0; i < 61; i++) {
            x.append(t);

        }
        return String.valueOf(x).toUpperCase();
    }

    public void exerciseThree() {

        String feedString = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        //String feedString = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f204363656963656963650063222663263b223f30633221262b690a652126243b632469203c24212425";
        String xorStringTest = "";

        byte[] deHexedFeedString = hexStringToByteArray(feedString);

        String resultFeedString = "";

        for (int i = 0; i < deHexedFeedString.length; i++) {
            resultFeedString += (char) deHexedFeedString[i];
        }
        System.out.println(resultFeedString);

        byte[] d = resultFeedString.getBytes();

        for (char t = 'a'; t <= 'z'; t++) { //Loopar igenom alfabetet och kollar vilken char vi kan Xor:a mot för att få en träff.

            xorStringTest = generateTestCharacterToXoRAgainst(t);
            //xorStringTest = "ICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICEICE";
            System.out.println(xorStringTest);

            byte[] l = xorStringTest.getBytes();

            int clearLetter;
            String resultString = "";

            for (int i = 0; i < d.length; i++) {
                byte letter = d[i];
                byte key = l[i];
                //int cipher = letter ^ key;

                clearLetter = letter ^ key;
                //System.out.print((char) clearLetter);
                resultString += (char) clearLetter;

            }
            System.out.println(resultString);
        }
    }

    public String generateTestCharacterToXoRAgainst(char t) {

        String s = "";
        StringBuilder x = new StringBuilder(s);
        for (int i = 0; i < 35; i++) {
            x.append(t);

        }
        return String.valueOf(x).toUpperCase();
    }

    public void exerciseOne() {
        //finns i andra programmet, med base64. och övning 6

    }

    public void exerciseTwo() {

        String feedString = "1c0111001f010100061a024b53535009181c"; //Dehexa dem alltid inna XOR i detta fallet.
        String xorString = "686974207468652062756c6c277320657965"; //Dehexa sen XOR i detta fallet.

        byte[] deHexedFeedString = hexStringToByteArray(feedString);
        byte[] deHexedXorString = hexStringToByteArray(xorString);

        String resultFeedString = "";
        String resultXorString = "";

        for (int i = 0; i < deHexedFeedString.length; i++) {

            resultFeedString += (char) deHexedFeedString[i];
        }
        System.out.println(resultFeedString);

        for (int i = 0; i < deHexedXorString.length; i++) {

            resultXorString += (char) deHexedXorString[i];
        }
        System.out.println(resultXorString);

        byte[] d = resultFeedString.getBytes();
        byte[] k = resultXorString.getBytes();

        int clearLetter;
        String resultString = "";

        for (int i = 0; i < d.length; i++) {
            byte letter = d[i];
            byte key = k[i];
            //int cipher = letter ^ key;

            clearLetter = letter ^ key;
            //System.out.print((char) clearLetter);
            resultString += (char) clearLetter;

        }
        System.out.println(resultString);

        byte[] a = resultString.getBytes();
        String hexedResultString = bytesToHex(a).toLowerCase();
        System.out.println(hexedResultString);



    }

    public static String bytesToHex(byte[] bytes) {

        // [68, 4, 72] -> ['4', '4', '0', '4', '4', '8'] -> "440448"

        String hexadecimals = "0123456789ABCDEF";

        char[] hexArray = hexadecimals.toCharArray();
        char[] hexChars = new char[bytes.length * 2];

        for (int i = 0; i < bytes.length; i++) {
            int value = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[value >>> 4];
            hexChars[i * 2 + 1] = hexArray[value & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {

        int len = s.length();

        //this only works with an even number of characters.
        //if len is odd, append a 0 at  the start of number.

        if (len % 2 != 0) {
            s = "0" + s;
            len++;
        }

        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) {
        new Main();
    }
}
