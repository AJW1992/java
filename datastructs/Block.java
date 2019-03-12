package datastructs;

import java.util.Arrays;

public class Block {
	
	//block contents
	private int previousHash;
	private String[] transactions;
	private int hash;
	
	public Block(int previousHash, String[] transactions) {
		this.previousHash = previousHash;
		this.transactions = transactions;
		
		//build current block hash using previous hash and current transactions hash
		Object[] contents = {previousHash, Arrays.hashCode(transactions)};
		hash = Arrays.hashCode(contents);
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public String[] getTransactions() {
		return transactions;
	}

	public int getHash() {
		return hash;
	}
}
