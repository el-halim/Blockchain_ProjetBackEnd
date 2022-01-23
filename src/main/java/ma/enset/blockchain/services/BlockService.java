package ma.enset.blockchain.services;

import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Transaction;

import java.util.List;

public interface BlockService {
    Block createBlock(List<Transaction> list, String previousHash);
    String getHashOfBlock(Block block);
    Block mineBlock(Block block, int difficulty);
    public List<Block> getAllBlocks();

}
