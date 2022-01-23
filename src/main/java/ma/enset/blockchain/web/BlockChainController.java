package ma.enset.blockchain.web;

import ma.enset.blockchain.DTO.BlockDTO;
import ma.enset.blockchain.DTO.BlockchainDTO;
import ma.enset.blockchain.DTO.SoldeRequest;
import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Blockchain;
import ma.enset.blockchain.entities.Transaction;
import ma.enset.blockchain.services.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/blockchain")
@CrossOrigin("*")
public class BlockChainController {

    @Autowired
    BlockchainService blockChainService;


    @PostMapping("/create")
    public Blockchain createBlockChaine(@RequestBody BlockchainDTO blockchainDTO)
    {
        return blockChainService.createBlockchain(blockchainDTO.getName(),blockchainDTO.getDifficulty(),blockchainDTO.getReward());

    }
    @GetMapping("/lastblock/{id}")
    public Block LastBlock(@PathVariable String id)
    {
        return blockChainService.getLastBlock(id);
    }
    @PostMapping("mineblock")
    public void mineBlock(@RequestBody BlockDTO blockDto)
    {
        blockChainService.mineBlock(blockDto.getBlockchainID(),blockDto.getTransactions(),blockDto.getPres_hash());
    }

    @GetMapping("/isvalid/{id}")
    public Boolean isValid(@PathVariable String id)
    {
        return blockChainService.verifyBlockchain(id);
    }

    @PostMapping("/solde")
    public double getSolde(@RequestBody SoldeRequest soldRequest)
    {
        return blockChainService.CalculSolde(soldRequest.getBlockchaineId(),soldRequest.getAddress());
    }

    @GetMapping(path = "/allblockchain")
    public List<Blockchain> getAllBlockchains(){
        return blockChainService.getAllBlockchains();
    }


    @GetMapping("/{id}")
    public  Blockchain getBlockchain(@PathVariable String id)  {
        return blockChainService.getBlockchaineByID(id);
    }


}
