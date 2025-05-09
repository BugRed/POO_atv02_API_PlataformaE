package com.plataforma_e.api.dto;

import java.util.List;

public class DungeonMasterDTO extends UserDTO {

        private List<CharacterRequestDTO> characters;
        private List<RoomRequestDTO> rooms;

        public DungeonMasterDTO(String username, String email) {
            super(username, email);
        }

        public DungeonMasterDTO() {
        }

        public List<CharacterRequestDTO> getCharacters() {
            return characters;
        }

        public List<RoomRequestDTO> getRooms() {
            return rooms;
        }

        @Override
        public String toString() {
            return "DungeonMaster{" +
                    "characters=" + characters +
                    ", rooms=" + rooms +
                    '}';
        }

}
