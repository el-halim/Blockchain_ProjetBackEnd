package ma.enset.blockchain.web;

import ma.enset.blockchain.DTO.BlockDTO;
import ma.enset.blockchain.DTO.BlockchainDTO;
import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.services.BlockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/block")
@CrossOrigin("*")
public class BlockController {
    private BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @RequestMapping(value = "/newblock", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Block createBlock(@RequestBody Block blockDto){
        return blockService.createBlock(blockDto.getTransactions(),blockDto.getPreviousHash());
    }

  @GetMapping(path = "/allblocks")
  public List<Block> getBlocks(){
      return blockService.getAllBlocks();
    }



}
