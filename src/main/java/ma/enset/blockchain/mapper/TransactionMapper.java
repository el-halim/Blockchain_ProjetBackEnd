package ma.enset.blockchain.mapper;


import ma.enset.blockchain.DTO.TransactionDTO;
import ma.enset.blockchain.entities.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

        Transaction TransactionDtoToTransaction(TransactionDTO transactionDto);


}
