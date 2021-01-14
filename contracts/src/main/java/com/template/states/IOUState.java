package com.template.states;

import com.template.contracts.TemplateContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.AnonymousParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import net.corda.core.serialization.CordaSerializable;

import java.util.Arrays;
import java.util.List;

// *********
// * State */
// *********
@BelongsToContract(TemplateContract.class)
// Replace TemplateState's definition with:
public class IOUState implements ContractState {
    private final int value;
    private final Party lender;
    private final Party borrower;
    private String cargo;
    private Status status;

    public IOUState(int value, Party lender, Party borrower, String cargo) {
        this.value = value;
        this.lender = lender;
        this.borrower = borrower;
        this.cargo = cargo;
        this.status = Status.GAME_IN_PROGRESS;
    }

    @ConstructorForDeserialization
    public IOUState(int value, Party lender, Party borrower, Status status) {
        this.value = value;
        this.lender = lender;
        this.borrower = borrower;
        this.status = status;
    }

    @CordaSerializable
    public enum Status {
        GAME_IN_PROGRESS, GAME_OVER
    }

    public IOUState returnNewState(Integer i){
        if(i > 2){
            IOUState b = new IOUState(this.value,this.lender,this.borrower,Status.GAME_OVER);
            return b;
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public Party getLender() {
        return lender;
    }

    public Party getBorrower() {
        return borrower;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(lender, borrower);
    }
}