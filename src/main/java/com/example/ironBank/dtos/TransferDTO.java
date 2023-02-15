package com.example.ironBank.dtos;
import java.math.BigDecimal;

public class TransferDTO {
    private Long sendingID;
    private Long receivingID;
    private BigDecimal amount;
    private String name;

    public TransferDTO(Long sendingID, Long receivingID, BigDecimal amount, String name) {
        this.sendingID = sendingID;
        this.receivingID = receivingID;
        this.amount = amount;
        this.name = name;
    }

    public Long getSendingID() {
        return sendingID;
    }

    public void setSendingID(Long sendingID) {
        this.sendingID = sendingID;
    }

    public Long getReceivingID() {
        return receivingID;
    }

    public void setReceivingID(Long receivingID) {
        this.receivingID = receivingID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
