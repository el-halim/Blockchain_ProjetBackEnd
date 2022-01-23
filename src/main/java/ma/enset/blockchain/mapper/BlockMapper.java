package ma.enset.blockchain.mapper;


import ma.enset.blockchain.DTO.BlockDTO;
import ma.enset.blockchain.entities.Block;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlockMapper {
        Block BlockDtoToBlock(BlockDTO blockDto);
        BlockDTO BlockToBlockDto(Block block);
}
