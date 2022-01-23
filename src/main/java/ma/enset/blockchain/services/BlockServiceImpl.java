package ma.enset.blockchain.services;

import ma.enset.blockchain.DTO.TransactionDTO;
import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Transaction;
import ma.enset.blockchain.mapper.BlockMapper;
import ma.enset.blockchain.repositories.BlockRepository;
import ma.enset.blockchain.repositories.TransactionRepository;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class BlockServiceImpl implements BlockService {


    @Autowired
    BlockRepository blockRepository;
    @Autowired
    TransactionRepository transactionRepository;

    private ModelMapper modelMapper;
    @Override
    public Block createBlock(List<Transaction> list, String previousHash) {
        Block block = new Block();
        block.setId(UUID.randomUUID().toString());
        block.setCreatedAt(new Date(System.currentTimeMillis()));
        block.setPreviousHash(previousHash);
        block.setNonce(0);
        block.setHash(getHashOfBlock(block));
        blockRepository.save(block);
        if(list!=null) {
            for(Transaction t : list) {
                t.setBlock(block);
            };
        }
        transactionRepository.saveAll(list);
        return block;
    }

    @Override
    public String getHashOfBlock(Block block) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String strToHash = block.toString();
            byte[] encodinghash = messageDigest.digest(
                    strToHash.getBytes(StandardCharsets.UTF_8)
            );
            return ConvertByteToHexa(encodinghash);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }



    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }


    @Override
    public Block mineBlock(Block block, int difficulty) {
        char[] chars = new char[difficulty];
        Arrays.fill(new char[difficulty], '0');
        String prefix = new String(new char[difficulty]).replace('\0','0');
        String hash = getHashOfBlock(block);
        while(!hash.startsWith(prefix, 0)){
            //System.out.println(hash);
            block.setNonce(block.getNonce()+1);
            hash = getHashOfBlock(block);
        }
        block.setHash(hash);
        //change
        return blockRepository.save(block);
    }
    private static String ConvertByteToHexa(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
