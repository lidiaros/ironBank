package com.example.ironBank.dtos;
import java.math.BigDecimal;

public class TransferThirdPartyDTO {

    private String hashedKey;
    private BigDecimal transferAmount;
    private Long accountId;
    private String secretKey;

    public TransferThirdPartyDTO(String hashedKey, BigDecimal transferAmount, Long accountId, String secretKey) {
        this.hashedKey = hashedKey;
        this.transferAmount = transferAmount;
        this.accountId = accountId;
        this.secretKey = secretKey;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}