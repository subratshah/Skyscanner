
package sample.com.skyscanner.model;

import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("Code")
    private String code;

    @SerializedName("Symbol")
    private String symbol;

    @SerializedName("ThousandsSeparator")
    private String thousandsSeparator;

    @SerializedName("DecimalSeparator")
    private String decimalSeparator;

    @SerializedName("SymbolOnLeft")
    private Boolean symbolOnLeft;

    @SerializedName("SpaceBetweenAmountAndSymbol")
    private Boolean spaceBetweenAmountAndSymbol;

    @SerializedName("RoundingCoefficient")
    private Integer roundingCoefficient;

    @SerializedName("DecimalDigits")
    private Integer decimalDigits;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public void setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public Boolean getSymbolOnLeft() {
        return symbolOnLeft;
    }

    public void setSymbolOnLeft(Boolean symbolOnLeft) {
        this.symbolOnLeft = symbolOnLeft;
    }

    public Boolean getSpaceBetweenAmountAndSymbol() {
        return spaceBetweenAmountAndSymbol;
    }

    public void setSpaceBetweenAmountAndSymbol(Boolean spaceBetweenAmountAndSymbol) {
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    }

    public Integer getRoundingCoefficient() {
        return roundingCoefficient;
    }

    public void setRoundingCoefficient(Integer roundingCoefficient) {
        this.roundingCoefficient = roundingCoefficient;
    }

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

}
