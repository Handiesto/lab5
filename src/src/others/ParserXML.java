package src.others;

/**
 * This is the class of xml parser.
 * Can be used for only specific construction of file.
 * @version 1.0.0
 */

public class ParserXML {
    private static final int NUMBER_OF_ELEMENTS = 1200;
    private static final int NUMBER_OF_TOKENS = 11;
    private int tokensOffset, valuesOffset, textOffset, productsNum;
    private String[] values;
    private String[] tokens = {"<Name>", "<X>", "<Y>", "<CreationDate>", "<Price>", "<partNumber>",
            "<manufactureCost>", "<UnitOfMeasure>", "<Name>", "<fullName>",
            "<employeesCount>", "<Product>"};
    private char[] text;

    /**
     * Simple constructor.
     * Nothing unusual.
     */

    public ParserXML() {
        values = new String[NUMBER_OF_ELEMENTS];
        tokensOffset = 0;
        valuesOffset = 0;
        textOffset = 0;
        productsNum = 1;
    }

    /**
     * Method for a file parsing.
     * @param text - the text of the file which will be parsed.
     */

    public void Parse(String text){
        String token = tokens[tokensOffset];
        final int START_SYM = 0;
        this.text = text.toCharArray();
        for (textOffset = 0; textOffset < this.text.length; textOffset++) {
            if(this.text[textOffset] == token.charAt(START_SYM)) {
                textOffset++;
                if(Compare(token)) {
                    if(tokensOffset == NUMBER_OF_TOKENS) {
                        tokensOffset = 0;
                        token = tokens[tokensOffset];
                        productsNum++;
                    }
                    else {
                        values[valuesOffset] = getField();
                        tokensOffset++;
                        token = tokens[tokensOffset];
                        valuesOffset++;
                    }
                }
            }
        }
    }

    /**
     * Method for comparing token and value from a file.
     * @param token - the token
     * @return returns true if a token and value are equal
     */

    private boolean Compare(String token) {
        boolean exit = false, equal = false;
        int offset = 1;
        while(!exit) {
            if(text[textOffset] == token.charAt(offset)){
                offset++;
                textOffset++;
                if(offset == token.length()) {
                    equal = true;
                    exit = true;
                }
            }
            else {
                exit = true;
            }
        }
        return equal;
    }


    /**
     * Method for extracting a value from a file.
     * @return returns value of future field of class.
     */

    private String getField() {
        String value = new String();
        while(text[textOffset] != '<') {
            value += text[textOffset];
            textOffset++;
        }
        if (value.equals("")) {
            value = null;
        }
        return value;
    }

    /**
     * Method for getting a number of products from a file.
     * @return returns number of products
     */

    public int getProductsNum() {return productsNum;}

    /**
     * Simple getter.
     * @return returns all values which were extracted from a file
     */
    public String[] getValues(){
        return values;
    }
}
