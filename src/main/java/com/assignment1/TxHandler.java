package com.assignment1;

import java.util.Arrays;

public class TxHandler {
    private static UTXOPool utxoPool;

    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */
    public TxHandler(UTXOPool _utxoPool) {
        if (_utxoPool == null) throw new RuntimeException("Null UTXO pool");
        utxoPool = _utxoPool;
    }

    /**
     * @return true if:
     * (1) all outputs claimed by {@code tx} are in the current UTXO pool,
     * (2) the signatures on each input of {@code tx} are valid,
     * (3) no UTXO is claimed multiple times by {@code tx},
     * (4) all of {@code tx}s output values are non-negative, and
     * (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
     * values; and false otherwise.
     * isSumInputsGTEsumOutputs
     */
    public boolean isValidTx(Transaction tx) {
        if (tx == null) return false;
        return tx.isValid(utxoPool);
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
        Transaction[] validTxs = Arrays.stream(possibleTxs)
                .filter(tx -> tx.isValid(utxoPool))
                .toArray(Transaction[]::new);
        
        return null;
    }

}
