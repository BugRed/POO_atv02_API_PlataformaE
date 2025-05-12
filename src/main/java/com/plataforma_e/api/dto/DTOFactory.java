package com.plataforma_e.api.dto;

import com.plataforma_e.api.model.User;

/**
 * Classe que serve para transformar classes e DTO.
 */
public class DTOFactory {

    /**
     * Converte uma entidade para o DTO correspondente.
     */
    public static <T> Object toDTO(T entity) {
        if (entity instanceof User u) return fromUser(u);  // testa qual é a classe que recebeu no objeto generico;
        throw new IllegalArgumentException("Tipo não suportado para conversão para DTO: " + entity.getClass());
    }

    /**
     * Converte um DTO para a entidade correspondente.
     */
    public static <T> T fromDTO(Object dto, Class<T> clazz) {
        if (dto instanceof UserDTO u && clazz == User.class) return clazz.cast(toUser(u)); // testa qual classe recebeu
        throw new IllegalArgumentException("Tipo não suportado para conversão de DTO: " + dto.getClass());
    }

    /**
     * Converte um objeto Player para UserDTO, incluindo ID e personagens.
     */
    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), user.getImgUrl(), user.isActive());
    }

    /**
     * Converte um PlayerDTO para Player, personagens incluídos.
     * O ID será tratado como 0 (ou ajustado posteriormente no serviço).
     */
    public static User toUser(UserDTO dto) {
        return new User(dto.getUsername(), dto.getEmail(), dto.getImgUrl(), dto.getStatus()); // Respeita o ID do DTO
    }

}