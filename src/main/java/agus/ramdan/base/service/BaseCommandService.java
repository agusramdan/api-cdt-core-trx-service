package agus.ramdan.base.service;

public interface BaseCommandService<T,ResultDTO,CreateDTO,UpdateDTO,ID>{

    default ResultDTO commandCreate(CreateDTO createDTO) {
        T data = convertFromCreateDTO(createDTO);
        T newData = saveCreate(data);
        return convertToResultDTO(newData);
    }

    default ResultDTO commandUpdate(ID id,UpdateDTO updateDTO) {
        T data = convertFromUpdateDTO(id,updateDTO);
        T newData = saveUpdate(data);
        return convertToResultDTO(newData);
    }

    void commandDelete(ID delete);
    T saveCreate(T data);
    T saveUpdate(T data);
    T convertFromCreateDTO(CreateDTO createDTO);
    T convertFromUpdateDTO(ID id,UpdateDTO createDTO);
    ResultDTO convertToResultDTO(T entity);

}
