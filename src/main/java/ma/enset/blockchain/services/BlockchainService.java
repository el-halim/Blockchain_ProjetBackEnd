package ma.enset.blockchain.services;

import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Blockchain;
import ma.enset.blockchain.entities.Transaction;

import java.util.List;

public interface BlockchainService {
    public Blockchain createBlockchain(String name,int difficulty,int reward);
    public boolean verifyBlockchain(String id);
    public double CalculSolde(String blockchainID,String address);
    public Block mineBlock(String IdBlockChain,List<Transaction> transactionList, String previousHash);
    public Block getLastBlock(String blockchainID);
    public List<Blockchain> getAllBlockchains();
    public Blockchain getBlockchaineByID(String id);


    }
