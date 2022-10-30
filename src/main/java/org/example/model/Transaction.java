package org.example.model;

import java.io.Serializable;

public class Transaction implements Serializable {
    private Long id;
    private String transactionType;
    private Integer TransactionAmount;
    private Integer AccountBalance;
    private Long depositNumber;
    private Long terminalId;
    private String terminalType;
    private String resultMessage;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    public Integer getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        AccountBalance = accountBalance;
    }

    public Long getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(Long depositNumber) {
        this.depositNumber = depositNumber;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionType='" + transactionType + '\'' +
                ", TransactionAmount=" + TransactionAmount +
                ", AccountBalance=" + AccountBalance +
                ", depositNumber=" + depositNumber +
                ", terminalId=" + terminalId +
                ", terminalType='" + terminalType + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
